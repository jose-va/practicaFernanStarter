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
            correo= s.nextLine();
            autentificacion(correo);

            if (contrasena.equals(contrasenaInversor1)) { //Menú inversor1----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
                                        System.out.println("¿En qué proyecto desea invertir?");
                                        System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
                                        System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
                                        System.out.println("3. Proyecto 3 " + nombreProyecto[2]);
                                        System.out.println("4. Salir");
                                        aportacionI1 = Integer.parseInt(s.next());
                                        switch (aportacionI1) {
                                            case 1:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada1[0] = Integer.parseInt(s.next());
                                                if (cantidadAportada1[0] > saldoTotal1) {
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                    break;
                                                } else {
                                                    inversion1[0] = true;
                                                    saldoTotal1 -= cantidadAportada1[0];
                                                    cantidadAportada[0] += cantidadAportada1[0];
                                                    inversiones1++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
                                            case 2:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada1[1] = Integer.parseInt(s.next());
                                                if (cantidadAportada1[1] > saldoTotal1) {
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                    break;
                                                } else {
                                                    inversion1[1] = true;
                                                    saldoTotal1 -= cantidadAportada1[0];
                                                    cantidadAportada[1] += cantidadAportada1[1];
                                                    inversiones1++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
                                            case 3:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada1[2] = Integer.parseInt(s.next());
                                                if (cantidadAportada1[2] > saldoTotal1) {
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                    break;
                                                } else {
                                                    inversion1[2] = true;
                                                    saldoTotal1 -= cantidadAportada1[2];
                                                    cantidadAportada[2] += cantidadAportada1[2];
                                                    inversiones1++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
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
                                                    System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                                                    System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
                                                    System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto[2]);
                                                    System.out.println("4. Salir");
                                                    aportacionI1 = Integer.parseInt(s.next());
                                                    switch (aportacionI1) {
                                                        case 1:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada1[0] = Integer.parseInt(s.next());
                                                            if (cantidadAportada1[0] > saldoTotal1) {
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                                break;
                                                            } else {
                                                                inversion1[0] = true;
                                                                saldoTotal1 -= cantidadAportada1[0];
                                                                cantidadAportada[0] += cantidadAportada1[0];
                                                                inversiones1++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
                                                        case 2:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada1[0] = Integer.parseInt(s.next());
                                                            if (cantidadAportada1[0] > saldoTotal1) {
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                                break;
                                                            } else {
                                                                inversion1[1] = true;
                                                                saldoTotal1 -= cantidadAportada1[0];
                                                                cantidadAportada[1] += cantidadAportada1[0];
                                                                inversiones1++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
                                                        case 3:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada1[2] = Integer.parseInt(s.next());
                                                            if (cantidadAportada1[2] > saldoTotal1) {
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: " + saldoTotal1 + "€");
                                                                break;
                                                            } else {
                                                                inversion1[2] = true;
                                                                saldoTotal1 -= cantidadAportada1[2];
                                                                cantidadAportada[2] += cantidadAportada1[2];
                                                                inversiones1++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
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
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion1[1]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion1[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                            }
                                            if (inversiones1 == 2) {
                                                System.out.println("¿Que inversión desea consultar?");
                                                if (inversion1[0] && inversion1[1]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion1[0] && inversion1[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion1[1] && inversion1[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                            }
                                            if (inversiones1 == 3) {
                                                System.out.println("Lista de todas sus inversiones: ");
                                                System.out.println();
                                                System.out.println(nombreProyecto[0]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[0]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[0]+ "€");
                                                System.out.println();
                                                System.out.println("******************************");
                                                System.out.println();
                                                System.out.println(nombreProyecto[1]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[1]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[1]+ "€");
                                                System.out.println();
                                                System.out.println("******************************");
                                                System.out.println();
                                                System.out.println(nombreProyecto[2]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[2]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[2]+ "€");
                                                System.out.println();
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
                                        break;
                                    case 3:
                                        System.out.println("Usted ha seleccionado salir.");
                                        break;
                                    default:
                                        System.out.println("Opcion seleccionada inválida.");
                                        break;
                                }
                            } while (opcion != 3);

                            break;
                        case 4:
                            System.out.println("INVITAR A UN AMIGO");
                            do {
                                System.out.println("1. Listado de amigos");
                                System.out.println("2. Añadir a un amigo");
                                System.out.println("3. Salir");
                                opcion = Integer.parseInt(s.next());
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
                            break;
                        case 5:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do {
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = Integer.parseInt(s.next());
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", inversor1);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        inversor1 = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaInversor1);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaInversor1 = s.next();
                                        break;
                                }
                            } while (opcion != 3);
                            System.out.println("Los cambios se han guardado correctamente");
                            System.out.println("Redirigiendo al menú principal");
                            break;
                        case 6:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                            break;
                    }
                } while (menu != 6);

            }if (contrasena.equals(contrasenaInversor2)) { //Menú inversor2-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
                                        System.out.println("¿En qué proyecto desea invertir?");
                                        System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
                                        System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
                                        System.out.println("3. Proyecto 3 " + nombreProyecto[2]);
                                        System.out.println("4. Salir");
                                        aportacionI2 = Integer.parseInt(s.next());
                                        switch (aportacionI2) {
                                            case 1:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada2[0] = Integer.parseInt(s.next());
                                                if (cantidadAportada2[0]>saldoTotal1){
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: "+saldoTotal2 + "€");
                                                    break;
                                                }else{
                                                    inversion2[0] = true;
                                                    saldoTotal2-=cantidadAportada2[0];
                                                    cantidadAportada[0]+=cantidadAportada2[0];
                                                    inversiones2++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
                                            case 2:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada2[1] = Integer.parseInt(s.next());
                                                if (cantidadAportada2[1]>saldoTotal2){
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: "+saldoTotal2 + "€");
                                                    break;
                                                }else{
                                                    inversion2[1] = true;
                                                    saldoTotal2-=cantidadAportada2[1];
                                                    cantidadAportada[1]+=cantidadAportada2[1];
                                                    inversiones2++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
                                            case 3:
                                                System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportada2[2] = Integer.parseInt(s.next());
                                                if (cantidadAportada2[2]>saldoTotal2){
                                                    System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                    System.out.println("Su saldo es de: "+saldoTotal2 + "€");
                                                    break;
                                                }else{
                                                    inversion2[2] = true;
                                                    saldoTotal2-=cantidadAportada2[2];
                                                    cantidadAportada[2]+=cantidadAportada2[2];
                                                    inversiones2++;
                                                    System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                    break;
                                                }
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
                                                    System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                                                    System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
                                                    System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
                                                    System.out.println("3. Proyecto 3 " + nombreProyecto[2]);
                                                    System.out.println("4. Salir");
                                                    aportacionI2 = Integer.parseInt(s.next());
                                                    switch (aportacionI2) {
                                                        case 1:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada2[0] = Integer.parseInt(s.next());
                                                            if (cantidadAportada2[0]>saldoTotal2){
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: "+saldoTotal2 + "€");
                                                                break;
                                                            }else{
                                                                inversion2[0] = true;
                                                                saldoTotal2-=cantidadAportada2[0];
                                                                cantidadAportada[0]+=cantidadAportada2[0];
                                                                inversiones2++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
                                                        case 2:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada2[1] = Integer.parseInt(s.next());
                                                            if (cantidadAportada2[1]>saldoTotal2){
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: "+saldoTotal2 + "€");
                                                                break;
                                                            }else{
                                                                inversion2[1] = true;
                                                                saldoTotal2-=cantidadAportada2[1];
                                                                cantidadAportada[1]+=cantidadAportada2[1];
                                                                inversiones2++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
                                                        case 3:
                                                            System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2]);
                                                            System.out.println("¿Que cantidad desea aportar?");
                                                            cantidadAportada2[2] = Integer.parseInt(s.next());
                                                            if (cantidadAportada2[2]>saldoTotal2){
                                                                System.out.println("No dispone de saldo suficiente para realizar la aportación.");
                                                                System.out.println("Su saldo es de: "+saldoTotal2);
                                                                break;
                                                            }else{
                                                                inversion2[2] = true;
                                                                saldoTotal2-=cantidadAportada2[2];
                                                                cantidadAportada[2]+=cantidadAportada2[2];
                                                                inversiones2++;
                                                                System.out.println("¡¡¡Gracias por aportar su parte!!!");
                                                                break;
                                                            }
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
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion2[1]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion2[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                            }
                                            if (inversiones2 == 2) {
                                                System.out.println("¿Que inversión desea consultar?");
                                                if (inversion2[0] && inversion2[1]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion2[0] && inversion2[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[0]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[0]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[0]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                                if (inversion2[1] && inversion2[2]) {
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[1]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[1]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[1]+ "€");
                                                    System.out.println();
                                                    System.out.println("******************************");
                                                    System.out.println();
                                                    System.out.println(nombreProyecto[2]);
                                                    System.out.print("Categoría: ");
                                                    System.out.println(categoria[2]);
                                                    System.out.print("Cantidad aportada: ");
                                                    System.out.println(cantidadAportada[2]+ "€");
                                                    System.out.println();
                                                }
                                            }
                                            if (inversiones2 == 3) {
                                                System.out.println("Lista de todas sus inversiones: ");
                                                System.out.println();
                                                System.out.println(nombreProyecto[0]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[0]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[0]+ "€");
                                                System.out.println();
                                                System.out.println("******************************");
                                                System.out.println();
                                                System.out.println(nombreProyecto[1]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[1]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[1]+ "€");
                                                System.out.println();
                                                System.out.println("******************************");
                                                System.out.println();
                                                System.out.println(nombreProyecto[2]);
                                                System.out.print("Categoría: ");
                                                System.out.println(categoria[2]);
                                                System.out.print("Cantidad aportada: ");
                                                System.out.println(cantidadAportada[2]+ "€");
                                                System.out.println();
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
                                        break;
                                    case 3:
                                        System.out.println("Usted ha seleccionado salir.");
                                        break;
                                    default:
                                        System.out.println("Opcion seleccionada inválida.");
                                        break;
                                }
                            } while (opcion != 3);

                            break;
                        case 4:
                            System.out.println("INVITAR A UN AMIGO");
                            do {
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
                            System.out.println("Los cambios se han guardado correctamente");
                            System.out.println("Redirigiendo al menú principal");
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