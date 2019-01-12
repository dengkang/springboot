package com.example.dao.impl;

import com.example.dao.ExpandRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class ExpandRepositioryImpl<T,ID extends Serializable>  extends SimpleJpaRepository<T,ID> implements ExpandRepository<T,ID> {
    private final EntityManager entityManager;

    private final JpaEntityInformation<T, ?> entityInformation;

    public ExpandRepositioryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    @Override
    public T findOne(String condition, Object... objects) {
        if(StringUtils.isEmpty(condition)){
            throw new NullPointerException("条件不能为空");
        }
        T result = null;

//        result = getResult(condition,objects);

        return result;
    }
}
