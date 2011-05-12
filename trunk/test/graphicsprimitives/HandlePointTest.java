/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphicsprimitives;

import graphics.HandlePoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandlePointTest {

    public HandlePointTest() {
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
     * Test of pointIsInside method, of class HandlePoint.
     */
    @Test
    public void testPointIsInside() {
        System.out.println("pointIsInside");
        int x = 3;
        int y = 3;
        HandlePoint instance = new HandlePoint(null, 10,10);
        boolean expResult = false;
        boolean result = instance.pointIsInside(x, y);
        assertEquals(expResult, result);

        expResult = true;
        result = instance.pointIsInside(9, 9);
        assertEquals(expResult, result);

        expResult = true;
        result = instance.pointIsInside(11, 12);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.pointIsInside(15, 10);
        assertEquals(expResult, result);

        expResult = true;
        result = instance.pointIsInside(10, 10);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.pointIsInside(92, 9);
        assertEquals(expResult, result);

    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        HandlePoint hp1 = new HandlePoint(null, 10,10);
        HandlePoint hp2 = new HandlePoint(null, 10, 10);
        HandlePoint hp3 = new HandlePoint(null, 10, 15);

        assertEquals(hp1, hp2);
        assertFalse(hp1.equals(hp3));

    }

}