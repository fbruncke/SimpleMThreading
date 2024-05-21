import java.util.Date;


public class CallingStopped implements Runnable{

    private String name;

    public CallingStopped(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i <10 && !Thread.interrupted(); i++) {
                Date now = new Date();
                System.out.println(now + ", " + this.name + ": Calling");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println("Interrupted: "+this.name);
        }


    }
}
