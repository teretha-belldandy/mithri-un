package net.picenter.picweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pic")
public class PicWebController {

	@RequestMapping(value = "/findpic.json", method = RequestMethod.GET)
	@ResponseBody
	public String findPic() {
		return "a picture";
	}

}
