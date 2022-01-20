package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute; // vo가 있을 때 사용
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {

	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(){
		System.out.println("PhoneController > writeForm()");
		return "writeForm";
	}
	
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo){
		// 파라미터 이름(form의 name)과 setter(필드) 이름이 같아야 함
		System.out.println("PhoneController > write()");
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	/*
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name, 
						@RequestParam("hp") String hp, 
						@RequestParam("company") String company ){
		System.out.println("PhoneController > write()");
		
		System.out.println(name+hp+company);
		PersonVo personVo = new PersonVo(name, hp, company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "";
	}
	*/
	
	/*
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String add( @RequestParam( value = "age", required=false, defaultValue="-1") int age,
			@RequestParam("name") String name) {
		
		System.out.println(name);
		System.out.println(age);
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	*/
	
	
	@RequestMapping(value="/test/{no}/{num}", method= {RequestMethod.GET, RequestMethod.POST})
	public String add( @PathVariable("no") int no,
						@PathVariable("num") int num) {
		
		System.out.println(no);
		System.out.println(num);
		
		return "writeForm";
	}
	
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){
		System.out.println("PhoneController > list()");
		
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		model.addAttribute("pList", personList); // DipatcherServlet이 request attribute에 넣어준다
		return "list";
	}
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(@RequestParam("personId") int personId,
							 Model model){
		
		PersonVo personVo = new PhoneDao().getPerson(personId);
		model.addAttribute("pVo",personVo);
		
		return "updateForm";
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo){
		
		new PhoneDao().personUpdate(personVo);
		return "redirect:/phone/list";
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("personId") int personId){
		
		new PhoneDao().personDelete(personId);
		return "redirect:/phone/list";
	}
	

	
}
	
	
	
	

