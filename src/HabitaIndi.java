public class HabitaIndi extends Habitacion {

    private double precio;
    private double sobrecoste;
    
    public HabitaIndi(double precio, int numero) {
        super(numero);
        this.precio = precio;
        sobrecoste = 0.2;
        calcularPrecio();
    }

    public void calcularPrecio(){
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
        return "\nHabitacion Individual{ " + " precio original= " + precio + '/'+ " precio con sobrecoste= " 
                + sobrecoste + " con numero= " + numero +'}' ;
    }
    

    
   
}
