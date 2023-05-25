package thread;

public class IntIncrement {

    public static void main(String[] args) {
        IntHolder holder = new IntHolder();
        Thread th1 = new Thread(new IntIncrementer("thread-1 ",holder));
        Thread th2 = new Thread(new IntIncrementer("thread-2 ",holder));
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
            int result = holder.getIntNum();
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class IntHolder {
    private int intNum = 0;

    public int getIntNum() {
        return intNum;
    }

    public void increment() {
        intNum++;
    }
}

class IntIncrementer implements Runnable {

    private String name;
    private IntHolder intHolder;

    public IntIncrementer(String name, IntHolder intHolder) {
        this.name = name;
        this.intHolder = intHolder;
    }

    @Override
    public void run() {
        System.out.println("[" + this.name + "started");
        for(int count = 0; count < 1000000; count++) {
            intHolder.increment();
        }
        System.out.println("[" + this.name + "end");
    }
}
