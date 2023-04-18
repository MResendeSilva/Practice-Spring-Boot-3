package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping // Indica utilização do método get
	public String HelloWorld() {
		return "Acredite no seu potencial! Você é capaz de tudo!";
	}
	
}
