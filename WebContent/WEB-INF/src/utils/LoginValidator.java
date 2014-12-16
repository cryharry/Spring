package utils;

import logic.User;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object commnad, Errors errors) {
		User user = (User)commnad;
		if(!StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required");
		}
		if(!StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.user");
		}
	}
}
