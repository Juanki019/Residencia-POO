
/**
 * @author Juan Carlos Snachez Garcia
 * Actividad 1 - POO
 */
import java.util.Scanner;

public class Main {

    //Creacion de un nuevo objeto (es una residencia)
    private static Residencia R1 = new Residencia();

    public static void main(String[] args) throws Exception { //throws Exception se encarga main de manejar las excepciones
        // Cargamos los datos establecidos en residencia 
        Residencia.cargarDatos(R1);
        menu();
    }

    // Metodo encargado de ejecutar el menu 
    private static void menu() throws Exception {
        printmenu();
        int opcion = opcionM();
        accionMenu(opcion);

    }

    private static void printmenu() {
        // Menu principal mostrado por pantalla
        System.out.println("\n ---- BIENVENIDO AL MENU PRINCIPAL ---- \n"
                + "\n 0 -> SALIR "
                + "\n 1 -> Gestion de reservas "
                + "\n 2 -> Gestion de clientes"
                + "\n 3 -> Gestion de habitaciones"
                + "\n 4 -> Listar Datos"
                + "\n ------------------------------------------------------");

    }

    // Metodo para recoger dato del usuario
    private static int opcionM() throws NumberFormatException {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        while (opcion > 5 || opcion < 0) {
            try {//capturar excepcion por si hay una letra escrita por el usuario 
                System.out.println("\n Introduzca la opcion deseada ->  ");
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n Introduzca un valor numerico ");
            }
        }
        return opcion;
    }

    private static void accionMenu(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                gestionReservas(R1);
                break;
            case 2:
                gestionResidentes(R1);
                break;
            case 3:
                gestionHabitaciones(R1);
                break;
            case 4:
                listarDatos(R1);
                break;
            case 0:
                System.out.println(" -- HASTA PRONTO -- ");
                break;
            default:
                System.out.println(" OPCION INCORRECTA ");//por si ocurre cualquier error

        }
    }

    // Submenu para la gestion de futuros residentes
    private static void gestionResidentes(Residencia residencia) throws Exception {
        menuCliente();
        int opcion = opcionM();
        accionMenuResidente(residencia, opcion);
    }

    // Submenu mostrado 
    private static void menuCliente() {
        System.out.println("---------------------");
        System.out.println("\n Selecciona opcion -> "
                + "\n -------------------------- "
                + "\n 0 -> Volver al menu "
                + "\n 1 -> Agregar un residente nuevo "
                + "\n 2 -> Borrar residente "
                + "\n 3 -> Listar los clientes ");
    }

    private static void accionMenuResidente(Residencia residencia, int opcion) throws Exception {
        switch (opcion) {
            case 0:
                menu();
                break;
            case 1:
                crearResidente(residencia);
                break;
            case 2:
                borrarResidente(residencia);
                break;
            case 3:
                listarResidentes(residencia);
                break;
            default:
                System.out.println(" ERROR ");
        }
    }
// Fin submenu

    // Metodo para crear cliente (opcion 1 del submenu)
    private static void crearResidente(Residencia residencia) throws Exception {
        Residente residente;
        Scanner teclado = new Scanner(System.in);//scanner para capturar la info del usuario

        System.out.println("\nIntroducir el ID -> ");
        String ID = teclado.nextLine();
        // Comprobar si el residente esta registrado
        if (!Residente.clienteExistente(ID, residencia)) {
            System.out.println("\nIntroducir el nombre del futuro residente -> ");
            String nombre = teclado.nextLine();
            System.out.println("\nIntroducir el apellido del futuro residente -> ");
            String apellido = teclado.nextLine();
            System.out.println("\nNumero de la habitacion del residente -> ");
            int Nhabitacion = teclado.nextInt();
            //crear objeto
            residente = new Residente(nombre, apellido, ID, Nhabitacion);
            //se agrega al arraylist creado de la residencia 
            residencia.addResidente(residente);
            System.out.println("\n El residente " + residente + "\n HA SIDO AGREGADO ");
        } else {//si el residente no existe saldra este mensaje 
            System.out.println("\n Hay un mismo usuario con el mismo ID ");
        }
        gestionResidentes(residencia);//para volver al submenu

    }

    // Metodo para borrar cliente (2 opcion del submenu)
    private static void borrarResidente(Residencia residencia) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("   Borrador de residentes   ");
        System.out.println("--------------------");
        System.out.print("Introduca el ID del residente: ");
        String dniClienteBorrar = sc.nextLine();
        Residente.borraResidente(R1, dniClienteBorrar);
        System.out.print("El residente ha sido borrado.\n");
        gestionResidentes(residencia);//para volver al submenu 
    }
    // Metodo para listar listar

    private static void listarResidentes(Residencia residencia) throws Exception {
        System.out.println("----------Residencia Lista---------------");

        System.out.println("Listado de clientes");
        System.out.println("----------------------");

        for (Residente residente : R1.getResidentes()) {
            System.out.println(residente);
        }
        gestionResidentes(residencia);//para volver al submenu
    }

    // Submenu para la gestion de habitaciones
    private static void gestionHabitaciones(Residencia residencia) throws Exception {
        printMenuHabitaciones();
        int opcion = opcionM();
        accionMenuHabita(opcion, residencia);
    }

    //submenu mostrado por pantalla
    private static void printMenuHabitaciones() {
        System.out.println("---------------------");
        System.out.println("\nSeleccione opcion -> ");
        System.out.println("---------------------");
        System.out.println("0 -> Volver al menu principal");
        System.out.println("1 -> Crear una habitacion nueva");
        System.out.println("2 -> Borrar una habitacion");
        System.out.println("3 -> Listar habitaciones");
    }

    private static void accionMenuHabita(int opcion, Residencia residencia) throws Exception {
        switch (opcion) {
            case 0:
                menu();
                break;
            case 1:
                crearHabitacion(residencia);
                break;
            case 2:
                borrarHabitacion(residencia);
                break;
            case 3:
                listarHabitaciones(residencia);
                break;
            default:
                System.out.println(" ERROR ");
        }
    }

    // Metodo para crear habitacion
    private static void crearHabitacion(Residencia residencia) throws Exception {
        int numero = 0;
        int opcion = -1;
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Introduzca el numero de habitacion: ");
            numero = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Introduce un numero valido \n");
        }

        // Comprobar si la habitacion existe 
        if (Habitacion.habitacionExistente(numero, residencia)) {
            System.out.println(" Habitacion ya existente");
            System.out.println(" PRUEBE DE NUEVO!!!!");
            printMenuHabitaciones();
        } else {//si no existe `pasa a un submenu del submenu donde se elige el tipo de habitacion
            System.out.println("Introduzca el tipo de habitacion");
            System.out.println("---------------------");
            System.out.println("0 -> Volver al menu");
            System.out.println("1 -> Habitacion individual");
            System.out.println("2 -> Habitacion doble ");
            System.out.println("3 -> Habitacion triple");
            while (opcion < 0 || opcion > 3) {
                try {
                    System.out.print("\nIntroduzca la opcion: \n");
                    opcion = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Introduzca un numero valido\n");
                }

                switch (opcion) {
                    case 0:
                        menu();
                        break;
                    case 1:
                        crearHabitacionIndividual(residencia, numero);
                        break;
                    case 2:
                        crearHabitacionDoble(residencia, numero);
                        break;
                    case 3:
                        crearHabitacionTriple(residencia, numero);
                        break;
                    default:
                        System.out.println(" ERROR ");
                }
            }
        }
    }

    // Metodo para crear la habitacion simple
    private static void crearHabitacionIndividual(Residencia residencia, int numero) throws Exception {
        HabitaIndi habitaIndi;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el precio: ");
        double precio = teclado.nextDouble();
        habitaIndi = new HabitaIndi(precio, numero);//crear objeto
        residencia.addHabitacion(habitaIndi);//añadir al arrayList 
        System.out.print("La habitacion Individual  ha sido creada " + habitaIndi);
        gestionHabitaciones(residencia);//volver al submenu
    }

    private static void crearHabitacionDoble(Residencia residencia, int numero) throws Exception {
        HabitaDoble habitadoble;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el precio: ");
        double precio = teclado.nextDouble();
        habitadoble = new HabitaDoble(precio, numero);//crear objeto
        residencia.addHabitacion(habitadoble);//crear objeto
        System.out.print("La habitacion doble  ha sido creada " + habitadoble);
        gestionHabitaciones(residencia);

    }

    private static void crearHabitacionTriple(Residencia residencia, int numero) throws Exception {
        HabitaTriple habitatriple;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el precio: ");
        double precio = teclado.nextDouble();
        habitatriple = new HabitaTriple(precio, numero);//crear objeto
        residencia.addHabitacion(habitatriple);//añadir al arrayList
        System.out.print("La habitacion triple ha sido creada " + habitatriple);
        gestionHabitaciones(residencia);

    }

    // Metodo para borrar habitaciones
    private static void borrarHabitacion(Residencia residencia) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n-----------------------");
        System.out.println("   Borrar habitacion   ");
        System.out.println("-----------------------");
        System.out.print("Introduca el numero de la habitacion: ");
        int numeroHabitacionBorrar = Integer.parseInt(teclado.nextLine());
        Habitacion.eliminarHabitacion(R1, numeroHabitacionBorrar);
        System.out.print("La habitacion se ha borrado.");
        gestionHabitaciones(residencia);

    }

    // Metodo para listar habitaciones reservadas/creadas
    private static void listarHabitaciones(Residencia residencia) throws Exception {
        HabitaIndi habitaIndi;
        HabitaDoble habitadoble;
        HabitaTriple habitatriple;

        System.out.println("\n--------------------------");
        System.out.println(" Listado de habitaciones");
        System.out.println("--------------------------");

        for (Habitacion habitacion : residencia.getHabitaciones()) {
            if (habitacion instanceof HabitaIndi) {
                habitaIndi = (HabitaIndi) habitacion;
                System.out.println(habitaIndi);
            } else if (habitacion instanceof HabitaDoble) {
                habitadoble = (HabitaDoble) habitacion;
                System.out.println(habitadoble);
            } else if (habitacion instanceof HabitaTriple) {
                habitatriple = (HabitaTriple) habitacion;
                System.out.println(habitatriple);
            }
        }
        gestionHabitaciones(residencia);
    }

    // Submenu para gestionar reservs
    private static void gestionReservas(Residencia residencia) throws Exception {
        menuReservas();
        int opcion = opcionM();
        accionReservas(residencia, opcion);
    }

    private static void menuReservas() {
        System.out.println("\n---------------------");
        System.out.println("Gestion de reservas");
        System.out.println("---------------------");
        System.out.println("0. Volver al menu principal");
        System.out.println("1. Crear una reserva nueva");
        System.out.println("2. Borrar una reserva");
        System.out.println("3. Listar reservas");
    }

    private static void accionReservas(Residencia residencia, int opcion) throws Exception {
        switch (opcion) {
            case 0:
                menu();
                break;
            case 1:
                crearReserva(residencia);
            case 2:
                borrarReserva(residencia);
                break;
            case 3:
                listarReservas(residencia);
                break;
            default:
                // definimos el default del menu por si ocurre un error en el programa
                System.out.println("Un error desconocido ha ocurrido, reinicie la aplicacion");
                break;
        }
    } // fin del submenu

    // Metodo para crear una reserva 
    private static void crearReserva(Residencia residencia) throws Exception {
        Reserva reservas;
        Residente residente = null;
        Habitacion habitacion;
        int numeroHabitacion = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println(" Insertar el ID del futuro residente ");
        String Id = teclado.nextLine();
        //para buscar si el residente existe
        try {
            if (Residente.clienteExistente(Id, residencia)) {
                residente = residencia.getResidente(Id);
                System.out.println("\nInformacion del cliente: " + residente);
            } else {
                // Imprimo que el cliente no existe y devuelvo al menu
                System.out.println("Este cliente no existe");
                System.out.println("Procedemos a insertar datos de este... \n");
            }
        } catch (NumberFormatException e) {//capturar excepcion
            System.err.println("Introduce un cliente valido" + e);
        }

        // Recibir el numero de reserva
        int numeroReserva = Reserva.ultimaReserva(residencia);
        System.out.println("\nNumero de la reserva: " + numeroReserva);

        try {
            System.out.print("Introduzca el numero de la habitacion: ");
            numeroHabitacion = Integer.parseInt(teclado.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Introduce una habitacion valida" + e);
        }

        //habitacion = instancia de la clase 
        habitacion = residencia.getHabitacion(numeroHabitacion);

        reservas = new Reserva(numeroReserva);//crear reserva
        reservas.addResidente(residente);//añadir datos recogidos al array
        reservas.addHabitacion(habitacion);
        residencia.addReserva(reservas);

        System.out.println("reserva: " + reservas);
        gestionReservas(residencia);
    }

    // Metodo para borrar una reserva
    private static void borrarReserva(Residencia residencia) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("\n----------------------");
        System.out.println("    Borrar reserva    ");
        System.out.println("----------------------");
        System.out.print("Introduca el numero de la reserva: ");
        int numeroReservaBorrar = Integer.parseInt(teclado.nextLine());
        Reserva.borrarReserva(R1, numeroReservaBorrar);
        System.out.print("La reserva se ha borrado.");
        gestionReservas(residencia);
    }

    // Metodo para listar las reservas
    private static void listarReservas(Residencia residencia) throws Exception {

        System.out.println("\n--------------------------");
        System.out.println("   Listado de reservas   ");
        System.out.println("--------------------------");

        for (Reserva reserva : residencia.getReservas()) {//rescorremos el array para despues mostrarlo por pantalla 
            System.out.println(reserva);
        }
        gestionReservas(residencia);//volver al submenu del submenu
    }

    //metodo para mostrar todos los arrays de la residencia 
    private static void listarDatos(Residencia residencia) throws Exception {
        HabitaIndi habitaIndi;
        HabitaDoble habitadoble;
        HabitaTriple habitatriple;

        System.out.println("\n-------------");
        System.out.println("Habitaciones");
        System.out.println("------------");
        for (Habitacion habitacion : residencia.getHabitaciones()) {
            if (habitacion instanceof HabitaIndi) {
                habitaIndi = (HabitaIndi) habitacion;
                System.out.println(habitaIndi);
            } else if (habitacion instanceof HabitaDoble) {
                habitadoble = (HabitaDoble) habitacion;
                System.out.println(habitadoble);
            } else if (habitacion instanceof HabitaTriple) {
                habitatriple = (HabitaTriple) habitacion;
                System.out.println(habitatriple);
            }
        }
        System.out.println("-------------");
        System.out.println("Clientes");
        System.out.println("------------");
        for (Residente residente : residencia.getResidentes()) {
            System.out.println(residente);
        }
        System.out.println("------------");
        System.out.println("Reservas");
        System.out.println("------------");
        for (Reserva reservas : residencia.getReservas()) {
            System.out.println(reservas);
        }

        menu();
    }

}
