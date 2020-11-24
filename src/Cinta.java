
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cinta implements Runnable{

    private ConcurrentLinkedQueue <Elemento> separar = new ConcurrentLinkedQueue<>();
    private DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void añadirelemento(Elemento elemento){
        separar.add(elemento);
    }

    @Override
    public void run() {
        while (!separar.isEmpty()){
            try {

                System.out.printf("%s -> El elemento %d de la tolva %d ha sido clasificado \n", LocalTime.now().format(hora),separar.element().numero_elemento,separar.element().numero_tolva);
                separar.remove();
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
            } catch (InterruptedException e) {
                System.out.printf("Error");
            }
        }

        System.out.printf("Terminado!");
    }



}
