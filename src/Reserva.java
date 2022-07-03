
import java.util.ArrayList;

public class Reserva {

    private int numeroReserva;
    private ArrayList<Residente> residente;
    private ArrayList<Habitacion> habitacion;

    public Reserva(int NumeroReserva) {
        this.numeroReserva = NumeroReserva;
        residente = new ArrayList();
        habitacion = new ArrayList();
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int NumeroReserva) {
        this.numeroReserva = NumeroReserva;
    }

    public ArrayList<Residente> getResidente() {
        return residente;
    }

    public void setResidente(ArrayList<Residente> residente) {
        this.residente = residente;
    }

    public ArrayList<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(ArrayList<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }

    //recoge todas las reservas y crea una variable en la ultima posicion
    public static int ultimaReserva(Residencia residencia) {
        int numeroUltimaReserva = 0;
        ArrayList<Reserva> reserva = residencia.getReservas();
        // Accede a las reservas, en la ultima posicion,  recibe el numero de esa reserva y suma 
        numeroUltimaReserva = (reserva.get(reserva.size() - 1).getNumeroReserva()) + 2;
        return numeroUltimaReserva;

    }

    public void addResidente(Residente residentes) {
        residente.add(residentes);
    }

    public void addHabitacion(Habitacion habitaciones) {
        habitacion.add(habitaciones);
    }
    
    //metodo para borrar reserva 
    static void borrarReserva(Residencia residencia, int numero) {
        for (Reserva reserva : residencia.getReservas()) {
            if (reserva.getNumeroReserva() == numero) {
                residencia.deleteReservation(reserva);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "\nReserva: " + "Numero= " + numeroReserva + "\n Residente= " + residente ;
    }


    
    

}
