package com.gduf.clock.controller;

import com.gduf.clock.entity.MemberInfo;
import com.gduf.clock.service.MemberInfoService;
import com.gduf.clock.service.impl.MemberInfoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberInfoController {
    private MemberInfoService memberInfoService;

    public MemberInfoController(MemberInfoServiceImpl memberInfoService) {
        this.memberInfoService = memberInfoService;
    }

    @GetMapping(value = "getAllMemberInfo", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity getAllMemberInfo(){
        try {
            List<MemberInfo> list = memberInfoService.getAllMemberInfo();
            return new ResponseEntity(list, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
