package com.zym.service;

import java.util.List;

import com.zym.domain.Classroom;


public interface ClassroomService {
	List<Classroom> selectClassroomlist();
	boolean  insertClassroom(Classroom classroom);
	boolean  updateClassroom(Classroom classroom);
	boolean  deleteClassroom(int classroomid);
	Classroom getClassroom(int classroomid );
}