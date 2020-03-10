package com.example.ext;

import com.example.dao.impl.ExpandRepositioryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/*
  装配自定义JPA扩展接口
 */
public class ExpandJpaRepositoryFactoryBean<R extends JpaRepository<T,ID>,T,ID extends Serializable> extends JpaRepositoryFactoryBean<R,T,ID> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager){
        return new ExpandJpaRepositoryFactory<T,ID>(entityManager);
    }

    private static class ExpandJpaRepositoryFactory<T,ID extends Serializable> extends JpaRepositoryFactory {

        private final EntityManager entityManager;

        public ExpandJpaRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
            return ExpandRepositioryImpl.class;
        }

        protected Object getTargetRepository(RepositoryMetadata metadata){
            JpaEntityInformation<T,Serializable> entityInformation = (JpaEntityInformation<T,Serializable>)getEntityInformation(metadata.getDomainType());
            return new ExpandRepositioryImpl<T,ID>(entityInformation,entityManager);
        }
    }
}
