package org.git.spring.controller;

import javax.inject.Inject;
import org.git.spring.service.TempService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/temp")
public class TempController {

	private TempService tempService;
	
	@Inject
	public TempController(TempService ts){
		this.tempService = ts;
	}
	@RequestMapping("/static")
	public @ResponseBody String getStaticTempText(){
		return "This is a static temp text [updated on MAC now]/"+tempService.getStaticTempTest();
	}
}
