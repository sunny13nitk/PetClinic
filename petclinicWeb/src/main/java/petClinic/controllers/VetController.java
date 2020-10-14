package petClinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import petClinic.repositories.VetsRepository;

@Controller
@RequestMapping("/vets")
public class VetController
{
	private final String vetList = "vets/list";
	
	private final VetsRepository vetSrv;
	
	@Autowired
	public VetController(
	        VetsRepository vetSrv
	)
	{
		super();
		this.vetSrv = vetSrv;
	}
	
	@GetMapping("/list")
	public String getVetsList(
	        Model model
	)
	{
		model.addAttribute("vets", vetSrv.findAll());
		return vetList;
	}
}
