package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationSocial;

public interface AssociationSocialMapper {
    int deleteByPrimaryKey(Long socialId);

    int insert(AssociationSocial record);

    int insertSelective(AssociationSocial record);

    AssociationSocial selectByPrimaryKey(Long socialId);

    int updateByPrimaryKeySelective(AssociationSocial record);

    int updateByPrimaryKey(AssociationSocial record);
    
    // 自定义
  	List<AssociationSocial> selectAllSocials();
}