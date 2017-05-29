package com.example.administrator.lecturesmanagerdemo.bean;

public class LecturesClassroomInfo {
	int lecturesid;
	private Integer classroomid;
	private String lat;
	private String lng;
	public int getLecturesid() {
		return lecturesid;
	}
	public void setLecturesid(int lecturesid) {
		lecturesid = lecturesid;
	}
	public Integer getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(Integer classroomid) {
		this.classroomid = classroomid;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
}
