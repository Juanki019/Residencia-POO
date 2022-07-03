public class HabitaDoble extends Habitacion {

    double precio;
    double sobrecoste;

    public HabitaDoble(double precio,int numero) {
        super(numero);
        this.precio = precio;
       sobrecoste = 0.1;
       calcularSobrecoste2();
    }
    
    public void calcularSobrecoste2(){
        sobrecoste = precio+(precio*sobrecoste);
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    
    @Override
    public String toString() {
        return "\nHabitacion Doble{ " + " precio original= " + precio + '/' + " precio con sobrecoste= " 
                + sobrecoste + " numero=" + numero +'}';
    }
    
    
   
}
