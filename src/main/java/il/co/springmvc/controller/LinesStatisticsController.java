package il.co.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import il.co.springmvc.entities.LinesStatistics;
import il.co.springmvc.services.LinesStatisticsServices;
import il.co.springmvc.servicesimpl.LinesStatisticsServicesImpl;

/**
 * @author Artem Meleshko
 * @version 1.0 2017
 *
 */
@Controller
@RequestMapping(value= {"/" ,"lines"})
public class LinesStatisticsController {
	
	@Autowired
	LinesStatisticsServices service;
	
	@RequestMapping(value= { "/page" } , method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view = new ModelAndView("hello");
		System.out.println("in controller get");
				return view;
	}
	
	@RequestMapping(value= { "/page" } , method = RequestMethod.POST)
	public ModelAndView postPage(@RequestParam(value = "text", required = false, defaultValue = "Try again!)") String text) {
		
		
		
		ModelAndView view = new ModelAndView("hello");
		view.addObject("text", text);
		
		System.out.println("in controller post");
		
		LinesStatistics lines = new LinesStatistics();
//		lines.setLine("kdfav akdfgn kasndf");
//		lines.setLine_length(54);
//		lines.setAverage_w_length(23);
//		lines.setLongest_word("Longest");
//		lines.setShortest_word("Shortest");
//		
//		service.createLineStatistic(lines);
		
		lines = service.findId(4);
		System.out.println(lines);

		service.deleteById(lines);
		System.out.println("GO");
		
		return view;
	}

}
