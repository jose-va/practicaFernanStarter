package utilidades;
import java.util.Scanner;
import static utilidades.FuncionesCadenas.*;
import static utilidades.EnvioGMail.*;


public class Funciones {
    public static void autentificacion() {

        /**
         * Autentificación mediante código
         * Esta función genera un código aleatorio de 4 dígitos que se enviará a un correo introducido por el usuario.
         *
         * @author Jose Manuel Vilchez Arenas
         * El correo será introducido por el usuario como una cadena de carácteres
         * Si el usuario introduce correctamente el código, será verificado correctamente
         */
        Scanner s = new Scanner(System.in);
        System.out.println("Verificación necesaria. Introduzca su correo electrónico");
        String correo = s.nextLine();

        int codigo = (int) (Math.random() * 8999 + 1000);
        String asunto = "Código de autentificación";
        String cuerpo = "<h1>Su código es el siguiente: <h1>" + codigo;

        enviarConGMail(correo, asunto, cuerpo);

        System.out.printf("Introduzca el código enviado a %s ", correo);
        int codigoUsuario = Integer.parseInt(s.nextLine());
        do {
            if (codigoUsuario == codigo) {
                System.out.println("Ha iniciado sesión correctamente.");
                break;
            } else {
                System.out.println("Código incorrecto. Por favor, introduzca el código recibido.");
                System.out.printf("Correo electrónico -> %s", correo);
                codigoUsuario = Integer.parseInt(s.nextLine());
            }
        } while (codigoUsuario != codigo);
    }

    /**
     * Gráfico de inversiones de un proyecto
     *
     * @param cantidad la cantidad total que se necesita aportar en un proyecto
     * @param cantidadAportada la cantidad que se ha aportado hasta el momento
     * @param proyecto el proyecto del que se quiere mostrar la gráfica
     * @author Jose Manuel Vilchez Arenas
     */
    public static void muestraGrafico(int[] cantidad, int[] cantidadAportada, int proyecto) {
        float grafico = (float) (cantidadAportada[proyecto] * 100) / cantidad[proyecto];
        System.out.println("Gráfica de financiación");
        System.out.print(grafico + "% \u2192 ");
        for (int i = 0; i <= grafico; i++) {
            System.out.print("\u001B[36m\u275A");
            if (i == 100) break;
        }
    }
    public static int leerListaProyecto(String [] nombreProyecto){
        for (int i=0; i< nombreProyecto.length; i++){
            if (nombreProyecto[i].isEmpty()) return i;
        }
        return 10;
    }

    /**
     * Vista previa de los proyectos
     *
     * @param nombreProyecto   nombre de los proyectos
     * @param categoria        categoria de los proyectos
     * @param cantidad         cantidad necesaria de los proyectos
     * @param cantidadAportada cantidad aportada en los proyectos
     * @author Jose Manuel Vilchez Arenas
     */
    public static void vistaPreviaProyecto(String[] nombreProyecto, String[] categoria,
                                           int[] cantidad, int[] cantidadAportada) {
        int proyecto= leerListaProyecto(nombreProyecto);
        if (proyecto == 0) {
            System.out.println("****Actualmente no hay ningún proyecto****");
        } else {
            for (int i = 0; i < proyecto; i++) {
                System.out.println(nombreProyecto[i]);
                System.out.println("Categoría: " + categoria[i]);
                System.out.println("Cantidad necesaria: " + cantidad[i] + "€");
                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                System.out.println("Cantidad financiada hasta el momento: " + cantidadAportada[i] + "€");
            }
        }
    }

    public static void crearProyecto(int proyecto, String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                     String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                     String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                     String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas){
        Scanner s= new Scanner(System.in);
        System.out.print("Introduzca el nombre del proyecto: ");
        nombreProyecto[proyecto] = s.next();
        s.nextLine();
        System.out.println("Introduzca la descripción del proyecto: ");
        descripcionProyecto[proyecto] = s.nextLine();
        System.out.print("Ingrese la categoría del proyecto: ");
        System.out.println("Arte");
        System.out.println("Tecnología");
        System.out.println("Cine");
        System.out.println("Música");
        System.out.println("Juegos");
        System.out.println("Comida");
        System.out.println("Moda");
        categoria[proyecto] = s.next();
        System.out.print("Introduzca la cantidad de inversión necesaria: ");
        cantidad[proyecto] = Integer.parseInt(s.next());
        System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
        fechaApertura[proyecto]= s.next();
        System.out.println("Introduzca la fecha de cierre de las inversiones: ");
        fechaCierre[proyecto]= s.next();
        System.out.println("Recompensas del proyecto");
        System.out.println("¿Cuántas desea añadir? (max 3.)");
        recompensas[proyecto]= Integer.parseInt(s.next());
        System.out.println("Nombre de la primera recompensa: ");
        nombreRecompensaB[proyecto]= s.next();
        s.nextLine();
        System.out.println("Introduzca una descripción");
        descripcionRecompensaB[proyecto]= s.nextLine();
        System.out.println("Introduzca el precio: ");
        precioRecompensaB[proyecto]= Float.parseFloat(s.next());
        if (recompensas[proyecto]<2) return;
        System.out.println("=================================");
        System.out.println("Nombre de la segunda recompensa: ");
        nombreRecompensaB[proyecto]= s.next();
        s.nextLine();
        System.out.println("Introduzca una descripción");
        descripcionRecompensaB[1]= s.nextLine();
        System.out.println("Introduzca el precio: ");
        precioRecompensaB[proyecto]= Float.parseFloat(s.next());
        if (recompensas[proyecto]<3) return;
        System.out.println("=================================");
        System.out.println("Nombre de la tercera recompensa: ");
        nombreRecompensaB[proyecto]= s.next();
        s.nextLine();
        System.out.println("Introduzca una descripción");
        descripcionRecompensaB[2]= s.nextLine();
        System.out.println("Introduzca el precio: ");
        precioRecompensaB[proyecto]= Float.parseFloat(s.next());

    }

    public static void modificarProyecto(String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                         String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                         String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                         String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas){
        Scanner s= new Scanner(System.in);
        System.out.println("MODIFICAR PROYECTOS");
        System.out.println("=================================================");
        vistaPreviaProyecto(nombreProyecto, categoria, cantidad, cantidadAportada);
        System.out.println("========================================================================");
        System.out.println("Por favor, introduzca el nombre de un proyecto para modificarlo: ");
        String nombre = s.nextLine().toLowerCase();
        int proyecto = buscaNombreProyecto(nombreProyecto, nombre);
        while (proyecto== -1) {
            System.out.println("Debes introducir un nombre correcto");
            nombre = s.nextLine().toLowerCase();
            proyecto = buscaNombreProyecto(nombreProyecto, nombre);
        }
        crearProyecto(proyecto, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
    }

    /**
     * Apartado de consulta detallada de los proyectos
     *
     * @author Jose Manuel Vilchez Arenas
     * Esta función se encarga de actualizar nuestros arrays previamente declarados
     * Nos muestra una salida con la información de cada uno de los proyectos que hemos creado
     */
    public static void consultaDetalladaProyecto(String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                                 String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                                 String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                                 String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas) {
        Scanner s = new Scanner(System.in);
        System.out.println("CONSULTA DE PROYECTOS");
        System.out.println("=================================================");
        vistaPreviaProyecto(nombreProyecto, categoria, cantidad, cantidadAportada);
        System.out.println("========================================================================");
        System.out.println("Por favor, escriba el nombre de un proyecto para mostrar información detallada: ");
        String nombre = s.nextLine().toLowerCase();
        int proyecto = buscaNombreProyecto(nombreProyecto, nombre);
        if (proyecto == -1) {
            System.out.println("No existe el proyecto");
        } else {
            System.out.println(nombreProyecto[proyecto]);
            System.out.print("Descripción: ");
            System.out.println(descripcionProyecto[proyecto]);
            System.out.print("Categoría: ");
            System.out.println(categoria[proyecto]);
            System.out.print("Cantidad necesaria: ");
            System.out.println(cantidad[proyecto] + "€");
            System.out.print("Cantidad aportada hasta el momento: ");
            System.out.println(cantidadAportada[proyecto] + "€");
            System.out.print("Fecha de apertura: ");
            System.out.println(fechaApertura[proyecto] + "/12/2024");
            System.out.print("Fecha de cierre: ");
            System.out.println(fechaCierre[proyecto] + "/12/2024");
            muestraGrafico(cantidad, cantidadAportada, proyecto);
            System.out.println();
            System.out.println("=============================");
            System.out.println("\u001B[0mRECOMPENSA 1");
            System.out.println(nombreRecompensaA[proyecto]);
            System.out.println(descripcionRecompensaA[proyecto]);
            System.out.println(precioRecompensaA[proyecto] + "€");
            System.out.println("=============================");
            System.out.println("RECOMPENSA 2");
            System.out.println(nombreRecompensaB[proyecto]);
            System.out.println(descripcionRecompensaB[proyecto]);
            System.out.println(precioRecompensaB[proyecto] + "€");
            System.out.println("=============================");
            System.out.println("RECOMPENSA 3");
            System.out.println(nombreRecompensaC[proyecto]);
            System.out.println(descripcionRecompensaC[proyecto]);
            System.out.println(precioRecompensaC[proyecto] + "€");
        }
    }

    /**
     * Apartado de mis proyectos para gestor y administrador
     *
     * @author Jose Manuel Vilchez Arenas
     * Esta función se encarga de la creación y modificación de proyectos
     */
    public static void misProyectos (String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                     String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                     String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                     String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas){
        Scanner s = new Scanner(System.in);
        System.out.println("MIS PROYECTOS");
        int proyecto= leerListaProyecto(nombreProyecto);
        if (proyecto == 0) {
            System.out.println("Aún no hay proyectos");
            crearProyecto(proyecto, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
        }else {
            int opcion;
            do {
                System.out.println("1. Crear Proyectos");
                System.out.println("2. Consultar proyectos");
                System.out.println("3. Modificar proyectos");
                System.out.println("4. Salir");
                opcion = Integer.parseInt(s.nextLine());
                switch (opcion) {
                    case 1:
                        if (proyecto == 10) System.out.println("No se pueden crear más de 10 proyectos.");
                        else crearProyecto(proyecto, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                        break;
                    case 2:
                        consultaDetalladaProyecto(nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                        break;
                    case 3:
                        modificarProyecto(nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                        break;
                    case 4:
                        System.out.println("Salir.");
                        return;
                    default:
                        System.out.println("Por, favor, introduzca una opción correcta.");
                        break;
                }
            } while (opcion != 3);
        }
    }

    public static int menuInversor(int menu){
        Scanner s = new Scanner(System.in);
        menu=0;
        do {
            System.out.println("========MENÚ========");
            System.out.println("1. Mis inversiones");
            System.out.println("2. Proyectos");
            System.out.println("3. Cartera digital");
            System.out.println("4. Invita a un amigo");
            System.out.println("5. Configuración");
            System.out.println("6. Cerrar sesión");
            menu = s.nextInt();
            if (menu<1 || menu>6){
                System.out.println("Por favor, introduzca una opción válida");
            }
        }while (menu<1 || menu>6);
        return menu;
    }
    public static int menuMisInversiones(int opcion){
        Scanner s = new Scanner(System.in);
        opcion=0;
        do {
            System.out.println("----MIS INVERSIONES----");
            System.out.println("1. Crear inversiones");
            System.out.println("2. Consultar inversiones");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(s.next());
            if (opcion < 1 || opcion > 3){
                System.out.println("Por favor, introduzca una opción válida");
            }
        }while (opcion < 1 || opcion > 3);
        return opcion;
    }


    /**
     * Esta función permite al inversor poder invertir en el proyecto que ha seleccionado anteriormente
     *
     * @autor Pablo Valderas Doblas
     * @param cantidad Muestra la cantidad total que necesita el proyecto para ser llevado a cabo
     * @param AportacionInversor Es la cantidad que aporta el inversor a ese proyecto
     * @param saldoTotal Es el saldo del inversor
     * @param id Es el identificador de la inversion
     * @param inversion Este boolean comprueba si el inversor a invertido en un proyecto determinado
     * @param cantidadAportada Es la cantidad que se le ha aportado a ese proyecto hasta el momento
     * @param inversiones Esta variable almacena la cantidad de veces que ha invertido el inversor
     * @return Detiene la ejecución de la función y devuelve los valores que ha ingresado el usuario al main
     */

    public static int crearInversion(int[] id, String[] listaUsuarios, String usuario, String[] nombreProyecto, int[] cantidad, int[] AportacionInversor, int[] saldoTotal, boolean[] inversion, int[] cantidadAportada, int[] inversiones) {
        Scanner s = new Scanner(System.in);
        int seleccionInversor = 0;
        do {
            System.out.println("¿En qué proyecto desea invertir?");
            System.out.println("0. Salir");
            for (int i = 0; i < 10; i++) {
                System.out.println((i + 1) + "Proyecto " + (i + 1) + ": " + nombreProyecto[i]);
            }
            seleccionInversor = Integer.parseInt(s.next());
            if (seleccionInversor < 0 || seleccionInversor > 10){
                System.out.println("Debe de introducir la opción correspondiente correcta");
            }
        }while (seleccionInversor < 0 || seleccionInversor > 10);
        do {
            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[seleccionInversor] + "€");
            System.out.println("¿Que cantidad desea aportar?");
            AportacionInversor[seleccionInversor] = s.nextInt();
            if (AportacionInversor[seleccionInversor] > saldoTotal[buscaNombreUsuario(listaUsuarios, usuario)]) {
                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                System.out.println("Su saldo es de: " + saldoTotal + "€");
            } else {
                inversion[seleccionInversor] = true;
                saldoTotal[buscaNombreUsuario(listaUsuarios, usuario)] -= cantidadAportada[buscaNombreUsuario(listaUsuarios, usuario)];
                cantidadAportada[seleccionInversor] += cantidadAportada[seleccionInversor];
                inversiones[buscaNombreUsuario(listaUsuarios, usuario)]++;
                id[buscaNombreUsuario(listaUsuarios, usuario)] = seleccionInversor;
                System.out.println("¡¡¡Gracias por aportar su parte!!!");
            }
        } while (seleccionInversor < 0 || seleccionInversor > 20);
        return crearInversion(id, nombreProyecto, listaUsuarios, usuario, cantidad, AportacionInversor, saldoTotal, inversion, cantidadAportada, inversiones);
    }


    public static int consultaInversion(int[] id, String[] listaUsuarios, String usuario, String[] nombreProyecto, int[] AportacionInversor, int[] inversiones){
        for (int i = 0; i < inversiones[buscaNombreUsuario(listaUsuarios, usuario)]; i++) {
            System.out.println("Inversion - "+);
        }

        return ();
    }




    /**
     * Esta función sirve para posibilizar la consulta de proyectos en los que ha invertido el inversor que solicita el inversor
     * Se muestra por pantalla los siguientes parámetros:
     *
     * @autor Pablo Valderas Doblas
     * @param nombreProyecto Es el nombre del proyecto en el cual ha invertido el inversor
     * @param categoria Es la categoría de un proyecto determinado
     * @param cantidadAportada Es la cantidad que ha aportado el inversor en un proyecto en concreto
     */


    public static void inversionA1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }



    /**
     * Esta función sirve para mostrar la cartera digital del inversor
     *
     * @autor Pablo Valderas Doblas
     * @param opcion Es una variable que permite seleccionar entre las distintas opciones de la interfaz
     * @param saldoTotal1 Muestra en pantalla el saldo total del inversor
     * @param saldo Esta variable se utiliza para recoger el saldo que el inversor desea introducir en su cartera digital
     */

    public static void cartera (int opcion, int saldoTotal1,int saldo){
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("CARTERA DIGITAL");
            System.out.println("1. Saldo actual");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(s.next());
            switch (opcion) {
                case 1:
                    if (saldoTotal1 == 0) {
                        System.out.println("Usted no dispone de saldo.");
                    } else {
                        System.out.printf("Saldo: %d€", saldoTotal1);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("¿Cuánto dinero desea ingresar?");
                    saldo = Integer.parseInt(s.next());
                    saldoTotal1 += saldo;
                    System.out.println("Su saldo ha sido añadido correctamente");
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado salir.");
                    break;
                default:
                    System.out.println("Opcion seleccionada inválida.");
                    break;
            }
        } while (opcion != 3);
    }

    /**
     * Esta función trabaja de la misma manera que la anterior pero se enfoca en el inversor 2
     * @autor Pablo Valderas Doblas
     *
     */



    /**
     * Esta función permite al inversor invitar a sus amigos a la página para que puedan ser nuevos inversores
     * @autor Pablo Valderas Doblas
     * @param opcion Es una variable que permite seleccionar entre las distintas opciones de la interfaz
     * @param amigo Almacena los amigos del inevrsor
     * @param correo Esta variable almacena el correo correspondienet de cada amigo
     */
    public static void anadeamigo1 (int opcion, String amigo, String correo ){
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("INVITAR A UN AMIGO");
            System.out.println("1. Listado de amigos");
            System.out.println("2. Añadir a un amigo");
            System.out.println("3. Salir");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("LISTADO DE AMIGOS");
                    System.out.println(amigo);
                    break;
                case 2:
                    System.out.println("AÑADIR A UN AMIGO: ");
                    correo = s.next();
                    amigo = amigo.concat(" " + correo);
                    break;
                case 3:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 3);
    }

    public static void anadeamigo2 (int opcion, String amigo, String correo ){
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("INVITAR A UN AMIGO");
            System.out.println("1. Listado de amigos");
            System.out.println("2. Añadir a un amigo");
            System.out.println("3. Salir");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("LISTADO DE AMIGOS");
                    System.out.println(amigo);
                    break;
                case 2:
                    System.out.println("AÑADIR A UN AMIGO: ");
                    correo = s.next();
                    amigo = amigo.concat(" " + correo);
                    break;
                case 3:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 3);
    }

    /**
     * Esta función es la configuración de la cuenta del inversor
     * El inversor podrá cambiar tanto su nombre de usuario como su contraseña a través de este menú
     *
     * @autor Pablo Valderas Doblas
     * @param opcion Es una variable que permite seleccionar entre las distintas opciones de la interfaz
     * @param usuarioInversor Esta variable es la que almacena el usuario del inversor
     * @param contrasenaInversor Esta variable guarda la contraseña del inversor
     */

    public static void config1 (int opcion, String usuarioInversor, String contrasenaInversor){
        Scanner s = new Scanner(System.in);
        System.out.println("CONFIGURACIÓN. Seleccione una opción: ");
        do {
            System.out.println("1. Cambiar usuario");
            System.out.println("2. Cambiar contraseña");
            System.out.println("3. Guardar cambios");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.printf("Usuario actual -> %s\n", usuarioInversor);
                    System.out.println("Introduzca su nuevo usuario: ");
                    usuarioInversor = s.nextLine();
                    break;
                case 2:
                    System.out.printf("Contraseña actual -> %s\n", contrasenaInversor);
                    System.out.println("Introduzca su nueva contraseña: ");
                    contrasenaInversor = s.nextLine();
                    break;
            }
        } while (opcion != 3);
        System.out.println("Los cambios se han guardado correctamente");
        System.out.println("Redirigiendo al menú principal");
    }


    public static void registroUsuarios(String[] inversor, String[]  contrasenaInversor,
                                        String[]  gestor, String[]  contrasenaGestor){
        Scanner s = new Scanner(System.in);
        System.out.println("=========Tipo de usuario==========");
        System.out.println("1. Inversor");
        System.out.println("2. Gestor");
        System.out.println("==================================");
        int opcion= Integer.parseInt(s.nextLine());
        boolean primerInversor= false;
        if (opcion==1){
            System.out.println("Cuenta de Inversor. Introduzca un nombre de usuario");
            if(inversor[0].isEmpty()){
                inversor[0]= s.nextLine();
                primerInversor = true;
            }else{
                inversor[1]= s.nextLine();
            }

            String contrasena;
            do{
                System.out.println("Introduzca su contraseña.");
                System.out.println("Recuerde que debe de tener mínimo 8 carácteres e incluir mayúsculas, minúsculas y simbolos especiales.");
                contrasena=s.nextLine();
            }while(!fortalezaContrasena(contrasena));

            String contrasena2;
            do{
                System.out.println("Vuelva a introducir su contraseña: ");
                contrasena2=s.nextLine();
            }while(!compararContrasena(contrasena, contrasena2));

            if (primerInversor) contrasenaInversor[0]= contrasena;
            else contrasenaInversor[1]= contrasena;
            autentificacion();

        }else{
            System.out.println("Cuenta de Gestor. Introduzca un nombre de usuario");
            gestor[0]= s.nextLine();

            String contrasena;
            do{
                System.out.println("Introduzca su contraseña.");
                System.out.println("Recuerde que debe de tener mínimo 8 carácteres e incluir mayúsculas, minúsculas y simbolos especiales.");
                contrasena=s.nextLine();
            }while(!fortalezaContrasena(contrasena));

            String contrasena2;
            do{
                System.out.println("Vuelva a introducir su contraseña: ");
                contrasena2=s.nextLine();
            }while(!compararContrasena(contrasena, contrasena2));
            contrasenaGestor[0]= contrasena;
            autentificacion();
        }
    }


}
