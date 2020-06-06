package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationExternal;

public interface AssociationExternalMapper {
    int deleteByPrimaryKey(Long sponsorId);

    int insert(AssociationExternal record);

    int insertSelective(AssociationExternal record);

    AssociationExternal selectByPrimaryKey(Long sponsorId);

    int updateByPrimaryKeySelective(AssociationExternal record);

    int updateByPrimaryKey(AssociationExternal record);
    // 自定义
 	List<AssociationExternal> selectAllSponsors();
}