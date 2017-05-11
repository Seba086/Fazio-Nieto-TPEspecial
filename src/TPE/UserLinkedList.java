package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedList implements IUserList {
	protected User first;
	protected User last;
	protected int size = 0;
	protected boolean insertarInicio = false; 
	
	public UserLinkedList(boolean insertarAlInicio){
		this.insertarInicio = insertarAlInicio;
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub

	};
	private void insertarUsuarioInicio(User user){
		user.setNext(first);
		this.first = user;
		this.size++;
	}
	private void insertarUsuarioFinal(User user) {
		if (this.first == null) {
			this.first = user;
			this.last = first;
		} else {
			this.last.setNext(user);
			this.last = user;
		}
		this.size++;
	}
	
	@Override
	public void addUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		Date init = new Date();
		for (User user : users) {
			insertUser(user);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeLast("500k", result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println(result);
	}

	@Override
	public void searchUsers(ArrayList<User> usersQuery) {
		for (User user : usersQuery) {
			user.setExists(false);
			boolean found = false;
			User userTemp = first;
			Date init = new Date();
			int i = 0;
			while (!found && (i < size)) {
				if (userTemp.getUserId().equals(user.getUserId())) {
					found = true;
					user.setExists(true);
				} else {
					if (userTemp.hasNext()) {
						userTemp = userTemp.getNext();
					}
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			saveResult(user, size, result);
		}
	}

	@Override
	public void saveResult(User user, int size, long result) {
		if (size <= 500000) {
			user.setTimeFirst("500k", result);
		} else if (size <= 1000000) {
			user.setTimeFirst("1m", result);
		} else if (size > 3000000) {
			user.setTimeFirst("3m", result);
		}
	}
}
