import java.util.Scanner;
import static utilidades.Funciones.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "toranzo", contrasenaInversor2="1234toranzo";
        String amigo="",contrasena="", correo;

        String [] nombreProyecto={"","",""};
        String [] descripcionProyecto= {"","",""};
        String [] fechaApertura={"","",""};
        String [] fechaCierre={"","",""};

        String []nombreRecompensaA={"","",""};
        String []nombreRecompensaB={"","",""};
        String []nombreRecompensaC={"","",""};
        String []categoria={"","",""};

        String []descripcionRecompensaA={"","",""};
        String []descripcionRecompensaB={"","",""};
        String []descripcionRecompensaC={"","",""};

        String respuesta=" ";

        float []precioRecompensaA={0,0,0};
        float []precioRecompensaB={0,0,0};
        float []precioRecompensaC={0,0,0};

        int proyectos = 0;
        int []recompensas={0,0,0};
        int []cantidadAportada={0,0,0};
        int []cantidad={0,0,0};
        int []cantidadAportada1={0,0,0};
        int []cantidadAportada2={0,0,0};
        int saldo = 0, saldoTotal1 = 0, saldoTotal2 = 0, inversiones1 = 0, inversiones2 = 0;
        int seleccionInversor=0;

        boolean[] inversion1={false,false,false};
        boolean[] inversion2={false,false,false};

        int intentos=2, opcion = 0, numpro=0, menu = 0; //Intentos queda a 2, así los usuarios tendran hasta 3 oportunidades para entrar al sistema (hasta 0)
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false, sesion=true;

        do {
            System.out.println("============Bienvenido============");
            System.out.println("Introduzca su nombre de usuario: ");
            System.out.println("==================================");
            System.out.println("(* para salir)");
            String usuario = s.next().toLowerCase();
            if (usuario.equals("*")) return;

            while (!usuario.equals(administrador) && !usuario.equals(gestor)
                    && !usuario.equals(inversor1) && !usuario.equals(inversor2)) {
                System.out.println("El usuario no existe.");
                System.out.println("Por favor, introduzca un nombre de usuario válido: ");
                usuario = s.next().toLowerCase();
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
                intentos=2;
                while (!contrasena.equals(contrasenaGestor) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
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
                intentos=2;
                while (!contrasena.equals(contrasenaInversor1) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
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
                intentos=2;
                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                while (!contrasena.equals(contrasenaInversor2) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }

                if (intentos == 0) {
                    bloqueoInversor2 = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            System.out.printf("%s, verificación necesaria.\n", usuario);
            System.out.println("Introduzca su correo electrónico para recibir un código de un solo uso: ");
            s.nextLine();
            correo= s.nextLine();
            autentificacion(correo);

            if (contrasena.equals(contrasenaInversor1)) { //Menú inversor1----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    menuInversor(menu);
                    switch (menu) {
                        case 1:
                            menuMisInversiones(opcion);
                                switch (opcion) {
                                    case 1:
                                        MenuProyectoInversion(nombreProyecto, seleccionInversor);
                                        switch (seleccionInversor) {
                                            case 1:
                                                crearInversionA1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                            case 2:
                                                crearInversionB1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                            case 3:
                                                crearInversionC1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                            case 4:
                                                System.out.println("Salir.");
                                                break;
                                            default:
                                                System.out.println("Debe de introducir la opción correspondiente correcta");
                                                break;
                                        }
                                        break;
                                    case 2:
                                        if (inversiones1 == 0) {
                                            do {
                                                System.out.println("Actualmente, no ha realizado ninguna inversión");
                                                System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                                respuesta = s.next();
                                                if (!respuesta.equals("s") || !respuesta.equals("n")) {
                                                    System.out.println("Introduzca una respuesta válida");
                                                }
                                            } while (!respuesta.equals("s") || !respuesta.equals("n"));
                                            if (respuesta.equals("s")) {
                                                    MenuProyectoInversion(nombreProyecto, seleccionInversor);
                                                    switch (seleccionInversor) {
                                                        case 1:
                                                            crearInversionA1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                            break;
                                                        case 2:
                                                            crearInversionB1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                            break;
                                                        case 3:
                                                            crearInversionC1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                            break;
                                                        case 4:
                                                            System.out.println("Salir.");
                                                            break;
                                                        default:
                                                            System.out.println("Debe de introducir la opción correspondiente correcta");
                                                            break;
                                                }
                                                break;
                                            }
                                        } else if (inversiones1 > 0) {
                                            System.out.println("*****Consulta de inversiones*****");
                                            if (inversiones1 == 1) {
                                                if (inversion1[0]) {
                                                    inversionA1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion1[1]) {
                                                    inversionB1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion1[2]) {
                                                    inversionC1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                            }
                                            if (inversiones1 == 2) {
                                                System.out.println("¿Que inversión desea consultar?");
                                                if (inversion1[0] && inversion1[1]) {
                                                    inversionA1(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionB1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion1[0] && inversion1[2]) {
                                                    inversionA1(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionC1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion1[1] && inversion1[2]) {
                                                    inversionB1(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionC1(nombreProyecto, categoria, cantidadAportada);
                                                }
                                            }
                                            if (inversiones1 == 3) {
                                                inversionA1(nombreProyecto, categoria, cantidadAportada);
                                                System.out.println("******************************");
                                                inversionB1(nombreProyecto, categoria, cantidadAportada);
                                                System.out.println("******************************");
                                                inversionC1(nombreProyecto, categoria, cantidadAportada);
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Salir. Redirigiendo al menú del inversor.");
                                        break;
                                }
                            break;
                        case 2:
                            consultaProyectos(proyectos, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                            break;
                        case 3:
                            cartera1(opcion =0, saldoTotal1, saldo);
                            break;
                        case 4:
                            anadeamigo1(opcion=0, amigo, correo);
                            break;
                        case 5:
                            config1(opcion=0, inversor1, contrasenaInversor1);
                            break;
                        case 6:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                            break;
                    }
                } while (menu<1 || menu>6);
                break;
            } else if (contrasena.equals(contrasenaInversor2)) { //Menú inversor2-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    menuInversor(menu);
                    switch (menu) {
                        case 1:
                            menuMisInversiones(opcion);
                                switch (opcion) {
                                    case 1:
                                        MenuProyectoInversion(nombreProyecto, seleccionInversor);
                                        switch (seleccionInversor) {
                                            case 1:
                                                crearInversionA2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
                                                break;
                                            case 2:
                                                crearInversionB2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
                                                break;
                                            case 3:
                                                crearInversionC2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
                                                break;
                                            case 4:
                                                System.out.println("Salir.");
                                                break;
                                            default:
                                                System.out.println("Debe de introducir la opción correspondiente correcta");
                                                break;
                                        }
                                        break;
                                    case 2:
                                        if (inversiones2 == 0) {
                                            do {
                                                System.out.println("Actualmente, no ha realizado ninguna inversión");
                                                System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                                respuesta = s.next();
                                                if (!respuesta.equals("s") || !respuesta.equals("n")) {
                                                    System.out.println("Introduzca una respuesta válida");
                                                }
                                            } while (!respuesta.equals("s") || !respuesta.equals("n"));
                                            if (respuesta.equals("s")) {
                                                MenuProyectoInversion(nombreProyecto, seleccionInversor);
                                                switch (seleccionInversor) {
                                                    case 1:
                                                        crearInversionA1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                        break;
                                                    case 2:
                                                        crearInversionB1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                        break;
                                                    case 3:
                                                        crearInversionC1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
                                                        break;
                                                    case 4:
                                                        System.out.println("Salir.");
                                                        break;
                                                    default:
                                                        System.out.println("Debe de introducir la opción correspondiente correcta");
                                                        break;
                                                }
                                            }
                                        } else if (inversiones2 > 0) {
                                            System.out.println("*****Consulta de inversiones*****");
                                            if (inversiones2 == 1) {
                                                if (inversion2[0]) {
                                                    inversionA2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion2[1]) {
                                                    inversionB2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion2[2]) {
                                                    inversionC2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                            }
                                            if (inversiones2 == 2) {
                                                System.out.println("¿Que inversión desea consultar?");
                                                if (inversion2[0] && inversion2[1]) {
                                                    inversionA2(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionB2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion2[0] && inversion2[2]) {
                                                    inversionA2(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionC2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                                if (inversion2[1] && inversion2[2]) {
                                                    inversionB2(nombreProyecto, categoria, cantidadAportada);
                                                    System.out.println("******************************");
                                                    inversionC2(nombreProyecto, categoria, cantidadAportada);
                                                }
                                            }
                                            if (inversiones2 == 3) {
                                                inversionA2(nombreProyecto, categoria, cantidadAportada);
                                                System.out.println("******************************");
                                                inversionB2(nombreProyecto, categoria, cantidadAportada);
                                                System.out.println("******************************");
                                                inversionC2(nombreProyecto, categoria, cantidadAportada);
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Salir. Redirigiendo al menú del inversor.");
                                        break;
                                }
                            break;
                        case 2:
                            consultaProyectos(proyectos, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                            break;
                        case 3:
                            cartera2(opcion=0, saldoTotal1, saldo);
                            break;
                        case 4:

                            anadeamigo2(opcion=0, amigo, correo);
                            break;
                        case 5:
                            config2(opcion=0, inversor2, contrasenaInversor2);
                            break;
                        case 6:
                            System.out.println("Salir. Usted volverá al login.");
                            break;
                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                            break;
                    }
                } while (menu != 6);
                break;
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
                           misProyectos(proyectos, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                   nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                   nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                           break;
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
                            misProyectos(proyectos, nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                            break;
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