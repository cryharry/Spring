package controller;

import logic.User;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}
	
	@ModelAttribute
	public User setUpForm() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// 유저정보 검색 메서드 호출
		// 저장
		// 이동
		modelAndView.setViewName("loginSuccess");
		return modelAndView;
	}
}
