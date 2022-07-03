
import java.util.ArrayList;
import java.util.Iterator;

public class Residencia {
    private ArrayList<Residente> residentes;
    private ArrayList<Reserva> reservas;
    private ArrayList<Habitacion> habitaciones;

    public Residencia() { 
        residentes = new ArrayList<>();
        reservas = new ArrayList<>();
        habitaciones = new ArrayList<>();
    }

    public ArrayList<Residente> getResidentes() {
        return residentes;
    }

    public void setResidentes(ArrayList<Residente> residente) {
        this.residentes = residente;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public Residente getResidente(String ID){
        
        Residente residente = null;
        boolean encontrado = false;
        //Iterator permite recorrer el arraylist y mostrarlo por pantalla
        Iterator<Residente> it = residentes.iterator();
                while (!encontrado && it.hasNext()) {
            Residente resi = it.next();
            if (resi.getID().equals(ID)) {
                residente = resi;
                encontrado = true;
            }
        }
        return residente;   
    }
    
     public Habitacion getHabitacion(int numero) {
        Habitacion habitacion = null;
        boolean encontrado = false;
        Iterator<Habitacion> it = habitaciones.iterator();// iterator permite recorrer el array y mostrar su contenido
        while (!encontrado && it.hasNext()) {
            Habitacion h = it.next();
            if (h.getNumero() == numero){
                habitacion = h;
                encontrado = true;
            }
        }
        return habitacion;
    }
    
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    
    // Metodos parar borrar instancias 
    public void deleteResidente(Residente residente) { 
        residentes.remove(residente);
    }
    
    public void deleteReservation(Reserva reserva) { 
        reservas.remove(reserva);
    }
    
    public void deleteHabitacion(Habitacion habitacion) { 
        habitaciones.remove(habitacion);
     }
    
    // Metodos para agregar instancias 
    public void addResidente(Residente residente){
        residentes.add(residente);
    }
    
    public void addHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }

    // Metodo para precargar datos
    public static void cargarDatos(Residencia residencia){
        Residente residente;
        Habitacion habitacion;
        Reserva reserva;
        HabitaIndi habitaIndi;
        HabitaDoble habitadoble;
        HabitaTriple habitatriple;
        
        //habitaciones
        habitaIndi = new HabitaIndi(1000,1);
        residencia.addHabitacion(habitaIndi);
        habitaIndi = new HabitaIndi(3000,3);
        residencia.addHabitacion(habitaIndi);
        habitadoble = new HabitaDoble(700,6);
        residencia.addHabitacion(habitadoble);
        habitadoble = new HabitaDoble(900,2);
        residencia.addHabitacion(habitadoble);
        habitatriple = new HabitaTriple(700,1);
        residencia.addHabitacion(habitatriple);
        
        //residentes
        residente = new Residente("Gerard", "Siles aligue", "2222", 6);
        residencia.addResidente(residente);
        residente = new Residente("Juan", "Sanchez paxo", "1111", 3);
        residencia.addResidente(residente);
        residente = new Residente("Ana", "Garica holanda", "3333" , 1);
        residencia.addResidente(residente);
        
        
        //reservas
        residente = residencia.getResidente("2222");
        reserva = new Reserva(1000);
        habitacion = residencia.getHabitacion(1);
        reserva.addHabitacion(habitacion);
        reserva.addResidente(residente);
        residencia.addResidente(residente);

       residente = residencia.getResidente("1111");
        reserva = new Reserva(2);
        habitacion = residencia.getHabitacion(8);
        reserva.addHabitacion(habitacion);
        reserva.addResidente(residente);
        residencia.addReserva(reserva);

       residente = residencia.getResidente("3333");
        reserva = new Reserva(1);
        habitacion = residencia.getHabitacion(4);
        reserva.addHabitacion(habitacion);
        reserva.addResidente(residente);
        residencia.addReserva(reserva);
    }

    @Override
    public String toString() {
        return "Residencia{" + " residentes= " + residentes + ", reservas= " 
                + reservas + ", habitaciones= " + habitaciones + '}';
    }


    
    
}
