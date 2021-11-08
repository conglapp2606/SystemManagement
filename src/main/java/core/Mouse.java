package core;

import java.awt.*;
import java.awt.event.AWTEventListener;

public class Mouse {
    public Mouse(){
        long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK + AWTEvent.MOUSE_WHEEL_EVENT_MASK;
        Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
        {
            public void eventDispatched(AWTEvent e)
            {
                System.out.println(e.getID());
                System.out.println(e.paramString());
                System.out.println(e);
            }
        }, eventMask);
    }
}
