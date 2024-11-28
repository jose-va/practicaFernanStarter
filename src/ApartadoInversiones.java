import java.util.Scanner;

public class ApartadoInversiones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inversiones = 0;
        int cantidadAportadaA = 0;
        int cantidadAportadaB = 0;
        int cantidadAportadaC = 0;
        String cantidadA = "";
        String cantidadB = "";
        String cantidadC = "";
        String nombreProyectoA = "";
        String nombreProyectoB = "";
        String nombreProyectoC = "";
        //Aportación del inversor 1 a diferentes proyectos
        int aportacionI1 =0;
        boolean inversionA1 = false;
        boolean inversionB1 = false;
        boolean inversionC1 = false;
        //Aportación del inversor 2 a diferentes proyectos
        int aportacionI2=0;
        boolean inversionA2 = false;
        boolean inversionB2 = false;
        boolean inversionC2 = false;


        //A partir de aquí es lo que va dentro del main

        System.out.println("MIS INVERSIONES");

        if (inversiones == 0) {
            System.out.println("Actualmente, no ha realizado ninguna inversión");
            System.out.println("¿Desea invertir en algún proyecto? (s/n)");
            String respuesta2 = s.nextLine();
            if (respuesta2.equals("s")) {
                int opcion2 = 0;
                while (opcion2 != 1 || opcion2 != 2 || opcion2 != 3) {
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
                            inversionA1 = true;
                            break;
                        case 2:
                            System.out.println("La versión necesaria de este proyecto es de " + cantidadB);
                            System.out.println("¿Que cantidad desea aportar?");
                            cantidadAportadaB = s.nextInt();
                            inversionB1 = true;
                            break;
                        case 3:
                            System.out.println("La versión necesaria de este proyecto es de " + cantidadC);
                            System.out.println("¿Que cantidad desea aportar?");
                            cantidadAportadaC = s.nextInt();
                            inversionC1 = true;
                            break;
                        default:
                            System.out.println("Debe de introducir la opción correspondiente correcta");
                    }
                }
            } else if (!respuesta2.equals("n")) {
                System.out.println("Introduce una opcion valida (s/n)");
            }
        } else if (inversiones>0){


        }
    }
}
