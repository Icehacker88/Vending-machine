package RE_07_2412_Assignment2_Group_1;

import java.util.Date;

public class Timer extends Thread {

//    public static Date lastActiveTime;

//    public static long remindTime;

//    @Override
    public boolean run(Date lastActiveTime, String input) {
        int remindTime = 12000;
        boolean result = true;
        while (result == true) {
            Date now = new Date();
            long nowTime = now.getTime();
            if (nowTime - lastActiveTime.getTime() > remindTime) {
                System.out.println("Operation takes more than 2 minutes, you have exited.");
                result = false;
                break;
            } else {
                try {
                    Thread.sleep(1);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
