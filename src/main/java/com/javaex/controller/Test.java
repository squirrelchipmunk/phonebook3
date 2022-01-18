package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class Test {
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String TestPrint(){
		System.out.println("TestPrint");
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value="/writeForm", method={RequestMethod.GET, RequestMethod.POST})
	public String TestPrint2(){
		System.out.println("TestPrint2");
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value="/write", method={RequestMethod.GET, RequestMethod.POST})
	public String TestPrint3(){
		System.out.println("TestPrint3");
		return "/WEB-INF/views/Test.jsp";
	}
}
