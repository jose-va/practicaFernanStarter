package utilidades;

public class FuncionesCadenas {

    public static boolean compararContrasena(String contrasenaUsuario, String contrasenaUsuario2){
        for (int i=0; i< contrasenaUsuario.length(); i++){
            if (contrasenaUsuario.charAt(i)==contrasenaUsuario2.charAt(i));
            else return false;
        }
        return true;
    }
    public static boolean fortalezaContrasena(String contrasenaUsuario){
        if (contrasenaUsuario.length()<8) return false;

        int contMinusculas=0;
        int contMayusculas=0;
        int contSimbolos=0;
        for (int i=0; i< contrasenaUsuario.length(); i++){
            if (contrasenaUsuario.charAt(i)=='+' || contrasenaUsuario.charAt(i)=='-' || contrasenaUsuario.charAt(i)=='_' ||
                    contrasenaUsuario.charAt(i)=='*' || contrasenaUsuario.charAt(i)=='.' || contrasenaUsuario.charAt(i)==',' || contrasenaUsuario.charAt(i)=='@'){
                contSimbolos++;
            }else{
                if (contrasenaUsuario.charAt(i)==contrasenaUsuario.toUpperCase().charAt(i)) contMayusculas++;
                else contMinusculas++;
            }
        }

        if (contMinusculas > 0 && contMayusculas > 0 && contSimbolos > 0) return true;
        else return false;
    }

    public static int buscaNombreProyecto(String []nombreProyecto, String nombre) {
        for (int i=0; i<nombreProyecto.length; i++){
            if (nombreProyecto[i].toLowerCase().equals(nombre)) return i;
        }
        return -1;
    }

    public static int buscaProyectoVacio(String [] nombreProyecto){
        for (int i=0; i< nombreProyecto.length; i++){
            if (nombreProyecto[i].isEmpty()) return i;
        }
        return 20;
    }

    public static int buscaNombreUsuario(String []listaUsuarios, String usuario) {
        for (int i=0; i<listaUsuarios.length; i++){
            if (listaUsuarios[i].toLowerCase().equals(usuario)) return i;
        }
        return -1;
    }


    public static int buscaUsuarioVacio(String [] usuarios){
        for (int i=0; i< usuarios.length; i++){
            if (usuarios[i].isEmpty()) return i;
        }
        return 10;
    }

    public static void listadoUsuarios (String[] listaUsuariosGestor, String [] listaUsuariosInversor,
                                        boolean[] bloqueoGestor, boolean[] bloqueoInversor){

        System.out.println("==========Gestores==============");
        for (int i=0; i< listaUsuariosGestor.length; i++){
            System.out.println(listaUsuariosGestor[i]);
            if (bloqueoGestor[i]) System.out.print(" - Bloqueado\n");
            else System.out.print(" - Desbloqueado\n");
        }
        System.out.println("==========Inversores==============");
        for (int i=0; i< listaUsuariosInversor.length; i++){
            System.out.println(listaUsuariosInversor[i]);
            if (bloqueoInversor[i]) System.out.print(" - Bloqueado\n");
            else System.out.print(" - Desbloqueado\n");
        }
    }



}
