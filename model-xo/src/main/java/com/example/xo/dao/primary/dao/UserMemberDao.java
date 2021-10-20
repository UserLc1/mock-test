package com.example.xo.dao.primary.dao;

import com.example.xo.entity.UserMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
@Repository
@Mapper
public interface UserMemberDao {
    List<UserMember> getByAll();
}
