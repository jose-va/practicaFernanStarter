package utilidades;

public class FuncionesCadenas {
    public static boolean compararUsuario(String usuario, String usuario2){
        for (int i=0; i< usuario.length(); i++){
            if (usuario.toLowerCase().charAt(i)== usuario2.toLowerCase().charAt(i));
            else return false;
        }
        return true;
    }
    public static boolean compararContrasena(String contrasena, String contrasena2){
        for (int i=0; i< contrasena.length(); i++){
            if (contrasena.charAt(i)== contrasena2.charAt(i));
            else return false;
        }
        return true;
    }
    public static boolean fortalezaContrasena(String contrasena){
        if (contrasena.length()<8) return false;

        int contMinusculas=0;
        int contMayusculas=0;
        int contSimbolos=0;
        for (int i=0; i< contrasena.length(); i++){
            if (contrasena.charAt(i)=='+' || contrasena.charAt(i)=='-' || contrasena.charAt(i)=='_' ||
                    contrasena.charAt(i)=='*' || contrasena.charAt(i)=='.' || contrasena.charAt(i)==',' || contrasena.charAt(i)=='@'){
                contSimbolos++;
            }else{
                if (contrasena.charAt(i)==contrasena.toUpperCase().charAt(i)) contMayusculas++;
                else contMinusculas++;
            }
        }

        if (contMinusculas > 0 && contMinusculas > 0 && contSimbolos > 0) return true;
        else return false;
    }

    public static int buscaNombreProyecto(String []nombreProyecto, String nombre) {
        for (int i=0; i<nombreProyecto.length; i++){
            if (nombreProyecto[i].toLowerCase().equals(nombre)) return i;
        }
        return -1;
    }

}
