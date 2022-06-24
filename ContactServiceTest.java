//*******************************************************************
// Andreas Galatis
// CS320 - Software Testing
// ContactServiceTest.java
// 6/12/22
//*******************************************************************

package ContactServiceTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import ContactService.ContactService;

class ContactServiceTest {
  
	@Test 
	  void updateFirstNameTest() throws Exception { 
	    ContactService service = new ContactService();
	    service.newContact("Andy", "George", "2025551234", "123 John Doe ln");
	    service.updateFirstName(service.getContactList().get(0).getContactId(),
	    		"Andy");
	    assertEquals("Andy", service.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactId(),
	                         "AndysNameIsTooLong"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactId(), null));
	  }
	
	 @Test
	  void updateLastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact("Andy", "George", "2025551234", "123 John Doe ln");
	    service.updateLastName(service.getContactList().get(0).getContactId(),
	    		"George");
	    assertEquals("George", service.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactId(),
	                         "GeorgesNameIsTooLong"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactId(), null));
	  }
	 
	 @Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact("Andy", "George", "2025551234", "123 John Doe ln");
	    service.updatePhoneNumber(service.getContactList().get(0).getContactId(),
	    		"2025551234");
	    assertEquals("2025551234",
	                 service.getContactList().get(0).getPhoneNumber());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactId(),
	                         "18002025551234"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactId(),
	                         "20255"));
	    assertThrows(IllegalArgumentException.class,
	    			()
	    				-> service.updatePhoneNumber(
	                service.getContactList().get(0).getContactId(), null));
	 
	  }
	 
	 @Test
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact("Andy", "George", "2025551234", "123 John Doe ln");
	    service.updateAddress(service.getContactList().get(0).getContactId(),
	    		"123 John Doe ln");
	    assertEquals("123 John Doe ln", service.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactId(),
	                         "123 John Doe ln, Silver Spring, MD 20910, U.S.A."));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactId(), null));
	  }
	 
	 @Test
	  void deleteContactTest() {
		String tempIdToken;
	    ContactService service = new ContactService();
	    service.newContact("Andy", "George", "2025551234", "123 John Doe ln");
	    tempIdToken = service.getContactList().get(0).getContactId();
	    service.deleteContact(tempIdToken);
	    Assert.assertNull(service.searchContact(tempIdToken)); 
	     
	  }
	 
	
	 
	 

	
	

}
