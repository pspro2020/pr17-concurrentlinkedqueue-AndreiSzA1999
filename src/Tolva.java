import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable {


    private Cinta cinta;
    private DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private int numero_tolva;
    private ArrayList<Elemento> elementos = new ArrayList<>();

    public Tolva(Cinta cinta, int numero_tolva){

        this.cinta = cinta;
        this.numero_tolva = numero_tolva;

        for(int i = 0;i <5 ; i++){

            elementos.add(new Elemento(numero_tolva,i));
        }


    }

    @Override
    public void run() {

        for (Elemento elemento : elementos) {
            try{
                System.out.printf("%s -> El elemento %d de la tolva %d está en la cinta\n",LocalTime.now().format(hora),elemento.numero_elemento,numero_tolva);
                cinta.añadirelemento(elemento);
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s -> Todos los elementos de la tolva %d en la cinta\n", LocalTime.now().format(hora),numero_tolva);

    }
}
