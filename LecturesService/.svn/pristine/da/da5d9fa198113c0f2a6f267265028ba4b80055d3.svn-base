package com.zym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.LecturesTypeMapper;
import com.zym.domain.LecturesType;


@Service
public class LecturesTypeServiceImpl implements LecturesTypeService {

	@Autowired
	private LecturesTypeMapper lecturesTypeMapper;


	public List<LecturesType> selectLecturesTypelist() {
		 return lecturesTypeMapper.selectLecturesTypeList();
	}

	public LecturesType selectLecturesTypebyLecturesTypeid(int lecturestypeid) {
		return lecturesTypeMapper.selectByPrimaryKey(lecturestypeid);
	}

	public boolean insertLecturesType(LecturesType lecturestype) {
		if (lecturesTypeMapper.selectLecturesTypebyLecturestypeName(lecturestype.getLecturestypename())==null) {
			int result = lecturesTypeMapper.insertSelective(lecturestype);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean updateLecturesType(LecturesType lecturestype) {
		int result=lecturesTypeMapper.updateByPrimaryKeySelective(lecturestype);
		if (result==1) {
			return true;
		}
		return false;
	}

	public boolean deleteLecturesType(int lecturestypeid) {
		int result=lecturesTypeMapper.deleteByPrimaryKey(lecturestypeid);
		if (result==1) {
			return true;
		}
		return false;
	}

}