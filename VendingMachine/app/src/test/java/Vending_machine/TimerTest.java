package RE_07_2412_Assignment2_Group_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import java.util.Date;

public class TimerTest {
        @Test
        void runtest(){
            Timer timer = new Timer();
            Date lastActiveTime = new Date();
            lastActiveTime = new Date();
            String userInput = ("Add\nliuhao\nseller");
            ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(bais);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            System.setOut(printStream);
            timer.run(lastActiveTime,userInput);
        }
}
