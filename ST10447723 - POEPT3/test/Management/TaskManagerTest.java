/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Management;

import Models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HP
 */
public class TaskManagerTest {
    
    public TaskManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setCurrentUser method, of class TaskManager.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        User currentUser = null;
        TaskManager instance = null;
        instance.setCurrentUser(currentUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaskLimit method, of class TaskManager.
     */
    @Test
    public void testSetTaskLimit() {
        System.out.println("setTaskLimit");
        TaskManager instance = null;
        instance.setTaskLimit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class TaskManager.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        TaskManager instance = null;
        instance.addTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTasks method, of class TaskManager.
     */
    @Test
    public void testDisplayTasks() {
        System.out.println("displayTasks");
        TaskManager instance = null;
        instance.displayTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTotalDuration method, of class TaskManager.
     */
    @Test
    public void testDisplayTotalDuration() {
        System.out.println("displayTotalDuration");
        TaskManager instance = null;
        instance.displayTotalDuration();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of taskManagementMenu method, of class TaskManager.
     */
    @Test
    public void testTaskManagementMenu() {
        System.out.println("taskManagementMenu");
        TaskManager instance = null;
        instance.taskManagementMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
