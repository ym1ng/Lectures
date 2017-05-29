package com.zym.dao;

import java.util.List;

import com.zym.domain.LecturesType;

public interface LecturesTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lecturestypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    int insert(LecturesType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    int insertSelective(LecturesType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    LecturesType selectByPrimaryKey(Integer lecturestypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LecturesType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lecturestype
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LecturesType record);
  List<LecturesType>  selectLecturesTypeList();
 LecturesType selectLecturesTypebyLecturestypeName(String LecturestypeName);
}