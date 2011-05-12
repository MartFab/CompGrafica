package controllers;

import graphics.HandlePoint;
import graphics.primitives.GraphicPrimitive;
import graphics.primitives.impl.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrawingStateController {

    private DrawingController drawingController;
    /** Constantes para determinar que tipo de accion esta ocurriendo */
    public static final int IDLE = 0;
    public static final int CREATING = 1;
    public static final int DRAWING = 2;
    public static final int MOVING = 3;
    public static final int MOVING_HANDLE_POINT = 4;
    public static final int TRANSFORMING = 5;
    public static final int ROTATING = 6;
    private int state = IDLE;

    public DrawingStateController(DrawingController dc) {
        super();
        this.drawingController = dc;Logger.getLogger(DrawingStateController.class.getName()).setLevel(LogLevelController.getLogLevelManager().getLevel());

    }

    public int changeState(int x, int y) {
        HandlePoint handlePoint = drawingController.getHandlePointAt(x, y);
        GraphicPrimitive selectedGP = drawingController.getSelectedGraphicPrimitive();
        GraphicPrimitive gpAtXY = drawingController.getGraphicPrimitiveAt(x, y);
        GraphicPrimitive editingGP = drawingController.getEditingPrimitive();
        GraphicPrimitive rotatingGP = drawingController.getRotatingPrimitive();
        Class gpToDraw = drawingController.getSelectedGPToDraw();

        switch (state) {
            case IDLE:
//                System.out.println("Idle");
                // Puedo estar:
                //   creando
                //   seleccionando
                //   clickeando un punto de control
                if (gpToDraw != null) {// && handlePoint == null) {
                    setState(CREATING);
                } else if (handlePoint != null) {
                    setState(TRANSFORMING);
                } else if (gpAtXY != null && gpAtXY == selectedGP) {
                    setState(MOVING);
                }
                break;
            case CREATING:
//                System.out.println("Creating");
                if (gpToDraw == null) {
                    setState(IDLE);
                } else if (editingGP != null) {
                    setState(DRAWING);
                }
                break;
            case DRAWING:
//                System.out.println("Drawing");
                if (editingGP == null) {
                    setState(CREATING);
                }
//                else if (editingGP instanceof Point) {
//                    setState(CREATING);
//                }
                break;
            case MOVING:
//                System.out.println("Moving");
                if (handlePoint != null) {
                    setState(TRANSFORMING);
                } else if (gpAtXY == null || gpAtXY != selectedGP) {
                    setState(IDLE);
                }
                break;
            case TRANSFORMING:
//                System.out.println("Transforming");
//                System.out.println("HandlePoint = " + handlePoint + "   RotatingGP = " + rotatingGP);
                if (handlePoint == null) {
                    if (selectedGP != null) {
                        setState(MOVING);
                    } else {
                        setState(IDLE);
                    }
                } else if (rotatingGP != null) {
                    setState(ROTATING);
                }
                break;
            case ROTATING:
//                System.out.println("Rotating");
                if (handlePoint == null) {
                    if (gpAtXY != null) {
                        setState(MOVING);
                    } else {
                        setState(IDLE);
                    }
                }
                break;
            default:
        }

        return getState();
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        StringBuffer stateName = new StringBuffer("New state: ");
        switch (state) {
            case DrawingStateController.IDLE:
                stateName.append("DrawingStateController.IDLE");
                break;
            case DrawingStateController.CREATING:
                stateName.append("DrawingStateController.CREATING");
                break;
            case DrawingStateController.DRAWING:
                stateName.append("DrawingStateController.DRAWING");
                break;
            case DrawingStateController.TRANSFORMING:
                stateName.append("DrawingStateController.TRANSFORMING");
                break;
            case DrawingStateController.ROTATING:
                stateName.append("DrawingStateController.ROTATING");
                break;
            case DrawingStateController.MOVING:
                stateName.append("DrawingStateController.MOVING");
                break;
            default:
        }
        Logger.getLogger(DrawingStateController.class.getName()).log(Level.INFO, stateName.toString());
//        System.out.println(stateName);
    }
}
