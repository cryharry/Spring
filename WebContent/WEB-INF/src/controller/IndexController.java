package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Item;
import logic.Shop;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {
	// 객체 생성 Shop
	private Shop shop;
	// 객체 생성된 것을 set메서드 통해 주입
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 디비작업
		// 상품목록을 가져오는 메서드 호출
		List<Item> itemList = shop.getItemList();
		// 데이터형태 바꿈
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);
		
		ModelAndView modelAndView  = new ModelAndView();
		// 저장
		modelAndView.addAllObjects(model);
		// 이동
		//modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
