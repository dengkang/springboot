package com.example.bean;



import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="T_USER")
public class TUser implements Serializable {

  @Id
  private long id;
@Column(name="username")
  private String username;
@Column(name="password")
  private String password;
@Column(name="salt")
  private String salt;
@Column(name="locked")
  private String locked;
@Column(name="email")
  private String email;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public String getLocked() {
    return locked;
  }

  public void setLocked(String locked) {
    this.locked = locked;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
