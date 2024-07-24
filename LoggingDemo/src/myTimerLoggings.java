
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {

    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Debug Level: Time display with seconds increments
        timer.scheduleAtFixedRate(new TimerTask() {
            private LocalTime currentTime = LocalTime.of(20, 27, 0);

            @Override
            public void run() {
                logger.debug("Current Time: {}", currentTime);
                currentTime = currentTime.plusSeconds(1);
            }
        }, 0, 1000);

        // Info Level: Time display with minute increments
        timer.scheduleAtFixedRate(new TimerTask() {
            private LocalTime currentTime = LocalTime.of(20, 28, 0);

            @Override
            public void run() {
                logger.info("Current Minute: {}", currentTime);
                currentTime = currentTime.plusMinutes(1);
            }
        }, 0, 60000);

        // Error Level: Time display with hour increments
        timer.scheduleAtFixedRate(new TimerTask() {
            private LocalTime currentTime = LocalTime.of(21, 0, 0);

            @Override
            public void run() {
                logger.error("Current Hour: {}", currentTime);
                currentTime = currentTime.plusHours(1);
            }
        }, 0, 3600000);
    }
}
