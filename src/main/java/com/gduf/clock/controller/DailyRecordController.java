package com.gduf.clock.controller;

import com.gduf.clock.entity.DailyRecord;
import com.gduf.clock.service.DailyRecordService;
import com.gduf.clock.service.impl.DailyRecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DailyRecordController {
    private DailyRecordService dailyRecordService;

    public DailyRecordController(DailyRecordServiceImpl dailyRecordService) {
        this.dailyRecordService = dailyRecordService;
    }
    @GetMapping(value = "getAllDailyRecord", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity getAllDailyRecord(){
        try{
            List<DailyRecord> list = dailyRecordService.getAllDailyRecord();
            return new ResponseEntity(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
