//*******************************************************************
// Andreas Galatis
// CS320 - Software Testing
// ContactService.java
// 6/12/22
//*******************************************************************

package ContactService;

import java.util.ArrayList;
import java.util.UUID;

public class ContactService {
	
	// declare new Array list
	private ArrayList<Contact> contacts;

	// new contact Array list instance
	public ContactService()
	{
		contacts = new ArrayList<>(); 
	} 
	
	public ArrayList<Contact> getContactList() 
	{ 
		return contacts; 
	}
	
	public void newContact(String firstname, String lastname, String phonenumber, String address) 
	{
		 
		Contact contact = new Contact(newUniqueContactId(), firstname, lastname, phonenumber, address);
		contacts.add(contact);
	}
	
	// Function to create a unique Task ID
	private String newUniqueContactId() {
	    return UUID.randomUUID().toString().substring(
	               0, Math.min(toString().length(), 10));
	  }
	 
	// function to update first name
	public void updateFirstName(String id, String firstName)  {
		searchContact(id).setFirstName(firstName);
	}

	// function to update last name
	public void updateLastName(String id, String lastName) {
		searchContact(id).setLastName(lastName);
	}

	// function to update phone number
	public void updatePhoneNumber(String id, String phoneNumber)  {
		searchContact(id).setPhoneNumber(phoneNumber);
	}

	// function to update address
	public void updateAddress(String id, String address) {
		searchContact(id).setAddress(address);
	}
	
	// function to delete contact
		public void deleteContact(String id) {
			contacts.remove(searchContact(id));
		}
	 
	// function to search for contact
	public Contact searchContact(String id)  {
		int index = 0;
		Contact content = null;
		while (index < contacts.size()) {
			if (id.equals(contacts.get(index).getContactId())) {
				content = contacts.get(index);
			} 
			index++;
		}
		return content; 
	}
}
