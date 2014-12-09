package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import logic.Item;

public class ItemDaoImpl implements ItemDao {
	// 디비연결 1,2
	private SimpleJdbcTemplate template;
//	this.template = new SimpleJdbcTemplate(디비연결정보);
	// set메서드 디비연결 정보 주입
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	// 3,4,5 sql 실행 저장
	private static final String SELECT_ALL = "SELECT item_id, item_name, price, description, picture_url FROM item";
	@Override
	public List<Item> findAll() {
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		return this.template.query(SELECT_ALL, mapper);
	}
}
