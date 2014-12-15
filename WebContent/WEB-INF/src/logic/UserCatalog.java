package logic;

public interface UserCatalog {
	User findByUserIdAndPassword(String userId, String password);
}
