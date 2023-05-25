package thread;

public class AsyncProcess implements Runnable {
    private AsyncCallback callback;

    public AsyncProcess(AsyncCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000L);
            //다른 스레드를 실행 대기로 만든다.
            this.callback.notify("finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AsyncProcess is finished");
    }
}
