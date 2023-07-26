package ks47team02.admin.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminCommonController")
@RequestMapping("/admin")
public class CommonController {

	@GetMapping({"","/"})
	public String index(Model model) {
		model.addAttribute("title", "관리자 페이지");
		return "admin/index";
	}
}
