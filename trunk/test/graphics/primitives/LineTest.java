/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics.primitives;

import graphics.primitives.impl.Line;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LineTest {
    
    Line instance;
    
    public LineTest() {
        instance = new Line(Color.RED,0,0,50,50);
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
     * Test of isPointInside method, of class Line.
     */
    @Test
    public void testIsPointInside() {
        System.out.println("isPointInside");
        int x = 50;
        int y = 50;
        Line instance = new Line(Color.RED, 0,0,100,100);
        boolean expResult = true;
        boolean result = instance.isPointFromLine(x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSlope() {
        System.out.println("getSlope");
        double expResult = 1.0;
        double result = instance.getSlope();

        assertEquals(expResult, result, 0.1);
    }

    @Test
    public void testGetOffset() {
        System.out.println("getOffset");
        double expResult = 0;
        double result = instance.getOffset();

        assertEquals(expResult, result, 0.1);

        instance = new Line(Color.RED, 0, 100, 100, 200);
        expResult = 100.0;
        result = instance.getOffset();

        assertEquals(expResult, result, 0.1);
    }

}