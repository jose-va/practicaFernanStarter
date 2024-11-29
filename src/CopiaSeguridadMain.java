import java.util.Scanner;
// Último acceso: 29/11/2024
public class CopiaSeguridadMain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String administrador= "jose", contrasenaAdministrador="1234jose";
        String gestor= "pablo", contrasenaGestor="1234pablo";
        String inversor1= "eladio", contrasenaInversor1="1234eladio";
        String inversor2= "toranzo", contrasenaInversor2="1234toranzo";

        String nombreProyectoA = "", nombreProyectoB = "", nombreProyectoC="";
        String descripcionProyectoA = "", descripcionProyectoB = "", descripcionProyectoC="";
        int categoriaA=0, categoriaB=0, categoriaC=0;
        int cantidadA=0,cantidadAportadaA=0, cantidadB=0, cantidadAportadaB=0, cantidadC=0, cantidadAportadaC=0;
        int proyectos=0, saldo=0, saldoTotal=0, inversiones=0, amigos=0;
        int aportacionI1=0;
        int aportacionI2=0;
        boolean inversionA, inversionB, inversionC;
        String correo, amigo="";

        int intentos=3, opcion, opcion2, menu;
        boolean bloqueoGestor=false, bloqueoInversor1=false, bloqueoInversor2=false,sesion=true;

        do {
            System.out.println("************Bienvenido*********");
            System.out.println("Introduzca su nombre de usuario: ");
            String usuario = s.nextLine().toLowerCase();

            while (!usuario.equals(administrador) && !usuario.equals(gestor)
                    && !usuario.equals(inversor1) && !usuario.equals(inversor2)) {
                System.out.println("El usuario no existe.");
                System.out.println("Por favor, introduzca un nombre de usuario válido: ");
                usuario = s.nextLine();
            }

            String contrasena="";
            switch (usuario) {
                case "jose":
                    System.out.println("Administrador. Introduzca su contraseña: ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaAdministrador)) {
                        System.out.println("Contraseña incorrecta.");
                        System.out.println("Por favor, introduzca su contraseña: ");
                        contrasena = s.nextLine();
                    }
                    break;

                case "pablo":
                    if (bloqueoGestor) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Gestor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaGestor) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoGestor = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;

                case "eladio":
                    if (bloqueoInversor1) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaInversor1) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoInversor1 = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;

                case "toranzo":
                    if (bloqueoInversor2) {
                        System.out.println("Este usuario está bloqueado.");
                        break;
                    }

                    System.out.println("Inversor. Introduzca su contraseña (3 intentos):  ");
                    contrasena = s.nextLine();
                    while (!contrasena.equals(contrasenaInversor2) && intentos > 0) {
                        intentos--;
                        System.out.printf("Contraseña incorrecta. Por favor, introduzca su contraseña (%d intentos restantes):\n", intentos);
                        contrasena = s.nextLine();
                    }

                    if (intentos == 0) {
                        bloqueoInversor2 = true;
                        System.out.println("Se ha superado el máximo de intentos. Usuario bloqueado.");
                    }
                    break;
            }

            if (contrasena.equals(contrasenaInversor1)) { //Menú inversor

                System.out.println("Bienvenido. Cuenta de inversor.");
                do {
                    System.out.println("=======MENÚ========");
                    System.out.println("1. Mis inversiones");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Cartera digital");
                    System.out.println("4. Invita a un amigo");
                    System.out.println("5. Configuración");
                    System.out.println("6. Cerrar sesión");
                    menu = s.nextInt();

                    switch (menu) {
                        case 1:
                            System.out.println("MIS INVERSIONES");

                            if (inversiones == 0) {
                                System.out.println("Actualmente, no ha realizado ninguna inversión");
                                System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                String respuesta2 = s.nextLine();
                                while (!respuesta2.equals("s")){
                                    if (respuesta2.equals("n")){
                                        return;
                                    }
                                    System.out.println("Introduce una opcion valida (s/n)");
                                    System.out.println("¿Desea invertir en algún proyecto? (s/n)");
                                    respuesta2 = s.nextLine();
                                }
                                if (respuesta2.equals("s")) {
                                    int opcion3 = 0;
                                    while (opcion3 != 1 || opcion3 != 2 || opcion3 != 3) {
                                        System.out.println("¿En que proyecto desea invertir? Introduce el número correspondiente");
                                        System.out.println("Proyecto 1: " + nombreProyectoA);
                                        System.out.println("Proyecto 2: " + nombreProyectoB);
                                        System.out.println("Proyecto 3: " + nombreProyectoC);
                                        aportacionI1 = Integer.parseInt(s.nextLine());
                                        switch (aportacionI1) {
                                            case 1:
                                                System.out.println("La versión necesaria de este proyecto es de " + cantidadA);
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportadaA = s.nextInt();
                                                inversionA = true;
                                                break;
                                            case 2:
                                                System.out.println("La versión necesaria de este proyecto es de " + cantidadB);
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportadaB = s.nextInt();
                                                inversionB = true;
                                                break;
                                            case 3:
                                                System.out.println("La versión necesaria de este proyecto es de " + cantidadC);
                                                System.out.println("¿Que cantidad desea aportar?");
                                                cantidadAportadaC = s.nextInt();
                                                inversionC = true;
                                                break;
                                            default:
                                                System.out.println("Debe de introducir la opción correspondiente correcta");
                                                break;
                                        }
                                    }
                                }
                            } else if (inversiones>0){
                                System.out.println("Consulta de inversiones");
                            }
                            break;
                        case 2:
                            System.out.println("CONSULTA DE PROYECTOS");
                            System.out.println();
                            if (proyectos == 1) {
                                System.out.println(nombreProyectoA);
                                System.out.println("Categoría: " + categoriaA);
                                System.out.println("Cantidad necesaria: " + cantidadA);
                                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                System.out.println("Cantidad financiada hasta el momento: ");
                            } else if (proyectos == 2) {
                                System.out.println(nombreProyectoB);
                                System.out.println("Categoría: " + categoriaB);
                                System.out.println("Cantidad necesaria: " + cantidadB);
                                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                System.out.println("Cantidad financiada hasta el momento: ");
                            } else if (proyectos == 3) {
                                System.out.println(nombreProyectoC);
                                System.out.println("Categoría: " + categoriaC);
                                System.out.println("Cantidad necesaria: " + cantidadC);
                                //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                System.out.println("Cantidad financiada hasta el momento: ");
                            }
                            break;
                        case 3:
                            System.out.println("CARTERA DIGITAL");
                            do{
                                System.out.println("1. Saldo actual");
                                System.out.println("2. Añadir saldo");
                                System.out.println("3. Salir");
                                opcion=s.nextInt();
                                switch (opcion){
                                    case 1:
                                        if(saldoTotal==0){
                                            System.out.println("Usted no dispone de saldo.");
                                            break;
                                        }else{
                                            System.out.printf("Saldo %d€", saldoTotal);
                                        }
                                        break;
                                    case 2:
                                        System.out.println("¿Cuánto dinero desea ingresar?");
                                        saldo=Integer.parseInt(s.next());
                                        saldoTotal+=saldo;
                                        System.out.println("Su saldo ha sido añadido correctamente");
                                    case 3:
                                        System.out.println("Usted ha seleccionado salir.");
                                    default:
                                        System.out.println("Opcion seleccionada inválida.");
                                }
                            }while(opcion!=3);

                            break;
                        case 4:
                            System.out.println("INVITAR A UN AMIGO");
                            do{
                                System.out.println("1. Listado de amigos");
                                System.out.println("2. Añadir a un amigo");
                                opcion=s.nextInt();
                                switch (opcion){
                                    case 1:
                                        System.out.println("LISTADO DE AMIGOS");
                                        System.out.println(amigo);
                                    case 2:
                                        System.out.println("AÑADIR A UN AMIGO: ");
                                        correo= s.nextLine();
                                        amigo= amigo.concat(" " + correo);
                                }

                            }while(opcion!=3);
                            break;
                        case 5:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do{
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = s.nextInt();
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", inversor1);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        inversor1 = s.nextLine();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaInversor1);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaInversor1 = s.nextLine();
                                        break;
                                }
                            }while (opcion!=3);

                            break;
                        case 6:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 6)");
                            break;
                    }
                } while (menu != 6);

            }else if(contrasena.equals(contrasenaAdministrador)){ //Menú Administrador
                System.out.println("Bienvenido. Cuenta de administrador");
                do {
                    System.out.println("=======MENÚ========");
                    System.out.println("1. Panel de control");
                    System.out.println("2. Proyectos");
                    System.out.println("3. Configuración");
                    System.out.println("4. Cerrar sesión");
                    menu = Integer.parseInt(s.next());

                    switch (menu) {
                        case 1:
                            System.out.println("PANEL DE CONTROL");
                            System.out.println("Listado de usuarios: ");
                            if (bloqueoInversor1){
                                System.out.printf("Inversor %s- Bloqueado\n", inversor1);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=false;
                                }
                            }else{
                                System.out.printf("Inversor %s - Desbloqueado\n", inversor1);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor1=true;
                                }
                            }
                            if (bloqueoInversor2){
                                System.out.printf("Inversor %s- Bloqueado\n", inversor2);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor2);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=false;
                                }
                            }else{
                                System.out.printf("Inversor %s- Desbloqueado\n", inversor2);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", inversor2);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoInversor2=true;
                                }
                            }
                            if (bloqueoGestor){
                                System.out.printf("Gestor %s- Bloqueado\n", gestor);
                                System.out.printf("¿Desea desbloquear a %s? (s/n)\n", inversor1);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoGestor=false;
                                }
                            }else{
                                System.out.printf("Gestor %s - Desbloqueado\n", gestor);
                                System.out.printf("¿Desea bloquear a %s? (s/n)\n", gestor);
                                char b= s.next().toLowerCase().charAt(0);
                                if(b=='s'){
                                    bloqueoGestor=true;
                                }
                            }
                            break;

                        case 2:
                            System.out.println("PROYECTOS");
                            System.out.println("1. Crear Proyectos");
                            System.out.println("2. Consultar proyectos");
                            System.out.println("3. Modificar proyectos");
                            opcion = Integer.parseInt(s.next());
                            switch (opcion){
                                case 1:
                                    if (proyectos == 0) {
                                        System.out.println("Aún no hay proyectos");
                                        System.out.println("¿Desea crear un proyecto? (s/n)");
                                        String respuesta = s.next();
                                        if (respuesta.equals("s")) {
                                            System.out.println("Introduzca el nombre del proyecto: ");
                                            nombreProyectoA = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoA = s.next();
                                            System.out.println("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaA = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadA = Integer.parseInt(s.next());
                                            proyectos+=1;
                                            break;
                                        } else if (respuesta.equals("n")) {
                                            System.out.println("No hay proyectos existentes");
                                        } else {
                                            System.out.println("Tiene que introducir una respuesta");
                                        }
                                        break;
                                    } else if (proyectos>0) {
                                        //Submenu del gestor
                                        System.out.println("1. Crear Proyectos");
                                        System.out.println("2. Consultar proyectos");
                                        System.out.println("3. Modificar proyectos");
                                        opcion = s.nextInt();
                                        switch (opcion) {
                                            case 1:
                                                if (proyectos == 1) {
                                                    //segundo proyecto

                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoB = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoB = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaB = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadB = Integer.parseInt(s.next());

                                                } else if (proyectos == 2) {
                                                    //tercer proyecto

                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoC = s.next();
                                                    System.out.print("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoC = s.nextLine();
                                                    System.out.println("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaC = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadC = Integer.parseInt(s.next());

                                                } else if (proyectos == 3) {
                                                    System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("CONSULTA DE PROYECTOS");
                                                System.out.println();
                                                if (proyectos == 1) {
                                                    System.out.println(nombreProyectoA);
                                                    System.out.println("Categoría: " + categoriaA);
                                                    System.out.println("Cantidad necesaria: " + cantidadA);
                                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                                    System.out.println("Cantidad financiada hasta el momento: ");
                                                } else if (proyectos == 2) {
                                                    System.out.println(nombreProyectoB);
                                                    System.out.println("Categoría: " + categoriaB);
                                                    System.out.println("Cantidad necesaria: " + cantidadB);
                                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                                    System.out.println("Cantidad financiada hasta el momento: ");
                                                } else if (proyectos == 3) {
                                                    System.out.println(nombreProyectoC);
                                                    System.out.println("Categoría: " + categoriaC);
                                                    System.out.println("Cantidad necesaria: " + cantidadC);
                                                    //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                                    System.out.println("Cantidad financiada hasta el momento: ");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("MODIFICAR PROYECTOS");
                                                if (proyectos == 0) {
                                                    System.out.println("No hay ningún proyecto creado aún");
                                                } else {
                                                    System.out.println("¿Qué proyecto desea modificar?");
                                                    System.out.println("Introduzca el número del proyecto");
                                                    int numpro=0;
                                                    while (numpro!=1 || numpro!=2 || numpro!=3) {
                                                        if (proyectos == 1) {
                                                            System.out.println("Proyecto 1: " + nombreProyectoA);
                                                        } else if (proyectos == 2) {
                                                            System.out.println("Proyecto 1: " + nombreProyectoA);
                                                            System.out.println("Proyecto 2: " + nombreProyectoB);
                                                        } else if (proyectos == 3) {
                                                            System.out.println("Proyecto 1: " + nombreProyectoA);
                                                            System.out.println("Proyecto 2: " + nombreProyectoB);
                                                            System.out.println("Proyecto 3: " + nombreProyectoC);
                                                        }
                                                        numpro = Integer.parseInt(s.next());
                                                        if (numpro!= 1 || numpro !=2 || numpro != 3);
                                                        System.out.println("Debes introducir el número correspondiente");
                                                    }
                                                    switch (numpro){
                                                        case 1:
                                                            System.out.print("Introduzca el nombre del proyecto: ");
                                                            nombreProyectoA = s.next();
                                                            System.out.print("Introduzca la descripción del proyecto: ");
                                                            descripcionProyectoA = s.next();
                                                            System.out.println("Ingrese la categoría del proyecto: ");
                                                            System.out.println("1. Arte");
                                                            System.out.println("2. Tecnología");
                                                            System.out.println("3. Cine");
                                                            System.out.println("4. Música");
                                                            System.out.println("5. Juegos");
                                                            System.out.println("6. Comida");
                                                            System.out.println("7. Moda");
                                                            categoriaA = Integer.parseInt(s.next());
                                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                            cantidadA = Integer.parseInt(s.next());
                                                            break;
                                                        case 2:
                                                            System.out.print("Introduzca el nombre del proyecto: ");
                                                            nombreProyectoB = s.next();
                                                            System.out.println("Introduzca la descripción del proyecto: ");
                                                            descripcionProyectoB = s.next();
                                                            System.out.print("Ingrese la categoría del proyecto: ");
                                                            System.out.println("1. Arte");
                                                            System.out.println("2. Tecnología");
                                                            System.out.println("3. Cine");
                                                            System.out.println("4. Música");
                                                            System.out.println("5. Juegos");
                                                            System.out.println("6. Comida");
                                                            System.out.println("7. Moda");
                                                            categoriaB = Integer.parseInt(s.next());
                                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                            cantidadB = Integer.parseInt(s.next());
                                                            break;
                                                        case 3:
                                                            System.out.print("Introduzca el nombre del proyecto: ");
                                                            nombreProyectoC = s.next();
                                                            System.out.println("Introduzca la descripción del proyecto: ");
                                                            descripcionProyectoC = s.nextLine();
                                                            System.out.print("Ingrese la categoría del proyecto: ");
                                                            System.out.println("1. Arte");
                                                            System.out.println("2. Tecnología");
                                                            System.out.println("3. Cine");
                                                            System.out.println("4. Música");
                                                            System.out.println("5. Juegos");
                                                            System.out.println("6. Comida");
                                                            System.out.println("7. Moda");
                                                            categoriaC = Integer.parseInt(s.next());
                                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                            cantidadC = Integer.parseInt(s.next());
                                                            break;
                                                    }
                                                }
                                        }
                                    }
                                    break;
                            }

                        case 3:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do{
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = Integer.parseInt(s.next());
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", administrador);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        administrador = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaAdministrador);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaAdministrador = s.next();
                                        break;
                                    case 3:
                                        System.out.println("Cambios guardados.");
                                        break;
                                    default:
                                        System.out.println("Opción inválida.");
                                        break;
                                }
                            }while (opcion!=3);
                            break;

                        case 4:
                            System.out.println("Salir. Usted volverá al login.");
                            break;

                        default:
                            System.out.println("Por favor, introduzca una opcion válida (1 - 4)");
                            break;
                    }
                } while (menu != 4);

            }else if(contrasena.equals(contrasenaGestor)){
                System.out.println("Bienvenido. Cuenta de gestor");
                do {
                    System.out.println("1. Mis proyectos");
                    System.out.println("2. Configuración");
                    System.out.println("3. Cerrar sesión");
                    menu = Integer.parseInt(s.next());
                    switch (menu) {
                        case 1:
                            System.out.println("MIS PROYECTOS");
                            if (proyectos == 0) {
                                System.out.println("Aún no hay proyectos");
                                System.out.println("¿Desea crear un proyecto? (s/n)");
                                String respuesta = s.next();
                                if (respuesta.equals("s")) {
                                    System.out.println("Introduzca el nombre del proyecto: ");
                                    nombreProyectoA = s.next();
                                    System.out.println("Introduzca la descripción del proyecto: ");
                                    descripcionProyectoA = s.next();
                                    System.out.println("Ingrese la categoría del proyecto: ");
                                    System.out.println("1. Arte");
                                    System.out.println("2. Tecnología");
                                    System.out.println("3. Cine");
                                    System.out.println("4. Música");
                                    System.out.println("5. Juegos");
                                    System.out.println("6. Comida");
                                    System.out.println("7. Moda");
                                    categoriaA = Integer.parseInt(s.next());
                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                    cantidadA = Integer.parseInt(s.next());
                                    proyectos+=1;
                                    break;
                                } else if (respuesta.equals("n")) {
                                    System.out.println("No hay proyectos existentes");
                                } else {
                                    System.out.println("Tiene que introducir una respuesta");
                                }
                                break;
                            } else if (proyectos>0) {
                                //Submenu del gestor
                                System.out.println("1. Crear Proyectos");
                                System.out.println("2. Consultar proyectos");
                                System.out.println("3. Modificar proyectos");
                                opcion = s.nextInt();
                                switch (opcion) {
                                    case 1:
                                        if (proyectos == 1) {
                                            //segundo proyecto

                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoB = s.next();
                                            System.out.println("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoB = s.next();
                                            System.out.print("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaB = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadB = Integer.parseInt(s.next());

                                        } else if (proyectos == 2) {
                                            //tercer proyecto

                                            System.out.print("Introduzca el nombre del proyecto: ");
                                            nombreProyectoC = s.next();
                                            System.out.print("Introduzca la descripción del proyecto: ");
                                            descripcionProyectoC = s.next();
                                            System.out.println("Ingrese la categoría del proyecto: ");
                                            System.out.println("1. Arte");
                                            System.out.println("2. Tecnología");
                                            System.out.println("3. Cine");
                                            System.out.println("4. Música");
                                            System.out.println("5. Juegos");
                                            System.out.println("6. Comida");
                                            System.out.println("7. Moda");
                                            categoriaC = Integer.parseInt(s.next());
                                            System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                            cantidadC = Integer.parseInt(s.next());

                                        } else if (proyectos == 3) {
                                            System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("CONSULTA DE PROYECTOS");
                                        System.out.println();
                                        if (proyectos == 1) {
                                            System.out.println(nombreProyectoA);
                                            System.out.println("Categoría: " + categoriaA);
                                            System.out.println("Cantidad necesaria: " + cantidadA);
                                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                            System.out.println("Cantidad financiada hasta el momento: ");
                                        } else if (proyectos == 2) {
                                            System.out.println(nombreProyectoB);
                                            System.out.println("Categoría: " + categoriaB);
                                            System.out.println("Cantidad necesaria: " + cantidadB);
                                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                            System.out.println("Cantidad financiada hasta el momento: ");
                                        } else if (proyectos == 3) {
                                            System.out.println(nombreProyectoC);
                                            System.out.println("Categoría: " + categoriaC);
                                            System.out.println("Cantidad necesaria: " + cantidadC);
                                            //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                                            System.out.println("Cantidad financiada hasta el momento: ");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("MODIFICAR PROYECTOS");
                                        if (proyectos == 0) {
                                            System.out.println("No hay ningún proyecto creado aún");
                                        } else {
                                            System.out.println("¿Qué proyecto desea modicicar?");
                                            System.out.println("Introduzca el número del proyecto");
                                            int numpro=0;
                                            while (numpro!=1 || numpro!=2 || numpro!=3) {
                                                if (proyectos == 1) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                } else if (proyectos == 2) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                } else if (proyectos == 3) {
                                                    System.out.println("Proyecto 1: " + nombreProyectoA);
                                                    System.out.println("Proyecto 2: " + nombreProyectoB);
                                                    System.out.println("Proyecto 3: " + nombreProyectoC);
                                                }
                                                numpro = Integer.parseInt(s.next());
                                                if (numpro!= 1 || numpro !=2 || numpro != 3);
                                                System.out.println("Debes introducir el número correspondiente");
                                            }
                                            switch (numpro){
                                                case 1:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoA = s.next();
                                                    System.out.print("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoA = s.nextLine();
                                                    System.out.println("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaA = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadA = Integer.parseInt(s.next());
                                                    break;
                                                case 2:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoB = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoB = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaB = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadB = Integer.parseInt(s.next());
                                                    break;
                                                case 3:
                                                    System.out.print("Introduzca el nombre del proyecto: ");
                                                    nombreProyectoC = s.next();
                                                    System.out.println("Introduzca la descripción del proyecto: ");
                                                    descripcionProyectoC = s.next();
                                                    System.out.print("Ingrese la categoría del proyecto: ");
                                                    System.out.println("1. Arte");
                                                    System.out.println("2. Tecnología");
                                                    System.out.println("3. Cine");
                                                    System.out.println("4. Música");
                                                    System.out.println("5. Juegos");
                                                    System.out.println("6. Comida");
                                                    System.out.println("7. Moda");
                                                    categoriaC = Integer.parseInt(s.next());
                                                    System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                                    cantidadC = Integer.parseInt(s.next());
                                                    break;
                                                default:
                                                    while (numpro!=1 || numpro!=2 || numpro!=3) {
                                                        System.out.println("Debes introducir el número correspondiente");
                                                        numpro = Integer.parseInt(s.next());
                                                    }
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("CONFIGURACION. Seleccione una opción: ");
                            do {
                                System.out.println("1. Cambiar usuario");
                                System.out.println("2. Cambiar contraseña");
                                System.out.println("3. Guardar cambios");
                                opcion = Integer.parseInt(s.next());
                                switch (opcion) {
                                    case 1:
                                        System.out.printf("Usuario actual -> %s\n", gestor);
                                        System.out.println("Introduzca su nuevo usuario: ");
                                        gestor = s.next();
                                        break;
                                    case 2:
                                        System.out.printf("Contraseña actual -> %s\n", contrasenaGestor);
                                        System.out.println("Introduzca su nueva contraseña: ");
                                        contrasenaGestor = s.next();
                                        break;
                                    case 3:
                                        System.out.println("Cambios guardados");
                                        break;
                                    default:
                                        System.out.println("Por favor, introduzca una opción válida.");
                                        break;
                                }
                            }while (opcion!=3);
                            break;
                        case 3:
                            System.out.println("Saliendo. Se le está redirigiendo al login.");
                            break;
                        default:
                            System.out.println("Por favor, introduce una opcion válida (1 - 3)");
                    }
                } while (menu!=3);
            }
        }while(sesion);
    }
}