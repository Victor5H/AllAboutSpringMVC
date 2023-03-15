package io.github.Victor5H;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
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

	@RequestMapping("registerEmp")
	public ModelAndView homePage() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("empRegistration");
		return mView;
	}
}
