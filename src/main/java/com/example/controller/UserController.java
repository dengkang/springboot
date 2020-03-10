package com.example.controller;

import com.example.Exception.MyException;
import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.*;

@Controller
@Api(value = "用户controller")
public class UserController {

    private Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Autowired
    private Validator validator;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("host","localhost://10.41.2.81");
        return  "index";
    }
    @GetMapping("/exception")
    public Exception exceptionTest() throws Exception {
        throw new Exception("exceptionTest");
    }

    @GetMapping("/myException")
    public Exception myExceptionTest() throws MyException {
        throw new MyException("exceptionTest");
    }

    @ApiOperation(value="获取用户列表",notes = "")
    @GetMapping("/userList")
    public List<User> queryUserList(){
        List<User> userlist = new ArrayList(users.values());
        return userlist;
    }

    @ApiOperation(value = "添加用户",notes = "根据用户id创建用户")
    @ApiImplicitParam(name="user",value = "用户详细实体",required = true,dataType = "User")
    @PostMapping("/addUser")
    @ResponseBody
    public User addUser( @RequestBody @Valid User user){
        Set<ConstraintViolation<User>> set =  validator.validate(user);
        Assert.isTrue(set.size()==0,"校验不通过");
        users.put(user.getId(),user);
        return  user;
    }

    @ApiOperation(value = "更新用户",notes = "修改用户信息")
    @ApiImplicitParam(name = "user",value = "用户更新的详细实体",required = true,dataType = "User")
    @PutMapping(value="/updateUser",produces="application/json;charset=UTF-8")
    public String updateUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value="查询用户",notes = "根据用户id查询用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable long id){
        User user = users.get(id);
        return  user;
    }

    @ApiOperation(value="删除用户",notes = "根据用户id删除用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    @DeleteMapping(value="deleteUser/{id}",produces="application/json;charset=UTF-8" )
    public String deleteUser(@PathVariable long id){
        users.remove(id);
        return "success";
    }
}
