package utilidades;
import java.util.Scanner;
import static utilidades.EnvioGMail.*;

public class Funciones {
    /**
     * Autentificación mediante código
     * Esta función genera un código aleatorio de 4 dígitos que se enviará a un correo introducido por el usuario.
     *
     * @author Jose Manuel Vilchez Arenas
     * @param correo será introducido por el usuario como una cadena de carácteres
     * Se enviará el código generado al correo electrónico
     * Si el usuario introduce correctamente el código, será verificado correctamente
     */
    public static void autentificacion(String correo) {
        Scanner s = new Scanner(System.in);

        int codigo= (int) (Math.random()*8999+1000);
        String asunto = "Código de autentificación";
        String cuerpo = "<h1>Su código es el siguiente: <h1>" + codigo;

        enviarConGMail(correo, asunto, cuerpo);

        System.out.printf("Introduzca el código enviado a %s ", correo);
        int codigoUsuario= Integer.parseInt(s.nextLine());
        do{
            if (codigoUsuario==codigo){
                System.out.println("Ha iniciado sesión correctamente.");
                break;
            }else{
                System.out.println("Código incorrecto. Por favor, introduzca el código recibido.");
                System.out.printf("Correo electrónico -> %s", correo);
            }
        } while(codigoUsuario!=codigo);
    }

    /**
     * Gráfico de inversiones
     * Esta función devuelve un gráfico con lo que se ha invertido
     *
     * @author Jose Manuel Vilchez Arenas
     * @param cantidad como la cantidad que se necesita aportar en un proyecto
     * @param cantidadAportada como la cantidad que se ha aportado hasta el momento
     */
    public static void muestraGrafico(int[] cantidad, int[] cantidadAportada){
        float grafico = (float) (cantidadAportada[0] * 100) / cantidad[0];
        System.out.println("Gráfica de financiación");
        System.out.print(grafico + "% \u2192 ");
        for (int i = 0; i <= grafico; i++) {
            System.out.print("\u001B[36m\u275A");
            if (i == 100) break;
        }
    }

    /**
     * Apartado de consulta de proyectos para inversores
     * Devuelve toda la información en lo relativo a proyectos
     *
     * @author Jose Manuel Vilchez Arenas
     * Esta función se encarga de actualizar nuestros arrays previamente declarados
     * Nos muestra una salida con la información de cada uno de los proyectos que hemos creado
     */
    public static void consultaProyectos (int proyectos, String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                         String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                          String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                          String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas){
        Scanner s = new Scanner(System.in);
        System.out.println("CONSULTA DE PROYECTOS");
        System.out.println("=================================================");
        if (proyectos <= 0) {
            System.out.println("****Actualmente no hay ningún proyecto****");
        }else{
            do{
                System.out.println("PROYECTO 1");
                System.out.println(nombreProyecto[0]);
                System.out.println("Categoría: " + categoria[0]);
                System.out.println("Cantidad necesaria: " + cantidad[0]+ "€");
                System.out.println("Cantidad financiada hasta el momento: " + cantidadAportada[0] + "€");
                if (proyectos < 2) break;
                System.out.println("=================================================");
                System.out.println("PROYECTO 2");
                System.out.println(nombreProyecto[1]);
                System.out.println("Categoría: " + categoria[1]);
                System.out.println("Cantidad necesaria: " + cantidad[1]+ "€");
                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                System.out.println("Cantidad financiada hasta el momento: "+ cantidadAportada[1] + "€");
                if (proyectos < 3) break;
                System.out.println("=================================================");
                System.out.println("PROYECTO 3");
                System.out.println(nombreProyecto[2]);
                System.out.println("Categoría: " + categoria[2]);
                System.out.println("Cantidad necesaria: " + cantidad[2]+ "€");
                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                System.out.println("Cantidad financiada hasta el momento: "+ cantidadAportada[2] + "€");
                break;
            }while (proyectos>0);

            System.out.println("========================================================================");
            System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
            int opcion = Integer.parseInt(s.next());
            switch (opcion) {
                case 1:
                    if (proyectos <= 0) {
                        System.out.println("No existe el proyecto");
                    } else {
                        System.out.println(nombreProyecto[0]);
                        System.out.print("Descripción: ");
                        System.out.println(descripcionProyecto[0]);
                        System.out.print("Categoría: ");
                        System.out.println(categoria[0]);
                        System.out.print("Cantidad necesaria: ");
                        System.out.println(cantidad[0]+ "€");
                        System.out.print("Cantidad aportada hasta el momento: ");
                        System.out.println(cantidadAportada[0]+ "€");
                        System.out.print("Fecha de apertura: ");
                        System.out.println(fechaApertura[0] + "/12/2024");
                        System.out.print("Fecha de cierre: ");
                        System.out.println(fechaCierre[0] + "/12/2024");
                        muestraGrafico(cantidad, cantidadAportada);
                        System.out.println();
                        System.out.println("\u001B[0mRECOMPENSA 1");
                        System.out.println(nombreRecompensaA[0]);
                        System.out.println(descripcionRecompensaA[0]);
                        System.out.println(precioRecompensaA[0] + "€");
                        if (recompensas[0] == 1) break;
                        System.out.println("RECOMPENSA 2");
                        System.out.println(nombreRecompensaA[1]);
                        System.out.println(descripcionRecompensaA[1]);
                        System.out.println(precioRecompensaA[1] + "€");
                        if (recompensas[0] == 2) break;
                        System.out.println("RECOMPENSA 3");
                        System.out.println(nombreRecompensaA[2]);
                        System.out.println(descripcionRecompensaA[2]);
                        System.out.println(precioRecompensaA[2] + "€");

                    }
                    break;
                case 2:
                    if (proyectos < 2) {
                        System.out.println("No existe el proyecto.");
                    } else {
                        System.out.println(nombreProyecto[1]);
                        System.out.print("Descripción: ");
                        System.out.println(descripcionProyecto[1]);
                        System.out.print("Categoría: ");
                        System.out.println(categoria[1]);
                        System.out.print("Cantidad necesaria: ");
                        System.out.println(cantidad[1]+ "€");
                        System.out.print("Cantidad aportada hasta el momento: ");
                        System.out.println(cantidadAportada[1]+ "€");
                        System.out.print("Fecha de apertura: ");
                        System.out.println(fechaApertura[1] + "/12/2024");
                        System.out.print("Fecha de cierre: ");
                        System.out.println(fechaCierre[1] + "/12/2024");
                        muestraGrafico(cantidad, cantidadAportada);
                        System.out.println();
                        System.out.println("\u001B[0mRECOMPENSA 1");
                        System.out.println(nombreRecompensaB[0]);
                        System.out.println(descripcionRecompensaB[0]);
                        System.out.println(precioRecompensaB[0] + "€");
                        if (recompensas[1] == 1) break;
                        System.out.println("RECOMPENSA 2");
                        System.out.println(nombreRecompensaB[1]);
                        System.out.println(descripcionRecompensaB[1]);
                        System.out.println(precioRecompensaB[1] + "€");
                        if (recompensas[1] == 2) break;
                        System.out.println("RECOMPENSA 3");
                        System.out.println(nombreRecompensaB[2]);
                        System.out.println(descripcionRecompensaB[2]);
                        System.out.println(precioRecompensaB[2] + "€");

                    }
                    break;
                case 3:
                    if (proyectos < 3) {
                        System.out.println("No existe el proyecto.");
                    } else {
                        System.out.println(nombreProyecto[2]);
                        System.out.print("Descripción: ");
                        System.out.println(descripcionProyecto[2]);
                        System.out.print("Categoría: ");
                        System.out.println(categoria[2]);
                        System.out.print("Cantidad necesaria: ");
                        System.out.println(cantidad[2]+ "€");
                        System.out.print("Cantidad aportada hasta el momento: ");
                        System.out.println(cantidadAportada[2]+ "€");
                        System.out.print("Fecha de apertura: ");
                        System.out.println(fechaApertura[2] + "/12/2024");
                        System.out.print("Fecha de cierre: ");
                        System.out.println(fechaCierre[2] + "/12/2024");
                        muestraGrafico(cantidad, cantidadAportada);
                        System.out.println();
                        System.out.println("\u001B[0mRECOMPENSA 1");
                        System.out.println(nombreRecompensaC[0]);
                        System.out.println(descripcionRecompensaC[0]);
                        System.out.println(precioRecompensaC[0] + "€");
                        if (recompensas[1] == 1) break;
                        System.out.println("RECOMPENSA 2");
                        System.out.println(nombreRecompensaC[1]);
                        System.out.println(descripcionRecompensaC[1]);
                        System.out.println(precioRecompensaC[1] + "€");
                        if (recompensas[1] == 2) break;
                        System.out.println("RECOMPENSA 3");
                        System.out.println(nombreRecompensaC[2]);
                        System.out.println(descripcionRecompensaC[2]);
                        System.out.println(precioRecompensaC[2] + "€");

                    }
                    break;
                default:
                    System.out.println("Debe seleccionar un proyecto válido.");
                    break;
            }
        }

    }

    /**
     * Apartado de mis proyectos para gestor y administrador
     * Devuelve toda la información en lo relativo a los proyectos
     *
     * @author Jose Manuel Vilchez Arenas
     * Esta función se encarga de crear proyectos y de actualizar nuestros arrays previamente declarado
     * Nos muestra una salida con la información de cada uno de los proyectos que hemos creado
     */
    public static void misProyectos(int proyectos, String[] nombreProyecto, String[] categoria, int[] cantidad, int[] cantidadAportada, String[] descripcionProyecto,
                                    String[] fechaApertura, String[] fechaCierre, String[] nombreRecompensaA, String[] descripcionRecompensaA, float[] precioRecompensaA,
                                    String[] nombreRecompensaB, String[] descripcionRecompensaB, float[] precioRecompensaB, String[] nombreRecompensaC,
                                    String[] descripcionRecompensaC, float[] precioRecompensaC, int[] recompensas){
        Scanner s = new Scanner(System.in);
        System.out.println("MIS PROYECTOS");
        if (proyectos == 0) {
            System.out.println("Aún no hay proyectos");
            System.out.println("¿Desea crear un proyecto? (s/n)");
            String respuesta = s.next();
            if (respuesta.equals("s")) {
                proyectos++;
                System.out.println("Introduzca el nombre del proyecto: ");
                nombreProyecto[0] = s.next();
                s.nextLine();
                System.out.println("Introduzca la descripción del proyecto: ");
                descripcionProyecto[0] = s.nextLine();
                System.out.println("Ingrese la categoría del proyecto: ");
                System.out.println("Arte");
                System.out.println("Tecnología");
                System.out.println("Cine");
                System.out.println("Música");
                System.out.println("Juegos");
                System.out.println("Comida");
                System.out.println("Moda");
                categoria[0] = s.next();
                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                cantidad[0] = Integer.parseInt(s.next());
                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                fechaApertura[0]= s.next();
                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                fechaCierre[0]= s.next();
                System.out.println("Recompensas del proyecto");
                System.out.println("Usted debe añadir recompensas (max 3.)");
                recompensas[0]= Integer.parseInt(s.next());
                System.out.println("Nombre de la primera recompensa: ");
                nombreRecompensaA[0]= s.next();
                s.nextLine();
                System.out.println("Introduzca una descripción");
                descripcionRecompensaA[0]= s.nextLine();
                System.out.println("Introduzca el precio: ");
                precioRecompensaA[0]= Float.parseFloat(s.next());
                if (recompensas[0]<2) {
                    System.out.println("=================================");
                    System.out.println("Nombre de la segunda recompensa: ");
                    nombreRecompensaA[1]= s.next();
                    s.nextLine();
                    System.out.println("Introduzca una descripción");
                    descripcionRecompensaA[1]= s.nextLine();
                    System.out.println("Introduzca el precio: ");
                    precioRecompensaA[1]= Float.parseFloat(s.next());
                }
                if (recompensas[0]<3){
                    System.out.println("=================================");
                    System.out.println("Nombre de la tercera recompensa: ");
                    nombreRecompensaA[2]= s.next();
                    s.nextLine();
                    System.out.println("Introduzca una descripción");
                    descripcionRecompensaA[2]= s.nextLine();
                    System.out.println("Introduzca el precio: ");
                    precioRecompensaA[2]= Float.parseFloat(s.next());
                }
            } else if (respuesta.equals("n")) {
                System.out.println("No hay proyectos existentes");
            } else {
                System.out.println("Tiene que introducir una respuesta");
            }
        } else if (proyectos>0) {
            System.out.println("1. Crear Proyectos");
            System.out.println("2. Consultar proyectos");
            System.out.println("3. Modificar proyectos");
            int opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    if (proyectos == 1) {
                        proyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        nombreProyecto[1] = s.next();
                        s.nextLine();
                        System.out.println("Introduzca la descripción del proyecto: ");
                        descripcionProyecto[1] = s.nextLine();
                        System.out.print("Ingrese la categoría del proyecto: ");
                        System.out.println("Arte");
                        System.out.println("Tecnología");
                        System.out.println("Cine");
                        System.out.println("Música");
                        System.out.println("Juegos");
                        System.out.println("Comida");
                        System.out.println("Moda");
                        categoria[1] = s.next();
                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                        cantidad[1] = Integer.parseInt(s.next());
                        System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                        fechaApertura[1]= s.next();
                        System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                        fechaCierre[1]= s.next();
                        System.out.println("Recompensas del proyecto");
                        System.out.println("¿Cuántas desea añadir? (max 3.)");
                        recompensas[1]= Integer.parseInt(s.next());
                        System.out.println("Nombre de la primera recompensa: ");
                        nombreRecompensaB[0]= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB[0]= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB[0]= Float.parseFloat(s.next());
                        if (recompensas[1]<2) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la segunda recompensa: ");
                        nombreRecompensaB[1]= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB[1]= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB[1]= Float.parseFloat(s.next());
                        if (recompensas[1]<3) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la tercera recompensa: ");
                        nombreRecompensaB[2]= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB[2]= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB[2]= Float.parseFloat(s.next());
                        break;

                    } else if (proyectos == 2) {
                        proyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        nombreProyecto[2] = s.next();
                        s.nextLine();
                        System.out.print("Introduzca la descripción del proyecto: ");
                        descripcionProyecto[2] = s.nextLine();
                        System.out.println("Ingrese la categoría del proyecto: ");
                        System.out.println("Arte");
                        System.out.println("Tecnología");
                        System.out.println("Cine");
                        System.out.println("Música");
                        System.out.println("Juegos");
                        System.out.println("Comida");
                        System.out.println("Moda");
                        categoria[2] = s.next();
                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                        cantidad[2] = Integer.parseInt(s.next());
                        System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                        fechaApertura[2]= s.next();
                        System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                        fechaCierre[2]= s.next();
                        System.out.println("Recompensas del proyecto");
                        System.out.println("¿Cuántas desea añadir? (max 3.)");
                        recompensas[2]= Integer.parseInt(s.next());
                        System.out.println("Nombre de la primera recompensa: ");
                        nombreRecompensaC[0]= s.next();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC[0]= s.next();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC[0]= Float.parseFloat(s.next());
                        if (recompensas[2]<2) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la segunda recompensa: ");
                        nombreRecompensaC[1]= s.next();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC[1]= s.next();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC[1]= Float.parseFloat(s.next());
                        if (recompensas[2]<3) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la tercera recompensa: ");
                        nombreRecompensaC[2]= s.next();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC[2]= s.next();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC[2]= Float.parseFloat(s.next());
                        break;
                    } else if (proyectos == 3) {
                        System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                    }
                    break;

                case 2:
                    System.out.println("CONSULTA DE PROYECTOS");
                    System.out.println("=================================================");
                    if (proyectos <= 0){
                        System.out.println("****Actualmente no hay ningún proyecto****");
                        break;
                    }
                    do{
                        System.out.println("PROYECTO 1");
                        System.out.println(nombreProyecto[0]);
                        System.out.println("Categoría: " + categoria[0]);
                        System.out.println("Cantidad necesaria: " + cantidad[0] + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportada[0] + "€");
                        if (proyectos<2) break;
                        System.out.println("=================================================");
                        System.out.println("PROYECTO 2");
                        System.out.println(nombreProyecto[1]);
                        System.out.println("Categoría: " + categoria[1] + "€");
                        System.out.println("Cantidad necesaria: " + cantidad[1] + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportada[1] + "€");
                        if (proyectos<3) break;
                        System.out.println("=================================================");
                        System.out.println("PROYECTO 3");
                        System.out.println(nombreProyecto[2]);
                        System.out.println("Categoría: " + categoria[2]);
                        System.out.println("Cantidad necesaria: " + cantidad[2] + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportada[2] + "€");
                        break;
                    }while (proyectos>0);

                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                    opcion= Integer.parseInt(s.next());
                    switch (opcion){
                        case 1:
                            if (proyectos <=0){
                                System.out.println("No existe el proyecto");
                            }else {
                                System.out.println(nombreProyecto[0]);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyecto[0]);
                                System.out.print("Categoría: ");
                                System.out.println(categoria[0]);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidad[0]+ "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportada[0]+ "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaApertura[0] + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierre[0] + "/12/2024");
                                muestraGrafico(cantidad, cantidadAportada);
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaA[0]);
                                System.out.println(descripcionRecompensaA[0]);
                                System.out.println(precioRecompensaA[0] + "€");
                                if (recompensas[0]==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA[1]);
                                System.out.println(descripcionRecompensaA[1]);
                                System.out.println(precioRecompensaA[1] + "€");
                                if (recompensas[0]==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaA[2]);
                                System.out.println(descripcionRecompensaA[2]);
                                System.out.println(precioRecompensaA[2] + "€");

                            }
                            break;
                        case 2:
                            if (proyectos <2){
                                System.out.println("No existe el proyecto.");
                            }else {
                                System.out.println(nombreProyecto[1]);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyecto[1]);
                                System.out.print("Categoría: ");
                                System.out.println(categoria[1]);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidad[1]+ "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportada[1]+ "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaApertura[1] + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierre[1] + "/12/2024");
                                muestraGrafico(cantidad, cantidadAportada);
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaB[0]);
                                System.out.println(descripcionRecompensaB[0]);
                                System.out.println(precioRecompensaB[0] + "€");
                                if (recompensas[1]==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaB[1]);
                                System.out.println(descripcionRecompensaB[1]);
                                System.out.println(precioRecompensaB[1] + "€");
                                if (recompensas[1]==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaB[2]);
                                System.out.println(descripcionRecompensaB[2]);
                                System.out.println(precioRecompensaB[2] + "€");

                            }
                            break;
                        case 3:
                            if (proyectos <3){
                                System.out.println("No existe el proyecto.");
                            }else {
                                System.out.println(nombreProyecto[2]);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyecto[2]);
                                System.out.print("Categoría: ");
                                System.out.println(categoria[2]);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidad[2]+ "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportada[2]+ "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaApertura[2] + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierre[2] + "/12/2024");
                                muestraGrafico(cantidad, cantidadAportada);
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaC[0]);
                                System.out.println(descripcionRecompensaC[0]);
                                System.out.println(precioRecompensaC[0] + "€");
                                if (recompensas[1]==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaC[1]);
                                System.out.println(descripcionRecompensaC[1]);
                                System.out.println(precioRecompensaC[1] + "€");
                                if (recompensas[1]==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaC[2]);
                                System.out.println(descripcionRecompensaC[2]);
                                System.out.println(precioRecompensaC[2] + "€");

                            }
                            break;
                        default:
                            System.out.println("Debe seleccionar un proyecto válido.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("MODIFICAR PROYECTOS");
                    if (proyectos == 0) {
                        System.out.println("No hay ningún proyecto creado aún");
                    } else {
                        System.out.println("¿Qué proyecto desea modicicar?");
                        System.out.println("Introduzca el número del proyecto");
                        if (proyectos == 1) {
                            System.out.println("Proyecto 1: " + nombreProyecto[0]);
                        } else if (proyectos == 2) {
                            System.out.println("Proyecto 1: " + nombreProyecto[0]);
                            System.out.println("Proyecto 2: " + nombreProyecto[1]);
                        } else if (proyectos == 3) {
                            System.out.println("Proyecto 1: " + nombreProyecto[0]);
                            System.out.println("Proyecto 2: " + nombreProyecto[1]);
                            System.out.println("Proyecto 3: " + nombreProyecto[2]);
                        }
                        int numpro = Integer.parseInt(s.next());
                        while (numpro != 1 && numpro != 2 && numpro != 3){
                            System.out.println("Debes introducir el número correspondiente");
                            numpro = Integer.parseInt(s.next());
                        }
                        switch (numpro) {
                            case 1:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyecto[0] = s.next();
                                s.nextLine();
                                System.out.print("Introduzca la descripción del proyecto: ");
                                descripcionProyecto[0] = s.nextLine();
                                System.out.println("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoria[0] = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidad[0] = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaApertura[0]= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierre[0]= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaA[0]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA[0]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA[0]= Float.parseFloat(s.next());
                                if (recompensas[0]==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaA[1]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA[1]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA[1]= Float.parseFloat(s.next());
                                if (recompensas[0]==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaA[2]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA[2]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA[2]= Float.parseFloat(s.next());
                                break;
                            case 2:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyecto[1] = s.next();
                                s.nextLine();
                                System.out.println("Introduzca la descripción del proyecto: ");
                                descripcionProyecto[1] = s.nextLine();
                                System.out.print("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoria[1] = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidad[1] = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaApertura[1]= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierre[1]= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaB[0]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB[0]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB[0]= Float.parseFloat(s.next());
                                if (recompensas[1]==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaB[1]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB[1]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB[1]= Float.parseFloat(s.next());
                                if (recompensas[1]==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaB[2]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB[2]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB[2]= Float.parseFloat(s.next());
                                break;
                            case 3:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyecto[2] = s.next();
                                s.nextLine();
                                System.out.println("Introduzca la descripción del proyecto: ");
                                descripcionProyecto[2] = s.nextLine();
                                System.out.print("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoria[2] = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidad[2] = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaApertura[2]= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierre[2]= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaC[0]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC[0]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC[0]= Float.parseFloat(s.next());
                                if (recompensas[2]==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaC[1]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC[1]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC[1]= Float.parseFloat(s.next());
                                if (recompensas[2]==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaC[2]= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC[2]= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC[2]= Float.parseFloat(s.next());
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
