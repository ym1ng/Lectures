package com.zym.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zym.domain.Enroll;

public interface EnrollService {
	List<Enroll> selectEnrolllist();

	Enroll selectEnrollbyenrollid(long enrollid);

	boolean insertEnroll(Enroll enroll);

	boolean updateEnroll(Enroll enroll);

	boolean deleteEnroll(long enrollid);

	Enroll selectEnrollbyuseridLectures(long userid, int lecturesid);

	int selectcountenroll(int lecturesid);
	List<Enroll> lecturesQuerylikebylecturesid(int lecturesid);
	Map<String, Object> userenroll(long userid,int lecturesid);
	List<Enroll> queryuserenrollBydate(long userid,Date date);
	PageInfo<Enroll> lecturesQuerylikebyuserid(Integer pageNo,Integer pageSize,long userid);
	List<Enroll> getEnrollByDate(Map<String, Object> map);
}