//*******************************************************************
// Andreas Galatis
// CS320 - Software Testing
// Contact.java
// 6/12/22
//*******************************************************************

package ContactService;

// contact.java class
public class Contact {
	
	// declare variables
	private String contactId;
	private String firstName; 
	private String lastName;
	private String phoneNumber;
	private String address;
	 
	// costructor 
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	} 
	
	// The contact ID string cannot be longer than 10 characters. 
	// The contact ID shall not be null and shall not be updatable.
	public void setContactId(String contactId) {
		if (contactId == null) {
		      throw new IllegalArgumentException("Contact ID cannot be empty");
		    } else if (contactId.length() > 10) {
		      throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters");
		    } else {
		      this.contactId = contactId;
		    }
	} 
	
	// The firstName String field cannot be longer than 10 characters. 
	// The firstName field shall not be null.
	public void setFirstName(String firstName) {
		if (firstName == null) {
		      throw new IllegalArgumentException("First name cannot be empty");
		    } else if (firstName.length() > 10) {
		      throw new IllegalArgumentException("First name cannot be longer than 10 characters");
		    } else {
		      this.firstName = firstName;
		    }
	}
	
	// The lastName String field that cannot be longer than 10 characters. 
	// The lastName field shall not be null.
	public void setLastName(String lastName) {
		if (lastName == null) {
		      throw new IllegalArgumentException("Last name cannot be empty");
		    } else if (lastName.length() > 10) {
		      throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
		    } else {
		      this.lastName = lastName;
		    }
	}
	
	
	//The phone String field that must be exactly 10 digits. 
	// The phone field shall not be null.
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber == null) {
		      throw new IllegalArgumentException("Phone number cannot be empty.");
		} else if (phoneNumber.length() != 10) {
		      throw new IllegalArgumentException(
		          "Phone number length has to be 10 digits.");
		} else {
		      this.phoneNumber = phoneNumber;
		    }
	}
	
	
	public void setAddress(String address) {
		if (address == null) {
		      throw new IllegalArgumentException("Address cannot be empty");
		    } else if (address.length() > 30) {
		      throw new IllegalArgumentException("Address cannot be longer than 30 characters");
		    } else {
		      this.address = address;
		    }
	}
	
	
	// Accessors
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	
	

}
