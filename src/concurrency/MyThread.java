package concurrency;

public class MyThread extends Thread{

    private int threadNumber;

    public MyThread(Runnable target) {
        super(target);
    }
    public MyThread(Runnable target,int threadNumber) {
        super(target);
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("MyThread number is: "+this.threadNumber);
        super.run();
    }
}
