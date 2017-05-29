package com.zym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.dao.ClassroomMapper;
import com.zym.domain.Classroom;

@Service
public class ClassroomServiceImpl implements ClassroomService {

	@Autowired
	private ClassroomMapper classroomMapper;

	public List<Classroom> selectClassroomlist() {
		List<Classroom> list = classroomMapper.selectClassroomList();
		return list;
	}

	public boolean insertClassroom(Classroom classroom) {
		if (classroomMapper.selectClassroombyClassroomname(classroom.getClassroomname()) == null) {
			int result = classroomMapper.insertSelective(classroom);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public boolean updateClassroom(Classroom classroom) {
		int result = classroomMapper.updateByPrimaryKeySelective(classroom);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteClassroom(int classroomid) {
		int result = classroomMapper.deleteByPrimaryKey(classroomid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public Classroom getClassroom(int classroomid) {
		return classroomMapper.selectByPrimaryKey(classroomid);
	}

}