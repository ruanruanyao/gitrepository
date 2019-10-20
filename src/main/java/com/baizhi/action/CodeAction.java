package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.util.ValidateImageCodeUtils;

/*
 * 生成验证码
 */
public class CodeAction {
	// 返回值类型为 void
	public void createCodeImage(){
		// 从工具类获取4位验证码
		String securityCode = ValidateImageCodeUtils.getSecurityCode();
		// 将验证码保存至session中
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", securityCode);
		// 生成图片
		BufferedImage createImage = ValidateImageCodeUtils.createImage(securityCode);
		// 将图片以流的形式输出
		ServletOutputStream outputStream = null;
		try {
			outputStream = ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(createImage, "png", outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
