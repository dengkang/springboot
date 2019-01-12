package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface ExpandRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    T findOne(String condition ,Object... objects);

}
