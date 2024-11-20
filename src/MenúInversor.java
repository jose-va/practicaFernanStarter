import java.util.Scanner;

public class MenúInversor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        int menu=0;

        while (menu==Integer.parseInt(null)) {
            System.out.println("Menú:");
            System.out.println("1. Mis inversiones");
            System.out.println("2. Proyectos");
            System.out.println("3. Cartera digital");
            System.out.println("4. Invita a un amigo");
            System.out.println("5. Configuración");
            System.out.println("6. Cerrar sesión");
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
            case 5:

                break;
            case 6:

                break;
        }

    }
}
