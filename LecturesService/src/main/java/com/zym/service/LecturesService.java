package com.zym.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.github.pagehelper.PageInfo;
import com.zym.domain.Lectures;


public interface LecturesService {
	List<Lectures> selectLecturesList();
	Lectures selectLecturesbylecturesid(int lecturesid);
	boolean  insertLectures(Lectures lectures);
	boolean  updateLectures(Lectures lectures);
	boolean  deleteLectures(int lecturesid);
	PageInfo<Lectures> queryByPage(Integer pageNo,Integer pageSize);
	PageInfo<Lectures> queryByPagelikename(Integer pageNo,Integer pageSize,String lecturesname);
	List<Lectures> getLecturesInByDate(Map<String, Object> map);
	 HSSFWorkbook export() ;
}
