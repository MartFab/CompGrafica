/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics.primitives;

import graphics.HandlePoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.Calcs;
import static org.junit.Assert.*;


public class AbstractGraphicPrimitiveTest {

    public AbstractGraphicPrimitiveTest() {
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
     * Test of getDistanceBetweenHandlePoints method, of class AbstractGraphicPrimitive.
     */
    @Test
    public void testGetDistanceBetweenHandlePoints() {
        System.out.println("getDistanceBetweenHandlePoints");
        HandlePoint hp1 = new HandlePoint(null, 15, 15);
        HandlePoint hp2 = new HandlePoint(null, 3, 24);
        AbstractGraphicPrimitive instance = new AbstractGraphicPrimitiveImpl();
        double expResult = 15;
        double result = Calcs.getDistance(hp1, hp2);
        assertEquals(expResult, result, 0.001);
    }

    public class AbstractGraphicPrimitiveImpl extends AbstractGraphicPrimitive {

        public void rotate(double angle) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isPointFromLine(int x, int y) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}