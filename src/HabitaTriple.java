public class HabitaTriple extends Habitacion {
    
    // Atributos del tipo habitacion
    private double precio;
    private double descuento;

    public HabitaTriple(double precio, int numero) {
        super(numero);
        this.precio = precio;
        descuento = 0.1;
        calcularDescuento3();
    }

        // Calcula descuento del precio de la habitacion
   public void calcularDescuento3(){
       descuento=precio-(precio*descuento);
   }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\nHabitacion Triple{ " + " precio= " + precio + '/' 
                + " precio con descuento= " + descuento + " numero" +numero+'}';
    }
    
    
}
