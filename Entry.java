package Xuggler.MusalaSoftProject;

public class Entry implements Comparable<Object> {

	private static final int POSSIBLE_LENGTH_3 = 14;
	private static final int POSSIBLE_LENGTH_2 = 13;
	private static final int POSSIBLE_LENGTH1 = 10;
	private String username;
	private String phoneNum;
	private int outgoingCalls;

	public Entry(String name, String phoneNum) throws InvalidPhoneException {
		this.setUsername(name);
		this.setPhoneNum(checkPhoneNumber(phoneNum));
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	@Override
	public String toString() {
		return "Entry [username=" + this.getUsername() + ", phoneNum=" + this.getPhoneNum() + "]";
	}

	public void setPhoneNum(String phoneNum) {
		if (phoneNum != null)
			this.phoneNum = phoneNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username != null)
			this.username = username;
	}
	
	

	public int compareTo(Object entry) {
		String entryName1 = this.getUsername().toUpperCase();
		String entryName2 = ((Entry) entry).getUsername().toUpperCase();
		return entryName1.compareTo(entryName2);
	}

	
	
	public static String checkPhoneNumber(String phoneNumber) throws InvalidPhoneException {
		if (phoneNumber != null) {			
			String regex1 = "/+359 [8[7-9]] [2-9]{1} [0-9]{6}/";
			String regex2 = "/0 [8[7-9]] [2-9]{1} [0-9]{6}/";
			String regex3 = "/00359 [8[7-9]] [2-9]{1} [0-9]{6}/";
			
			if (phoneNumber.length() == POSSIBLE_LENGTH1 || phoneNumber.length() == POSSIBLE_LENGTH_2 || phoneNumber.length() == POSSIBLE_LENGTH_3) {
			if(phoneNumber.matches(regex1) || phoneNumber.matches(regex2) || phoneNumber.matches(regex3)){
				return phoneNumber;		
			}	
			}
		}
		throw new InvalidPhoneException("Invalid phone number");
	}

	public int getOutgoingCalls() {
		return outgoingCalls;
	}

	public void setOutgoingCalls(int outgoingCalls) {
		this.outgoingCalls = outgoingCalls;
	}

}
