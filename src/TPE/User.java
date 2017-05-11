package TPE;

import java.util.ArrayList;

public class User {
	private User next;
	private Integer userId;
	private ArrayList<String> userInterest = new ArrayList<String>();
	private boolean exists = false;
	private long timeLast500k;
	private long timeLast1m;
	private long timeLast3m;
	private long timeFirst500k;
	private long timeFirst1m;
	private long timeFirst3m;
	private long timeArray500k;
	private long timeArray1m;
	private long timeArray3m;
	
	public boolean exists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}
	
	public Integer getUserId(){
		return userId;
	}
	
	public void setUserId(String id){
		userId = Integer.parseInt(id);
	}
	
	public void addInterest(String interest){
		if(!userInterest.contains(interest)){
			userInterest.add(interest);
		}
	}

	public int compareTo(User user) {
		return this.userId-user.getId();
	}

	private Integer getId() {
		// TODO Auto-generated method stub
		return userId;
	}

	public void setNext(User user) {
		this.next = user;
	}

	public User getNext() {
		return this.next;
	}
	
	public boolean hasNext() {
		if(next != null){
			return true;
		}
		else{
			return false;
		}
	}

	public long getTimeArray(String value) {
		if(value.equals("500k")){
			return timeArray500k;
		} else if(value.equals("1m")){
			return timeArray1m;
		} else{
			return timeArray3m;
		}
	}


	public void setTimeArray(String value, long timeArray) {
		if(value.equals("500k")){
			this.timeArray500k = timeArray;
		} else if(value.equals("1m")){
			this.timeArray1m = timeArray;
		} else if(value.equals("3m")){
			this.timeArray3m = timeArray;
		}
	}

	public long getTimeFirst(String value) {
		if(value.equals("500k")){
			return timeFirst500k;
		} else if(value.equals("1m")){
			return timeFirst1m;
		} else{
			return timeFirst3m;
		}
	}

	public void setTimeFirst(String value, long timeFirst) {
		if(value.equals("500k")){
			this.timeFirst500k = timeFirst;
		} else if(value.equals("1m")){
			this.timeFirst1m = timeFirst;
		} else if(value.equals("3m")){
			this.timeFirst3m = timeFirst;
		}
	}

	public long getTimeLast(String value) {
		if(value.equals("500k")){
			return timeLast500k;
		} else if(value.equals("1m")){
			return timeLast1m;
		} else{
			return timeLast3m;
		}
	}

	public void setTimeLast(String value, long timeLast) {
		if(value.equals("500k")){
			this.timeLast500k = timeLast;
		} else if(value.equals("1m")){
			this.timeLast1m = timeLast;
		} else if(value.equals("3m")){
			this.timeLast3m = timeLast;
		}
	}
}
