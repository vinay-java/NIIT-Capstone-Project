package com.controller.product;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/AddProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				 maxFileSize=1024*1024*50,      	// 50 MB
				 maxRequestSize=1024*1024*100)   	// 100 MB

public class AddProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


}