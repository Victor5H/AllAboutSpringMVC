package io.github.Victor5H;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.github.Victor5H.model.Employee;
import io.github.Victor5H.service.EmployeeService;

@Controller
public class HomeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("home")
	public String getHomePage() {
		return "home";
	}

	@RequestMapping("modelDemo")
	public String modeldemo(Model model) {
		model.addAttribute("name", "Harshit");
		model.addAttribute("email", "harshit@gmail.com");
		List<String> list = new ArrayList<>();
		list.add("Ak47");
		list.add("M249");
		list.add("Desert Eagle");
		model.addAttribute("guns", list);
		return "modelDemo";
	}

	@RequestMapping("modelAndViewDemo")
	public ModelAndView modelViewDemo() {
		ModelAndView modelAndView = new ModelAndView();
		List<String> list = new ArrayList<>();
		list.add("Ak47");
		list.add("M249");
		list.add("Desert Eagle");
		modelAndView.addObject("guns", list);
		modelAndView.setViewName("modelAndViewDemo");
		return modelAndView;
	}

	@RequestMapping("registerEmp")
	public ModelAndView homePage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("empRegistration");
		return mView;
	}

//	@RequestMapping(path = "postEmp", method = RequestMethod.POST)
//	public ModelAndView gotEmp(@RequestParam("name") String name, @RequestParam("id") int id,
//			@RequestParam("email") String email) {
//		ModelAndView mView = new ModelAndView();
//		mView.setViewName("success");
//		mView.addObject("name", name);
//		mView.addObject("id", id);
//		mView.addObject("email", email);
//		employeeService.insertEmp(new Employee(id, name, email));
//		return mView;
//	}
	@RequestMapping(path = "postEmp", method = RequestMethod.POST)
	public ModelAndView gotEmp(@ModelAttribute Employee emp, ModelAndView mView) {
		mView = new ModelAndView();
		mView.setViewName("success");
		employeeService.insertEmp(emp);
		return mView;
	}

	@RequestMapping("allEmployees")
	public ModelAndView getAllEmployees() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("viewAllEmp");
		List<Employee> list = employeeService.selectAllEmp();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping("deleteEmp")
	public ModelAndView deleteEmp() {
		ModelAndView modelAndView = new ModelAndView("deleteEmp");
		return modelAndView;
	}

	@RequestMapping(path = "deletePost", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("successDelete");
		boolean flag = employeeService.deleteEmp(id);
		modelAndView.addObject("flag", flag);
		return modelAndView;
	}

	@RequestMapping("findEmployee")
	public String findOneEmp() {
		return "searchEmp";
	}

	@RequestMapping(path = "postFind", method = RequestMethod.POST)
	public String postFind(@RequestParam("id") int id, Model m) {
		Employee employee = employeeService.selectEmpById(id);
		if (employee == null) {
			m.addAttribute("flag", false);
		} else {
			m.addAttribute("flag", true);
		}
		m.addAttribute("emp", employee);
		return "resultEmp";
	}
}
