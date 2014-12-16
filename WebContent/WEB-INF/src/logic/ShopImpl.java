package logic;

import java.util.List;

public class ShopImpl implements Shop {
	// 객체 선언 ItemCatalog
	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;
	// set메서드 객체 생성 주입 받기
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}
	@Override
	public List<Item> getItemList() {
		return itemCatalog.getItemList(); //메서드호출
	}
	@Override
	public Item getItemByItemId(Integer itemId) {
		return itemCatalog.getItemByItemId(itemId);
	}
	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return userCatalog.getUserByUserIdAndPassword(userId, password);
	}
	@Override
	public void entryUser(User user) {
		userCatalog.entryUser(user);
	}
}
