/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ippbxstatus;

import java.util.EventListener;

/**
 *
 * @author apogee
 */
// Declare the listener class. It must extend EventListener.
// A class must implement this interface to get MyEvents.
public interface MyEventListener extends EventListener {
    public void myEventOccurred(IdleEvent evt);
}
