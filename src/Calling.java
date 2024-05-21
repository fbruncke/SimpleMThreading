import java.util.Date;


public class Calling implements Runnable {

    private String name;
    private long sleepTime = 1;

    public Calling(String name) {
        this.name = name;
    }

    public Calling(String name,long sleepTime ) {
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i <10; i++) {
                Date now = new Date();
                System.out.println(now + ", " + this.name + ": Calling");
                Thread.sleep(this.sleepTime);
            }

        }
        catch (InterruptedException ex)
        {
            Date now = new Date();
            System.out.println("Interrupted: "+ now + ", " + this.name);
        }


    }
}
