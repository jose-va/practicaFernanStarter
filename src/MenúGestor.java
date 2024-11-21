import java.util.Scanner;

public class MenúGestor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("¡Bienvenido al menú gestor!");
        int menu=0;

        while (menu==Integer.parseInt(null)) {
            System.out.println("Menú:");
            System.out.println("1. Mis proyectos");
            System.out.println("2. Configuración");
            System.out.println("3. Cerrar sesión");
            menu = s.nextInt();
            if (menu == Integer.parseInt(null)) ;
            System.out.println("Debes de introducir alguna opcion");
            System.out.println();
        }
        switch (menu) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
    }
}
