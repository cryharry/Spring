package logic;

import java.util.List;

import dao.ItemDao;
import dao.ItemDaoImpl;

public class ItemCatalogImpl implements ItemCatalog {
	// ItemDaoImpl객체 생성
	//ItemDao itemDao = new ItemDaoImpl();
	private ItemDao itemDao;
	// 객체 생성 주입 받아옴
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	@Override
	public List<Item> getItemList() {
		// 메서드 호출 findAll()
		return this.itemDao.findAll();
	}
	@Override
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}
}
