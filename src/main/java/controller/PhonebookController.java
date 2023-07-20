package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import service.PhonebookService;
import vo.PhonebookVO;

@Controller
public class PhonebookController {

	@Autowired
	PhonebookService service;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.setViewName("index");
		return mv;
	} 
	
	@RequestMapping("/insert")
	public ModelAndView insert(int idx, String hp, String name, String memo) {
		System.out.println(idx+","+hp+","+name+","+memo);
		int result=service.insert(new PhonebookVO(idx, hp, name, memo ));
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/findAll")
	public ModelAndView findAll() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/findOneById")
	public ModelAndView findOneById(int idx) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.addObject("phonebook",service.findOneById(idx));
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/searchFind")
		public ModelAndView searchFind(int idx) {
			ModelAndView mv=new ModelAndView();
			mv.addObject("list", service.findAll());
			mv.addObject("phonebook", service.searchFind(null));
			mv.setViewName("index");
			return mv;
	}
	
	
	@RequestMapping("/update")
	public ModelAndView update(int idx) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.addObject("phonebook",service.update(idx, null));
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int idx) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("list",service.findAll());
		mv.addObject("phonebook",service.delete(idx));
		mv.setViewName("index");
		return mv;
	}
}
