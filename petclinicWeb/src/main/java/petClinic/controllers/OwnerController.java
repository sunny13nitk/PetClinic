package petClinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petClinic.services.OwnerService;

@Controller
@RequestMapping("owners")
public class OwnerController
{
	private final String ownerList = "owners/list";
	
	private final OwnerService ownerSrv;
	
	@Autowired
	public OwnerController(
	        OwnerService ownerSrv
	)
	{
		this.ownerSrv = ownerSrv;
	}
	
	@GetMapping("/list")
	public String getOwnersList(
	        Model model
	)
	{
		model.addAttribute("owners", ownerSrv.findAll());
		return ownerList;
	}
}
