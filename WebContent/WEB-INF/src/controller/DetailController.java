package controller;

import java.util.HashMap;
import java.util.Map;

import logic.Item;
import logic.Shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController{
	// Shop 멤버변수 선언
	private Shop shop;
	// 주입 받기
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@RequestMapping
	public ModelAndView detailItem(Integer itemId) {
		// System.out.println("detailItem");
		// 메서드 호출 itemId에 해당하는 상품정보 가져오기
		Item item = shop.getItemByItemId(itemId);
		// 모델생성
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("item", item);
		
		ModelAndView modelAndView = new ModelAndView();
		// 데이터 저장
		modelAndView.addAllObjects(model);
		// 이동
		modelAndView.setViewName("detail");
		return modelAndView;
	}
}
