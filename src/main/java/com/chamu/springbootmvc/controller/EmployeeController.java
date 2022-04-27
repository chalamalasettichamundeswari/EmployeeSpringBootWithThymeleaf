package com.chamu.springbootmvc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chamu.springbootmvc.employee.EmployeeServiceImpl;
import com.chamu.springbootmvc.entity.Employee;
import com.chamu.springbootmvc.util.EmailUtil;
import com.chamu.springbootmvc.util.PDFGenerator;

@Controller
public class EmployeeController {
    
	private String DIR_PATH="/Users/chamundeswari/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/Employees/employee";
	@Autowired
	EmployeeServiceImpl empSer;
	@Autowired
	EmailUtil emailUtil;
	@Autowired
	PDFGenerator pdf;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping("/")
	public ModelAndView createEmployee() {
		LOGGER.info("Inside createEmployee()");
		ModelAndView mv = new ModelAndView("createEmployee");
		Employee emp = new Employee();
		mv.addObject("employee", emp);
		return mv;
	}

	@RequestMapping("/viewEmployee")
	public ModelAndView viewEmployee() {
		LOGGER.info("Inside viewEmployee()");
		ModelAndView mv = new ModelAndView("viewEmployee");
		Employee emp = new Employee();
		mv.addObject("employee", emp);
		return mv;
	}

	@RequestMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee emp, ModelMap modelMap) {
		LOGGER.info("Inside saveEmployee()"+emp);
//		By default sl4j default is info and above that level will show up.
//		LOGGER.error("ERROR");
//		LOGGER.warn("WARN");
//		LOGGER.info("INFO");
//		LOGGER.debug("DEBUG");
//		LOGGER.trace("TRACE");
		DateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		Employee createEmployee = empSer.createEmployee(emp);
		String msg = "Employee created with id : " + createEmployee.getId();
		//create employees folder
		String filePath = DIR_PATH
				+ "_ " + currentDateTime + ".pdf";
		pdf.generateItinerary(createEmployee, filePath);
		emailUtil.sendEmail("springtest505@gmail.com",filePath);
		modelMap.addAttribute("msg", msg);
		
		return "createEmployee";
	}

	@RequestMapping("/displayEmployee")
	public String displayEmployees(@ModelAttribute Employee emp, ModelMap modelMap) {
		LOGGER.info("Inside displayEmployees()"+emp);
		Employee employee = empSer.getEmployeeById(emp.getId());
		modelMap.addAttribute("employee", employee);
		return "displayEmployee";
	}

	@RequestMapping("/displayEmployees")
	public String displayEmployee(@ModelAttribute Employee emp, ModelMap modelMap) {
		LOGGER.info("Inside displayEmployee()"+emp);
		List<Employee> employees = empSer.getAllEmployees();
		modelMap.addAttribute("employees", employees);
		return "displayEmployees";
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int id, ModelMap modelMap) {
		LOGGER.info("Inside deleteEmployee()"+id);
		Employee emp = new Employee();
		emp.setId(id);
		// Employee empl = empSer.getEmployeeById(id);
		empSer.deleteEmployee(emp);
		List<Employee> employees = empSer.getAllEmployees();
		modelMap.addAttribute("employees", employees);
		return "displayEmployees";
	}

	@RequestMapping("/updateEmployee")
	public String showUpdate(@RequestParam int id, ModelMap modelMap) {
		LOGGER.info("Inside showUpdate()"+id);
		Employee employee = empSer.getEmployeeById(id);
		modelMap.addAttribute("employee", employee);
		return "editEmployee";
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmployee(Employee emp, ModelMap modelMap) {
		LOGGER.info("Inside updateEmployee()"+emp);
		empSer.updateEmployee(emp);
//		String msg = "Employee updated with id : "+employee.getId();
//		modelMap.addAttribute("msg", msg);
		return "editEmployee";
	}

}
