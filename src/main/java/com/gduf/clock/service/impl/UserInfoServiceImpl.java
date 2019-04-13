package com.gduf.clock.service.impl;

import com.gduf.clock.dao.UserInfoMapper;
import com.gduf.clock.entity.UserInfo;
import com.gduf.clock.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfo getUserInfo(String openId) {
        return userInfoMapper.selectByPrimaryKey(openId);
    }
}
