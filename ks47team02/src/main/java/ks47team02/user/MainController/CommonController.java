package ks47team02.user.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller("userCommonController")
public class CommonController {
	@GetMapping("/user")
	public String main(Model model) {
		
		model.addAttribute("title", "메인화면");
		model.addAttribute("titleText", "메인화면");
		model.addAttribute("contents", "메인 화면을 볼 수 있는 페이지입니다.");
		
		return "user/main";
	}
}
