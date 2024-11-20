import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

       String administrador= "Jose";
       String gestor= "Pablo";
       String inversor1= "Eladio";
       String inversor2= "Toranzo";

        System.out.println("Bienvenido");
        System.out.println("Por favor, introduzca su nombre de usuario");
        String usuario= s.nextLine();

        while (!usuario.equals(administrador.toLowerCase()) || !usuario.equals(gestor.toLowerCase())
                || !usuario.equals(inversor1.toLowerCase()) || !usuario.equals(inversor2.toLowerCase())){
            System.out.println("Por favor, introduzca su nombre de usuario");
            usuario= s.nextLine();
        }

    }
}