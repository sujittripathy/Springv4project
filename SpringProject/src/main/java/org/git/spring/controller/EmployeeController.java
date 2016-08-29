package org.git.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@RequestMapping("/add")
	public String addEmployee(){
		return "newemployee";
	}
}
