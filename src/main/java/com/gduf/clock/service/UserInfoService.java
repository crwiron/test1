package com.gduf.clock.service;

import com.gduf.clock.entity.UserInfo;

public interface UserInfoService {
    //通过openId获取用户信息
    UserInfo getUserInfo(String openId);
}
