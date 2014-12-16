package controller;

import logic.Shop;
import logic.User;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {
	private Shop shop;
	private Validator loginValidator;
	// Setter
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@ModelAttribute
	public User setUpForm() {
		return new User();
	}
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		// 에러처리
		loginValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		try {
			// 유저정보 검색 메서드 호출
			User loginUser = shop.getUserByUserIdAndPassword(user.getUserId(), user.getPassword());
			// 세션값 생성
			
			// 저장
			modelAndView.addObject("loginUser", loginUser);
			// 이동
			modelAndView.setViewName("loginSuccess");
			return modelAndView;
		} catch (EmptyResultDataAccessException e) {
			bindingResult.reject("error.login.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}
