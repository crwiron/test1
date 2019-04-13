package com.gduf.clock.controller;

import com.gduf.clock.entity.UserInfo;
import com.gduf.clock.service.UserInfoService;
import com.gduf.clock.service.impl.UserInfoServiceImpl;
import com.gduf.clock.vo.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    UserInfoService userInfoService;

    public UserInfoController(UserInfoServiceImpl userInfoService) {
        this.userInfoService = userInfoService;
    }
    @ApiOperation(value = "显示用户信息", notes = "显示用户信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "openId", dataType = "String", paramType = "query")
            }
    )
    @ResponseBody
    @PostMapping(value = "getUserInfo", produces = "application/json; charset=utf-8")
    public ResponseEntity getUserInfo(@RequestParam("openId") String openId){
        try{
            UserInfo user = userInfoService.getUserInfo(openId);
            if(user==null){
                return new ResponseEntity(new Result("未登录"),HttpStatus.FAILED_DEPENDENCY);
            }
            return new ResponseEntity(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
