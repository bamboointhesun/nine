package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.ActivityPro;

public interface ActivityProMapper {
    int deleteByPrimaryKey(Long proId);

    int insert(ActivityPro record);

    int insertSelective(ActivityPro record);

    ActivityPro selectByPrimaryKey(Long proId);

    int updateByPrimaryKeySelective(ActivityPro record);

    int updateByPrimaryKey(ActivityPro record);

 // 自定义
  	List<ActivityPro> selectAllPros();
}