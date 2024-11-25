import java.util.Scanner;
public class ProyectosGestor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int proyectos = 0;
            if (proyectos == 0) {
                System.out.println("Aún no hay proyectos. ¿Desea crear un proyecto? (si/no)");
                String respuesta = s.next();
                if (respuesta.equals("si")) {
                    System.out.print("Introduzca el nombre del proyecto: ");
                    String nombreProyecto = s.nextLine();
                    System.out.print("Introduzca la descripción del proyecto: ");
                    String descripciónProyecto = s.nextLine();
                    System.out.print("Ingrese la categoría del proyecto:  ");
                    System.out.println("1. Arte");
                    System.out.println("2. Tecnología");
                    System.out.println("3. Cine");
                    System.out.println("4. Música");
                    System.out.println("5. Juegos");
                    System.out.println("6. Comida");
                    System.out.println("7. Moda");
                    int opcion = s.nextInt();
                } else if (respuesta.equals("no")) {

                } else {
                    System.out.println("Tiene que introducir una respuesta");
                }
            }
    }
}

