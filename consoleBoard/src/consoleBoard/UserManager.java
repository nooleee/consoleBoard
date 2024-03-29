package consoleBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private ArrayList<User> list;
	private Map<String, ArrayList<Board>> userData = new HashMap<>();	// userData = (password/list, password/list, ...)
	
	public UserManager() {
		list = new ArrayList<>();
		
	}
	
	public User createUser(String id, String password) {
		if(!findUserByUserId(id)) {
			User user = new User(id, password);
			list.add(user);
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
	
//	public boolean deleteUser(User user) {
//		
//	}
	
	public User getUserByUserId(String id) {
		for(User user : list) {
			if(user.getId().equals(id))
				return user;
		}
		return new User();
	}
	
	public ArrayList<User> findUserAll() {
		ArrayList<User> copy = new ArrayList<>();
		for(User user : list) {
			copy.add(user.clone());
		}
		return copy;
	}

}
