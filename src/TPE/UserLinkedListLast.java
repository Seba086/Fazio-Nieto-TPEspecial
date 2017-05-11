package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedListLast extends UserLinkedList {

	@Override
	public void insertUser(User user) {// INSERTA AL FINAL
		if (first == null) {
			first = user;
			last = first;
		} else {
			last.setNext(user);
			last = user;
		}
		super.size++;
	}
	
	@Override
	public void saveResult(User user, int size, long result) {
		// TODO Auto-generated method stub
		if(size <= 500000){
			user.setTimeLast("500k", result);
		}
		else if( size <= 1000000){
			user.setTimeLast("1m",result);
		}
		else if( size > 3000000){
			user.setTimeLast("3m",result);
		}
	}
}
