/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics.primitives;

import graphics.primitives.impl.PolyLine;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RectangleTest {

    public RectangleTest() {
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
     * Test of isPointInside method, of class Rectangle.
     */
    @Test
    public void testIsPointInside() {
        System.out.println("isPointInside");
        int x = 20;
        int y = 40;
        PolyLine instance = new PolyLine(Color.RED, 20,10, true);
        instance.setLastHandlePointPosition(100, 100);
        boolean expResult = true;
        boolean result = instance.isPointFromLine(x, y);
        assertEquals(expResult, result);
    }

}