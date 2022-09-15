package com.example.xo.service.zbdb.user.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.param.Operator;
import com.ejlchina.searcher.util.MapUtils;
import com.example.xo.entity.zb.ZbUser;
import com.example.xo.service.zbdb.user.ZbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Lc
 * @Date: 2021-12-31
 * @apiNote
 */
@Service
@Transactional
public class ZbUserServiceImpl implements ZbUserService {
    /**
     * 注入 Map 检索器，它检索出来的数据以 Map 对象呈现
     */
    @Autowired
    private MapSearcher mapSearcher;
    /**
     * 注入 Bean 检索器，它检索出来的数据以 泛型 对象呈现
     */
    @Autowired
    private BeanSearcher beanSearcher;


    @Override
    public SearchResult<Map<String, Object>> getList(HttpServletRequest request) {
        // 一行代码，实现一个用户检索接口（MapUtils.flat 只是收集前端的请求参数）
        return mapSearcher.search(ZbUser.class, MapUtils.flat(request.getParameterMap()));
    }

    @Override
    public SearchResult<Map<String, Object>> getByEntity(ZbUser zbUser,Long page,Integer size) {
        Map<String, Object> params = MapUtils.builder()
                .page(page,size)
                .field(ZbUser::getNickName,zbUser.getNickName()).op(Operator.StartWith)
                .field(ZbUser::getRealName,zbUser.getRealName())
                .build();
        return mapSearcher.search(ZbUser.class, params);
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("aa","aa");
        map.put("aaa","b");
        map.put("cc","c");

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if(key.startsWith("aa")){
                System.out.println(key);
                map.put(key.replace("aa","bb"),map.remove(key));
                iterator = map.keySet().iterator();
            }
        }
//        map.keySet().stream().forEach(key -> {
//            if(key.startsWith("aa")){
//                map.put(key.replace("aa","bb"),map.remove(key));
//            }
//        });
        System.out.println(JSONArray.toJSONString(map));
    }
}
