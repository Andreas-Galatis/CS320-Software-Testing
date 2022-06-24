//*******************************************************************
// Andreas Galatis
// CS320 - Software Testing
// ContactTest.java
// 6/12/22
//*******************************************************************

package ContactServiceTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactService.Contact;

public class ContactTest {
	
	@Test 
	void contactClassConstructorTest() {
		Contact contact =
	        new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    assertAll("constructor",
	              ()
	                  -> assertEquals("1234567890", contact.getContactId()),
	              ()
	                  -> assertEquals("Andy", contact.getFirstName()),
	              ()
	                  -> assertEquals("George", contact.getLastName()),
	              ()
	                  -> assertEquals("2025551234", contact.getPhoneNumber()),
	              () -> assertEquals( "123 John Doe ln", contact.getAddress()));
	  } 
	
	// check exceptions for contact id being null and too long
	@Test 
	void contactIdNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null, "Andy", "George", "2025551234", "123 John Doe ln");
		});
	}
	
	@Test 
	void contactIdTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890987", "Andy", "George", "2025551234", "123 John Doe ln");
		});
	}
	
	// check exceptions for first name being null and too long
	@Test 
	void contactFirstNameNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", null, "George", "2025551234", "123 John Doe ln");
		});
	}
	
	@Test 
	void contactFirstNameTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "This first name is obviously too long", "George", "2025551234", "123 John Doe ln");
		});
	}
	
	// check exceptions for last name being null and too long
	@Test 
	void contactLastNameNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", null, "2025551234", "123 John Doe ln");
		});
	}
	
	@Test 
	void contactLastNameTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "This last name is obviously too long", "2025551234", "123 John Doe ln");
		});
	}
	
	// check exceptions for phone number being null, too short and too long
	@Test 
	void contactPhoneNumberNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "George", null, "123 John Doe ln");
		});
	}
	
	@Test 
	void contactPhoneNumberTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "George", "18002025551234", "123 John Doe ln");
		});
	}
	
	@Test 
	void contactPhoneNumberTooShortTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "George", "202555", "123 John Doe ln");
		});
	}
	
	// check exceptions for address being null and too long
	@Test 
	void contactAddressNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "George", "2025551234", null);
		});
	}
	
	@Test 
	void contactAddressTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln, somewhere state, 22222, address too long");
		});
	}
	
	
	
	@Test
	  void setFirstNameTest() {
	    Contact contact = new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    contact.setFirstName("John");
	    assertAll(
	        "first name",
	        ()
	            -> assertEquals("John", contact.getFirstName()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setFirstName(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setFirstName("AndysNameIsTooLong")));
	  }
	 

	  @Test
	  void setLastNameTest() {
	    Contact contact = new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    contact.setLastName("George");
	    assertAll(
	        "last name",
	        ()
	            -> assertEquals("George", contact.getLastName()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setLastName(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setLastName("GeorgesNameIsTooLong")));
	  }

	  @Test
	  void setPhoneNumberTest() {
	    Contact contact = new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    contact.setPhoneNumber("2025551234");
	    assertAll("phone number",
	              ()
	                  -> assertEquals("2025551234", contact.getPhoneNumber()),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.setPhoneNumber(null)),
	              ()
	                  -> assertThrows(
	                      IllegalArgumentException.class,
	                      () -> contact.setPhoneNumber("18002025551234")),
	              ()
	                  -> assertThrows(
	                      IllegalArgumentException.class,
	                      () -> contact.setPhoneNumber("5551234")));
	              
	  }

	  @Test
	  void setAddressTest() {
	    Contact contact = new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    contact.setAddress("123 John Doe ln");
	    assertAll("address",
	              ()
	                  -> assertEquals("123 John Doe ln", contact.getAddress()),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.setAddress(null)),
	              ()
	                  -> assertThrows(IllegalArgumentException.class,
	                                  () -> contact.setAddress("123 John Doe ln, Silver Spring, MD 20910, U.S.A.")));
	  }

	  @Test
	  void setContactIdTest() {
	    Contact contact = new Contact("1234567890", "Andy", "George", "2025551234", "123 John Doe ln");
	    contact.setContactId("1234567890");
	    assertAll(
	        "contact ID",
	        ()
	            -> assertEquals("1234567890", contact.getContactId()),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setContactId(null)),
	        ()
	            -> assertThrows(IllegalArgumentException.class,
	                            () -> contact.setContactId("12345678909876")));
	  }
	
	

}
