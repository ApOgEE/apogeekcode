/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxstatus;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.event.EventListenerList;

/**
 *
 * @author apogee
 */
public class UserStatusTimer {
    int is_idle;
    int prev_x,prev_y;
    int timecounter;
    int stop_timer;

    Timer timer;
    int m_sec;

    EventListenerList myList = new EventListenerList();

    public void addListener(MyEventListener listener) {
        myList.add(MyEventListener.class, listener);
    }

    public void removeListener(MyEventListener listener) {
        myList.add(MyEventListener.class, listener);
    }

    protected void invokeCheck(IdleEvent idleEvent) {
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

    public UserStatusTimer(int seconds) {
        m_sec = seconds;
        stop_timer = 0;
        timer = new Timer();
        timer.schedule(new CheckStatus(), seconds * 1000);
    }

    public void StopCheck() {
        timer.cancel();
        stop_timer = 1;
        //timer = null;
    }

    private void InvokeCheckEvent() {
            IdleEvent e = new IdleEvent(this);
            invokeCheck(e);
    }

    class CheckStatus extends TimerTask {

        public void run() {
            if (stop_timer == 1) {
                //System.exit(0);
                return;
            }

            timecounter+=m_sec;

            if (timecounter > 60) {
                //System.out.println("User is active");
                timecounter = 0;
                InvokeCheckEvent();
            }

            //timer = new Timer();
            timer.schedule(new CheckStatus(), m_sec * 1000);
            //System.exit(0); //Stops the AWT thread (and everything else)
        }
    }

}
