package com.example.xo.entity.zb;

import com.ejlchina.searcher.bean.DbField;
import lombok.Data;

/**
 * @Author: Lc
 * @Date: 2021-08-06
 */
@Data
public class ZbUser {
    private Long userId; //用户账号

    private String userName; //用户账号

    private String nickName; //用户昵称

//    private String passWord; //用户密码

    private String realName; //真实姓名
}
