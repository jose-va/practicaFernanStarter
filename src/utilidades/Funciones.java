package utilidades;
import java.util.Scanner;
import static utilidades.EnvioGMail.enviarConGMail;
import static utilidades.FuncionesCadenas.*;
public class Funciones {

    /**
     * Autentificación mediante código
     * Esta función genera un código aleatorio de 4 dígitos que se enviará a un correo introducido por el usuario.
     *
     * @author Jose Manuel Vilchez Arenas
     * El correo será introducido por el usuario como una cadena de carácteres
     * Si el usuario introduce correctamente el código, será verificado correctamente
     */
    public static void autentificacion() {
        Scanner s = new Scanner(System.in);
        System.out.println("Verificación necesaria. Introduzca su correo electrónico");
        String correo=s.nextLine();

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
                codigoUsuario= Integer.parseInt(s.nextLine());
            }
        } while(codigoUsuario!=codigo);
    }

    /**
     * Vista previa de los proyectos
     *
     * @author Jose Manuel Vilchez Arenas
     *
     * @param proyectos
     * @param nombreProyecto
     * @param categoria
     * @param cantidad
     * @param cantidadAportada
     */

    public static void vistaPreviaProyectos(int proyectos, String[] nombreProyecto, String[] categoria,
                                            int[] cantidad, int[] cantidadAportada){
        if (proyectos <= 0){
            System.out.println("****Actualmente no hay ningún proyecto****");
        }else{
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
        }
    }

    /**
     * Gráfico de inversiones
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
        vistaPreviaProyectos(proyectos,nombreProyecto,categoria,cantidad, cantidadAportada);
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

    /**
     * Apartado de mis proyectos para gestor y administrador
     *
     * @author Jose Manuel Vilchez Arenas
     * Esta función se encarga de la creación y modificación de proyectos
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
                    vistaPreviaProyectos(proyectos,nombreProyecto,categoria,cantidad, cantidadAportada);
                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                    opcion= Integer.parseInt(s.next());
                    switch (opcion){
                        case 1:
                            if (proyectos <=0){
                                System.out.println("No existe el proyecto");
                            }else {
                                System.out.println("Nombre:  ");
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
                    System.out.println("=================================================");
                    vistaPreviaProyectos(proyectos,nombreProyecto,categoria,cantidad, cantidadAportada);
                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto modificarlo: ");
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
        }
    }

    /**
     * Menu de selección de proyectos
     * Esta función muestra por pantalla los proyectos existentes ya creados para que el usuario seleccione el que desee para invertir en él
     *
     * @autor Pablo Valderas Doblas
     * @param nombreProyecto Es el nombre de los diferentes proyectos
     *
     */
    public static void MenuProyectoInversion(String[] nombreProyecto){
        System.out.println("¿En qué proyecto desea invertir?");
        System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
        System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
        System.out.println("3. Proyecto 3: " + nombreProyecto[2]);
        System.out.println("4. Salir");
    }

    /**
     * Esta función permite al inversor poder invertir en el proyecto que ha seleccionado anteriormente
     *
     * @autor Pablo Valderas Doblas
     * @param cantidad Muestra la cantidad total que necesita el proyecto para ser llevado a cabo
     * @param cantidadAportada1 Es la cantidad que aporta el inversor a ese proyecto
     * @param saldoTotal1 Es el saldo del inversor
     * @param inversion1 Este boolean comprueba si el inversor a invertido en un proyecto determinado
     * @param cantidadAportada Es la cantidad que se le a aportado a ese proyecto hasta el momento
     * @param inversiones1 Esta variable almacena la cantidad de veces que ha invertido el inversor
     * @return Detiene la ejecución de la función y devuelve los velores que ha ingresado el usuario al main
     */

    public static int crearInversionA1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1){
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[0] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[0] = true;
            saldoTotal1 -= cantidadAportada1[0];
            cantidadAportada[0] += cantidadAportada1[0];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionA1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }
    public static int crearInversionB1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[1] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[1] = true;
            saldoTotal1 -= cantidadAportada1[1];
            cantidadAportada[1] += cantidadAportada1[1];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionB1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }
    public static int crearInversionC1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[2] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[2] = true;
            saldoTotal1 -= cantidadAportada1[2];
            cantidadAportada[2] += cantidadAportada1[2];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionC1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }

    /**
     * Esta función tiene la misma finalidad que las anteriores pero esta vez con el inversor 2
     * @autor Pablo Valderas Doblas
     *
     */

    public static int crearInversionA2(int[] cantidad, int[] cantidadAportada2, int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2){
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[0]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[0] = true;
            saldoTotal2-=cantidadAportada2[0];
            cantidadAportada[0]+=cantidadAportada2[0];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionA2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
    }

    public static int crearInversionB2 (int[] cantidad, int[] cantidadAportada2, int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[1]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[1] = true;
            saldoTotal2-=cantidadAportada2[1];
            cantidadAportada[1]+=cantidadAportada2[1];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionB2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
    }
    public static int crearInversionC2 (int[] cantidad, int[] cantidadAportada2,int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[2]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[2] = true;
            saldoTotal2-=cantidadAportada2[2];
            cantidadAportada[2]+=cantidadAportada2[2];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionC2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
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
    public static void inversionB1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[1]);
        System.out.print("Categoría: ");
        System.out.println(categoria[1]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[1]+ "€");
        System.out.println();
    }
    public static void inversionC1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[2]);
        System.out.print("Categoría: ");
        System.out.println(categoria[2]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[2]+ "€");
        System.out.println();
    }
    public static void inversionA2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionB2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionC2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
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

    public static void cartera1 (int opcion, int saldoTotal1,int saldo){
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

    public static void cartera2 (int opcion, int saldoTotal1,int saldo){
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
     * @param inversor1 Esta variable es la que almacena el usuario del inversor
     * @param contrasenaInversor1 Esta variable guarda la contraseña del inversor
     */

    public static void config1 (int opcion, String inversor1, String contrasenaInversor1){
        Scanner s = new Scanner(System.in);
        System.out.println("CONFIGURACIÓN. Seleccione una opción: ");
        do {
            System.out.println("1. Cambiar usuario");
            System.out.println("2. Cambiar contraseña");
            System.out.println("3. Guardar cambios");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.printf("Usuario actual -> %s\n", inversor1);
                    System.out.println("Introduzca su nuevo usuario: ");
                    inversor1 = s.nextLine();
                    break;
                case 2:
                    System.out.printf("Contraseña actual -> %s\n", contrasenaInversor1);
                    System.out.println("Introduzca su nueva contraseña: ");
                    contrasenaInversor1 = s.nextLine();
                    break;
            }
        } while (opcion != 3);
        System.out.println("Los cambios se han guardado correctamente");
        System.out.println("Redirigiendo al menú principal");
    }

    public static void config2 (int opcion, String inversor2, String contrasenaInversor2){
        Scanner s = new Scanner(System.in);
        System.out.println("CONFIGURACIÓN. Seleccione una opción: ");
        do {
            System.out.println("1. Cambiar usuario");
            System.out.println("2. Cambiar contraseña");
            System.out.println("3. Guardar cambios");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.printf("Usuario actual -> %s\n", inversor2);
                    System.out.println("Introduzca su nuevo usuario: ");
                    inversor2 = s.nextLine();
                    break;
                case 2:
                    System.out.printf("Contraseña actual -> %s\n", contrasenaInversor2);
                    System.out.println("Introduzca su nueva contraseña: ");
                    contrasenaInversor2 = s.nextLine();
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
