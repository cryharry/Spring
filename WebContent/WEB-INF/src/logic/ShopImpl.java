package logic;

import java.util.List;

public class ShopImpl implements Shop {
	// 객체 선언 ItemCatalog
	private ItemCatalog itemCatalog;
	// set메서드 객체 생성 주입 받기
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}
	@Override
	public List<Item> getItemList() {
		return this.itemCatalog.getItemList(); //메서드호출
	}
	@Override
	public Item getItemByItemId(Integer itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}
}
