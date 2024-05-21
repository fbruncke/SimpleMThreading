public class StartingAThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Before start");
        MyWork mw = new MyWork();
        Thread myThread = new Thread(mw);


        Thread myThreadFP = new Thread(()->{
            for (int i = 0; i < 20; i++) {
                System.out.println("FP: " + i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        myThreadFP.start();
        myThread.start();
        //for (int i = 0; i < 20; i++) {
        //    System.out.println("Main counter: " + i);
        //}

        myThreadFP.join();
        myThread.join();
        System.out.println("Work done");
    }
}
