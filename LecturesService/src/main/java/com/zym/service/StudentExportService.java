package com.zym.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.zym.domain.User;

@Service  
public class StudentExportService {  
  
    public HSSFWorkbook export(List<User> list) {  
    String[] excelHeader = { "用户编号", "用户名称", "用户邮箱","手机","院系","地址","注册时间"};  
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("User");  
        HSSFRow row = sheet.createRow((int) 0);  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        for (int i = 0; i < excelHeader.length; i++) {  
            HSSFCell cell = row.createCell(i);  
            cell.setCellValue(excelHeader[i]);  
            cell.setCellStyle(style);  
//            sheet.autoSizeColumn(i); 
          sheet.setColumnWidth(i, 50 *100);  
        }  
        sheet.autoSizeColumn(1, true);
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow(i + 1);  
            User user = list.get(i);  
            row.createCell(0).setCellValue(user.getUserid());  
            row.createCell(1).setCellValue(user.getRealname());  
            row.createCell(2).setCellValue(user.getEmail());  
            row.createCell(3).setCellValue(user.getPhone());  
            row.createCell(4).setCellValue(user.getColleges().getCollegesname());  
            row.createCell(5).setCellValue(user.getAddress());
            row.createCell(6).setCellValue(user.getAddtime()); 
            
        }  
        return wb;  
    }  
}  