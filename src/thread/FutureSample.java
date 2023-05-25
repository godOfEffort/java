package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 작업 처리 요청
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                return "Execution is failed";
            }
            return "finished";
        });

        System.out.println("ExecutorService is started");

        try {
            String message = future.get();
            System.out.println(message);
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
