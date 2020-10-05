package petClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController
{
	private final String ownerList = "owners/list";
	
	@GetMapping("/list")
	public String getOwnersList(
	)
	{
		return ownerList;
	}
}
