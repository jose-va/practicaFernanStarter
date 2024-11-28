import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "toranzo", contrasenaInversor2="1234toranzo";

        String nombreProyectoA = "", nombreProyectoB = "", nombreProyectoC="";
        String descripcionProyectoA = "", descripcionProyectoB = "", descripcionProyectoC;
        int categoriaA=0, categoriaB=0, categoriaC=0;
        int cantidadA=0, cantidadB=0, cantidadC=0;
        int proyectos=0, saldo=0, saldoTotal=0, amigos=0;
        int inversiones=0;

        int intentos=3, menu, opcion;
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false,sesion=true;

        do {
            System.out.println("************Bienvenido*********");
            System.out.println("Introduzca su nombre de usuario: ");
            String usuario = s.nextLine().toLowerCase();

            while (!usuario.equals(administrador) && !usuario.equals(gestor)
                    && !usuario.equals(inversor1) && !usuario.equals(inversor2)) {
                System.out.println("El usuario no existe.");
                System.out.println("Por favor, introduzca un nombre de usuario válido: ");
                usuario = s.nextLine();
            }

            String contrasena="";
            switch (usuario) {
                case "jose":
                    System.out.println("Administrador. Introduzca su contraseña: ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaAdministrador)) {
                        System.out.println("Contraseña incorrecta.");
                        System.out.println("Por favor, introduzca su contraseña: ");
                        contrasena = s.nextLine();
                    }
                    break;

                case "pablo":
                    if (bloqueoGestor) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaGestor) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoGestor = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;

                case "eladio":
                    if (bloqueoInversor1) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaInversor1) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoInversor1 = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;

                case "toranzo":
                    if (bloqueoInversor2) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaInversor2) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoInversor2 = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;
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
                            System.out.println("MIS INVERSIONES");
                            if (inversiones==0){
                                System.out.println("Actualmente, no ha realizado ninguna inversión");
                                System.out.println("¿Desea invertir en algún proyecto?");
                            }




                            break;
                        case 2:
                            System.out.println("PROYECTOS");
                            if (proyectos==0){
                                System.out.println("No existen proyectos. El gestor debe de crear uno.");
                                break;
                            }else if(proyectos==1){

                            }
                            break;
                        case 3:
                            System.out.println("CARTERA DIGITAL");
                            do{
                                System.out.println("1. Saldo actual");
                                System.out.println("2. Añadir saldo");
                                System.out.println("3. Salir");
                                opcion=s.nextInt();
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
                                        if (amigos==0){
                                            System.out.println("Usted no ha añadido a ningún amigo");
                                            break;
                                        }else{

                                        }
                                    case 2:
                                        System.out.println("Introduzca el nombre del amigo: ");

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
                                        usuario = s.nextLine();
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
                    menu = s.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println("PANEL DE CONTROL");
                            System.out.println("Listado de usuarios: ");
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
                            System.out.println("PROYECTOS");
                            System.out.println("1. Crear Proyectos");
                            System.out.println("2. Consultar proyectos");
                            System.out.println("3. Modificar proyectos");
                            opcion = s.nextInt();
                            switch (opcion){
                                case 1:
                                    if (proyectos==1) {
                                        //Segundo proyecto

                                        System.out.print("Introduzca el nombre del proyecto: ");
                                        nombreProyectoB = s.nextLine();
                                        System.out.print("Introduzca la descripción del proyecto: ");
                                        descripcionProyectoB = s.nextLine();
                                        System.out.print("Ingrese la categoría del proyecto: ");
                                        System.out.println("1. Arte");
                                        System.out.println("2. Tecnología");
                                        System.out.println("3. Cine");
                                        System.out.println("4. Música");
                                        System.out.println("5. Juegos");
                                        System.out.println("6. Comida");
                                        System.out.println("7. Moda");
                                        categoriaB = s.nextInt();
                                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                        cantidadB = s.nextInt();

                                    } else if (proyectos==2) {
                                        //tercer proyecto

                                        System.out.print("Introduzca el nombre del proyecto: ");
                                        nombreProyectoC = s.nextLine();
                                        System.out.print("Introduzca la descripción del proyecto: ");
                                        descripcionProyectoC = s.nextLine();
                                        System.out.print("Ingrese la categoría del proyecto: ");
                                        System.out.println("1. Arte");
                                        System.out.println("2. Tecnología");
                                        System.out.println("3. Cine");
                                        System.out.println("4. Música");
                                        System.out.println("5. Juegos");
                                        System.out.println("6. Comida");
                                        System.out.println("7. Moda");
                                        categoriaC = s.nextInt();
                                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                        cantidadC = s.nextInt();

                                    } else if (proyectos==3) {
                                        System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                    }
                                    break;
                                case 2:
                                    System.out.println(nombreProyectoA);
                                    System.out.println("Descripción");
                                    System.out.println(descripcionProyectoA);

                                    break;
                                case 3:

                                    break;
                            }


                        case 3:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do{
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = s.nextInt();
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", administrador);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        administrador = s.nextLine();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaAdministrador);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaAdministrador = s.nextLine();
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
                    menu = s.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println("MIS PROYECTOS");
                            if (proyectos == 0) {
                                System.out.println("Aún no hay proyectos");
                                System.out.println("¿Desea crear un proyecto? (s/n)");
                                String respuesta = s.next();
                                if (respuesta.equals("s")) {
                                    System.out.print("Introduzca el nombre del proyecto: ");
                                    nombreProyectoA = s.nextLine();
                                    System.out.print("Introduzca la descripción del proyecto: ");
                                    descripcionProyectoA = s.nextLine();
                                    System.out.print("Ingrese la categoría del proyecto: ");
                                    System.out.println("1. Arte");
                                    System.out.println("2. Tecnología");
                                    System.out.println("3. Cine");
                                    System.out.println("4. Música");
                                    System.out.println("5. Juegos");
                                    System.out.println("6. Comida");
                                    System.out.println("7. Moda");
                                    categoriaA = s.nextInt();
                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                    cantidadA = s.nextInt();
                                } else if (respuesta.equals("N")) {
                                    System.out.println("No hay proyectos existentes");
                                } else {
                                    System.out.println("Tiene que introducir una respuesta");
                                }
                            } else if (proyectos>0) {
                                //Submenu del gestor
                                System.out.println("1. Crear Proyectos");
                                System.out.println("2. Consultar proyectos");
                                System.out.println("3. Modificar proyectos");
                                opcion = s.nextInt();
                                switch (opcion){
                                    case 1:
                                        if (proyectos==1) {
                                            //Segundo proyecto

                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoB = s.nextLine();
                                            System.out.print("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoB = s.nextLine();
                                            System.out.print("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaB = s.nextInt();
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadB = s.nextInt();

                                        } else if (proyectos==2) {
                                            //tercer proyecto

                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoC = s.nextLine();
                                            System.out.print("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoC = s.nextLine();
                                            System.out.print("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaC = s.nextInt();
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadC = s.nextInt();

                                        } else if (proyectos==3) {
                                            System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                        }
                                        break;
                                    case 2:
                                        System.out.println(nombreProyectoA);
                                        System.out.println("Descripción");
                                        System.out.println(descripcionProyectoA);

                                        break;
                                    case 3:

                                        break;
                                }

                            }
                            break;
                        case 2:

                            break;
                        case 3:
                            System.out.println("Saliendo. Se le está redirigiendo al login.");
                            break;
                        default:
                            System.out.println("Por favor, introduce una opcion válida (1 - 3)");


                    }
                } while (menu!=3);
            }

        }while(sesion);

    }
}