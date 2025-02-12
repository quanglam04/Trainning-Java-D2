package BT_10;

import java.util.ArrayList;

public abstract class Phone {
	protected ArrayList<Contact> contacts;
	public Phone() {
		contacts = new ArrayList<Contact>();
	}
	public abstract void insertContact(String name,String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name,String newPhone);
	public abstract void searchContact(String name);
	public abstract void showAllContact();
}
