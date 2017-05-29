package com.zym.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RenameFileUtils {
    public static String renameFileName(String fileName) {
        String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); // ��ǰʱ���ַ���
        int random = new Random().nextInt(10000);
        String extension = fileName.substring(fileName.lastIndexOf(".")); // �ļ���׺
        return formatDate + random + extension;
    }
}
