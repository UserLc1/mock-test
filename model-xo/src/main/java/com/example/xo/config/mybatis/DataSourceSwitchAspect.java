package com.example.xo.config.mybatis;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Lc
 * @Date: 2021-07-30
 */
@Component
@Order(value = 1)
@Aspect
public class DataSourceSwitchAspect {
    @Pointcut("execution(* com.example.xo.service.xgdb..*.*(..))")
    private void primaryAspect() {
    }

    @Pointcut("execution(* com.example.xo.service.zbdb..*.*(..))")
    private void zbsysAspect() {
    }

    @Before("primaryAspect()")
    public void primary() {
//        log.info("切换到【PRIMARY】数据源...");
        System.out.println("切换到【PRIMARY】数据源...");
        DataSourceContextHolder.setDbType(DataSourceTypeEnum.PRIMARY);
    }

    @Before("zbsysAspect()")
    public void zbsys() {
//        log.info("切换到【ZBSYS】数据源...");
        System.out.println("切换到【ZBSYS】数据源...");
        DataSourceContextHolder.setDbType(DataSourceTypeEnum.ZBSYS);
    }
}
