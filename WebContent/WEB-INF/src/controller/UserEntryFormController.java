package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import logic.Shop;
import logic.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEntryFormController {
	private Shop shop;
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@ModelAttribute
	public User setUpForm() {
		return new User();
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birthDay", new CustomDateEditor(dateFormat, false));
	}
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntryView() {
		return "userEntry";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult) {
		// 에러처리
		
		ModelAndView modelAndView = new ModelAndView();
		// 회원가입 메서드 호출
		shop.entryUser(user);
		// 자바빈 데이터 저장
		modelAndView.addObject("user",user);
		// 이동 "userEntrySuccess"
		modelAndView.setViewName("userEntrySuccess");
		return modelAndView;
	}
}
