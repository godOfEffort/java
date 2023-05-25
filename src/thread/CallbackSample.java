package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackSample {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        AsyncProcess asyncProcess = new AsyncProcess(message -> {
            System.out.println("call back message" + message);
            executorService.shutdown();
        });
        executorService.execute(asyncProcess);
        System.out.println("AsyncProcess is started..");
    }
}
