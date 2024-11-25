import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "toranzo", contrasenaInversor2="1234toranzo";

        int intentos=3;
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false, controlAdministrador=true;

        int proyectos=0;

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

            if (contrasena.equals(contrasenaInversor1)) {

                int menu;
                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    System.out.println("Menú:");
                    System.out.println("1. Mis inversiones");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Cartera digital");
                    System.out.println("4. Invita a un amigo");
                    System.out.println("5. Configuración");
                    System.out.println("6. Cerrar sesión");
                    menu = s.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println("INVERSIONES");
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
                            break;
                        case 4:
                            System.out.println("INVITAR A UN AMIGO");
                            break;
                        case 5:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            int opcion;
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

            }else if(contrasena.equals(contrasenaAdministrador)){
                int menu;
                System.out.println("Bienvenido. Cuenta de administrador");
                do {
                    System.out.println("Menú:");
                    System.out.println("1. Panel de Control");
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
                            if (proyectos==0){
                                System.out.println("No existen proyectos. El gestor debe de crear uno.");
                                break;
                            }else if(proyectos==1){

                            }
                            break;

                        case 3:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            int opcion;
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
            }

        }while(controlAdministrador);

    }
}