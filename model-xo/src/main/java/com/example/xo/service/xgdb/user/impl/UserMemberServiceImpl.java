package com.example.xo.service.xgdb.user.impl;


import com.example.xo.dao.primary.dao.UserMemberDao;
import com.example.xo.entity.UserMember;
import com.example.xo.service.xgdb.user.UserMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
@Service
@Transactional
public class UserMemberServiceImpl implements UserMemberService {
    @Autowired
    UserMemberDao userMemberDao;
    @Override
    public List<UserMember> getByAll() {
        return userMemberDao.getByAll();
    }


}
