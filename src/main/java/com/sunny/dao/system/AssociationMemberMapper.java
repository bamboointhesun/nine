package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.AssociationMember;

public interface AssociationMemberMapper {
    int deleteByPrimaryKey(Long memberId);

    int insert(AssociationMember record);

    int insertSelective(AssociationMember record);

    AssociationMember selectByPrimaryKey(Long memberId);

    int updateByPrimaryKeySelective(AssociationMember record);

    int updateByPrimaryKey(AssociationMember record);
    
 // 自定义
 	List<AssociationMember> selectAllMembers();
 	
 	AssociationMember selectAObject(String webLoginame);
    
}