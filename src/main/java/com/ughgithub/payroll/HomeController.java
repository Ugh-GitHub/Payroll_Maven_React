package com.ughgithub.payroll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @Controller marks this class as a Spring MVC controller.
public class HomeController {

	@RequestMapping(value = "/")
	// @RequestMapping flags the index() method to support the / route. It returns index as the name of the template, which Spring Boot’s... (see next comment)
	public String index() {
		return "index";
		// ... autoconfigured view resolver will map to src/main/resources/templates/index.html.
	}

}
