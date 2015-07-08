package com.company.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.model.Equipment;
import com.company.model.LoginCommand;
import com.company.model.LoginInfo;
import com.company.model.ModelSample;
import com.company.model.W0SModel;
import com.company.service.IEqipmentService;

@Controller
public class MainController {

	@Autowired
	private IEqipmentService eqipmentService;

	@RequestMapping(value = "login.action", method = RequestMethod.POST)
	public String afterlogin(
			@ModelAttribute("modelsample") ModelSample modelsample,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "login";
	}
	@RequestMapping(value = "module.action", method = RequestMethod.GET)
	public String modulefirst(
			@ModelAttribute("modelsample") ModelSample modelsample,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "modulefirst";
	}
	@RequestMapping(value = "index.action", method = RequestMethod.GET)
	public String mainloginPage(
			@ModelAttribute("loginInfo") LoginInfo loginInfo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "loginForm";
	}

//	@RequestMapping(value = "index.action", method = RequestMethod.GET)
//	public String login(@ModelAttribute("modelsample") ModelSample modelsample,
//			HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//		return "mainpage";
//	}

	@RequestMapping(value = "book.action", method = RequestMethod.GET)
	public String book(@ModelAttribute("modelsample") ModelSample modelsample,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "book";
	}

	@RequestMapping(value = "admin.action", method = RequestMethod.GET)
	public String admin(
			@ModelAttribute("loginCommand") LoginCommand logincommand,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "admin";
	}

	@RequestMapping(value = "admin.action", method = RequestMethod.POST)
	public String menu(
			@ModelAttribute("loginCommand") LoginCommand logincommand,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "adminMenu";
	}

	@RequestMapping(value = "addvehi.action", method = RequestMethod.GET)
	public String vehicle(
			@ModelAttribute("loginCommand") LoginCommand logincommand,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "addVehicles";
	}

	@RequestMapping(value = "addacc.action", method = RequestMethod.GET)
	public String assesarious(
			@ModelAttribute("loginCommand") LoginCommand logincommand,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "addAccessories";
	}

	@RequestMapping(value = "certificate.action", method = RequestMethod.GET)
	public String certificate(
			@ModelAttribute("loginCommand") LoginCommand logincommand,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "certificate";
	}

	@RequestMapping(value = "10q.action", method = RequestMethod.GET)
	public String call10q(@ModelAttribute("w0sModel") W0SModel w0sModel,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "demo";
	}

	@RequestMapping(value = "execute.action", method = RequestMethod.GET)
	public String call(@ModelAttribute("w0sModel") W0SModel w0sModel,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "demo";
	}

	@RequestMapping(value = "execute1.action", method = RequestMethod.GET)
	public String call1(@ModelAttribute("equipment") Equipment equipment,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		return "login1";
	}

	@RequestMapping(value = "upload.action", method = RequestMethod.POST)
	public String callequipment(@ModelAttribute("w0sModel") W0SModel w0sModel,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// when upload is clicked it is called
		// TODO do DB operation
		// login1 is the name of jsp page
		this.eqipmentService.saveEquipment(null);
		return "login1";
	}
	@RequestMapping(value = "execute2.action", method = RequestMethod.POST)
	public String callequipment1(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("w0sModel") W0SModel w0sModel,
			BindingResult result,ModelMap model)
			throws IOException {
		w0sModel.setName("bbbbbbbbbb");
//		model.put("w0sModel", w0sModel1);
		return "demo";
	//	model.addAttribute("name","dbvalue");
	    
		//ToDO pass equipment in saveEquipment .
		// Equipment equipment 
//		eqipmentService.saveEquipment(null);

		
		
//		return "demo";
	}
	
	@RequestMapping(value = "execute3.action", method = RequestMethod.POST)
	public String processtransfer(@ModelAttribute("equipment") Equipment equipment,
			BindingResult result)
			throws IOException {
		//ToDO pass equipment in saveEquipment .
		// Equipment equipment 
		eqipmentService.saveEquipment(null);
		return "login3";
	}
	@RequestMapping(value = "logout.action", method = RequestMethod.GET)
	public String logout(@ModelAttribute("loginInfo") LoginInfo loginInfo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		return "loginForm";
	}
	@RequestMapping(value = "login.action", method = RequestMethod.GET)
	public String mainMenu(
			@ModelAttribute("modelsample") ModelSample modelsample,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "login";
	}
	@RequestMapping(value = "ajax.action", method = RequestMethod.GET)
	public String ajax(
			@ModelAttribute("modelsample") ModelSample modelsample,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		String a="a";
//		response.getWriter().write(a);
		return "modulefirst";
	}
}
