package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationJob;

public interface AssociationJobMapper {
    int deleteByPrimaryKey(Long jobId);

    int insert(AssociationJob record);

    int insertSelective(AssociationJob record);

    AssociationJob selectByPrimaryKey(Long jobId);

    int updateByPrimaryKeySelective(AssociationJob record);

    int updateByPrimaryKey(AssociationJob record);
    
    // 自定义
 	List<AssociationJob> selectAllJobs();
}