package com.gslab.sample.web.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ControllerAdvice
public class DefaultExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	public static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	public static final String REQUEST_WITH_HEADER = "X-Requested-With";
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
		// If the exception is annotated with @ResponseStatus rethrow it and let

		if (XML_HTTP_REQUEST.equals(request.getHeader(REQUEST_WITH_HEADER))) {
			return createJacksonView(e);
		} 
		
		// Otherwise setup and send the user to a default error-view.
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	private ModelAndView createJacksonView(Exception e) {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("message", e.getMessage());
		
		ModelAndView jacksonModelAndView = new ModelAndView(jsonView, modelMap);
		return jacksonModelAndView;

	}
}
