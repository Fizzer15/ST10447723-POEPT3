/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Management;

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
public class TaskArrayManagementTest {
    
    public TaskArrayManagementTest() {
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
     * Test of createAspectArrays method, of class TaskArrayManagement.
     */
    @Test
    public void testCreateAspectArrays() {
        System.out.println("createAspectArrays");
        TaskArrayManagement instance = null;
        instance.createAspectArrays();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertTasksToArray method, of class TaskArrayManagement.
     */
    @Test
    public void testConvertTasksToArray() {
        System.out.println("convertTasksToArray");
        TaskArrayManagement instance = null;
        String[][] expResult = null;
        String[][] result = instance.convertTasksToArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskArrays method, of class TaskArrayManagement.
     */
    @Test
    public void testDisplayTaskArrays() {
        System.out.println("displayTaskArrays");
        TaskArrayManagement instance = null;
        instance.displayTaskArrays();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayDoneTasks method, of class TaskArrayManagement.
     */
    @Test
    public void testDisplayDoneTasks() {
        System.out.println("displayDoneTasks");
        TaskArrayManagement instance = null;
        instance.displayDoneTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayTaskWithLongestDuration method, of class TaskArrayManagement.
     */
    @Test
    public void testDisplayTaskWithLongestDuration() {
        System.out.println("displayTaskWithLongestDuration");
        TaskArrayManagement instance = null;
        instance.displayTaskWithLongestDuration();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTaskByName method, of class TaskArrayManagement.
     */
    @Test
    public void testSearchTaskByName() {
        System.out.println("searchTaskByName");
        String taskName = "";
        TaskArrayManagement instance = null;
        instance.searchTaskByName(taskName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchTaskByDeveloper method, of class TaskArrayManagement.
     */
    @Test
    public void testSearchTaskByDeveloper() {
        System.out.println("searchTaskByDeveloper");
        String developer = "";
        TaskArrayManagement instance = null;
        instance.searchTaskByDeveloper(developer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTaskByName method, of class TaskArrayManagement.
     */
    @Test
    public void testDeleteTaskByName() {
        System.out.println("deleteTaskByName");
        String taskName = "";
        TaskArrayManagement instance = null;
        boolean expResult = false;
        boolean result = instance.deleteTaskByName(taskName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
