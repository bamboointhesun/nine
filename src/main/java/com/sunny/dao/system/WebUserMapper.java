package com.sunny.dao.system;

import com.sunny.model.system.WebUser;

public interface WebUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(WebUser record);

    int insertSelective(WebUser record);

    WebUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(WebUser record);

    int updateByPrimaryKeyWithBLOBs(WebUser record);

    int updateByPrimaryKey(WebUser record);
    
    
// 自定义
	WebUser selectByLoginame(String webLoginame);
}