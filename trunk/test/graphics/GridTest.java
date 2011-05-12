/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GridTest {

    public GridTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getGridPointX method, of class Grid.
     */
    @Test
    public void testGetGridPointX() {
        System.out.println("getGridPointX");
        int x = 37;
        Grid instance = new Grid();
        int expResult = 40;
        int result = instance.getNearestGridPointX(x);
        assertEquals(expResult, result);

        x = 38;
        instance = new Grid();
        expResult = 40;
        result = instance.getNearestGridPointX(x);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGridPointY method, of class Grid.
     */
    @Test
    public void testGetGridPointY() {
        System.out.println("getGridPointY");
        int y = 30;
        Grid instance = new Grid();
        int expResult = 30;
        int result = instance.getNearestGridPointY(y);
        assertEquals(expResult, result);
    }

}