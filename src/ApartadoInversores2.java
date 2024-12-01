import java.util.Scanner;

public class ApartadoInversores2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String administrador = "jose", contrasenaAdministrador = "1234jose";
        String gestor = "pablo", contrasenaGestor = "1234pablo";
        String inversor1 = "eladio", contrasenaInversor1 = "1234eladio";
        String inversor2 = "toranzo", contrasenaInversor2 = "1234toranzo";
        String amigo = "", contrasena = "", correo;

        String nombreProyectoA = "", nombreProyectoB = "", nombreProyectoC = "";
        String descripcionProyectoA = "", descripcionProyectoB = "", descripcionProyectoC = "";
        String fechaAperturaA = "", fechaAperturaB = "", fechaAperturaC = "";
        String fechaCierreA = "", fechaCierreB = "", fechaCierreC = "";

        String nombreRecompensaA1 = "", nombreRecompensaA2 = "", nombreRecompensaA3 = "";
        String nombreRecompensaB1 = "", nombreRecompensaB2 = "", nombreRecompensaB3 = "";
        String nombreRecompensaC1 = "", nombreRecompensaC2 = "", nombreRecompensaC3 = "";

        String descripcionRecompensaA1 = "", descripcionRecompensaA2 = "", descripcionRecompensaA3 = "";
        String descripcionRecompensaB1 = "", descripcionRecompensaB2 = "", descripcionRecompensaB3 = "";
        String descripcionRecompensaC1 = "", descripcionRecompensaC2 = "", descripcionRecompensaC3 = "";

        float precioRecompensaA1 = 0, precioRecompensaA2 = 0, precioRecompensaA3 = 0;
        float precioRecompensaB1 = 0, precioRecompensaB2 = 0, precioRecompensaB3 = 0;
        float precioRecompensaC1 = 0, precioRecompensaC2 = 0, precioRecompensaC3 = 0;
        int recompensasA = 0, recompensasB = 0, recompensasC = 0;

        int categoriaA = 0, categoriaB = 0, categoriaC = 0;
        int cantidadAportadaA1 = 0, cantidadAportadaB1 = 0, cantidadAportadaC1 = 0, cantidadAportadaA2 = 0, cantidadAportadaB2 = 0, cantidadAportadaC2 = 0;
        int cantidadAportadaA = cantidadAportadaA1 + cantidadAportadaA2, cantidadAportadaB = cantidadAportadaB1 + cantidadAportadaA1, cantidadAportadaC = cantidadAportadaC1 + cantidadAportadaC2;
        int cantidadA = 0, cantidadB = 0, cantidadC = 0;
        int proyectos = 0, saldo = 0, saldoTotal1 = 0, saldoTotal2 = 0, inversiones1 = 0, inversiones2 = 0, amigos = 0;
        int aportacionI1, aportacionI2 = 0;
        boolean inversionA1 = false, inversionB1 = false, inversionC1 = false, inversionA2 = false, inversionB2 = false, inversionC2 = false;

        int intentos = 3, opcion, numpro = 0, menu;
        boolean bloqueoGestor = false, bloqueoInversor1 = false, bloqueoInversor2 = false, sesion = true;
        //}if (contrasena.equals(contrasenaInversor1)) { //Menú inversor1-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Bienvenido. Cuenta de inversor 1.");
        do {
            System.out.println("========MENÚ========");
            System.out.println("1. Mis inversiones");
            System.out.println("2. Proyectos");
            System.out.println("3. Cartera digital");
            System.out.println("4. Invita a un amigo");
            System.out.println("5. Configuración");
            System.out.println("6. Cerrar sesión");
            menu = s.nextInt();

            switch (menu) {
                case 1:
                    opcion = 1;
                    while (opcion == 1 || opcion == 2) {
                        System.out.println("----MIS INVERSIONES----");
                        System.out.println("1. Crear inversiones");
                        System.out.println("2. Consultar inversiones");
                        System.out.println("3. Salir");
                        opcion = Integer.parseInt(s.next());
                        switch (opcion) {
                            case 1:
                                System.out.println("¿En qué proyecto desea invertir?");
                                System.out.println("Proyecto 1: " + nombreProyectoA);
                                System.out.println("Proyecto 2: " + nombreProyectoB);
                                System.out.println("Proyecto 3: " + nombreProyectoC);
                                aportacionI1 = Integer.parseInt(s.next());
                                switch (aportacionI1) {
                                    case 1:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadA);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaA1 = s.nextInt();
                                        if (cantidadAportadaA1>saldoTotal1){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal1);
                                            break;
                                        }else{
                                            inversionA1 = true;
                                            saldoTotal1+=cantidadAportadaA1;
                                            inversiones1++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    case 2:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadB);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaB1 = s.nextInt();
                                        if (cantidadAportadaB1>saldoTotal1){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal1);
                                            break;
                                        }else{
                                            inversionB1 = true;
                                            saldoTotal1-=cantidadAportadaB1;
                                            inversiones1++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    case 3:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadC);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaC1 = s.nextInt();
                                        if (cantidadAportadaC1>saldoTotal1){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal1);
                                            break;
                                        }else{
                                            inversionC1 = true;
                                            saldoTotal1+=cantidadAportadaC1;
                                            inversiones1++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    default:
                                        System.out.println("Debe de introducir la opción correspondiente correcta");
                                        break;
                                } break;
                            case 2:
                                if (inversiones1 == 0) {
                                    System.out.println("Actualmente, no ha realizado ninguna inversión");
                                    System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                    String respuesta2 = s.nextLine();
                                    while (!respuesta2.equals("s")) {
                                        if (respuesta2.equals("n")) {
                                            return;
                                        }
                                        System.out.println("Introduce una opcion valida (s/n)");
                                        System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                        respuesta2 = s.nextLine();
                                    }
                                    if (respuesta2.equals("s")) {
                                        int opcion3 = 0;
                                        while (opcion3 != 1 || opcion3 != 2 || opcion3 != 3) {
                                            System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                                            System.out.println("Proyecto 1: " + nombreProyectoA);
                                            System.out.println("Proyecto 2: " + nombreProyectoB);
                                            System.out.println("Proyecto 3: " + nombreProyectoC);
                                            aportacionI1 = Integer.parseInt(s.nextLine());
                                            switch (aportacionI1) {
                                                case 1:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadA);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaA1 = s.nextInt();
                                                    if (cantidadAportadaA1>saldoTotal1){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal1);
                                                        break;
                                                    }else{
                                                        inversionA1 = true;
                                                        saldoTotal1+=cantidadAportadaA1;
                                                        inversiones1++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                case 2:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadB);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaB1 = s.nextInt();
                                                    if (cantidadAportadaB1>saldoTotal1){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal1);
                                                        break;
                                                    }else{
                                                        inversionB1 = true;
                                                        saldoTotal1-=cantidadAportadaB1;
                                                        inversiones1++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                case 3:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadC);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaC1 = s.nextInt();
                                                    if (cantidadAportadaC1>saldoTotal1){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal1);
                                                        break;
                                                    }else{
                                                        inversionC1 = true;
                                                        saldoTotal1+=cantidadAportadaC1;
                                                        inversiones1++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                default:
                                                    System.out.println("Debe de introducir la opción correspondiente correcta");
                                                    break;
                                            }
                                        }
                                    }
                                } else if (inversiones1 > 0) {
                                    System.out.println("*****Consulta de inversiones*****");
                                    if (inversiones1 == 1) {
                                        if (inversionA1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println("Categoría: "+categoriaA);
                                            System.out.println("Cantidad aportada: "+cantidadAportadaA);
                                            System.out.println();
                                        }
                                        if (inversionB1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                        }
                                        if (inversionC1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                    }
                                    if (inversiones1 == 2) {
                                        System.out.println("¿Que inversión desea consultar?");
                                        if (inversionA1 && inversionB1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println(categoriaA);
                                            System.out.println(cantidadAportadaA);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                        }
                                        if (inversionA1 && inversionC1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println(categoriaA);
                                            System.out.println(cantidadAportadaA);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                        if (inversionB1 && inversionC1) {
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                    }
                                    if (inversiones1 == 3) {
                                        System.out.println("Lista de todaas sus inversiones: ");
                                        System.out.println();
                                        System.out.println(nombreProyectoA);
                                        System.out.println(categoriaA);
                                        System.out.println(cantidadAportadaA);
                                        System.out.println();
                                        System.out.println("******************************");
                                        System.out.println();
                                        System.out.println(nombreProyectoB);
                                        System.out.println(categoriaB);
                                        System.out.println(cantidadAportadaB);
                                        System.out.println();
                                        System.out.println("******************************");
                                        System.out.println();
                                        System.out.println(nombreProyectoC);
                                        System.out.println(categoriaC);
                                        System.out.println(cantidadAportadaC);
                                        System.out.println();
                                    }
                                }
                            case 3:
                                System.out.println("Salir. Redirigiendo al menú del inversor.");
                                break;
                        }
                    }
                case 2:
                    System.out.println("****Actualmente no hay ningún proyecto****");
                    if (proyectos < 1) break;
                    System.out.println("CONSULTA DE PROYECTOS");
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 1");
                    System.out.println(nombreProyectoA);
                    System.out.println("Categoría: " + categoriaA);
                    System.out.println("Cantidad necesaria: " + cantidadA);
                    System.out.println("Cantidad financiada hasta el momento: "+  cantidadAportadaA);
                    if (proyectos < 2) break;
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 2");
                    System.out.println(nombreProyectoB);
                    System.out.println("Categoría: " + categoriaB);
                    System.out.println("Cantidad necesaria: " + cantidadB);
                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                    System.out.println("Cantidad financiada hasta el momento: ");
                    if (proyectos < 3) break;
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 3");
                    System.out.println(nombreProyectoC);
                    System.out.println("Categoría: " + categoriaC);
                    System.out.println("Cantidad necesaria: " + cantidadC);
                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                    System.out.println("Cantidad financiada hasta el momento: ");
                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                    opcion = Integer.parseInt(s.next());
                    switch (opcion) {
                        case 1:
                            if (proyectos <= 0) {
                                System.out.println("No existe el proyecto");
                            } else {
                                System.out.println(nombreProyectoA);
                                System.out.println(descripcionProyectoA);
                                System.out.println(categoriaA);
                                System.out.println(cantidadA);
                                System.out.println(cantidadAportadaA);
                                System.out.println(fechaAperturaA);
                                System.out.println(fechaCierreA);
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaA1);
                                System.out.println(descripcionRecompensaA1);
                                System.out.println(precioRecompensaA1);
                                if (recompensasA == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA2);
                                System.out.println(descripcionRecompensaA2);
                                System.out.println(precioRecompensaA2);
                                if (recompensasA == 2) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA3);
                                System.out.println(descripcionRecompensaA3);
                                System.out.println(precioRecompensaA3);
                            }
                            break;
                        case 2:
                            if (proyectos < 2) {
                                System.out.println("No existe el proyecto.");
                            } else {
                                System.out.println(nombreProyectoB);
                                System.out.println(descripcionProyectoB);
                                System.out.println(categoriaB);
                                System.out.println(cantidadB);
                                System.out.println(cantidadAportadaB);
                                System.out.println(fechaAperturaB);
                                System.out.println(fechaCierreB);
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaB1);
                                System.out.println(descripcionRecompensaB1);
                                System.out.println(precioRecompensaB1);
                                if (recompensasB == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaB2);
                                System.out.println(descripcionRecompensaB2);
                                System.out.println(precioRecompensaB2);
                                if (recompensasB == 2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaB3);
                                System.out.println(descripcionRecompensaB3);
                                System.out.println(precioRecompensaB3);
                            }
                            break;
                        case 3:
                            if (proyectos < 3) {
                                System.out.println("No existe el proyecto.");
                            } else {
                                System.out.println(nombreProyectoC);
                                System.out.println(descripcionProyectoC);
                                System.out.println(categoriaC);
                                System.out.println(cantidadC);
                                System.out.println(cantidadAportadaC);
                                System.out.println(fechaAperturaC);
                                System.out.println(fechaCierreC);
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaC1);
                                System.out.println(descripcionRecompensaC1);
                                System.out.println(precioRecompensaC1);
                                if (recompensasB == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaC2);
                                System.out.println(descripcionRecompensaC2);
                                System.out.println(precioRecompensaC2);
                                if (recompensasB == 2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaC3);
                                System.out.println(descripcionRecompensaC3);
                                System.out.println(precioRecompensaC3);
                            }
                            break;
                        default:
                            System.out.println("Debe seleccionar un proyecto válido.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("CARTERA DIGITAL");
                    do {
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
                            case 3:
                                System.out.println("Usted ha seleccionado salir.");
                            default:
                                System.out.println("Opcion seleccionada inválida.");
                        }
                    } while (opcion != 3);

                    break;
                case 4:
                    System.out.println("INVITAR A UN AMIGO");
                    do {
                        System.out.println("1. Listado de amigos");
                        System.out.println("2. Añadir a un amigo");
                        opcion = s.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("LISTADO DE AMIGOS");
                                System.out.println(amigo);
                            case 2:
                                System.out.println("AÑADIR A UN AMIGO: ");
                                correo = s.nextLine();
                                amigo = amigo.concat(" " + correo);
                        }

                    } while (opcion != 3);
                    break;
                case 5:
                    System.out.println("CONFIGURACION. Seleccione una opción: ");
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

                    break;
                case 6:
                    System.out.println("Salir. Usted volverá al login.");
                    break;

                default:
                    System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                    break;
            }
        } while (menu != 6);

        //}if (contrasena.equals(contrasenaInversor2)) { //Menú inversor2-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Bienvenido. Cuenta de inversor 2.");
        do {
            System.out.println("========MENÚ========");
            System.out.println("1. Mis inversiones");
            System.out.println("2. Proyectos");
            System.out.println("3. Cartera digital");
            System.out.println("4. Invita a un amigo");
            System.out.println("5. Configuración");
            System.out.println("6. Cerrar sesión");
            menu = s.nextInt();

            switch (menu) {
                case 1:
                    opcion = 1;
                    while (opcion == 1 || opcion == 2) {
                        System.out.println("----MIS INVERSIONES----");
                        System.out.println("1. Crear inversiones");
                        System.out.println("2. Consultar inversiones");
                        System.out.println("3. Salir");
                        opcion = Integer.parseInt(s.next());
                        switch (opcion) {
                            case 1:
                                System.out.println("¿En qué proyecto desea invertir?");
                                System.out.println("Proyecto 1: " + nombreProyectoA);
                                System.out.println("Proyecto 2: " + nombreProyectoB);
                                System.out.println("Proyecto 3: " + nombreProyectoC);
                                aportacionI2 = Integer.parseInt(s.next());
                                switch (aportacionI2) {
                                    case 1:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadA);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaA2 = s.nextInt();
                                        if (cantidadAportadaA2>saldoTotal1){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal2);
                                            break;
                                        }else{
                                            inversionA2 = true;
                                            saldoTotal2+=cantidadAportadaA2;
                                            inversiones2++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    case 2:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadB);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaB2 = s.nextInt();
                                        if (cantidadAportadaB2>saldoTotal2){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal2);
                                            break;
                                        }else{
                                            inversionB2 = true;
                                            saldoTotal2-=cantidadAportadaB2;
                                            inversiones2++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    case 3:
                                        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadC);
                                        System.out.println("¿Que cantidad desea aportar?");
                                        cantidadAportadaC2 = s.nextInt();
                                        if (cantidadAportadaC2>saldoTotal2){
                                            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                            System.out.println("Su saldo es de: "+saldoTotal2);
                                            break;
                                        }else{
                                            inversionC2 = true;
                                            saldoTotal2+=cantidadAportadaC2;
                                            inversiones2++;
                                            System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                            break;
                                        }
                                    default:
                                        System.out.println("Debe de introducir la opción correspondiente correcta");
                                        break;
                                } break;
                            case 2:
                                if (inversiones2 == 0) {
                                    System.out.println("Actualmente, no ha realizado ninguna inversión");
                                    System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                    String respuesta2 = s.nextLine();
                                    while (!respuesta2.equals("s")) {
                                        if (respuesta2.equals("n")) {
                                            return;
                                        }
                                        System.out.println("Introduce una opcion valida (s/n)");
                                        System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                        respuesta2 = s.nextLine();
                                    }
                                    if (respuesta2.equals("s")) {
                                        int opcion3 = 0;
                                        while (opcion3 != 1 || opcion3 != 2 || opcion3 != 3) {
                                            System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                                            System.out.println("Proyecto 1: " + nombreProyectoA);
                                            System.out.println("Proyecto 2: " + nombreProyectoB);
                                            System.out.println("Proyecto 3: " + nombreProyectoC);
                                            aportacionI2 = Integer.parseInt(s.nextLine());
                                            switch (aportacionI2) {
                                                case 1:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadA);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaA2 = s.nextInt();
                                                    if (cantidadAportadaA2>saldoTotal2){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal2);
                                                        break;
                                                    }else{
                                                        inversionA2 = true;
                                                        saldoTotal2+=cantidadAportadaA2;
                                                        inversiones2++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                case 2:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadB);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaB2 = s.nextInt();
                                                    if (cantidadAportadaB2>saldoTotal2){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal2);
                                                        break;
                                                    }else{
                                                        inversionB2 = true;
                                                        saldoTotal2-=cantidadAportadaB2;
                                                        inversiones2++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                case 3:
                                                    System.out.println("La cantidad necesaria de este proyecto es de " + cantidadC);
                                                    System.out.println("¿Que cantidad desea aportar?");
                                                    cantidadAportadaC2 = s.nextInt();
                                                    if (cantidadAportadaC2>saldoTotal2){
                                                        System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                        System.out.println("Su saldo es de: "+saldoTotal2);
                                                        break;
                                                    }else{
                                                        inversionC2 = true;
                                                        saldoTotal2+=cantidadAportadaC2;
                                                        inversiones2++;
                                                        System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                        break;
                                                    }
                                                default:
                                                    System.out.println("Debe de introducir la opción correspondiente correcta");
                                                    break;
                                            }
                                        }
                                    }
                                } else if (inversiones2 > 0) {
                                    System.out.println("*****Consulta de inversiones*****");
                                    if (inversiones2 == 1) {
                                        if (inversionA2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println("Categoría: "+categoriaA);
                                            System.out.println("Cantidad aportada: "+cantidadAportadaA);
                                            System.out.println();
                                        }
                                        if (inversionB2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                        }
                                        if (inversionC2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                    }
                                    if (inversiones2 == 2) {
                                        System.out.println("¿Que inversión desea consultar?");
                                        if (inversionA2 && inversionB2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println(categoriaA);
                                            System.out.println(cantidadAportadaA);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                        }
                                        if (inversionA2 && inversionC2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoA);
                                            System.out.println(categoriaA);
                                            System.out.println(cantidadAportadaA);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                        if (inversionB2 && inversionC2) {
                                            System.out.println();
                                            System.out.println(nombreProyectoB);
                                            System.out.println(categoriaB);
                                            System.out.println(cantidadAportadaB);
                                            System.out.println();
                                            System.out.println("******************************");
                                            System.out.println();
                                            System.out.println(nombreProyectoC);
                                            System.out.println(categoriaC);
                                            System.out.println(cantidadAportadaC);
                                            System.out.println();
                                        }
                                    }
                                    if (inversiones2 == 3) {
                                        System.out.println("Lista de todaas sus inversiones: ");
                                        System.out.println();
                                        System.out.println(nombreProyectoA);
                                        System.out.println(categoriaA);
                                        System.out.println(cantidadAportadaA);
                                        System.out.println();
                                        System.out.println("******************************");
                                        System.out.println();
                                        System.out.println(nombreProyectoB);
                                        System.out.println(categoriaB);
                                        System.out.println(cantidadAportadaB);
                                        System.out.println();
                                        System.out.println("******************************");
                                        System.out.println();
                                        System.out.println(nombreProyectoC);
                                        System.out.println(categoriaC);
                                        System.out.println(cantidadAportadaC);
                                        System.out.println();
                                    }
                                }
                            case 3:
                                System.out.println("Salir. Redirigiendo al menú del inversor.");
                                break;
                        }
                    }
                case 2:
                    System.out.println("****Actualmente no hay ningún proyecto****");
                    if (proyectos < 1) break;
                    System.out.println("CONSULTA DE PROYECTOS");
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 1");
                    System.out.println(nombreProyectoA);
                    System.out.println("Categoría: " + categoriaA);
                    System.out.println("Cantidad necesaria: " + cantidadA);
                    System.out.println("Cantidad financiada hasta el momento: "+ cantidadAportadaA);
                    if (proyectos < 2) break;
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 2");
                    System.out.println(nombreProyectoB);
                    System.out.println("Categoría: " + categoriaB);
                    System.out.println("Cantidad necesaria: " + cantidadB);

                    System.out.println("Cantidad financiada hasta el momento: "+ cantidadAportadaB);
                    if (proyectos < 3) break;
                    System.out.println("=================================================");
                    System.out.println("PROYECTO 3");
                    System.out.println(nombreProyectoC);
                    System.out.println("Categoría: " + categoriaC);
                    System.out.println("Cantidad necesaria: " + cantidadC);
                    System.out.println("Cantidad financiada hasta el momento: "+ cantidadAportadaC);
                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                    opcion = Integer.parseInt(s.next());
                    switch (opcion) {
                        case 1:
                            if (proyectos <= 0) {
                                System.out.println("No existe el proyecto");
                            } else {
                                System.out.println(nombreProyectoA);
                                System.out.println("Descripción: "+descripcionProyectoA);
                                System.out.println("Categoría: "+categoriaA);
                                System.out.println("Cantidad necesaria: "+cantidadA);
                                System.out.println("Cantidad aportada hasta el momento: "+cantidadAportadaA);
                                System.out.println("Fecha de apertura: "+fechaAperturaA);
                                System.out.println("Fecha de cierre: "+fechaCierreA);
                                System.out.println();
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaA1);
                                System.out.println("Descripción: "+descripcionRecompensaA1);
                                System.out.println("Precio de la recompensa: "+precioRecompensaA1);
                                if (recompensasA == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA2);
                                System.out.println("Descripción: "+descripcionRecompensaA2);
                                System.out.println("Precio de la recompensa: "+precioRecompensaA2);
                                if (recompensasA == 2) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA3);
                                System.out.println("Descripción: "+descripcionRecompensaA3);
                                System.out.println("Precio de la recompensa: "+precioRecompensaA3);
                            }
                            break;
                        case 2:
                            if (proyectos < 2) {
                                System.out.println("No existe el proyecto.");
                            } else {
                                System.out.println(nombreProyectoB);
                                System.out.println("Descripción: "+descripcionProyectoB);
                                System.out.println("Categoría: "+categoriaB);
                                System.out.println("Cantidad necesaria: "+cantidadB);
                                System.out.println("Cantidad aportada hasta el momento: "+cantidadAportadaB);
                                System.out.println(fechaAperturaB);
                                System.out.println(fechaCierreB);
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaB1);
                                System.out.println("Descripción: "+descripcionRecompensaB1);
                                System.out.println(precioRecompensaB1);
                                if (recompensasB == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaB2);
                                System.out.println("Descripción: "+descripcionRecompensaB2);
                                System.out.println(precioRecompensaB2);
                                if (recompensasB == 2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaB3);
                                System.out.println(descripcionRecompensaB3);
                                System.out.println(precioRecompensaB3);
                            }
                            break;
                        case 3:
                            if (proyectos < 3) {
                                System.out.println("No existe el proyecto.");
                            } else {
                                System.out.println(nombreProyectoC);
                                System.out.println("Descripción: "+descripcionProyectoC);
                                System.out.println("Categoría: "+categoriaC);
                                System.out.println("Cantidad necesaria: "+cantidadC);
                                System.out.println("Cantidad aportada hasta el momento: "+cantidadAportadaC2);
                                System.out.println(fechaAperturaC);
                                System.out.println(fechaCierreC);
                                System.out.println("RECOMPENSA 1");
                                System.out.println(nombreRecompensaC1);
                                System.out.println("Descripción: "+descripcionRecompensaC1);
                                System.out.println(precioRecompensaC1);
                                if (recompensasB == 1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaC2);
                                System.out.println("Descripción: "+descripcionRecompensaC2);
                                System.out.println(precioRecompensaC2);
                                if (recompensasB == 2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaC3);
                                System.out.println("Descripción: "+descripcionRecompensaC3);
                                System.out.println(precioRecompensaC3);
                            }
                            break;
                        default:
                            System.out.println("Debe seleccionar un proyecto válido.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("CARTERA DIGITAL");
                    do {
                        System.out.println("1. Saldo actual");
                        System.out.println("2. Añadir saldo");
                        System.out.println("3. Salir");
                        opcion = Integer.parseInt(s.next());
                        switch (opcion) {
                            case 1:
                                if (saldoTotal1 == 0) {
                                    System.out.println("Usted no dispone de saldo.");
                                    break;
                                } else {
                                    System.out.printf("Saldo %d€", saldoTotal1);
                                }
                                break;
                            case 2:
                                System.out.println("¿Cuánto dinero desea ingresar?");
                                saldo = Integer.parseInt(s.next());
                                saldoTotal1 += saldo;
                                System.out.println("Su saldo ha sido añadido correctamente");
                            case 3:
                                System.out.println("Usted ha seleccionado salir.");
                            default:
                                System.out.println("Opcion seleccionada inválida.");
                        }
                    } while (opcion != 3);

                    break;
                case 4:
                    System.out.println("INVITAR A UN AMIGO");
                    do {
                        System.out.println("1. Listado de amigos");
                        System.out.println("2. Añadir a un amigo");
                        opcion = s.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("LISTADO DE AMIGOS");
                                System.out.println(amigo);
                            case 2:
                                System.out.println("AÑADIR A UN AMIGO: ");
                                correo = s.nextLine();
                                amigo = amigo.concat(" " + correo);
                        }

                    } while (opcion != 3);
                    break;
                case 5:
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

                    break;
                case 6:
                    System.out.println("Salir. Usted volverá al login.");
                    break;

                default:
                    System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                    break;
            }
        } while (menu != 6);
    }
}
