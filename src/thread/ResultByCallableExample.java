package thread;

import java.util.concurrent.*;

public class ResultByCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");

        Callable<Integer> callable = () -> {
            int sum = 0;
            for(int i = 1; i<= 10; i++) {
                sum += i;
            }
            return sum;
        };

        Future<Integer> submit = executorService.submit(callable);

        try {
            int sum = submit.get();
            System.out.println("처리 결과 " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
