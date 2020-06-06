package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationProject;

public interface AssociationProjectMapper {
    int deleteByPrimaryKey(Long projectId);

    int insert(AssociationProject record);

    int insertSelective(AssociationProject record);

    AssociationProject selectByPrimaryKey(Long projectId);

    int updateByPrimaryKeySelective(AssociationProject record);

    int updateByPrimaryKey(AssociationProject record);
    
    
 // 自定义
 	List<AssociationProject> selectAllProjects();
}