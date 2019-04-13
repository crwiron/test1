package com.gduf.clock.service.impl;

import com.gduf.clock.dao.DailyRecordMapper;
import com.gduf.clock.entity.DailyRecord;
import com.gduf.clock.service.DailyRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DailyRecordServiceImpl implements DailyRecordService {
    private DailyRecordMapper dailyRecordMapper;

    public DailyRecordServiceImpl(DailyRecordMapper dailyRecordMapper) {
        this.dailyRecordMapper = dailyRecordMapper;
    }

    @Override
    public List<DailyRecord> getAllDailyRecord() {
        List<DailyRecord> list = dailyRecordMapper.selectAll();
        if (list == null) {
            return null;
        } else {
            return list;
        }
    }
}
