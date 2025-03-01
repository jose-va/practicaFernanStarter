import java.util.Scanner;
import static utilidades.Funciones.*;
import static utilidades.FuncionesCadenas.*;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] administrador= {"jose"} ;
        String[] contrasenaAdministrador= {"1234jose"};
        String[] listaUsuariosGestor= new String [10];
        String[] listaUsuariosInversor= new String [10];
        String[] contrasenasGestor= new String [10];
        String[] contrasenasInversor= new String [10];
        String amigo="",contrasena="", correo="";
        String respuesta = " ";

        String [] nombreProyecto= new String[20];
        String [] descripcionProyecto= new String[20];
        String [] fechaApertura= new String[20];
        String [] fechaCierre= new String[20];

        String []nombreRecompensaA= new String[20];
        String []nombreRecompensaB= new String[20];
        String []nombreRecompensaC= new String[20];
        String []categoria= new String[20];

        String []descripcionRecompensaA= new String[20];
        String []descripcionRecompensaB= new String[20];
        String []descripcionRecompensaC= new String[20];

        float []precioRecompensaA= new float[20];
        float []precioRecompensaB= new float[20];
        float []precioRecompensaC= new float[20];


        int[]id = new int[100];
        int seleccionInversor=0;

        int []recompensas=new int[20];
        int []cantidadAportada=new int[20];
        int []cantidad=new int[20];
        int []cantidadAportada1=new int[20];
        int []cantidadAportada2=new int[20];

        int saldo = 0;

        int[] saldoTotal = new int[10];
        int[] inversiones = new int[10];

        int[] AportacionInversor = new int[10];

        boolean[] inversion={false,false,false};

        int intentos=2, opcion, numpro=0, menu; //Intentos queda a 2, así los listaUsuarios tendran hasta 3 oportunidades para entrar al sistema (hasta 0)
        boolean[] bloqueoGestor= new boolean[10];
        boolean[] bloqueoInversor = new boolean[10];
        boolean sesion=true;

        do {
            do{
                System.out.println("============Bienvenido============");
                System.out.println("1. Iniciar sesión en su cuenta");
                System.out.println("2. Registrarse");
                System.out.println("==================================");
                opcion = Integer.parseInt(s.nextLine());
                if (opcion == 2) registroUsuarios(listaUsuariosGestor, listaUsuariosInversor, contrasenasGestor, contrasenasInversor);
            }while (opcion!=1);

            String usuario;
            do{
                System.out.println("Por favor, introduzca su nombre de usuario: ");
                System.out.println("(* para salir)");
                System.out.println("==================================");
                usuario = s.next().toLowerCase();
                if (usuario.equals("*")) return;
            }while ((buscaNombreUsuario(listaUsuariosGestor, usuario) == -1) &&
                    (buscaNombreUsuario(listaUsuariosInversor, usuario) == -1)  && !usuario.equals("jose"));

            if (usuario.equals("jose")){
                System.out.println("Introduzca su contraseña: ");
                contrasena = s.next();
                while (!compararContrasena(contrasena, contrasenaAdministrador[0])){
                    System.out.println("Contraseña incorrecta.");
                    System.out.println("Por favor, introduzca su contraseña: ");
                    contrasena = s.next();
                }
            }else if((buscaNombreUsuario(listaUsuariosGestor, usuario) >= 0){
                int posicion= buscaNombreUsuario(listaUsuariosGestor, usuario);
                if (bloqueo[posicion]) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                System.out.println(" Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                intentos=2;
                while (!compararContrasena(contrasena, contrasenasGestor[posicion]) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }
                if (intentos == 0) {
                    bloqueo[posicion] = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }else if (buscaNombreUsuario(listaUsuariosInversor, usuario) >= 0){
                int posicion= buscaNombreUsuario(listaUsuariosInversor, usuario);
                if (bloqueo[posicion]) {
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }
                System.out.println(" Introduzca su contraseña (3 intentos):  ");
                contrasena = s.next();
                intentos=2;
                while (!compararContrasena(contrasena, contrasenasInversor[posicion]) && intentos > 0) {
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena = s.next();
                    intentos--;
                }
                if (intentos == 0) {
                    bloqueo[posicion] = true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
            }


            if (buscaNombreUsuario(listaUsuariosInversor, usuario) >= 0){
                    System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    menuInversor(menu);
                    switch (menu) {
                        case 1:
                            menuMisInversiones(opcion);
                            switch (opcion) {
                                case 1:
                                    crearInversion(id, nombreProyecto, cantidad, AportacionInversor, saldoTotal, inversion, cantidadAportada, inversiones);
                                    break;
                                case 2:
                                    if (inversiones[buscaNombreUsuario()] == 0) {
                                        do {
                                            System.out.println("Actualmente, no ha realizado ninguna inversión");
                                            System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                            respuesta = s.next();
                                            if (!respuesta.equals("s") || !respuesta.equals("n")) {
                                                System.out.println("Introduzca una respuesta válida");
                                            }
                                        } while (!respuesta.equals("s") || !respuesta.equals("n"));
                                        if (respuesta.equals("s")) {
                                            crearInversion(id, nombreProyecto, listaUsuarios, usuario, cantidad, AportacionInversor, saldoTotal, inversion, cantidadAportada, inversiones);
                                            break;
                                        }
                                    } else if (inversiones[buscaNombreUsuario()] > 0) {
                                        System.out.println("*****Consulta de inversiones*****");
                                        consultaInversion()
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Salir. Redirigiendo al menú del inversor.");
                            break;
                        case 2:
                            consultaDetalladaProyecto( nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
                                    nombreRecompensaA, descripcionRecompensaA, precioRecompensaA, nombreRecompensaB, descripcionRecompensaB, precioRecompensaB,
                                    nombreRecompensaC, descripcionRecompensaC, precioRecompensaC, recompensas);
                            break;
                        case 3:
                            cartera(opcion =0, saldoTotal[buscaNombreUsuario(listaUsuariosInversor, usuario)], saldo);
                            break;
                        case 4:
                            anadeamigo1(opcion=0, amigo, correo);
                            break;
                        case 5:
                            config1(opcion=0, inversor, contrasenasInversor);
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

            }else if(contrasena.equalsIgnoreCase(contrasenaAdministrador[0])){ //Menú Administrador
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
                            System.out.println("Listado de todos los usuarios");
                            listadoUsuarios(listaUsuariosGestor, listaUsuariosInversor, bloqueoGestor, bloqueoInversor);
                            System.out.println("=====================================================================");
                            System.out.println("Por favor, introduzca el nombre de un usuario para cambiar su estado.");
                            usuario= s.nextLine().toLowerCase();
                            if (buscaNombreUsuario(listaUsuariosGestor, usuario)!=-1){
                                int posicion= buscaNombreUsuario(listaUsuariosGestor, usuario);
                                System.out.println(listaUsuariosGestor[posicion]);
                                if(bloqueoGestor[posicion]){
                                    System.out.print(" - Bloqueado\n");
                                    System.out.println("¿Desea desbloquear a este usuario? (si/no)");
                                    String respuesta= s.nextLine().toLowerCase();
                                    if (respuesta.equals("si")) bloqueoGestor[posicion]=false;

                                }else{
                                    System.out.print(" - Desbloqueado\n");
                                    System.out.println("¿Desea bloquear a este usuario? (si/no)");
                                    String respuesta= s.nextLine().toLowerCase();
                                    if (respuesta.equals("si")) bloqueoGestor[posicion]=true;
                                }

                            }else if(buscaNombreUsuario(listaUsuariosInversor,usuario)!=-1){
                                int posicion= buscaNombreUsuario(listaUsuariosInversor,usuario);
                                System.out.println(listaUsuariosInversor[posicion]);
                                if(bloqueoInversor[posicion]){
                                    System.out.print(" - Bloqueado\n");
                                    System.out.println("¿Desea desbloquear a este usuario? (si/no)");
                                    String respuesta= s.nextLine().toLowerCase();
                                    if (respuesta.equals("si")) bloqueoInversor[posicion]=false;

                                }else{
                                    System.out.print(" - Desbloqueado\n");
                                    System.out.println("¿Desea bloquear a este usuario? (si/no)");
                                    String respuesta= s.nextLine().toLowerCase();
                                    if (respuesta.equals("si")) bloqueoInversor[posicion]=true;
                                }

                            }else{
                                System.out.println("El usuario introducido no existe.");
                            }

                        case 2:
                            misProyectos(nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
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

            }else if(buscaNombreUsuario(listaUsuariosGestor, usuario) >= 0){
                int posicion= buscaNombreUsuario(listaUsuariosGestor, usuario);
                System.out.println("Bienvenido. Cuenta de gestor");
                do {
                    System.out.println("1. Mis proyectos");
                    System.out.println("2. Configuración");
                    System.out.println("3. Cerrar sesión");
                    menu = Integer.parseInt(s.next());
                    switch (menu) {
                        case 1:
                            misProyectos(nombreProyecto, categoria, cantidad, cantidadAportada, descripcionProyecto, fechaApertura, fechaCierre,
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
                                        System.out.printf("Usuario actual -> %s\n", listaUsuariosGestor[posicion]);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        listaUsuariosGestor[0] = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenasGestor[posicion]);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenasGestor[posicion] = s.next();
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
