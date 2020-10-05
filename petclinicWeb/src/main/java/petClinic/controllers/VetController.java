package petClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController
{
	private final String vetList = "vets/list";
	
	@GetMapping("/list")
	public String getVetsList(
	)
	{
		
		return vetList;
	}
}
