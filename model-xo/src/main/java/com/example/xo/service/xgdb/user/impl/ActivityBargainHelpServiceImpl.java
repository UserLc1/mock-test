package com.example.xo.service.xgdb.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.xo.dao.primary.dao.ActivityBargainHelpDao;
import com.example.xo.entity.ActivityBargainHelp;
import com.example.xo.service.xgdb.user.ActivityBargainHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author: Lc
 * @Date: 2021-08-10
 * @apiNote
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityBargainHelpServiceImpl extends ServiceImpl<ActivityBargainHelpDao, ActivityBargainHelp> implements ActivityBargainHelpService {

    @Autowired
    ActivityBargainHelpDao activityBargainHelpDao;
    @Override
    public ActivityBargainHelp saveEntity() {
        ActivityBargainHelp activityBargainHelp = new ActivityBargainHelp();
        activityBargainHelp.setMemberId(1L);
        activityBargainHelp.setActivityId(1L);
        activityBargainHelp.setCreateTime("2021-08-10 09:19:00");
        activityBargainHelp.setPrice(new BigDecimal(1));
        activityBargainHelp.setUserId(2L);
        activityBargainHelpDao.insert(activityBargainHelp);
        return activityBargainHelp;
    }
}
