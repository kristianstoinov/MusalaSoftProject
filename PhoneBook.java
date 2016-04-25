package Xuggler.MusalaSoftProject;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {

	private static final int MAX_COUNTER = 5;
	private Set<Entry> phoneBook;
	private Scanner read;

	public PhoneBook() {
		this.phoneBook = new TreeSet<Entry>();
	}

	
	
	public PhoneBook(File textFile) {
		String part;
		String username;
		String phoneNumber;
		String verifiedNumber;
		try {
			read = new Scanner((Readable) phoneBook);
			while (read.hasNextLine()) {
				part= read.nextLine();
				int separator =part.lastIndexOf(",");
				username = part.substring(0, separator);
				phoneNumber = part.substring(separator);
				verifiedNumber = Entry.checkPhoneNumber(phoneNumber);
				this.phoneBook.add(new Entry(username, verifiedNumber));
			}
		} catch (InvalidPhoneException e) {
			e.printStackTrace();
		} finally {
			if (read != null)
				read.close();
		}
	}

	public void addEntry(String name, String phoneNumber) throws InvalidPhoneException {
		if (name != null && phoneNumber != null) {
			Entry newEntry = new Entry(name, phoneNumber);
			this.phoneBook.add(newEntry);
			System.out.println("Entry added!");
		}
	}

	public void removeEntry(String name) {
		if (name != null) {
			for (Entry ent : this.phoneBook) {
				if (ent.getUsername().equals(name)) {
					this.phoneBook.remove(ent);
				}
			}
		}
		System.out.println("Entry removed!");
	}

	public String getPhoneNumByName(String name) {
		if (name != null) {
			String phoneNum;
			for (Entry ent : this.phoneBook) {
				if (ent.getUsername().equals(name)) {
					phoneNum = ent.getPhoneNum();
					return phoneNum;
				}
			}
			return "No such username!";
		} else {
			return "Invalid username!";
		}
	}

	public void printAllByName() {
		for (Entry entry : this.phoneBook) {
			entry.toString();
		}
	}
	
	public void getLastOutgoingCalls(){
		int counter = 0;
		OutgoingCallsComp comp=new OutgoingCallsComp();
		Set<Entry> topFive=new TreeSet<Entry>(comp);
		topFive.addAll(this.phoneBook);
		while(counter<=MAX_COUNTER){
			for(Entry e:topFive){
				System.out.println(e.toString());
			}
			counter++;
		}		
	}
}
