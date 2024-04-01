package consoleBoard;

import java.util.ArrayList;
import java.util.Random;

public class UserManager extends User {
	private Random ran = new Random();
	private ArrayList<User> list;
	
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
			if(user.getCode() == 0)
				break;
		}
		return code;
	}
	
	public User findUserByUserCode(int code) {
		for(User user : list) {
			if(user.getCode() == code)
				return user.clone();
		}
		return new User();
	} 
	
	public boolean findUserByUserId(String id) {
		for(User user : list) {
			if(user.getId().equals(id))
				return true;
		}
		return false;
	}
	
	public boolean deleteUser(User user) {
		int code = user.getCode();
		User target = getUserByUserCode(code);
		return list.remove(target);
	}
	
	public User getUserByUserCode(int code) {
		for(User user : list) {
			if(user.getCode() == code)
				return user;
		}
		return new User();
	}
	
	public User findUserByPassword(String password) {
		for(User user : list) {
			if(user.getPassword().equals(password))
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
