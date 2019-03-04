package org.seedstack.samples.store.domain.model.customer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CustomerTest {

    private Customer customer;
    private String firstName;
    private String lastName;
    private String address;
    private String deliveryAddress;
    private String password;
    private String otherPassword;

    @Before
    public void setUp() throws Exception {
        firstName = "William";
        lastName = "Alvarez";
        address = "Street Parker s/n";
        deliveryAddress = "Street second #123";
        password = "passwordTest123";
        otherPassword = "test123";
        customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setDeliveryAddress(deliveryAddress);
        customer.setPassword(password);
    }

    @Test
    public void getFirstName() {
        assertEquals("William", customer.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    public void getAddress() {
        assertEquals(address, customer.getAddress());
    }

    @Test
    public void getDeliveryAddress() {
        assertEquals(deliveryAddress, customer.getDeliveryAddress());
    }

    @Test
    public void getPassword() {
        assertEquals(password, customer.getPassword());
    }

    @Test
    public void testWithOtherPassword() {
        assertNotEquals(otherPassword, customer.getPassword());
    }

    @Test
    public void setEmptyPassword() {
        String emptyPassword = "";
        customer.setPassword(emptyPassword);
        assertEquals(emptyPassword, customer.getPassword());
    }

    @Test
    public void setNewFirstName() {
        String newFirstName = "Carlos";
        customer.setFirstName(newFirstName);
        assertNotEquals(firstName, customer.getFirstName());
        assertEquals(newFirstName, customer.getFirstName());
    }

    @Test
    public void setNewFirstNameWithNumbers() {
        String newFirstName = "Carlos 123456";
        customer.setFirstName(newFirstName);
        assertNotEquals(firstName, customer.getFirstName());
        assertEquals(newFirstName, customer.getFirstName());
    }

    @Test
    public void setNewFirstNameWithEmptyData() {
        String newFirstName = "";
        customer.setFirstName(newFirstName);
        assertNotEquals(firstName, customer.getFirstName());
        assertEquals(newFirstName, customer.getFirstName());
    }
}
