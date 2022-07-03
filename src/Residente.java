public class Residente {
    
    private String nombre;
    private String apellidos;
    private String ID;
    private int Nhabitacion;

    public Residente(String nombre, String apellidos, String ID, int Nhabitacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ID = ID;
        this.Nhabitacion = Nhabitacion;
    }
    
    
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getNhabitacion() {
        return Nhabitacion;
    }

    public void setNhabitacion(int Nhabitacion) {
        this.Nhabitacion = Nhabitacion;
    }
    //fin getters y setters
    
    //metodo para buscar clientes con el mismo ID
    static boolean clienteExistente(String ID, Residencia residencia){
        boolean existe = false;
        for (Residente resi : residencia.getResidentes()) { //forloop cogen el tamaño del array 
            if (resi.getID().equals(ID)) {//si el dni es = sale true
                existe = true;
                break;
            }
        }
        return existe;
    }
    
    static void borraResidente(Residencia residencia , String ID){
        for (Residente resi : residencia.getResidentes()) {
            if (resi.getID().equals(ID)) {
                residencia.deleteResidente(resi);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "\n ID: " + ID + "\n nombre: " + nombre 
                + "\n apellidos: " + apellidos + "\n habitacion: " + Nhabitacion;
    }


    
    
    }
    

