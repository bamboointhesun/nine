package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.ApplyActivity;

public interface ApplyActivityMapper {
    int deleteByPrimaryKey(Long appId);

    int insert(ApplyActivity record);

    int insertSelective(ApplyActivity record);

    ApplyActivity selectByPrimaryKey(Long appId);

    int updateByPrimaryKeySelective(ApplyActivity record);

    int updateByPrimaryKey(ApplyActivity record);
    
    List<ApplyActivity> selectAllApplys();
    
    List<ApplyActivity> selectByActivityName(String ActicityName);
}