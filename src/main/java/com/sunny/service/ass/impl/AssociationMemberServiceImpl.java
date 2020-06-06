package com.sunny.service.ass.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunny.model.system.AssociationMember;
import com.sunny.service.ass.AssociationMemberService;
import com.sunny.utils.BaseService;

@Service
public class AssociationMemberServiceImpl extends BaseService implements AssociationMemberService {

	@Override
	public List<AssociationMember> displayMembers() {
		List<AssociationMember> allMembers = associationMemberMapperImpl.selectAllMembers();
		return allMembers;
	}

	@Override
	public void deleteMemberByMemberId(long memberId) {
		associationMemberMapperImpl.deleteByPrimaryKey(memberId);
	}

	@Override
	public AssociationMember findUpdateObject(long memberId) {
		AssociationMember member = associationMemberMapperImpl.selectByPrimaryKey(memberId);
		return member;
	}

	@Override
	public void updateMember(AssociationMember member) {
		associationMemberMapperImpl.updateByPrimaryKeySelective(member);
		
	}

	@Override
	public void addMember(AssociationMember member) {
		associationMemberMapperImpl.insertSelective(member);
		
	}

	@Override
	public AssociationMember findAObject(String webLoginame) {
		AssociationMember object = associationMemberMapperImpl.selectAObject(webLoginame);
		return object;
	}

}
