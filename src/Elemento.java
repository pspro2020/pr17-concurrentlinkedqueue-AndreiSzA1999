import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Elemento {

    int numero_tolva;
    int numero_elemento;
    private DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Elemento(int numero_tolva,int numero_elemento){
        this.numero_tolva= numero_tolva;
        this.numero_elemento=numero_elemento;
    }


}
