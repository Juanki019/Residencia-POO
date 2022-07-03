
public class Habitacion {

    int numero;

    // Constructor 
    public Habitacion(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Metodo para comprobar si la habitacion existe en la residencia 
    static boolean habitacionExistente(int numero, Residencia residencia) {
        boolean existe = false;

        for (Habitacion habita : residencia.getHabitaciones()) { //
            if (habita.getNumero() == numero) {    //no equals porque es un int     
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Metodo para borrar habitacion de la residencia 
    static void eliminarHabitacion(Residencia residencia, int numero) {
        for (Habitacion habita : residencia.getHabitaciones()) {
            if (habita.getNumero() == numero) {
                residencia.deleteHabitacion(habita);
                break;
            }
        }
    }
}
