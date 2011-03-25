/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxstatus;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.event.EventListenerList;

/**
 *
 * @author apogee
 */
public class CheckUserIdle {
    int is_idle;
    int prev_x,prev_y;
    int same_loc_sec;
    int stop_timer;

    Timer timer;
    int m_sec;

    EventListenerList myList = new EventListenerList();

    public void addIdleListener(MyEventListener listener) {
        myList.add(MyEventListener.class, listener);
    }

    public void removeIdleListener(MyEventListener listener) {
        myList.add(MyEventListener.class, listener);
    }

    protected void invokeIdle(IdleEvent idleEvent) {
        Object[] lists = myList.getListenerList();

        // loop through each listener and pass on the event if needed
        int numListeners = lists.length;
        for (int i = 0; i<numListeners; i+=2)
        {
            if (lists[i]==MyEventListener.class)
            {
               // pass the event to the listeners event dispatch method
                ((MyEventListener)lists[i+1]).myEventOccurred(idleEvent);  // dispatchXXX(xxxEvent);
            }
        }
    }

    public CheckUserIdle(int seconds) {
        is_idle = 0;
        same_loc_sec = 0;
        m_sec = seconds;
        stop_timer = 0;
        timer = new Timer();
        timer.schedule(new CheckMouse(), seconds * 1000);
    }

    public void StopCheck() {
        timer.cancel();
        stop_timer = 1;
        //timer = null;
    }

    private void InvokeIdleEvent(int idle_status) {
            IdleEvent e = new IdleEvent(this);
            invokeIdle(e);
    }

    class CheckMouse extends TimerTask {

        public void run() {

            if (stop_timer == 1) {
                //System.exit(0);
                return;
            }

            Point b = MouseInfo.getPointerInfo().getLocation();
            //System.out.println("Time's up!");
            //toolkit.beep();
            //timer.cancel();

            if ((prev_x == b.x) && (prev_y == b.y)) {
                same_loc_sec+=5;
                //System.out.println("Mouse in same position for " + same_loc_sec + " seconds.");
            } else {
                prev_x = b.x;
                prev_y = b.y;

                same_loc_sec = 0;
            }



            if (same_loc_sec == 0 && is_idle != 0) {
                //System.out.println("User is active");
                is_idle = 0;
                InvokeIdleEvent(is_idle);
            } else if (same_loc_sec > 60 && is_idle != 1) {
                //System.out.println("User is Idle");
                is_idle = 1;
                InvokeIdleEvent(is_idle);
            }

            //timer = new Timer();
            timer.schedule(new CheckMouse(), m_sec * 1000);
            //System.exit(0); //Stops the AWT thread (and everything else)
        }
    }
}

