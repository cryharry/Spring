package dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {
	// 디비연결 1,2
	private SimpleJdbcTemplate template;
	// set메서드 디비연결 정보 주입
	public void setDataSource(DataSource dataSource) {
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	private static final String SELECT_BY_USERID_PASSWORD = "SELECT user_id,user_name,password,postcode,address,email,job,birthday FROM user WHERE user_id = ? and password = ?";
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userId, password);
	}

}
