import java.util.concurrent.TimeUnit;

public class Main {

    private final static int NUMERO_DE_TOLVAS = 5;


    public static void main(String[] args) throws InterruptedException {

        Cinta cinta = new Cinta();

        Thread ThreadCinta = new Thread(cinta);
        Thread tolva;


        for(int i = 0 ; i < NUMERO_DE_TOLVAS; i++){
            tolva = new Thread(new Tolva(cinta,i));
            tolva.start();
        }

        TimeUnit.SECONDS.sleep(3);

        ThreadCinta.start();

    }
}
