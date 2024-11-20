import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

       String administrador= "Jose";
       String contrasenaAdministrador="1234jose";
       String gestor= "Pablo";
       String contrasenaGestor="1234pablo";
       String inversor1= "Eladio";
       String contrasenaInversor1="1234eladio";
       String inversor2= "Toranzo";
       String contrasenaInversor2="1234toranzo";

       int intentos=3;

        boolean bloqueoInversor1=false;
        boolean bloqueoInversor2=false;

        System.out.println("Bienvenido.");
        System.out.println("Por favor, introduzca su nombre de usuario:: ");
        String usuario= s.nextLine();

        while (!usuario.equals(administrador.toLowerCase()) || !usuario.equals(gestor.toLowerCase())
                || !usuario.equals(inversor1.toLowerCase()) || !usuario.equals(inversor2.toLowerCase())){
            System.out.println("Contraseña incorrecta.");
            System.out.println("Introduzca su nombre de usuario: ");
            usuario= s.nextLine();
        }

        String contrasena;
        switch (usuario){
            case "jose":
                System.out.println("Administrador. Introduzca su contraseña: ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaAdministrador)){
                    System.out.println("Contraseña incorrecta. Por favor, introduzca su contraseña: ");
                    contrasena= s.nextLine();
                }
                break;

            case "pablo":
                System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaGestor) && intentos>0){
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena= s.nextLine();
                }

                boolean bloqueoGestor= intentos==0 ? true: false;

            case "eladio":




                break;
        }




    }
}