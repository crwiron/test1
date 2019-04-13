package com.gduf.clock.service;

import com.gduf.clock.entity.DailyRecord;

import java.util.List;

public interface DailyRecordService {
    //获取所有用户的日记信息
    List<DailyRecord> getAllDailyRecord();
}
