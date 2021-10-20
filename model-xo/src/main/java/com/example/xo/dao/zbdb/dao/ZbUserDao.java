package com.example.xo.dao.zbdb.dao;

import com.example.xo.entity.zb.ZbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
@Repository
@Mapper
public interface ZbUserDao {
    List<ZbUser> getByAll();
}
