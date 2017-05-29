package com.zym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.CollegesMapper;
import com.zym.domain.Colleges;

@Service
public class CollegesServiceImpl implements CollegesService {

	@Autowired
	private CollegesMapper collegesMapper;

	public List<Colleges> selectCollegeslist() {
		List<Colleges> list = collegesMapper.selectCollegesList();
		return list;
	}

	public boolean insertColleges(Colleges colleges) {
		if (collegesMapper.selectCollegesbyCollegesname(colleges.getCollegesname()) == null) {
			int result = collegesMapper.insertSelective(colleges);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean updateColleges(Colleges colleges) {
		int result = collegesMapper.updateByPrimaryKeySelective(colleges);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteColleges(int collegesid) {
		int result = collegesMapper.deleteByPrimaryKey(collegesid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Colleges getColleges(int collegesid) {
		return collegesMapper.selectByPrimaryKey(collegesid);

	}

}