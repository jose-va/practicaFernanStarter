import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class MenúGestor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int proyectos=0;
        int menu;
        //Proyecto1
        String nombreProyectoA ="";
        String descripcionProyectoA ="";
        int categoriaA = 0;
        int cantidadA = 0;
        int cantidadfinanciadaA=0;

        //Proyecto2
        String nombreProyectoB = "";
        String descripcionProyectoB = "";
        int categoriaB = 0;
        int cantidadB = 0;
        int cantidadfinanciadaB=0;

        //Proyecto3
        String nombreProyectoC = "";
        String descripcionProyectoC = "";
        int categoriaC = 0;
        int cantidadC = 0;
        int cantidadfinanciadaC=0;

        String gestor= "pablo", contrasenaGestor="1234pablo";

        //Identificadores para saber que proyectos ha creado el gestor (Proyecto 1 (A), Proyecto 2 (B)...)
        boolean creadoGestorA = false;
        boolean creadoGestorB = false;
        boolean creadoGestorC = false;

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
                            System.out.println("Introduzca el nombre del proyecto: ");
                            nombreProyectoA = s.next();
                            System.out.println("Introduzca la descripción del proyecto: ");
                            descripcionProyectoA = s.nextLine();
                            System.out.println("Ingrese la categoría del proyecto: ");
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
                            proyectos+=1;
                            creadoGestorA = true;

                            break;
                        } else if (respuesta.equals("n")) {
                            System.out.println("No hay proyectos existentes");
                        } else {
                            System.out.println("Tiene que introducir una respuesta");
                        }
                        break;
                    } else if (proyectos>0) {
                        //Submenu del gestor
                        System.out.println("1. Crear Proyectos");
                        System.out.println("2. Consultar proyectos");
                        System.out.println("3. Modificar proyectos");
                        int opcion = s.nextInt();
                        switch (opcion) {
                            case 1:
                                if (proyectos == 1) {
                                    //segundo proyecto

                                    System.out.print("Introduzca el nombre del proyecto: ");
                                    nombreProyectoB = s.next();
                                    System.out.println("Introduzca la descripción del proyecto: ");
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
                                    proyectos+=1;
                                    creadoGestorA = true;

                                } else if (proyectos == 2) {
                                    //tercer proyecto

                                    System.out.print("Introduzca el nombre del proyecto: ");
                                    nombreProyectoC = s.next();
                                    System.out.print("Introduzca la descripción del proyecto: ");
                                    descripcionProyectoC = s.nextLine();
                                    System.out.println("Ingrese la categoría del proyecto: ");
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
                                    proyectos+=1;
                                    creadoGestorA = true;

                                } else if (proyectos == 3) {
                                    System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                }
                                break;
                            case 2:
                                System.out.println("CONSULTA DE PROYECTOS");
                                System.out.println();
                                if (proyectos == 1) {
                                    System.out.println(nombreProyectoA);
                                    System.out.println("Categoría: " + categoriaA);
                                    System.out.println("Cantidad necesaria: " + cantidadA);
                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                    System.out.println("Cantidad financiada hasta el momento: ");
                                } else if (proyectos == 2) {
                                    System.out.println(nombreProyectoB);
                                    System.out.println("Categoría: " + categoriaB);
                                    System.out.println("Cantidad necesaria: " + cantidadB);
                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                    System.out.println("Cantidad financiada hasta el momento: ");
                                } else if (proyectos == 3) {
                                    System.out.println(nombreProyectoC);
                                    System.out.println("Categoría: " + categoriaC);
                                    System.out.println("Cantidad necesaria: " + cantidadC);
                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                    System.out.println("Cantidad financiada hasta el momento: ");
                                }
                                break;
                            case 3:
                                System.out.println("MODIFICAR PROYECTOS");
                                if (proyectos == 0) {
                                    System.out.println("No hay ningún proyecto creado aún");
                                } else {
                                    System.out.println("¿Qué proyecto desea modicicar?");
                                    System.out.println("Introduzca el número del proyecto");
                                    int numpro=0;
                                    while (numpro!=1 || numpro!=2 || numpro!=3) {
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
                                        numpro = s.nextInt();
                                        if (numpro!= 1 || numpro !=2 || numpro != 3);
                                        System.out.println("Debes introducir el número correspondiente");
                                    }
                                    switch (numpro){
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
                                            categoriaA = s.nextInt();
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadA = s.nextInt();
                                            break;
                                        case 2:
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoB = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
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
                                            break;
                                        case 3:
                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoC = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
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
                                            break;
                                        default:
                                            while (numpro!=1 || numpro!=2 || numpro!=3) {
                                                System.out.println("Debes introducir el número correspondiente");
                                                numpro = s.nextInt();
                                            }
                                    }
                                    break;
                                }
                        }
                    }
                    break;
                case 2:
                    System.out.println("CONFIGURACION. Seleccione una opción: ");
                    int opcion;
                    do {
                        System.out.println("1. Cambiar usuario");
                        System.out.println("2. Cambiar contraseña");
                        System.out.println("3. Guardar cambios");
                        opcion = s.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.printf("Usuario actual -> %s\n", gestor);
                                System.out.println("Introduzca su nuevo usuario: ");
                                gestor = s.nextLine();
                                break;
                            case 2:
                                System.out.printf("Contraseña actual -> %s\n", contrasenaGestor);
                                System.out.println("Introduzca su nueva contraseña: ");
                                contrasenaGestor = s.nextLine();
                                break;
                        }
                    }while (opcion!=3);
                    break;
                case 3:
                    System.out.println("Saliendo. Se le está redirigiendo al login.");
                    break;
                default:
                    System.out.println("Por favor, introduce una opcion válida (1 - 3)");
            }
        } while (menu!=3);
    }
}