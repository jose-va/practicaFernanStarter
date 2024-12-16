package utilidades;

import java.util.Scanner;
public class FuncionesInversiones {
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

}