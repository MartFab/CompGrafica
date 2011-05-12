/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import graphics.HandlePoint;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CalculationsTest {

    public CalculationsTest() {
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
     * Test of scalarMult method, of class Calculations.
     */
    @Test
    public void testScalarMult() {
        System.out.println("scalarMult");
        HandlePoint hpA = new HandlePoint(null, -3, 2);
        HandlePoint hpB = new HandlePoint(null, 2, 4);
        Calcs instance = new Calcs();
        double expResult = 2;
        double result = instance.scalarMult(hpA, hpB);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of module method, of class Calculations.
     */
    @Test
    public void testModule() {
        System.out.println("module");
        HandlePoint hp = new HandlePoint(null, -3, 2);
        Calcs instance = new Calcs();
        double expResult = Math.sqrt(13);
        double result = instance.module(hp);
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getAngleBetweenHandlePoints method, of class Calculations.
     */
    @Test
    public void testGetAngleBetweenHandlePoints() {
        System.out.println("getAngleBetweenHandlePoints");
        HandlePoint hpA = new HandlePoint(null, -3, 2);
        HandlePoint hpB = new HandlePoint(null, 2, 4);
        Calcs instance = new Calcs();
        double expResult = 1.446;
        double result = instance.getAngle(hpA, hpB);
        assertEquals(expResult, result, 0.1);
        hpB = new HandlePoint(null, -3, 2);
        hpA = new HandlePoint(null, 2, 4);
        instance = new Calcs();
        expResult = -1.446;
        result = instance.getAngle(hpA, hpB);
        result *= GraphicMethods.ccw(new HandlePoint(null, 0,0), hpA, hpB);
        assertEquals(expResult, result, 0.1);
    }

}