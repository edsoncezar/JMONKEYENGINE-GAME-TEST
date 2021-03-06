package com.jmex.awt.swingui.dnd;

import java.awt.Component;
import java.awt.dnd.DnDConstants;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

/**
 * @author Galun
 */
public class JMEMouseDragGestureRecognizer implements MouseListener, MouseMotionListener {

    private MouseEvent firstEvent = null;
    private int motionThreshold = 5;
    //	private Logger log = logger;
    private JMEDragGestureListener dragGestureListener;
    private Component component;
    private JMEDragAndDrop dnd;

    /**
     * create a new gesture recognizer that will send an event if it detects a drag gesture
     *
     * @param dragAndDropSupport JMEDragAndDrop this recognizer should use
     * @param c   the component to monitor
     * @param act the allowed action (TODO: not yet used - probably remove?) 
     * @param dgl the drag gesture listener
     */
    public JMEMouseDragGestureRecognizer( JMEDragAndDrop dragAndDropSupport, Component c, int act, JMEDragGestureListener dgl ) {
        dragGestureListener = dgl;
        this.component = c;
        c.addMouseListener( this );
        c.addMouseMotionListener( this );
        dnd = dragAndDropSupport;
    }

    protected int mapDragOperationFromModifiers( MouseEvent e ) {
        int mods = e.getModifiersEx();

        if ( ( mods & InputEvent.BUTTON1_DOWN_MASK ) != InputEvent.BUTTON1_DOWN_MASK ) {
            return DnDConstants.ACTION_NONE;
        }

        return DnDConstants.ACTION_MOVE;
    }

    /**
     * Invoked when the mouse has been pressed on a component.
     * <p/>
     *
     * @param e the <code>MouseEvent</code>
     */

    public void mousePressed( MouseEvent e ) {
//    	TestJMEDragAndDrop.addText("mousePressed on " + ((JComponent)e.getSource()).getName());
        if ( mapDragOperationFromModifiers( e ) != DnDConstants.ACTION_NONE ) {
            firstEvent = e;
            e.consume();
        }
    }

    public void mouseReleased( MouseEvent e ) {
        if ( dnd.isDragging() ) {
            dnd.doDrop( e );
        }
        firstEvent = null;
    }

    public void mouseDragged( MouseEvent e ) {
        //log.info("mouseDragged: " + e.getSource());
//    	TestJMEDragAndDrop.addText("mouseDragged: " + ((JComponent)e.getSource()).getName() +
//    			" " + e.getWhen() + " firstEvent" + (firstEvent == null ? "==" : "!=") + "null");
        if ( firstEvent != null ) {
            e.consume();

            int action = mapDragOperationFromModifiers( e );
            if ( action == DnDConstants.ACTION_NONE ) {
                return;
            }

            int dx = Math.abs( e.getX() - firstEvent.getX() );
            int dy = Math.abs( e.getY() - firstEvent.getY() );
            if ( ( dx > getMotionThreshold() ) || ( dy > getMotionThreshold() ) ) {
                SwingUtilities.convertMouseEvent( firstEvent.getComponent(), firstEvent, component );
                final JMEDragGestureEvent dge = new JMEDragGestureEvent( this, action,
                        firstEvent.getPoint(), firstEvent );
                dispatchDragGestureEvent( dge );
                firstEvent = null;
            }
        } else {
            if ( dnd.isDragging() ) {
                dnd.doDrag( e );
                e.consume();
            }
        }
    }

    protected void dispatchDragGestureEvent( final JMEDragGestureEvent event ) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                dragGestureListener.dragGestureRecognized( event );
            }
        } );
    }

    /**
     * get the minimum width in pixel (horiz. and vertical) that one has to drag before the event is fired
     *
     * @return the current threshold
     */
    public int getMotionThreshold() {
        return motionThreshold;
    }

    /**
     * set the minimum width in pixel (horiz. and vertical) that one has to drag before the event is fired
     *
     * @param newThreshold the width in pixel
     */
    public void setMotionThreshold( int newThreshold ) {
        if ( newThreshold < 1 ) {
            throw new IllegalArgumentException( "motion threshold must be at least 1" );
        }
        motionThreshold = newThreshold;
    }

    public void mouseClicked( MouseEvent e ) {
        firstEvent = null;
    }

    public void mouseEntered( MouseEvent e ) {
        if ( dnd.isDragging() ) {
            dnd.mouseEntered( e );
        }
    }

    public void mouseExited( MouseEvent e ) {
        if ( dnd.isDragging() ) {
            dnd.mouseExited( e );
        }
    }

    public void mouseMoved(MouseEvent e) {
	}
}
