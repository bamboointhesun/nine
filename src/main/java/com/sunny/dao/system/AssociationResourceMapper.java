package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationResource;

public interface AssociationResourceMapper {
    int deleteByPrimaryKey(Long resourceId);

    int insert(AssociationResource record);

    int insertSelective(AssociationResource record);

    AssociationResource selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(AssociationResource record);

    int updateByPrimaryKey(AssociationResource record);
    
    
    // 自定义
 	List<AssociationResource> selectAllResources();
}