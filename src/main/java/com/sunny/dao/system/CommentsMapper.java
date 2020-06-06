package com.sunny.dao.system;

import java.util.List;

import com.sunny.model.system.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);

	List<Comments> selectCommentsByNewId(Long proNo);
}