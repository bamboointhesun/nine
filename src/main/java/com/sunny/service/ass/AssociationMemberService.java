package com.sunny.service.ass;

import java.util.List;

import com.sunny.model.system.AssociationMember;

public interface AssociationMemberService {

	List<AssociationMember> displayMembers();

	void deleteMemberByMemberId(long memberId);

	AssociationMember findUpdateObject(long memberId);

	void updateMember(AssociationMember member);

	void addMember(AssociationMember member);
	
	AssociationMember findAObject(String webLoginame);
	
}
