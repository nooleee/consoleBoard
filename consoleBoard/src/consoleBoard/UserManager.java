package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserManager extends User {
	private Random ran = new Random();
	private ArrayList<User> list;
	private Map<User, ArrayList<Board>> userData = new HashMap<>();	// userData = (password/list, password/list, ...)
	
	public UserManager() {
		list = new ArrayList<>();
	}
	
	public User createUser(String id, String password) {
		int code = generateUserCode();
		if(!findUserByUserId(id)) {
			User user = new User(id, password, code);
			list.add(user);
			return user.clone();
		}
		return new User();
	}
	
	private int generateUserCode() {
		int code = 0;
		while(true) {
			code = ran.nextInt(9000) + 1000;
			
			User user = findUserByUserCode(code);
		}
	}
	
	public User findUserByUserCode(int code) {
		for(User user : list) {
			if(user.getCode() == code)
				return user.clone();
		}
		return new User();
	} 
	
	private boolean findUserByUserId(String id) {
		for(User user : list) {
			if(user.getId().equals(id))
				return true;
		}
		return false;
	}
	
	public boolean deleteUser(User user) {
		String userId = user.getId();
		User target = getUserByUserId(userId);
		return list.remove(target);
	}
	
	public User getUserByUserId(String id) {
		for(User user : list) {
			if(user.getId().equals(id))
				return user;
		}
		return new User();
	}
	
	public int getUserSize() {
		return this.list.size();
	}
	
	public ArrayList<User> findUserAll() {
		ArrayList<User> copy = new ArrayList<>();
		for(User user : list) {
			copy.add(user.clone());
		}
		return copy;
	}

}
