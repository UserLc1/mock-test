package com.example.xo.service.zbdb.user;

import com.ejlchina.searcher.SearchResult;
import com.example.xo.entity.zb.ZbUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Lc
 * @Date: 2021-08-06
 */
public interface ZbUserService {
     SearchResult<Map<String,Object>> getList(HttpServletRequest request);

     SearchResult<Map<String, Object>> getByEntity(ZbUser zbUser, Long page, Integer size);

}
