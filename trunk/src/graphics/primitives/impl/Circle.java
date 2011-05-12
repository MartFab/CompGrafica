/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics.primitives.impl;

/**
 *
 * @author Babou
 */

import graphics.primitives.*;
import graphics.*;
import java.awt.Color;

public class Circle extends AbstractGraphicPrimitive{

    static final long serialVersionUID = 1L;
    private HandlePoint startPoint;
    private HandlePoint controlPoint;

    public Circle(Color color, int x, int y, int xAxis, int yAxis) {
        super.setBorderColor(color);
        startPoint = new HandlePoint(this, x, y);
        controlPoint = new HandlePoint(this, xAxis, yAxis);
        rotationPoint = new RotationPoint(this, x, y);
        handlePoints.add(startPoint);
        handlePoints.add(controlPoint);
    }

    public Circle(Circle circle) {
        startPoint = new HandlePoint(circle.getStartPoint());
        controlPoint = new HandlePoint(circle.getControlPoint());
        rotationPoint = new RotationPoint(this, startPoint.getX(), startPoint.getY());
        handlePoints.add(startPoint);
        handlePoints.add(controlPoint);
        setSelected(circle.isSelected());
        setRotationPoint(new RotationPoint(circle.getRotationPoint()));
    }


    @Override
    public String toString() {
        return "Circle " + getStartPoint() + getControlPoint();
    }

    /**
     * @return the startPoint
     */
    public HandlePoint getStartPoint() {
        return startPoint;
    }

    /**
     * @param startPoint the startPoint to set
     */
    public void setStartPoint(HandlePoint startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * @return the controlPoint
     */
    public HandlePoint getControlPoint() {
        return controlPoint;
    }

    /**
     * @param controlPoint the controlPoint to set
     */
    public void setControlPoint(HandlePoint controlPoint) {
        this.controlPoint = controlPoint;
    }

    @Override
    public RotationPoint getRotationPoint() {
        rotationPoint.setX(startPoint.getX());
        rotationPoint.setY(startPoint.getY());
        return rotationPoint;
    }

    public boolean isPointFromLine(int x, int y) {
        return false;
    }

    @Override
    public void setLastHandlePointPosition(double x, double y) {

        
        double newXValue = Math.abs(x - startPoint.getX());
        double newYValue = Math.abs(y - startPoint.getY());
        super.setLastHandlePointPosition(newXValue,newYValue);
    }
}
