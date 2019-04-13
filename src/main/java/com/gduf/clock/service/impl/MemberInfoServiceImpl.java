package com.gduf.clock.service.impl;

import com.gduf.clock.dao.MemberInfoMapper;
import com.gduf.clock.entity.MemberInfo;
import com.gduf.clock.service.MemberInfoService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {
    MemberInfoMapper memberInfoMapper;

    public MemberInfoServiceImpl(MemberInfoMapper memberInfoMapper) {
        this.memberInfoMapper = memberInfoMapper;
    }

    @Override
    public List<MemberInfo> getAllMemberInfo() {
        List<MemberInfo> list = new ArrayList<MemberInfo>();
        if(list==null){
            return null;
        }else{
            list = memberInfoMapper.selectAll();
            Collections.sort(list, new Comparator<MemberInfo>(){
                /*
                 * int compare(MemberInfo p1, MemberInfo p2) 返回一个基本类型的整型，
                 * 返回负数表示：p1 小于p2，
                 * 返回0 表示：p1和p2相等，
                 * 返回正数表示：p1大于p2
                 */
                public int compare(MemberInfo p1, MemberInfo p2) {
                    //按照MemberInfo的insist_day进行升序排列
                    if(p2.getInsistDay() < p1.getInsistDay()){
                        return 1;
                    }
                    if(p1.getInsistDay() == p2.getInsistDay()){
                        return 0;
                    }
                    return -1;
                }
            });
            return list;
        }
    }
}
