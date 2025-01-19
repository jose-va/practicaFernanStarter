import java.util.Scanner;
import static utilidades.Funciones.*;
import static utilidades.FuncionesCadenas.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] administrador= {"jose"} ;
        String[] contrasenaAdministrador={"1234jose"};
        String[] gestor= {""};
        String[] contrasenaGestor= {""};
        String[] correoGestor={""};
        String[] inversor={"",""};
        String[] contrasenaInversor={"", ""};
        String[] correoInversor={"",""};
        String amigo="",contrasena="", correo="";

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
        int aportacionI1, aportacionI2;

        boolean[] inversion1={false,false,false};
        boolean[] inversion2={false,false,false};

        int intentos=2, opcion, numpro=0, menu; //Intentos queda a 2, así los usuarios tendran hasta 3 oportunidades para entrar al sistema (hasta 0)
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false, sesion=true;

        do {
            do{
                System.out.println("============Bienvenido============");
                System.out.println("1. Iniciar sesión en su cuenta");
                System.out.println("2. Registrarse");
                System.out.println("==================================");
                opcion = Integer.parseInt(s.nextLine());
                if (opcion == 2) registroUsuarios(inversor,contrasenaInversor, gestor, contrasenaGestor);
            }while (opcion!=1);

            System.out.println("==================================");
            System.out.println("Introduzca su nombre de usuario: ");
            System.out.println("==================================");
            System.out.println("(* para salir)");
            String usuario = s.next().toLowerCase();
            if (usuario.equals("*")) return;


            if (compararUsuario(usuario, administrador[0])){
                System.out.println("Administrador. Introduzca su contraseña: ");
                contrasena = s.next();
                while (!compararContrasena(contrasena, contrasenaAdministrador[0])) {
                    System.out.println("Contraseña incorrecta.");
                    System.out.println("Por favor, introduzca su contraseña: ");
                    contrasena = s.next();
                }
            }

            if (compararUsuario(usuario, gestor[0])) {
                if (bloqueoGestor) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                intentos=2;
                while (!compararContrasena(contrasena, contrasenaGestor[0]) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }

                if (intentos == 0) {
                    bloqueoGestor = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (compararUsuario(usuario, inversor[0])){
                if (bloqueoInversor1) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }

                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                intentos=2;
                while (!compararContrasena(contrasena, contrasenaInversor[0]) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }

                if (intentos == 0) {
                    bloqueoInversor1 = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (compararUsuario(usuario, inversor[1])){
                if (bloqueoInversor2) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                intentos=2;
                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                while (!compararContrasena(contrasena, contrasenaInversor[1]) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }

                if (intentos == 0) {
                    bloqueoInversor2 = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }

            if (compararContrasena(contrasena,contrasenaInversor[0])){ //Menú inversor1----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    System.out.println("========MENÚ========");
                    System.out.println("1. Mis inversiones");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Cartera digital");
                    System.out.println("4. Invita a un amigo");
                    System.out.println("5. Configuración");
                    System.out.println("6. Cerrar sesión");
                    menu = Integer.parseInt(s.next());

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
                                        MenuProyectoInversion(nombreProyecto);
                                        aportacionI1 = Integer.parseInt(s.next());
                                        switch (aportacionI1) {
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
                                            System.out.println("Actualmente, no ha realizado ninguna inversión");
                                            System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                            String respuesta2 = s.next();
                                            while (!respuesta2.equals("s")) {
                                                if (respuesta2.equals("n")) {
                                                    break;
                                                }
                                                System.out.println("Introduce una opcion valida (s/n)");
                                                System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                                respuesta2 = s.next();
                                            }
                                            if (respuesta2.equals("s")) {
                                                int opcion3 = 0;
                                                while (opcion3 != 1 || opcion3 != 2 || opcion3 != 3) {
                                                    MenuProyectoInversion(nombreProyecto);
                                                    aportacionI1 = Integer.parseInt(s.next());
                                                    switch (aportacionI1) {
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
                            config1(opcion=0, inversor[0], contrasenaInversor[0]);
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

            }if (contrasena.equals(contrasenaInversor[1])) { //Menú inversor2-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    System.out.println("========MENÚ========");
                    System.out.println("1. Mis inversiones");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Cartera digital");
                    System.out.println("4. Invita a un amigo");
                    System.out.println("5. Configuración");
                    System.out.println("6. Cerrar sesión");
                    menu = Integer.parseInt(s.next());

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
                                        MenuProyectoInversion(nombreProyecto);
                                        aportacionI2 = Integer.parseInt(s.next());
                                        switch (aportacionI2) {
                                            case 1:
                                                crearInversionA2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
                                            case 2:
                                                crearInversionB2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
                                            case 3:
                                                crearInversionC2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
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
                                            System.out.println("Actualmente, no ha realizado ninguna inversión");
                                            System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                            String respuesta2 = s.next();
                                            while (!respuesta2.equals("s")) {
                                                if (respuesta2.equals("n")) {
                                                    return;
                                                }
                                                System.out.println("Introduce una opcion valida (s/n)");
                                                System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                                respuesta2 = s.next();
                                            }
                                            if (respuesta2.equals("s")) {
                                                int opcion3 = 0;
                                                while (opcion3 != 1 || opcion3 != 2 || opcion3 != 3) {
                                                    MenuProyectoInversion(nombreProyecto);
                                                    aportacionI2 = Integer.parseInt(s.next());
                                                    switch (aportacionI2) {
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
                            config2(opcion=0, inversor[1], contrasenaInversor[1]);
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
            }else if(contrasena.equals(contrasenaAdministrador[0])){ //Menú Administrador
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
                                System.out.printf("Inversor %s- Bloqueado\n", inversor[0]);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor[0]);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=false;
                                }
                            }else{
                                System.out.printf("Inversor %s - Desbloqueado\n", inversor[0]);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor[0]);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=true;
                                }
                            }
                            if (bloqueoInversor2){
                                System.out.printf("Inversor %s- Bloqueado\n", inversor[1]);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor[1]);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=false;
                                }
                            }else{
                                System.out.printf("Inversor %s- Desbloqueado\n", inversor[1]);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor[1]);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=true;
                                }
                            }
                            if (bloqueoGestor){
                                System.out.printf("Gestor %s- Bloqueado\n", gestor[0]);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor[0]);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoGestor=false;
                                }
                            }else{
                                System.out.printf("Gestor %s - Desbloqueado\n",gestor[0]);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", gestor[0]);
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
                                        System.out.printf("Usuario actual -> %s\n", administrador[0]);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        administrador[0] = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaAdministrador[0]);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaAdministrador[0] = s.next();
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

            }else if(contrasena.equals(contrasenaGestor[0])){
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
                                        System.out.printf("Usuario actual -> %s\n", gestor[0]);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        gestor[0] = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaGestor[0]);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaGestor[0] = s.next();
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
