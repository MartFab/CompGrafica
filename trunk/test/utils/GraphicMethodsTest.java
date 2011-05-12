/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import graphics.HandlePoint;
import graphics.primitives.impl.Line;
import graphics.primitives.impl.PolyLine;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GraphicMethodsTest {

    public GraphicMethodsTest() {
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
     * Test of linesIntersect method, of class GraphicMethods.
     */
    @Test
    public void testLinesIntersect() {
        System.out.println("linesIntersect");
        Line lineA = new Line(Color.RED, 5,5,100,100);
        Line lineB = new Line(Color.RED, 5,100,100,5);
        boolean expResult = true;
        boolean result = GraphicMethods.linesIntersect(lineA, lineB);
        assertEquals(expResult, result);

        lineA = new Line(Color.RED, 5,5,5,100);
        lineB = new Line(Color.RED, 100,5,100,100);
        expResult = false;
        result = GraphicMethods.linesIntersect(lineA, lineB);
        assertEquals(expResult, result);

        lineA = new Line(Color.RED, 5,5,25,25);
        lineB = new Line(Color.RED, 50,50,100,100);
        expResult = false;
        result = GraphicMethods.linesIntersect(lineA, lineB);
        assertEquals(expResult, result);

        lineA = new Line(Color.RED, 5,5,25,25);
        lineB = new Line(Color.RED, 50,50,50,100);
        expResult = false;
        result = GraphicMethods.linesIntersect(lineA, lineB);
        assertEquals(expResult, result);
        lineA = new Line(Color.RED, 5,5,100,5);
        lineB = new Line(Color.RED, 5,6,100,5);
        expResult = false;
        result = GraphicMethods.linesIntersect(lineA, lineB);
        assertEquals(expResult, result);
    }

    /**
     * Test of ccw method, of class GraphicMethods.
     */
    @Test
    public void testCcw() {
        System.out.println("ccw");
        HandlePoint a = new HandlePoint(null,5,5);
        HandlePoint b = new HandlePoint(null,100,100);
        HandlePoint c = new HandlePoint(null,100,5);
        int expResult = 1;
        int result = GraphicMethods.ccw(a, b, c);
        assertEquals(expResult, result);

        a = new HandlePoint(null,5,5);
        b = new HandlePoint(null,100,100);
        c = new HandlePoint(null,5,100);
        expResult = -1;
        result = GraphicMethods.ccw(a, b, c);
        assertEquals(expResult, result);

        a = new HandlePoint(null,5,5);
        b = new HandlePoint(null,100,100);
        c = new HandlePoint(null,500,500);
        expResult = 0;
        result = GraphicMethods.ccw(a, b, c);
        assertEquals(expResult, result);
    }

    @Test
    public void testPointInPolygon() {
        System.out.println("pointInPolygon");
        PolyLine pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 100);
        pl.addPoint(100,0);
        pl.addPoint(0, 0);

        boolean res = GraphicMethods.pointInPolygon(pl, 50, 50);
        boolean expectedResult = true;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 100);
        pl.addPoint(100,0);
        pl.addPoint(0, 0);

        res = GraphicMethods.pointInPolygon(pl, 150, 50);
        expectedResult = false;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 100);
        pl.addPoint(100,0);
        pl.addPoint(0, 0);

        res = GraphicMethods.pointInPolygon(pl, 99, 99);
        expectedResult = true;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 100);
        pl.addPoint(100,0);
        pl.addPoint(0, 0);

        res = GraphicMethods.pointInPolygon(pl, 101, 50);
        expectedResult = false;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 200);
        pl.addPoint(200,100);
        pl.addPoint(100, 0);

        res = GraphicMethods.pointInPolygon(pl, 150, 50);
        expectedResult = false;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 200);
        pl.addPoint(200,100);
        pl.addPoint(100, 0);

        res = GraphicMethods.pointInPolygon(pl, 100, 100);
        expectedResult = true;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100, 200);
        pl.addPoint(200,100);
        pl.addPoint(100, 0);

        res = GraphicMethods.pointInPolygon(pl, 0, 101);
        expectedResult = false;

        assertEquals(expectedResult, res);

        pl = new PolyLine(Color.RED, 0,0);

        pl.addPoint(0, 100);
        pl.addPoint(100,100);
        pl.addPoint(100, 200);
        pl.addPoint(200,100);
        pl.addPoint(100, 0);

        res = GraphicMethods.pointInPolygon(pl, 50, 100);
        expectedResult = false;

        assertEquals(expectedResult, res);

    }

}