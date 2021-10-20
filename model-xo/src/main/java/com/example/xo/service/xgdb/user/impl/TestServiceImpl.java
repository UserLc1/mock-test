package com.example.xo.service.xgdb.user.impl;

import com.example.xo.service.xgdb.user.ActivityBargainHelpService;
import com.example.xo.service.xgdb.user.TestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Lc
 * @Date: 2021-08-10
 * @apiNote
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    ActivityBargainHelpService bargainHelpService;

    @Override
    @GlobalTransactional
    @Transactional
    public String saveEntity(){
        bargainHelpService.saveEntity();
        throw new RuntimeException();
    }
}
