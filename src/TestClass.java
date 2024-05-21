
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestClass {
    public static void main(String[] args) {



        TestClass tc = new TestClass();



        //tc.test2Threads();
        //tc.test3Threads();
        //tc.test2ThreadsStopped();

        //tc.specializedThread();
        //System.out.println("I finished");

    }

    private void test()
    {
        System.out.println("test");
    }


    private void test2Threads()
    {
        Calling call1 = new Calling("Skywalker");
        Calling call2 = new Calling("Chewbacca");

        Thread t1 = new Thread(call1);
        Thread t2 = new Thread(call2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Date now = new Date();
        System.out.println(now + " Finished ");
    }





    private void test3Threads()
    {
        Calling call1 = new Calling("Skywalker");
        Calling call2 = new Calling("Chewbacca",10);

        Thread t1 = new Thread(call1);
        Thread t2 = new Thread(call2);
        t1.start();
        t2.start();

        try{
            for (int i = 0; i <10; i++) {
                Date now = new Date();
                System.out.println(now + ", main Thread");
                TimeUnit.MILLISECONDS.sleep(1);
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupted");
        }
    }




    private void test2ThreadsStopped()
    {
        Calling call1 = new Calling("Skywalker");
        Calling call2 = new Calling("Chewbacca");

        Thread t1 = new Thread(call1);
        Thread t2 = new Thread(call2);
        t1.start();
        t2.start();

        try{
            TimeUnit.MILLISECONDS.sleep(55);
            Date now1 = new Date();
            System.out.println(now1 +  " Do Interrupt Skywalker");


        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupted issue");
        }

        t1.interrupt();

        Date now = new Date();
        System.out.println(now + " Finished ");
    }



    /**
     * Running a thread with a bound job
     */
    public void specializedThread()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("count " + i);
                }
            }
        }).start();



    }


}
