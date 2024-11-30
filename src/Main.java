import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "toranzo", contrasenaInversor2="1234toranzo";
        String amigo="",contrasena="", correo;

        String nombreProyectoA = "", nombreProyectoB = "", nombreProyectoC="";
        String descripcionProyectoA = "", descripcionProyectoB = "", descripcionProyectoC="";
        String fechaAperturaA="", fechaAperturaB="", fechaAperturaC="";
        String fechaCierreA="", fechaCierreB="", fechaCierreC="";

        String nombreRecompensaA1="", nombreRecompensaA2="", nombreRecompensaA3="";
        String nombreRecompensaB1="", nombreRecompensaB2="", nombreRecompensaB3="";
        String nombreRecompensaC1="", nombreRecompensaC2="", nombreRecompensaC3="";

        String descripcionRecompensaA1="", descripcionRecompensaA2="", descripcionRecompensaA3="";
        String descripcionRecompensaB1="", descripcionRecompensaB2="", descripcionRecompensaB3="";
        String descripcionRecompensaC1="", descripcionRecompensaC2="", descripcionRecompensaC3="";

        float precioRecompensaA1=0, precioRecompensaA2=0, precioRecompensaA3=0;
        float precioRecompensaB1=0, precioRecompensaB2=0, precioRecompensaB3=0;
        float precioRecompensaC1=0, precioRecompensaC2=0, precioRecompensaC3=0;
        int recompensasA=0, recompensasB=0, recompensasC=0;

        int categoriaA=0, categoriaB=0, categoriaC=0;
        int cantidadA=0,cantidadAportadaA=0, cantidadB=0, cantidadAportadaB=0, cantidadC=0, cantidadAportadaC=0;
        int proyectos=0, saldo=0, saldoTotal=0, inversiones=0, amigos=0;
        int aportacionI1, aportacionI2=0;
        boolean inversionA=false, inversionB=false, inversionC=false;

        int intentos=3, opcion, numpro=0, menu;
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false,sesion=true;

        do {
            System.out.println("************Bienvenido*********");
            System.out.println("Introduzca su nombre de usuario: ");
            String usuario = s.next().toLowerCase();

            while (!usuario.equals(administrador) && !usuario.equals(gestor)
                    && !usuario.equals(inversor1) && !usuario.equals(inversor2)) {
                System.out.println("El usuario no existe.");
                System.out.println("Por favor, introduzca un nombre de usuario válido: ");
                usuario = s.next();
            }

            if (usuario.equals(administrador)){
                System.out.println("Administrador. Introduzca su contraseña: ");
                contrasena = s.next();
                while (!contrasena.equals(contrasenaAdministrador)) {
                    System.out.println("Contraseña incorrecta.");
                    System.out.println("Por favor, introduzca su contraseña: ");
                    contrasena = s.next();
                }
            }

            if (usuario.equals(gestor)) {
                if (bloqueoGestor) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                while (!contrasena.equals(contrasenaGestor) && intentos > 0) {
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                }

                if (intentos == 0) {
                    bloqueoGestor = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (usuario.equals(inversor1)){
                if (bloqueoInversor1) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }

                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                while (!contrasena.equals(contrasenaInversor1) && intentos > 0) {
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                }

                if (intentos == 0) {
                    bloqueoInversor1 = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (usuario.equals(inversor2)){
                if (bloqueoInversor2) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                while (!contrasena.equals(contrasenaInversor2) && intentos > 0) {
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                }

                if (intentos == 0) {
                    bloqueoInversor2 = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (contrasena.equals(contrasenaInversor1)) { //Menú inversor

                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    System.out.println("=======MENÚ========");
                    System.out.println("1. Mis inversiones");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Cartera digital");
                    System.out.println("4. Invita a un amigo");
                    System.out.println("5. Configuración");
                    System.out.println("6. Cerrar sesión");
                    menu = s.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println("-----MIS INVERSIONES-----");
                            System.out.println("1. Crear inversiones");
                            System.out.println("2. Consultar inversiones");
                            System.out.println("3. Salir");
                            opcion= Integer.parseInt(s.next());
                            switch (opcion){
                                case 1:
                                    System.out.println("¿En qué proyecto desea invertir?");
                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                    System.out.println("Proyecto 3: " + nombreProyectoC);
                                    aportacionI1 = Integer.parseInt(s.nextLine());
                                    switch (aportacionI1) {
                                        case 1:
                                            System.out.println("La versión necesaria de este proyecto es de " + cantidadA);
                                            System.out.println("¿Que cantidad desea aportar?");
                                            cantidadAportadaA = s.nextInt();
                                            inversionA = true;
                                            break;
                                        case 2:
                                            System.out.println("La versión necesaria de este proyecto es de " + cantidadB);
                                            System.out.println("¿Que cantidad desea aportar?");
                                            cantidadAportadaB = s.nextInt();
                                            inversionB = true;
                                            break;
                                        case 3:
                                            System.out.println("La versión necesaria de este proyecto es de " + cantidadC);
                                            System.out.println("¿Que cantidad desea aportar?");
                                            cantidadAportadaC = s.nextInt();
                                            inversionC = true;
                                            break;
                                        default:
                                            System.out.println("Debe de introducir la opción correspondiente correcta");
                                            break;
                                    }
                                case 2:
                                    if (inversiones == 0) {
                                        System.out.println("Actualmente, no ha realizado ninguna inversión");
                                        System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                        String respuesta2 = s.nextLine();
                                        while (!respuesta2.equals("s")){
                                            if (respuesta2.equals("n")){
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
                                                        System.out.println("La versión necesaria de este proyecto es de " + cantidadA);
                                                        System.out.println("¿Que cantidad desea aportar?");
                                                        cantidadAportadaA = s.nextInt();
                                                        inversionA = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("La versión necesaria de este proyecto es de " + cantidadB);
                                                        System.out.println("¿Que cantidad desea aportar?");
                                                        cantidadAportadaB = s.nextInt();
                                                        inversionB = true;
                                                        break;
                                                    case 3:
                                                        System.out.println("La versión necesaria de este proyecto es de " + cantidadC);
                                                        System.out.println("¿Que cantidad desea aportar?");
                                                        cantidadAportadaC = s.nextInt();
                                                        inversionC = true;
                                                        break;
                                                    default:
                                                        System.out.println("Debe de introducir la opción correspondiente correcta");
                                                        break;
                                                }
                                            }
                                        }
                                    } else if (inversiones>0){
                                        System.out.println("*****Consulta de inversiones*****");
                                        System.out.println("¿Que inversión desea consultar?");
                                        if (inversiones==1){
                                            if (inversionA){

                                            }
                                            if (inversionB){

                                            }
                                            if (inversionC){

                                            }
                                        }
                                        if (inversiones==2){
                                            /*if (inversionA && inversionB=true) {
                                                System.out.println("duhewj");

                                            }
                                            if (inversionA=true && inversionC=true) {

                                            }
                                            if (inversionB=true && inversionC=true) {

                                            }*/
                                        }
                                        if (inversiones==3){
                                            if (inversionA){
                                            }
                                        }
                                    }
                                    break;
                                        case 3:






                                            break;
                            }
                        case 2:
                            System.out.println("CONSULTA DE PROYECTOS");
                            System.out.println("=================================================");
                            System.out.println("PROYECTO 1");
                            System.out.println(nombreProyectoA);
                            System.out.println("Categoría: " + categoriaA);
                            System.out.println("Cantidad necesaria: " + cantidadA);
                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                            System.out.println("Cantidad financiada hasta el momento: ");
                            if (proyectos<2) break;
                            System.out.println("=================================================");
                            System.out.println("PROYECTO 2");
                            System.out.println(nombreProyectoB);
                            System.out.println("Categoría: " + categoriaB);
                            System.out.println("Cantidad necesaria: " + cantidadB);
                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                            System.out.println("Cantidad financiada hasta el momento: ");
                            if (proyectos<3) break;
                            System.out.println("=================================================");
                            System.out.println("PROYECTO 3");
                            System.out.println(nombreProyectoC);
                            System.out.println("Categoría: " + categoriaC);
                            System.out.println("Cantidad necesaria: " + cantidadC);
                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                            System.out.println("Cantidad financiada hasta el momento: ");
                            System.out.println("========================================================================");
                            System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                            opcion= Integer.parseInt(s.next());
                            switch (opcion){
                                case 1:
                                    if (proyectos <=0){
                                        System.out.println("No existe el proyecto");
                                    }else {
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
                                        if (recompensasA==1) break;
                                        System.out.println("RECOMPENSA 2");
                                        System.out.println(nombreRecompensaA2);
                                        System.out.println(descripcionRecompensaA2);
                                        System.out.println(precioRecompensaA2);
                                        if (recompensasA==2) break;
                                        System.out.println("RECOMPENSA 2");
                                        System.out.println(nombreRecompensaA3);
                                        System.out.println(descripcionRecompensaA3);
                                        System.out.println(precioRecompensaA3);
                                    }
                                    break;
                                case 2:
                                    if (proyectos <2){
                                        System.out.println("No existe el proyecto.");
                                    }else {
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
                                        if (recompensasB==1) break;
                                        System.out.println("RECOMPENSA 2");
                                        System.out.println(nombreRecompensaB2);
                                        System.out.println(descripcionRecompensaB2);
                                        System.out.println(precioRecompensaB2);
                                        if (recompensasB==2) break;
                                        System.out.println("RECOMPENSA 3");
                                        System.out.println(nombreRecompensaB3);
                                        System.out.println(descripcionRecompensaB3);
                                        System.out.println(precioRecompensaB3);
                                    }
                                    break;
                                case 3:
                                    if (proyectos <3){
                                        System.out.println("No existe el proyecto.");
                                    }else {
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
                                        if (recompensasB==1) break;
                                        System.out.println("RECOMPENSA 2");
                                        System.out.println(nombreRecompensaC2);
                                        System.out.println(descripcionRecompensaC2);
                                        System.out.println(precioRecompensaC2);
                                        if (recompensasB==2) break;
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
                            do{
                                System.out.println("1. Saldo actual");
                                System.out.println("2. Añadir saldo");
                                System.out.println("3. Salir");
                                opcion= Integer.parseInt(s.next());
                                switch (opcion){
                                    case 1:
                                        if(saldoTotal==0){
                                            System.out.println("Usted no dispone de saldo.");
                                            break;
                                        }else{
                                            System.out.printf("Saldo %d€", saldoTotal);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("¿Cuánto dinero desea ingresar?");
                                        saldo=Integer.parseInt(s.next());
                                        saldoTotal+=saldo;
                                        System.out.println("Su saldo ha sido añadido correctamente");
                                    case 3:
                                        System.out.println("Usted ha seleccionado salir.");
                                    default:
                                        System.out.println("Opcion seleccionada inválida.");
                                }
                            }while(opcion!=3);

                            break;
                        case 4:
                            System.out.println("INVITAR A UN AMIGO");
                            do{
                                System.out.println("1. Listado de amigos");
                                System.out.println("2. Añadir a un amigo");
                                opcion=s.nextInt();
                                switch (opcion){
                                    case 1:
                                        System.out.println("LISTADO DE AMIGOS");
                                        System.out.println(amigo);
                                    case 2:
                                        System.out.println("AÑADIR A UN AMIGO: ");
                                        correo= s.nextLine();
                                        amigo= amigo.concat(" " + correo);
                                }

                            }while(opcion!=3);
                            break;
                        case 5:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do{
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
                            }while (opcion!=3);

                            break;
                        case 6:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                            break;
                    }
                } while (menu != 6);

            }else if(contrasena.equals(contrasenaAdministrador)){ //Menú Administrador
                System.out.println("Bienvenido. Cuenta de administrador");
                do {
                    System.out.println("=======MENÚ========");
                    System.out.println("1. Panel de control");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Configuración");
                    System.out.println("4. Cerrar sesión");
                    menu = Integer.parseInt(s.next());

                    switch (menu) {
                        case 1:
                            System.out.println("PANEL DE CONTROL");
                            System.out.println("Listado de usuarios");
                            if (bloqueoInversor1){
                                System.out.printf("Inversor %s- Bloqueado\n", inversor1);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=false;
                                }
                            }else{
                                System.out.printf("Inversor %s - Desbloqueado\n", inversor1);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=true;
                                }
                            }
                            if (bloqueoInversor2){
                                System.out.printf("Inversor %s- Bloqueado\n", inversor2);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor2);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=false;
                                }
                            }else{
                                System.out.printf("Inversor %s- Desbloqueado\n", inversor2);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor2);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=true;
                                }
                            }
                            if (bloqueoGestor){
                                System.out.printf("Gestor %s- Bloqueado\n", gestor);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoGestor=false;
                                }
                            }else{
                                System.out.printf("Gestor %s - Desbloqueado\n", gestor);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", gestor);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoGestor=true;
                                }
                            }
                            break;

                        case 2:
                            System.out.println("MIS PROYECTOS");
                            if (proyectos == 0) {
                                System.out.println("Aún no hay proyectos");
                                System.out.println("¿Desea crear un proyecto? (s/n)");
                                String respuesta = s.next();
                                if (respuesta.equals("s")) {
                                    System.out.println("Introduzca el nombre del proyecto: ");
                                    nombreProyectoA = s.next();
                                    System.out.println("Introduzca la descripción del proyecto: ");
                                    descripcionProyectoA = s.next();
                                    System.out.println("Ingrese la categoría del proyecto: ");
                                    System.out.println("1. Arte");
                                    System.out.println("2. Tecnología");
                                    System.out.println("3. Cine");
                                    System.out.println("4. Música");
                                    System.out.println("5. Juegos");
                                    System.out.println("6. Comida");
                                    System.out.println("7. Moda");
                                    categoriaA = Integer.parseInt(s.next());
                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                    cantidadA = Integer.parseInt(s.next());
                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                    fechaAperturaA= s.next();
                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                    fechaCierreA= s.next();
                                    System.out.println("Recompensas del proyecto");
                                    System.out.println("¿Cuántas desea añadir? (max 3.)");
                                    recompensasA= Integer.parseInt(s.next());
                                    System.out.println("Nombre de la primera recompensa: ");
                                    nombreRecompensaA1= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA1= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA1= Float.parseFloat(s.next());
                                    if (recompensasA<2) break;
                                    System.out.println("=================================");
                                    System.out.println("Nombre de la segunda recompensa: ");
                                    nombreRecompensaA2= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA2= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA2= Float.parseFloat(s.next());
                                    if (recompensasA<3) break;
                                    System.out.println("=================================");
                                    System.out.println("Nombre de la tercera recompensa: ");
                                    nombreRecompensaA3= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA3= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA3= Float.parseFloat(s.next());
                                    proyectos++;
                                    break;
                                } else if (respuesta.equals("n")) {
                                    System.out.println("No hay proyectos existentes");
                                } else {
                                    System.out.println("Tiene que introducir una respuesta");
                                }
                                break;
                            } else if (proyectos>0) {
                                System.out.println("1. Crear Proyectos");
                                System.out.println("2. Consultar proyectos");
                                System.out.println("3. Modificar proyectos");
                                opcion = s.nextInt();
                                switch (opcion) {
                                    case 1:
                                        if (proyectos == 1) {
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoB = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoB = s.next();
                                            System.out.print("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaB = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadB = Integer.parseInt(s.next());
                                            System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                            fechaAperturaB= s.next();
                                            System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                            fechaCierreB= s.next();
                                            System.out.println("Recompensas del proyecto");
                                            System.out.println("¿Cuántas desea añadir? (max 3.)");
                                            recompensasB= Integer.parseInt(s.next());

                                            System.out.println("Nombre de la primera recompensa: ");
                                            nombreRecompensaB1= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB1= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB1= Float.parseFloat(s.next());
                                            if (recompensasB<2) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la segunda recompensa: ");
                                            nombreRecompensaB2= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB2= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB2= Float.parseFloat(s.next());
                                            if (recompensasB<3) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la tercera recompensa: ");
                                            nombreRecompensaB3= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB3= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB3= Float.parseFloat(s.next());
                                            proyectos++;
                                            break;

                                        } else if (proyectos == 2) {
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoC = s.next();
                                            System.out.print("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoC = s.next();
                                            System.out.println("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaC = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadC = Integer.parseInt(s.next());
                                            System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                            fechaAperturaC= s.next();
                                            System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                            fechaCierreC= s.next();
                                            System.out.println("Recompensas del proyecto");
                                            System.out.println("¿Cuántas desea añadir? (max 3.)");
                                            recompensasC= Integer.parseInt(s.next());
                                            System.out.println("Nombre de la primera recompensa: ");
                                            nombreRecompensaC1= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC1= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC1= Float.parseFloat(s.next());
                                            if (recompensasC<2) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la segunda recompensa: ");
                                            nombreRecompensaC2= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC2= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC2= Float.parseFloat(s.next());
                                            if (recompensasC<3) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la tercera recompensa: ");
                                            nombreRecompensaC3= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC3= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC3= Float.parseFloat(s.next());
                                            proyectos++;
                                            break;
                                        } else if (proyectos == 3) {
                                            System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("CONSULTA DE PROYECTOS");
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 1");
                                        System.out.println(nombreProyectoA);
                                        System.out.println("Categoría: " + categoriaA);
                                        System.out.println("Cantidad necesaria: " + cantidadA);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        if (proyectos<2) break;
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 2");
                                        System.out.println(nombreProyectoB);
                                        System.out.println("Categoría: " + categoriaB);
                                        System.out.println("Cantidad necesaria: " + cantidadB);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        if (proyectos<3) break;
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 3");
                                        System.out.println(nombreProyectoC);
                                        System.out.println("Categoría: " + categoriaC);
                                        System.out.println("Cantidad necesaria: " + cantidadC);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        System.out.println("========================================================================");
                                        System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                                        opcion= Integer.parseInt(s.next());
                                        switch (opcion){
                                            case 1:
                                                if (proyectos <=0){
                                                    System.out.println("No existe el proyecto");
                                                }else {
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
                                                    if (recompensasA==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaA2);
                                                    System.out.println(descripcionRecompensaA2);
                                                    System.out.println(precioRecompensaA2);
                                                    if (recompensasA==2) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaA3);
                                                    System.out.println(descripcionRecompensaA3);
                                                    System.out.println(precioRecompensaA3);
                                                }
                                                break;
                                            case 2:
                                                if (proyectos <2){
                                                    System.out.println("No existe el proyecto.");
                                                }else {
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
                                                    if (recompensasB==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaB2);
                                                    System.out.println(descripcionRecompensaB2);
                                                    System.out.println(precioRecompensaB2);
                                                    if (recompensasB==2) break;
                                                    System.out.println("RECOMPENSA 3");
                                                    System.out.println(nombreRecompensaB3);
                                                    System.out.println(descripcionRecompensaB3);
                                                    System.out.println(precioRecompensaB3);
                                                }
                                                break;
                                            case 3:
                                                if (proyectos <3){
                                                    System.out.println("No existe el proyecto.");
                                                }else {
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
                                                    if (recompensasB==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaC2);
                                                    System.out.println(descripcionRecompensaC2);
                                                    System.out.println(precioRecompensaC2);
                                                    if (recompensasB==2) break;
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
                                        System.out.println("MODIFICAR PROYECTOS");
                                        if (proyectos == 0) {
                                            System.out.println("No hay ningún proyecto creado aún");
                                        } else {
                                            System.out.println("¿Qué proyecto desea modificar?");
                                            System.out.println("Introduzca el número del proyecto");
                                                if (proyectos == 1) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                } else if (proyectos == 2) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                } else if (proyectos == 3) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                    System.out.println("Proyecto 3: " + nombreProyectoC);
                                                }
                                                numpro = Integer.parseInt(s.next());
                                                while (numpro != 1 && numpro != 2 && numpro != 3){
                                                    System.out.println("Debes introducir el número correspondiente");
                                                    numpro = Integer.parseInt(s.next());
                                                }
                                            switch (numpro) {
                                                case 1:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoA = s.next();
                                                    System.out.print("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoA = s.nextLine();
                                                    System.out.println("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaA = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadA = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaA= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreA= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaA1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA1= Float.parseFloat(s.next());
                                                    if (recompensasA==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaA2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA2= Float.parseFloat(s.next());
                                                    if (recompensasA==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaA3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA3= Float.parseFloat(s.next());
                                                    break;
                                                case 2:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoB = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoB = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaB = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadB = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaB= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreB= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaB1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB1= Float.parseFloat(s.next());
                                                    if (recompensasB==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaB2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB2= Float.parseFloat(s.next());
                                                    if (recompensasB==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaB3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB3= Float.parseFloat(s.next());
                                                    break;
                                                case 3:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoC = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoC = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaC = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadC = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaC= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreC= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaC1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC1= Float.parseFloat(s.next());
                                                    if (recompensasC==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaC2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC2= Float.parseFloat(s.next());
                                                    if (recompensasC==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaC3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC3= Float.parseFloat(s.next());
                                                    break;
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                        case 3:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do{
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = Integer.parseInt(s.next());
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", administrador);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        administrador = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaAdministrador);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaAdministrador = s.next();
                                        break;
                                    case 3:
                                        System.out.println("Cambios guardados.");
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                        break;
                                }
                            }while (opcion!=3);
                            break;

                        case 4:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 4)");
                            break;
                    }
                } while (menu != 4);

            }else if(contrasena.equals(contrasenaGestor)){
                System.out.println("Bienvenido. Cuenta de gestor");
                do {
                    System.out.println("1. Mis proyectos");
                    System.out.println("2. Configuración");
                    System.out.println("3. Cerrar sesión");
                    menu = Integer.parseInt(s.next());
                    switch (menu) {
                        case 1:
                            System.out.println("MIS PROYECTOS");
                            if (proyectos == 0) {
                                System.out.println("Aún no hay proyectos");
                                System.out.println("¿Desea crear un proyecto? (s/n)");
                                String respuesta = s.next();
                                if (respuesta.equals("s")) {
                                    System.out.println("Introduzca el nombre del proyecto: ");
                                    nombreProyectoA = s.next();
                                    System.out.println("Introduzca la descripción del proyecto: ");
                                    descripcionProyectoA = s.next();
                                    System.out.println("Ingrese la categoría del proyecto: ");
                                    System.out.println("1. Arte");
                                    System.out.println("2. Tecnología");
                                    System.out.println("3. Cine");
                                    System.out.println("4. Música");
                                    System.out.println("5. Juegos");
                                    System.out.println("6. Comida");
                                    System.out.println("7. Moda");
                                    categoriaA = Integer.parseInt(s.next());
                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                    cantidadA = Integer.parseInt(s.next());
                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                    fechaAperturaA= s.next();
                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                    fechaCierreA= s.next();
                                    System.out.println("Recompensas del proyecto");
                                    System.out.println("¿Cuántas desea añadir? (max 3.)");
                                    recompensasA= Integer.parseInt(s.next());
                                    System.out.println("Nombre de la primera recompensa: ");
                                    nombreRecompensaA1= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA1= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA1= Float.parseFloat(s.next());
                                    if (recompensasA<2) break;
                                    System.out.println("=================================");
                                    System.out.println("Nombre de la segunda recompensa: ");
                                    nombreRecompensaA2= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA2= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA2= Float.parseFloat(s.next());
                                    if (recompensasA<3) break;
                                    System.out.println("=================================");
                                    System.out.println("Nombre de la tercera recompensa: ");
                                    nombreRecompensaA3= s.next();
                                    System.out.println("Introduzca una descripción");
                                    descripcionRecompensaA3= s.next();
                                    System.out.println("Introduzca el precio: ");
                                    precioRecompensaA3= Float.parseFloat(s.next());
                                    proyectos++;
                                    break;
                                } else if (respuesta.equals("n")) {
                                    System.out.println("No hay proyectos existentes");
                                } else {
                                    System.out.println("Tiene que introducir una respuesta");
                                }
                                break;
                            } else if (proyectos>0) {
                                System.out.println("1. Crear Proyectos");
                                System.out.println("2. Consultar proyectos");
                                System.out.println("3. Modificar proyectos");
                                opcion = s.nextInt();
                                switch (opcion) {
                                    case 1:
                                        if (proyectos == 1) {
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoB = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoB = s.next();
                                            System.out.print("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaB = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadB = Integer.parseInt(s.next());
                                            System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                            fechaAperturaB= s.next();
                                            System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                            fechaCierreB= s.next();
                                            System.out.println("Recompensas del proyecto");
                                            System.out.println("¿Cuántas desea añadir? (max 3.)");
                                            recompensasB= Integer.parseInt(s.next());
                                            System.out.println("Nombre de la primera recompensa: ");
                                            nombreRecompensaB1= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB1= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB1= Float.parseFloat(s.next());
                                            if (recompensasB<2) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la segunda recompensa: ");
                                            nombreRecompensaB2= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB2= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB2= Float.parseFloat(s.next());
                                            if (recompensasB<3) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la tercera recompensa: ");
                                            nombreRecompensaB3= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaB3= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaB3= Float.parseFloat(s.next());
                                            proyectos++;
                                            break;

                                        } else if (proyectos == 2) {
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoC = s.next();
                                            System.out.print("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoC = s.next();
                                            System.out.println("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaC = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadC = Integer.parseInt(s.next());
                                            System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                            fechaAperturaC= s.next();
                                            System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                            fechaCierreC= s.next();
                                            System.out.println("Recompensas del proyecto");
                                            System.out.println("¿Cuántas desea añadir? (max 3.)");
                                            recompensasC= Integer.parseInt(s.next());
                                            System.out.println("Nombre de la primera recompensa: ");
                                            nombreRecompensaC1= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC1= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC1= Float.parseFloat(s.next());
                                            if (recompensasC<2) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la segunda recompensa: ");
                                            nombreRecompensaC2= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC2= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC2= Float.parseFloat(s.next());
                                            if (recompensasC<3) break;
                                            System.out.println("=================================");
                                            System.out.println("Nombre de la tercera recompensa: ");
                                            nombreRecompensaC3= s.next();
                                            System.out.println("Introduzca una descripción");
                                            descripcionRecompensaC3= s.next();
                                            System.out.println("Introduzca el precio: ");
                                            precioRecompensaC3= Float.parseFloat(s.next());
                                            proyectos++;
                                            break;
                                        } else if (proyectos == 3) {
                                            System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                        }
                                        break;

                                    case 2:
                                        System.out.println("CONSULTA DE PROYECTOS");
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 1");
                                        System.out.println(nombreProyectoA);
                                        System.out.println("Categoría: " + categoriaA);
                                        System.out.println("Cantidad necesaria: " + cantidadA);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        if (proyectos<2) break;
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 2");
                                        System.out.println(nombreProyectoB);
                                        System.out.println("Categoría: " + categoriaB);
                                        System.out.println("Cantidad necesaria: " + cantidadB);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        if (proyectos<3) break;
                                        System.out.println("=================================================");
                                        System.out.println("PROYECTO 3");
                                        System.out.println(nombreProyectoC);
                                        System.out.println("Categoría: " + categoriaC);
                                        System.out.println("Cantidad necesaria: " + cantidadC);
                                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                        System.out.println("Cantidad financiada hasta el momento: ");
                                        System.out.println("========================================================================");
                                        System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                                        opcion= Integer.parseInt(s.next());
                                        switch (opcion){
                                            case 1:
                                                if (proyectos <=0){
                                                    System.out.println("No existe el proyecto");
                                                }else {
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
                                                    if (recompensasA==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaA2);
                                                    System.out.println(descripcionRecompensaA2);
                                                    System.out.println(precioRecompensaA2);
                                                    if (recompensasA==2) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaA3);
                                                    System.out.println(descripcionRecompensaA3);
                                                    System.out.println(precioRecompensaA3);
                                                }
                                                break;
                                            case 2:
                                                if (proyectos <2){
                                                    System.out.println("No existe el proyecto.");
                                                }else {
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
                                                    if (recompensasB==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaB2);
                                                    System.out.println(descripcionRecompensaB2);
                                                    System.out.println(precioRecompensaB2);
                                                    if (recompensasB==2) break;
                                                    System.out.println("RECOMPENSA 3");
                                                    System.out.println(nombreRecompensaB3);
                                                    System.out.println(descripcionRecompensaB3);
                                                    System.out.println(precioRecompensaB3);
                                                }
                                                break;
                                            case 3:
                                                if (proyectos <3){
                                                    System.out.println("No existe el proyecto.");
                                                }else {
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
                                                    if (recompensasB==1) break;
                                                    System.out.println("RECOMPENSA 2");
                                                    System.out.println(nombreRecompensaC2);
                                                    System.out.println(descripcionRecompensaC2);
                                                    System.out.println(precioRecompensaC2);
                                                    if (recompensasB==2) break;
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
                                        System.out.println("MODIFICAR PROYECTOS");
                                        if (proyectos == 0) {
                                            System.out.println("No hay ningún proyecto creado aún");
                                        } else {
                                            System.out.println("¿Qué proyecto desea modicicar?");
                                            System.out.println("Introduzca el número del proyecto");
                                                if (proyectos == 1) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                } else if (proyectos == 2) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                } else if (proyectos == 3) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                    System.out.println("Proyecto 3: " + nombreProyectoC);
                                                }
                                                numpro = Integer.parseInt(s.next());
                                                while (numpro != 1 && numpro != 2 && numpro != 3){
                                                    System.out.println("Debes introducir el número correspondiente");
                                                    numpro = Integer.parseInt(s.next());
                                                }
                                            switch (numpro) {
                                                case 1:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoA = s.next();
                                                    System.out.print("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoA = s.nextLine();
                                                    System.out.println("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaA = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadA = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaA= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreA= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaA1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA1= Float.parseFloat(s.next());
                                                    if (recompensasA==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaA2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA2= Float.parseFloat(s.next());
                                                    if (recompensasA==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaA3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaA3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaA3= Float.parseFloat(s.next());
                                                    break;
                                                case 2:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoB = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoB = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaB = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadB = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaB= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreB= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaB1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB1= Float.parseFloat(s.next());
                                                    if (recompensasB==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaB2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB2= Float.parseFloat(s.next());
                                                    if (recompensasB==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaB3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaB3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaB3= Float.parseFloat(s.next());
                                                    break;
                                                case 3:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoC = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoC = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaC = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadC = Integer.parseInt(s.next());
                                                    System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                                    fechaAperturaC= s.next();
                                                    System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                                    fechaCierreC= s.next();
                                                    System.out.println("Recompensas del proyecto.");
                                                    System.out.println("Nombre de la primera recompensa: ");
                                                    nombreRecompensaC1= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC1= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC1= Float.parseFloat(s.next());
                                                    if (recompensasC==1) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la segunda recompensa: ");
                                                    nombreRecompensaC2= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC2= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC2= Float.parseFloat(s.next());
                                                    if (recompensasC==2) break;
                                                    System.out.println("================================");
                                                    System.out.println("Nombre de la tercera recompensa: ");
                                                    nombreRecompensaC3= s.next();
                                                    System.out.println("Introduzca una descripción");
                                                    descripcionRecompensaC3= s.next();
                                                    System.out.println("Introduzca el precio: ");
                                                    precioRecompensaC3= Float.parseFloat(s.next());
                                                    break;
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                        case 2:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do {
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = Integer.parseInt(s.next());
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", gestor);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        gestor = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaGestor);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaGestor = s.next();
                                        break;
                                    case 3:
                                        System.out.println("Cambios guardados");
                                        break;
                                    default:
                                        System.out.println("Por favor, introduzca una opción válida.");
                                        break;
                                }
                            }while (opcion!=3);
                            break;

                        case 3:
                            System.out.println("Saliendo. Se le está redirigiendo al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduce una opcion válida (1 - 3)");
                            break;
                    }
                } while (menu!=3);
            }
        }while(sesion);
    }
}