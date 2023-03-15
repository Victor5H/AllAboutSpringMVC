package io.github.Victor5H;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("tp")
	public String tp() {
		return "tp";
	}
}
