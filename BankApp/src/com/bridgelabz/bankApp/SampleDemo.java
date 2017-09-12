package com.bridgelabz.bankApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleDemo extends HttpServlet {
	private String message;
	@Override
	public void init() throws ServletException {
		message="Welcome to bridgelabz";
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text");
		PrintWriter out = resp.getWriter();
		out.println(message);
	}
	@Override
	public void destroy() {
	
	}
}
