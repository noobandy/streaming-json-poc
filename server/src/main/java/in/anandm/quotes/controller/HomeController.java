package in.anandm.quotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.anandm.quotes.config.APIConfig;

@Controller
public class HomeController {

	@Autowired
	private APIConfig config;
	
	@GetMapping("/")
	public String getHomePage() {
		
		System.out.println(config);
		return "index";
	}
}
