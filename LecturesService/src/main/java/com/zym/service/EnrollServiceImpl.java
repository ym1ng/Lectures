package com.zym.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.dao.EnrollMapper;
import com.zym.domain.Enroll;

@Service
public class EnrollServiceImpl implements EnrollService {

	@Autowired
	private EnrollMapper enrollMapper;

	public List<Enroll> selectEnrolllist() {
		return enrollMapper.selectenrollList();

	}

	public Enroll selectEnrollbyenrollid(long enrollid) {
		return enrollMapper.selectByPrimaryKey(enrollid);
	}

	public boolean insertEnroll(Enroll enroll) {
		int result = enrollMapper.insertSelective(enroll);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean updateEnroll(Enroll enroll) {
		int result = enrollMapper.updateByPrimaryKeySelective(enroll);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteEnroll(long enrollid) {
		int result = enrollMapper.deleteByPrimaryKey(enrollid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Enroll selectEnrollbyuseridLectures(long userid, int lecturesid) {
		Enroll enroll = enrollMapper.selectenrollByUseridAndLecturesid(userid, lecturesid);

		return enroll;
	}

	public int selectcountenroll(int lecturesid) {
		return enrollMapper.selectcountenroll(lecturesid);
	}

	public Map<String, Object> userenroll(long userid, int lecturesid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Enroll enroll = new Enroll();
		enroll.setLecturesid(lecturesid);
		enroll.setUserid(userid);
		enroll.setEnrolltime(new Date());
		if (enrollMapper.insertSelective(enroll) == 1) {
			map.put("code", 200);
			map.put("msg", "报名成功");
		}else{
			map.put("code", 201);
			map.put("msg", "报名失败");
		}
		return map;
	}

	public List<Enroll> queryuserenrollBydate(long userid, Date date) {
		
		return enrollMapper.queryuserenrollBydate(userid, date);
	}

	public PageInfo<Enroll> lecturesQuerylikebyuserid(Integer pageNo, Integer pageSize, long userid) {
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<Enroll> list = enrollMapper.queryuserenrollByuserid(userid);
	    PageInfo<Enroll> page = new PageInfo<Enroll>(list);
	    return page;
	}

	public List<Enroll> getEnrollByDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return enrollMapper.getEnrollByDate(map);
	}

	public List<Enroll> lecturesQuerylikebylecturesid(int lecturesid) {

		return enrollMapper.queryuserenrollBylecturesid(lecturesid);
	}

}