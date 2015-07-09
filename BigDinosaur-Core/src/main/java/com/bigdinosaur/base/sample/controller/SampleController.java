package com.bigdinosaur.base.sample.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdinosaur.base.sample.example.ModelSample;



@Controller
public class SampleController {


	
	@RequestMapping(value = "index.action", method = RequestMethod.GET)
	public String googleAuthentication( @ModelAttribute("modelsample") ModelSample modelsample, HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "login";
	}

	

	

}
