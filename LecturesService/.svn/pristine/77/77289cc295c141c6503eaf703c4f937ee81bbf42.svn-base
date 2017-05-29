package com.zym.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.dao.LecturesMapper;
import com.zym.domain.Lectures;

@Service  
public class LecturesServiceImpl implements  LecturesService {

    @Autowired  
    private LecturesMapper lecturesMapper;

	public List<Lectures> selectLecturesList() {
		return lecturesMapper.selectLecturesList();
	}


	public Lectures selectLecturesbylecturesid(int lecturesid) {
		// TODO Auto-generated method stub
		return lecturesMapper.selectByPrimaryKey(lecturesid);
	}

	public boolean insertLectures(Lectures lectures) {
		int result = lecturesMapper.insertSelective(lectures);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public boolean updateLectures(Lectures lectures) {		
		int result=lecturesMapper.updateByPrimaryKeySelective(lectures);
		if (result==1) {
			return true;
		}
		return false;
	
	}

	public boolean deleteLectures(int lecturesid) {
		int result=lecturesMapper.deleteByPrimaryKey(lecturesid);
		if (result==1) {
			return true;
		}
		return false;
	}


	public PageInfo<Lectures> queryByPage(Integer pageNo, Integer pageSize) {
		 pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Lectures> list = lecturesMapper.selectLecturesList();
		    //用PageInfo对结果进行包装
		    PageInfo<Lectures> page = new PageInfo<Lectures>(list);
		    //测试PageInfo全部属性
//		    System.out.println(page.getPageNum());
//		    System.out.println(page.getPageSize());
//		    System.out.println(page.getStartRow());
//		    System.out.println(page.getEndRow());
//		    System.out.println(page.getTotal());
//		    System.out.println(page.getPages());
//		    System.out.println(page.getFirstPage());
//		    System.out.println(page.getLastPage());
//		    System.out.println(page.isHasPreviousPage());
//		    System.out.println(page.isHasNextPage());
		    return page;
	}


	public PageInfo<Lectures> queryByPagelikename(Integer pageNo, Integer pageSize, String lecturesname) {
		    pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Lectures> list = lecturesMapper.selectLecturesListlike(lecturesname);
		    PageInfo<Lectures> page = new PageInfo<Lectures>(list);
		    return page;
	}


	public List<Lectures> getLecturesInByDate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return lecturesMapper.getLecturesInByDate( map);
	}


	public HSSFWorkbook export() {
	    String[] excelHeader = {"讲座id","讲座名称","讲座类型","讲座时间","院系","游览次数"};  
	  //   List<User> list =userMapper.selectUserList();
	    List<Lectures>list= lecturesMapper.selectLecturesList();
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        HSSFSheet sheet = wb.createSheet("User");  
	        HSSFRow row = sheet.createRow((int) 0);  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	        for (int i = 0; i < excelHeader.length; i++) {  
	            HSSFCell cell = row.createCell(i);  
	            cell.setCellValue(excelHeader[i]);  
	            cell.setCellStyle(style);  
//	            sheet.autoSizeColumn(i); 
	          sheet.setColumnWidth(i, 50 *100);  
	        }  
	        sheet.autoSizeColumn(1, true);
	        for (int i = 0; i < list.size(); i++) {  
	            row = sheet.createRow(i + 1);  
	            Lectures lectures = list.get(i);  
	            row.createCell(0).setCellValue(lectures.getLecturesid());  
	            row.createCell(1).setCellValue(lectures.getLecturesname());  
	            row.createCell(2).setCellValue(lectures.getLecturesType().getLecturestypename());  
	            row.createCell(3).setCellValue(lectures.getLecturestime());  
	            row.createCell(4).setCellValue(lectures.getColleges().getCollegesname());  
	            row.createCell(5).setCellValue(lectures.getPapeview()); 
	        }  
	        sheet.autoSizeColumn((short)0); //调整第一列宽度
            sheet.autoSizeColumn((short)1); //调整第二列宽度
            sheet.autoSizeColumn((short)2); //调整第三列宽度
            sheet.autoSizeColumn((short)3); //调整第四列宽度
            sheet.autoSizeColumn((short)4); //调整第一列宽度
            sheet.autoSizeColumn((short)5); //调整第二列宽度

	        return wb;  
	}


//	@Override
//	public PageInfo<Lectures> lecturesQuerylikebyuserid(Integer pageNo, Integer pageSize, long userid){
//	    pageNo = pageNo == null?1:pageNo;
//	    pageSize = pageSize == null?10:pageSize;
//	    PageHelper.startPage(pageNo, pageSize);
//	    List<Lectures> list = lecturesMapper.lecturesQuerylikebyuserid(userid);
//	    PageInfo<Lectures> page = new PageInfo<Lectures>(list);
//	    return page;
//	}


	
}