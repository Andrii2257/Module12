package hw1;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeCounter {
    private  static int secondsFromStart = 0;
    public static void main(String[] args) {
        System.out.println("Start " + LocalTime.now());
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(()->{
            System.out.println("После запуска прошло " + ++secondsFromStart + " секунд " + LocalTime.now());
        }, 1, 1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(()->{
            System.out.println("Прошло 5 секунд " + LocalTime.now());
        }, 5, 5, TimeUnit.SECONDS);
    }
}