package il.co.springmvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import il.co.springmvc.entities.LinesStatistics;
import il.co.springmvc.services.LinesStatisticsServices;

/**
 * @author Artem Meleshko
 * @version 1.0 2017
 *
 */
@Controller
@RequestMapping(value= {"/" ,"lines"})
public class LinesStatisticsController {
	
	private String absoluteFilePath;
	
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
		lines.setLine("kdfav akdfgn kasndf");
		lines.setLine_length(54);
		lines.setAverage_w_length(23);
		lines.setLongest_word("Longest");
		lines.setShortest_word("Shortest");
		
		service.createLineStatistic(lines);
		
//		lines = service.findId(4);
//		System.out.println(lines);
//
//		service.deleteById(lines);
//		System.out.println("GO");
		
		return view;
	}
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody 
	       ModelAndView uploadFileHandler(@RequestParam("name") String name, 
									@RequestParam("file") MultipartFile file) {
		
		ModelAndView view = new ModelAndView("hello");
		String message = "You successfully uploaded ";
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				absoluteFilePath = serverFile.getAbsolutePath();
								
				view.addObject("name", name);
				view.addObject("message", message);
				return view;
			} catch (Exception e) {
				String eGetMessage = e.getMessage();
				System.out.println(eGetMessage);
				String rootPath = System.getProperty("catalina.home");
				System.out.println(rootPath);
				if(eGetMessage.equals(rootPath + "/" + "tmpFiles" + " (Is a directory)")) {
					eGetMessage = "the file! Fill the file name please";
				}
				message = ("You failed to upload " + eGetMessage);
				view.addObject("message", message);
				return view;
			}
		} else {
			message = "You failed to upload " + name + " because the file was empty.";
			view.addObject("message", message);
			return view;
		}
	}


}
