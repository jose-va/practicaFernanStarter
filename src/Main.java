import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "Ttranzo", contrasenaInversor2="1234toranzo";

        int intentos=3;
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false;

        System.out.println("Bienvenido.");
        System.out.println("Introduzca su nombre de usuario: ");
        String usuario= s.nextLine().toLowerCase();

        while (!usuario.equals(administrador) && !usuario.equals(gestor)
                && !usuario.equals(inversor1) && !usuario.equals(inversor2)){
            System.out.println("El usuario no existe.");
            System.out.println("Por favor, introduzca un nombre de usuario válido: ");
            usuario= s.nextLine();
        }

        String contrasena="";
        switch (usuario){
            case "jose":
                System.out.println("Administrador. Introduzca su contraseña: ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaAdministrador)){
                    System.out.println("Contraseña incorrecta.");
                    System.out.println("Por favor, introduzca su contraseña: ");
                    contrasena= s.nextLine();
                }
                break;

            case "pablo":
                if (bloqueoGestor){
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }

                System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaGestor) && intentos>0){
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena= s.nextLine();
                }

                if (intentos==0){
                    bloqueoGestor=true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
                break;

            case "eladio":
                if (bloqueoInversor1){
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }

                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaInversor1) && intentos>0){
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena= s.nextLine();
                }

                if (intentos==0){
                    bloqueoInversor1= true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
                break;

            case "toranzo":
                if (bloqueoInversor2){
                    System.out.println("Este usuario está bloqueado.");
                    break;
                }

                System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                contrasena= s.nextLine();
                while(!contrasena.equals(contrasenaInversor2) && intentos>0){
                    intentos--;
                    System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                    contrasena= s.nextLine();
                }

                if(intentos==0){
                    bloqueoInversor2=true;
                    System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                }
                break;
        }

            if (contrasena.equals(contrasenaGestor)){

            }

            //Proyectos
        int proyectos = 0;
            if (proyectos==0){
                System.out.println("Aún no hay proyectos. ¿Desea crear un proyecto? (si/no)");
                String respuesta = s.next();
                if (respuesta.equals("si")){
                    System.out.print("Introduzca el nombre del proyecto: ");
                    String nombreProyecto=s.nextLine();
                    System.out.print("Introduzca la descripción del proyecto: ");
                    String descripciónProyecto= s.nextLine();
                    System.out.print("Ingrese la categoría del proyecto:  ");
                    System.out.println("1. Arte");
                    System.out.println("2. Tecnología");
                    System.out.println("3. Cine");
                    System.out.println("4. Música");
                    System.out.println("5. Juegos");
                    System.out.println("6. Comida");
                    System.out.println("7. Moda");
                    int opcion = s.nextInt();




                } else if (respuesta.equals("no")){

                }else{
                    System.out.println("Tiene que introducir una respuesta");
                }

            }

    }
}