package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class UploadAction {
	private File upload;
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	/*
	 * 1. 获取服务器路径
	 * 2. 判断是否存在目标文件夹
	 * 3. 解决文件重名问题
	 * 4. 文件上传
	 */
	public String upload(){
		// 获取服务器路径
		String realPath = ServletActionContext.getRequest().getRealPath("/back/img");
		// 判断是否存在目标文件夹
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdir();
		}
		// 解决文件重名问题
		uploadFileName = new Date().getTime()+"_"+uploadFileName;
		// 文件上传
		try {
			FileUtils.copyFile(upload,new File(realPath, uploadFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
}
