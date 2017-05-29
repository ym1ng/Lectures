package com.zym.utils;

import java.io.File;
import java.util.List;

public class VideoUtils {
	public static String processImg(String veido_path, String ffmpeg_path) {
		File file = new File(Base.BASE_PIC_PATH+veido_path);
		if (!file.exists()) {
			System.err.println("·��[" + veido_path + "]��Ӧ����Ƶ�ļ�������!");
			return null;
		}
		List<String> commands = new java.util.ArrayList<String>();
		commands.add(ffmpeg_path);
		commands.add("-i");
		commands.add(Base.BASE_PIC_PATH+veido_path);
		commands.add("-y");
		commands.add("-f");
		commands.add("image2");
		commands.add("-ss");
		commands.add("1");// ������������ý�ȡ��Ƶ������ʱ�Ļ���
		// commands.add("-t");
		// commands.add("0.001");
		commands.add("-s");
		commands.add("700x525");
		commands.add(Base.BASE_PIC_PATH+veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.start();
			System.out.println("��ȡ�ɹ�");
			return  veido_path.substring(0, veido_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
