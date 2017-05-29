package com.zym.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

public class ImageUtils {
	/**
	 * ͨ��BASE64Decoder���룬������ͼƬ
	 * 
	 * @param imgStr
	 *            ������string
	 */
	public static boolean string2Image(String imgStr, String imgFilePath) {
		// ���ֽ������ַ�������Base64���벢����ͼƬ
		if (imgStr == null)
			return false;
		try {
			// Base64����
			byte[] b = new BASE64Decoder().decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					// �����쳣����
					b[i] += 256;
				}
			}
			// ����JpegͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
