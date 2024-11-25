import java.sql.SQLOutput;
import java.util.Scanner;

public class MenúGestor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int proyectos=0;
        int menu;
        //Proyecto1
        String nombreProyectoA = "";
        String descripcionProyectoA = "";
        int categoriaA = 0;
        int cantidadA = 0;

        //Proyecto2
        String nombreProyectoB = "";
        String descripcionProyectoB = "";
        int categoriaB = 0;
        int cantidadB = 0;

        //Proyecto3
        String nombreProyectoC = "";
        String descripcionProyectoC = "";
        int categoriaC = 0;
        int cantidadC = 0;

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
                        System.out.println("¿Desea crear un proyecto? (S/N)");
                        String respuesta = s.next();
                        if (respuesta.equals("S")) {
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
                        int opcion = s.nextInt();
                        switch (opcion){
                            case 1:
                                if (proyectos==1) {
                                    //segundo proyecto

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
}