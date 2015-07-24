package com.gslab.sample.web.mvc;
 
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping(value="welcome")
public class WelcomeController {
 
	private final Logger LOGGER = Logger.getLogger(WelcomeController.class);
	
	private final String VIEW = "hello";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
 
		LOGGER.debug("index() is executed!");
 
		model.put("title", "Sample Spring Application.");
		model.put("msg", "This is a sample message shown on a VIEW");
 
		return VIEW;
	}
 
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
 
		LOGGER.debug("hello() is executed - $name {}" + name);
 
		ModelAndView modelAndView = new ModelAndView(VIEW);
 
		modelAndView.addObject("title", "Hello" + name);
		modelAndView.addObject("msg", "Its nice meeting you " + name);
 
		return modelAndView;
 
	}
 
}