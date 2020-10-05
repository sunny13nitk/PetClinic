package petClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(
    { "", "/" }
)
public class IndexController
{
	private final String indexPage = "index";
	
	@GetMapping(
	    { "/", "", "index" }
	)
	public String loadIndex(
	)
	{
		return indexPage;
	}
}
