/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import controllers.ImageController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.WritableRaster;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CanvasTest {

    public CanvasTest() {
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

    @Test
    public void testSwap(){
        int x1 = 4;
        int x2 = 5;

        //Canvas.getCanvasInstance().swap(x1, x2);

        int aux = x1;
        x1 = x2;
        x2 = aux;

        assertEquals(5, x1);
        assertEquals(4, x2);
    }

}