package test;

import users.User;
import users.UserServices;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class UserTest {

    public static void main(String[] args) {
        testAddUser();
        //testEditUser();
        testGetUserByEmail();
        testGetUserById();
        testShowUsers();

        testGetName();
        testSetName();
        testGetLastName();
        testSetLastName();
        testIsActive();
        testSetActive();

    }
    private static void printTestResult(String testName, boolean isPassed) {
        if (isPassed) {
            System.out.println(testName + " PASSED");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    public static void testGetName() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        String name = user.getName();
        boolean isPassed = "John".equals(name);
        printTestResult("testGetName", isPassed);
    }

    public static void testSetName() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        user.setName("Jane");
        String name = user.getName();
        if ("Jane".equals(name)) {
            System.out.println("testSetName passed");
        } else {
            System.out.println("testSetName failed");
        }
    }

    public static void testGetLastName() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        String lastName = user.getLastName();
        if ("Doe".equals(lastName)) {
            System.out.println("testGetLastName passed");
        } else {
            System.out.println("testGetLastName failed");
        }
    }

    public static void testSetLastName() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        user.setLastName("Smith");
        String lastName = user.getLastName();
        if ("Smith".equals(lastName)) {
            System.out.println("testSetLastName passed");
        } else {
            System.out.println("testSetLastName failed");
        }
    }

    public static void testIsActive() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        boolean isActive = user.isActive();
        if (isActive) {
            System.out.println("testIsActive passed");
        } else {
            System.out.println("testIsActive failed");
        }
    }

    public static void testSetActive() {
        User user = new User("John", "Doe", 30, "johndoe@example.com", "password");
        user.setActive(false);
        boolean isActive = user.isActive();
        if (!isActive) {
            System.out.println("testSetActive passed");
        } else {
            System.out.println("testSetActive failed");
        }
    }
    public static void testAddUser() {
        // Mocking user input for testing
        String input = "John\nDoe\n30\njohndoe@example.com\npassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirecting System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserServices.addUser();

        // Verify that a user was added and output
        assertEquals(1, UserServices.users.size());
        assertTrue(outContent.toString().contains("Usuario agregado exitosamente"));
    }

    public static void testEditUser() {
        // Mocking user input for testing
        String input = "1\nNewName\nNewLastName\nNO\nNO\nNO\nNO\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirecting System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));



        // Verify that editing was successful
        User editedUser = UserServices.users.get(0);
        assertEquals("John", editedUser.getName());
        assertEquals("Doe", editedUser.getLastName());
        UserServices.editUser();
    }

   public static void testGetUserByEmail() {
        UserServices.addMockUser();
        User user = UserServices.getUserByEmail("johndoe@example.com");
        assertNotNull(user);
        assertEquals("John", user.getName());
    }

    public static void testGetUserById() {
        UserServices.addMockUser();
        User user = UserServices.getUserById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
    }

    public static void testShowUsers() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //UserServices.showUsers();

        // Verify that the list of users was displayed
        //assertTrue(outContent.toString().contains("John Doe"));
    }

    private static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual != null || !expected.equals(actual)) {
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
        System.out.println("expected = " + expected);
    }

    private static void assertNotNull(Object object) {
        if (object == null) {
            throw new AssertionError("Expected a non-null object");
        }
        
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected true");
        }
    }


    }

