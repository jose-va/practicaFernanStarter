import java.util.Scanner;

public class ApartadoInversiones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int inversiones = 0;
        int cantidadAportadaA=0;
        String cantidadA="";
        String nombreProyectoA="";
        String nombreProyectoB="";
        String nombreProyectoC="";

        //A partir de aquí es lo que va dentro del main

        if (inversiones == 0) {
            System.out.println("Actualmente, no ha realizado ninguna inversión");
            System.out.println("¿Desea invertir en algún proyecto? (s/n)");
            String respuesta2 = s.nextLine();
            if (respuesta2.equals("s")){
                int opcion = 0;
                while (opcion !=1 || opcion !=2 || opcion !=3)
                System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                System.out.println("Proyecto 1: " + nombreProyectoA);
                System.out.println("Proyecto 2: " + nombreProyectoB);
                System.out.println("Proyecto 3: " + nombreProyectoC);
                int opcion2 = s.nextInt();
                switch (opcion2){
                    case 1:
                        System.out.println("La versión necesaria de este proyecto es de "+cantidadA);
                        System.out.println("¿Que cantidad desea aportar?");
                        cantidadAportadaA = s.nextInt();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Debe de introducir la opción correspondiente correcta");
                }
            }

        }
    }
}
