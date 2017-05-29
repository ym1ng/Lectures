package com.zym.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.dao.CommentMapper;
import com.zym.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	public List<Comment> selectCommentlist() {
		// return commentMapper.selectenrollList();

		return commentMapper.selectCommentList();
	}

	public Comment selectCommentbyCommentid(int Commentid) {
		return commentMapper.selectByPrimaryKey(Commentid);
	}

	public boolean deleteComment(int Commentid) {
		int result = commentMapper.deleteByPrimaryKey(Commentid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean insertComment(Comment Comment) {
		int result = commentMapper.insertSelective(Comment);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean updateComment(Comment Comment) {
		int result = commentMapper.updateByPrimaryKeySelective(Comment);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Comment selectCommentbylecturesidfirst(int lecturesid) {

		if (commentMapper.selectCommentbylecturesid(lecturesid).size() == 0) {
			return null;
		}
		;
		return commentMapper.selectCommentbylecturesid(lecturesid).get(0);
	}

	public List<Comment> selectCommentlistByLecturesid(int lecturesid) {
		return commentMapper.selectCommentbylecturesid(lecturesid);
	}

	public PageInfo<Comment> queryByPage(Integer pageNo, Integer pageSize,int lecturesid) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Comment> list = commentMapper.selectCommentbylecturesid(lecturesid);
		// 用PageInfo对结果进行包装
		PageInfo<Comment> page = new PageInfo<Comment>(list);
		// 测试PageInfo全部属性
		// System.out.println(page.getPageNum());
		// System.out.println(page.getPageSize());
		// System.out.println(page.getStartRow());
		// System.out.println(page.getEndRow());
		// System.out.println(page.getTotal());
		// System.out.println(page.getPages());
		// System.out.println(page.getFirstPage());
		// System.out.println(page.getLastPage());
		// System.out.println(page.isHasPreviousPage());
		// System.out.println(page.isHasNextPage());
		return page;
	}

	public List<Comment> getCommentByDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentMapper.getCommentByDate(map);
	}

}