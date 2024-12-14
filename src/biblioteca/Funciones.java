package biblioteca;

import java.util.Scanner;

import static biblioteca.EnvioGMail.enviarConGMail;

public class Funciones {
    public static void autentificacion(String usuario) {
        Scanner s = new Scanner(System.in);

        int codigo= (int) (Math.random()*8999+1000);
        String asunto = "Código de autentificación";
        String cuerpo = "<h1>Su código es el siguiente: <h1>" + codigo;

        System.out.printf("%s, verificación necesaria.", usuario);
        System.out.println("Introduzca su correo electrónico para recibir un código de un solo uso: ");
        String destinatario= s.nextLine();
        enviarConGMail(destinatario, asunto, cuerpo);

        System.out.printf("Introduzca el código enviado a %s ", destinatario);
        int codigoUsuario= Integer.parseInt(s.nextLine());
        do{
            if (codigoUsuario==codigo){
                System.out.println("Ha iniciado sesión correctamente.");
                break;
            }else{
                System.out.println("Código incorrecto. Por favor, introduzca el código recibido.");
                System.out.printf("Correo electrónico -> %s", destinatario);
            }
        } while(codigoUsuario!=codigo);
    }
    public static void proyectos(){
        System.out.println("MIS PROYECTOS");
        if (proyectos == 0) {
            System.out.println("Aún no hay proyectos");
            System.out.println("¿Desea crear un proyecto? (s/n)");
            String respuesta = s.next();
            if (respuesta.equals("s")) {
                proyectos++;
                System.out.println("Introduzca el nombre del proyecto: ");
                nombreProyectoA = s.next();
                s.nextLine();
                System.out.println("Introduzca la descripción del proyecto: ");
                descripcionProyectoA = s.nextLine();
                System.out.println("Ingrese la categoría del proyecto: ");
                System.out.println("Arte");
                System.out.println("Tecnología");
                System.out.println("Cine");
                System.out.println("Música");
                System.out.println("Juegos");
                System.out.println("Comida");
                System.out.println("Moda");
                categoriaA = s.next();
                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                cantidadA = Integer.parseInt(s.next());
                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                fechaAperturaA= s.next();
                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                fechaCierreA= s.next();
                System.out.println("Recompensas del proyecto");
                System.out.println("¿Cuántas desea añadir? (max 3.)");
                recompensasA= Integer.parseInt(s.next());
                System.out.println("Nombre de la primera recompensa: ");
                nombreRecompensaA1= s.next();
                s.nextLine();
                System.out.println("Introduzca una descripción");
                descripcionRecompensaA1= s.nextLine();
                System.out.println("Introduzca el precio: ");
                precioRecompensaA1= Float.parseFloat(s.next());
                if (recompensasA<2) break;
                System.out.println("=================================");
                System.out.println("Nombre de la segunda recompensa: ");
                nombreRecompensaA2= s.next();
                s.nextLine();
                System.out.println("Introduzca una descripción");
                descripcionRecompensaA2= s.nextLine();
                System.out.println("Introduzca el precio: ");
                precioRecompensaA2= Float.parseFloat(s.next());
                if (recompensasA<3) break;
                System.out.println("=================================");
                System.out.println("Nombre de la tercera recompensa: ");
                nombreRecompensaA3= s.next();
                s.nextLine();
                System.out.println("Introduzca una descripción");
                descripcionRecompensaA3= s.nextLine();
                System.out.println("Introduzca el precio: ");
                precioRecompensaA3= Float.parseFloat(s.next());
                break;
            } else if (respuesta.equals("n")) {
                System.out.println("No hay proyectos existentes");
            } else {
                System.out.println("Tiene que introducir una respuesta");
            }
            break;
        } else if (proyectos>0) {
            System.out.println("1. Crear Proyectos");
            System.out.println("2. Consultar proyectos");
            System.out.println("3. Modificar proyectos");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    if (proyectos == 1) {
                        proyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        nombreProyectoB = s.next();
                        s.nextLine();
                        System.out.println("Introduzca la descripción del proyecto: ");
                        descripcionProyectoB = s.nextLine();
                        System.out.print("Ingrese la categoría del proyecto: ");
                        System.out.println("Arte");
                        System.out.println("Tecnología");
                        System.out.println("Cine");
                        System.out.println("Música");
                        System.out.println("Juegos");
                        System.out.println("Comida");
                        System.out.println("Moda");
                        categoriaB = s.next();
                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                        cantidadB = Integer.parseInt(s.next());
                        System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                        fechaAperturaB= s.next();
                        System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                        fechaCierreB= s.next();
                        System.out.println("Recompensas del proyecto");
                        System.out.println("¿Cuántas desea añadir? (max 3.)");
                        recompensasB= Integer.parseInt(s.next());

                        System.out.println("Nombre de la primera recompensa: ");
                        nombreRecompensaB1= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB1= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB1= Float.parseFloat(s.next());
                        if (recompensasB<2) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la segunda recompensa: ");
                        nombreRecompensaB2= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB2= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB2= Float.parseFloat(s.next());
                        if (recompensasB<3) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la tercera recompensa: ");
                        nombreRecompensaB3= s.next();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaB3= s.next();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaB3= Float.parseFloat(s.next());
                        break;

                    } else if (proyectos == 2) {
                        proyectos++;
                        System.out.print("Introduzca el nombre del proyecto: ");
                        nombreProyectoC = s.next();
                        s.nextLine();
                        System.out.print("Introduzca la descripción del proyecto: ");
                        descripcionProyectoC = s.nextLine();
                        System.out.println("Ingrese la categoría del proyecto: ");
                        System.out.println("Arte");
                        System.out.println("Tecnología");
                        System.out.println("Cine");
                        System.out.println("Música");
                        System.out.println("Juegos");
                        System.out.println("Comida");
                        System.out.println("Moda");
                        categoriaC = s.next();
                        System.out.print("Introduzca la cantidad de inversión necesaria: ");
                        cantidadC = Integer.parseInt(s.next());
                        System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                        fechaAperturaC= s.next();
                        System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                        fechaCierreC= s.next();
                        System.out.println("Recompensas del proyecto");
                        System.out.println("¿Cuántas desea añadir? (max 3.)");
                        recompensasC= Integer.parseInt(s.next());
                        System.out.println("Nombre de la primera recompensa: ");
                        nombreRecompensaC1= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC1= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC1= Float.parseFloat(s.next());
                        if (recompensasC<2) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la segunda recompensa: ");
                        nombreRecompensaC2= s.next();
                        s.nextLine();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC2= s.nextLine();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC2= Float.parseFloat(s.next());
                        if (recompensasC<3) break;
                        System.out.println("=================================");
                        System.out.println("Nombre de la tercera recompensa: ");
                        nombreRecompensaC3= s.next();
                        System.out.println("Introduzca una descripción");
                        descripcionRecompensaC3= s.next();
                        System.out.println("Introduzca el precio: ");
                        precioRecompensaC3= Float.parseFloat(s.next());
                        break;
                    } else if (proyectos == 3) {
                        System.out.println("Máximo de proyectos alcanzado. No es posible crear más proyectos");
                    }
                    break;
                case 2:
                    System.out.println("CONSULTA DE PROYECTOS");
                    System.out.println("=================================================");
                    if (proyectos <= 0) {
                        System.out.println("****Actualmente no hay ningún proyecto****");
                        break;
                    }

                    do{
                        System.out.println("PROYECTO 1");
                        System.out.println(nombreProyectoA);
                        System.out.println("Categoría: " + categoriaA);
                        System.out.println("Cantidad necesaria: " + cantidadA + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportadaA + "€");
                        if (proyectos<2) break;
                        System.out.println("=================================================");
                        System.out.println("PROYECTO 2");
                        System.out.println(nombreProyectoB);
                        System.out.println("Categoría: " + categoriaB);
                        System.out.println("Cantidad necesaria: " + cantidadB + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportadaB + "€");
                        if (proyectos<3) break;
                        System.out.println("=================================================");
                        System.out.println("PROYECTO 3");
                        System.out.println(nombreProyectoC);
                        System.out.println("Categoría: " + categoriaC);
                        System.out.println("Cantidad necesaria: " + cantidadC + "€");
                        //Introducir la variable correspondiente para la cantidad financiada hasta el momento
                        System.out.println("Cantidad financiada hasta el momento: " + cantidadAportadaC + "€");
                        break;
                    }while (proyectos>0);

                    System.out.println("========================================================================");
                    System.out.println("Por favor, seleccione un proyecto para mostrar información detallada: ");
                    opcion= Integer.parseInt(s.next());
                    switch (opcion){
                        case 1:
                            if (proyectos <=0){
                                System.out.println("No existe el proyecto");
                            }else {
                                System.out.println(nombreProyectoA);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyectoA);
                                System.out.print("Categoría: ");
                                System.out.println(categoriaA);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidadA + "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportadaA + "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaAperturaA + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierreA + "/12/2024");
                                grafico= (float) (cantidadAportadaA*100)/cantidadA;
                                System.out.println("Gráfica de financiación");
                                System.out.print(grafico + "% \u2192 ");
                                for(int i=0; i<=grafico; i++){
                                    System.out.print("\u001B[36m\u275A");
                                    if (i==100) break;
                                }
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaA1);
                                System.out.println(descripcionRecompensaA1);
                                System.out.println(precioRecompensaA1 + "€");
                                if (recompensasA==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaA2);
                                System.out.println(descripcionRecompensaA2);
                                System.out.println(precioRecompensaA2 + "€");
                                if (recompensasA==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaA3);
                                System.out.println(descripcionRecompensaA3);
                                System.out.println(precioRecompensaA3 + "€");

                            }
                            break;
                        case 2:
                            if (proyectos <2){
                                System.out.println("No existe el proyecto.");
                            }else {
                                System.out.println(nombreProyectoB);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyectoB);
                                System.out.print("Categoría: ");
                                System.out.println(categoriaB);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidadB+ "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportadaB+ "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaAperturaB + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierreB + "/12/2024");
                                grafico= (float) (cantidadAportadaB*100)/cantidadB;
                                System.out.println("Gráfica de financiación");
                                System.out.print(grafico + "% \u2192 ");
                                for(int i=0; i<=grafico; i++){
                                    System.out.print("\u001B[36m\u275A");
                                    if (i==100) break;
                                }
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaB1);
                                System.out.println(descripcionRecompensaB1);
                                System.out.println(precioRecompensaB1 + "€");
                                if (recompensasB==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaB2);
                                System.out.println(descripcionRecompensaB2);
                                System.out.println(precioRecompensaB2 + "€");
                                if (recompensasB==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaB3);
                                System.out.println(descripcionRecompensaB3);
                                System.out.println(precioRecompensaB3 + "€");

                            }
                            break;
                        case 3:
                            if (proyectos <3){
                                System.out.println("No existe el proyecto.");
                            }else {
                                System.out.println(nombreProyectoC);
                                System.out.print("Descripción: ");
                                System.out.println(descripcionProyectoC);
                                System.out.print("Categoría: ");
                                System.out.println(categoriaC);
                                System.out.print("Cantidad necesaria: ");
                                System.out.println(cantidadC+ "€");
                                System.out.print("Cantidad aportada hasta el momento: ");
                                System.out.println(cantidadAportadaC+ "€");
                                System.out.print("Fecha de apertura: ");
                                System.out.println(fechaAperturaC + "/12/2024");
                                System.out.print("Fecha de cierre: ");
                                System.out.println(fechaCierreC + "/12/2024");

                                grafico= (float) (cantidadAportadaC*100)/cantidadC;
                                System.out.println("Gráfica de financiación");
                                System.out.print(grafico + "% \u2192 ");
                                for(int i=0; i<=grafico; i++){
                                    System.out.print("\u001B[36m\u275A");
                                    if (i==100) break;
                                }
                                System.out.println();
                                System.out.println("\u001B[0mRECOMPENSA 1");
                                System.out.println(nombreRecompensaC1);
                                System.out.println(descripcionRecompensaC1);
                                System.out.println(precioRecompensaC1 + "€");
                                if (recompensasB==1) break;
                                System.out.println("RECOMPENSA 2");
                                System.out.println(nombreRecompensaC2);
                                System.out.println(descripcionRecompensaC2);
                                System.out.println(precioRecompensaC2 + "€");
                                if (recompensasB==2) break;
                                System.out.println("RECOMPENSA 3");
                                System.out.println(nombreRecompensaC3);
                                System.out.println(descripcionRecompensaC3);
                                System.out.println(precioRecompensaC3 + "€");

                            }
                            break;
                        default:
                            System.out.println("Debe seleccionar un proyecto válido.");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("MODIFICAR PROYECTOS");
                    if (proyectos == 0) {
                        System.out.println("No hay ningún proyecto creado aún");
                    } else {
                        System.out.println("¿Qué proyecto desea modificar?");
                        System.out.println("Introduzca el número del proyecto");
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
                        while (numpro != 1 && numpro != 2 && numpro != 3){
                            System.out.println("Debes introducir el número correspondiente");
                            numpro = Integer.parseInt(s.next());
                        }
                        switch (numpro) {
                            case 1:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyectoA = s.next();
                                s.nextLine();
                                System.out.print("Introduzca la descripción del proyecto: ");
                                descripcionProyectoA = s.nextLine();
                                System.out.println("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoriaA = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidadA = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaAperturaA= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierreA= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaA1= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA1= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA1= Float.parseFloat(s.next());
                                if (recompensasA==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaA2= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA2= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA2= Float.parseFloat(s.next());
                                if (recompensasA==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaA3= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaA3= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaA3= Float.parseFloat(s.next());
                                break;
                            case 2:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyectoB = s.next();
                                s.nextLine();
                                System.out.println("Introduzca la descripción del proyecto: ");
                                descripcionProyectoB = s.nextLine();
                                System.out.print("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoriaB = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidadB = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaAperturaB= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierreB= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaB1= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB1= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB1= Float.parseFloat(s.next());
                                if (recompensasB==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaB2= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB2= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB2= Float.parseFloat(s.next());
                                if (recompensasB==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaB3= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaB3= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaB3= Float.parseFloat(s.next());
                                break;
                            case 3:
                                System.out.print("Introduzca el nombre del proyecto: ");
                                nombreProyectoC = s.next();
                                s.nextLine();
                                System.out.println("Introduzca la descripción del proyecto: ");
                                descripcionProyectoC = s.nextLine();
                                System.out.print("Ingrese la categoría del proyecto: ");
                                System.out.println("Arte");
                                System.out.println("Tecnología");
                                System.out.println("Cine");
                                System.out.println("Música");
                                System.out.println("Juegos");
                                System.out.println("Comida");
                                System.out.println("Moda");
                                categoriaC = s.next();
                                System.out.print("Introduzca la cantidad de inversión necesaria: ");
                                cantidadC = Integer.parseInt(s.next());
                                System.out.println("Introduzca la fecha de apertura para recibir inversiones: ");
                                fechaAperturaC= s.next();
                                System.out.println("Introduzca la fecha de cierre de las inversiones: ");
                                fechaCierreC= s.next();
                                System.out.println("Recompensas del proyecto.");
                                System.out.println("Nombre de la primera recompensa: ");
                                nombreRecompensaC1= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC1= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC1= Float.parseFloat(s.next());
                                if (recompensasC==1) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la segunda recompensa: ");
                                nombreRecompensaC2= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC2= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC2= Float.parseFloat(s.next());
                                if (recompensasC==2) break;
                                System.out.println("================================");
                                System.out.println("Nombre de la tercera recompensa: ");
                                nombreRecompensaC3= s.next();
                                s.nextLine();
                                System.out.println("Introduzca una descripción");
                                descripcionRecompensaC3= s.nextLine();
                                System.out.println("Introduzca el precio: ");
                                precioRecompensaC3= Float.parseFloat(s.next());
                                break;
                        }
                    }
                    break;
            }
            break;
        }
    }


}
