//import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
/**
 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
 * seconds have passed.
 */

public class ReminderBeep {
  //Toolkit toolkit;
  int is_idle;
  int prev_x, prev_y;
  int same_loc_sec;

  Timer timer;
  int m_sec;
  public ReminderBeep(int seconds) {
	is_idle = 0;
	same_loc_sec = 0;
	m_sec = seconds;
    //toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new RemindTask(), seconds * 1000);
  }

  class RemindTask extends TimerTask {
    public void run() {
	  PointerInfo a = MouseInfo.getPointerInfo();
	  Point b = a.getLocation();
      System.out.println("Time's up!");
      //toolkit.beep();
      timer.cancel(); 
      
      if ((prev_x == b.x) && (prev_y == b.y)) {
		  same_loc_sec+=5;
		  System.out.println("Mouse in same position for " + same_loc_sec + " seconds.");
	  } else {
		  System.out.println("Mouse moved to x = " + b.x + ", y = " + b.y);
		  prev_x = b.x;
		  prev_y = b.y;
		  same_loc_sec = 0;
	  }
      
      timer = new Timer();
      System.out.println("Reschedule task for " + m_sec + " seconds.");
      timer.schedule(new RemindTask(), m_sec * 1000);
      //System.exit(0); //Stops the AWT thread (and everything else)
    }
  }

  public static void main(String args[]) {
    System.out.println("About to schedule task.");
    new ReminderBeep(5);
    System.out.println("Task scheduled.");
  }
}
