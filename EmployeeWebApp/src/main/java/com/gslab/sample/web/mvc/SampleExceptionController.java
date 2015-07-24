package com.gslab.sample.web.mvc;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gslab.sample.exception.SystemException;

@RestController
@RequestMapping(value={"api/exception"})
public class SampleExceptionController {
    
	@RequestMapping(value = "/jsonException", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getJsonException() {
		throw new SystemException("This is exception for JSON request");
	}
	
	@RequestMapping(value = "/viewException", method = RequestMethod.GET)
    public ModelAndView getViewException() {
		throw new SystemException("This is exception for Model and View request");
	}
    
}
