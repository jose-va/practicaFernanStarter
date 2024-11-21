import java.util.Scanner;

public class MenúAdministrador {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("¡Bienvenido al menú del administrador!");
        int menu=0;

        while (menu==Integer.parseInt(null)) {
            System.out.println("1. Panel de control");
            System.out.println("2. Proyectos");
            System.out.println("3. Configuración");
            System.out.println("4. Cerrar sesión");
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
            case 4:

                break;
        }
    }
}
