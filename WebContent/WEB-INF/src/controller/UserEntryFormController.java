package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import logic.Shop;
import logic.User;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.UserEntryValidator;

@Controller
public class UserEntryFormController {
	private Shop shop;
	private UserEntryValidator userEntryValidator;
	private MessageSource messageSource;
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public void setUserEntryValidator(UserEntryValidator userEntryValidator) {
		this.userEntryValidator = userEntryValidator;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@ModelAttribute
	public User setUpForm() {
		User user = new User();
		// 설명글 message2 => 자바빈 저장
		MessageSourceAccessor accessor = new MessageSourceAccessor(messageSource);
		user.setUserId(accessor.getMessage("user.userId.default"));
		user.setUserName(accessor.getMessage("user.userName.default"));
		return user;
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
		ModelAndView modelAndView = new ModelAndView();
		// 에러처리
		userEntryValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		try {
			// 회원가입 메서드 호출
			shop.entryUser(user);
			// 자바빈 데이터 저장
			modelAndView.addObject("user",user);
			// 이동 "userEntrySuccess"
			modelAndView.setViewName("userEntrySuccess");
			return modelAndView;

		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}
