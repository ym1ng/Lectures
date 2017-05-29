package com.zym.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zym.domain.Comment;


public interface CommentService {
	List<Comment> selectCommentlist();
	Comment selectCommentbyCommentid(int Commentid);
	boolean  insertComment(Comment Comment);
	boolean  updateComment(Comment Comment);
	boolean  deleteComment(int Commentid);
	Comment  selectCommentbylecturesidfirst(int lecturesid);
	List<Comment> selectCommentlistByLecturesid(int lecturesid);
	PageInfo<Comment> queryByPage(Integer pageNo,Integer pageSize,int lecturesid);
	List<Comment> getCommentByDate(Map<String, Object> map);

}