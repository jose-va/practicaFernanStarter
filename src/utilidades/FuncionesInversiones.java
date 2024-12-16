package utilidades;

import java.util.Scanner;
public class FuncionesInversiones {


    public static void MenuProyectoInversion(String[] nombreProyecto){
        System.out.println("¿En qué proyecto desea invertir?");
        System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
        System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
        System.out.println("3. Proyecto 3: " + nombreProyecto[2]);
        System.out.println("4. Salir");
    }


    public static int crearInversionA1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1){
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[0] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[0] = true;
            saldoTotal1 -= cantidadAportada1[0];
            cantidadAportada[0] += cantidadAportada1[0];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionA1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }
    public static int crearInversionB1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[1] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[1] = true;
            saldoTotal1 -= cantidadAportada1[1];
            cantidadAportada[1] += cantidadAportada1[1];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionB1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }
    public static int crearInversionC1(int[] cantidad, int[] cantidadAportada1, int saldoTotal1, boolean[] inversion1, int[] cantidadAportada, int inversiones1) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = s.nextInt();
        if (cantidadAportada1[2] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
        } else {
            inversion1[2] = true;
            saldoTotal1 -= cantidadAportada1[2];
            cantidadAportada[2] += cantidadAportada1[2];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionC1(cantidad, cantidadAportada1, saldoTotal1, inversion1, cantidadAportada, inversiones1);
    }




    public static int crearInversionA2(int[] cantidad, int[] cantidadAportada2, int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2){
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[0]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[0] = true;
            saldoTotal2-=cantidadAportada2[0];
            cantidadAportada[0]+=cantidadAportada2[0];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionA2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
    }

    public static int crearInversionB2 (int[] cantidad, int[] cantidadAportada2, int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[1]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[1] = true;
            saldoTotal2-=cantidadAportada2[1];
            cantidadAportada[1]+=cantidadAportada2[1];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionB2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
    }
    public static int crearInversionC2 (int[] cantidad, int[] cantidadAportada2,int saldoTotal2, boolean[] inversion2, int[] cantidadAportada, int inversiones2) {
        Scanner s = new Scanner(System.in);
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = s.nextInt();
        if (cantidadAportada2[2]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
        }else{
            inversion2[2] = true;
            saldoTotal2-=cantidadAportada2[2];
            cantidadAportada[2]+=cantidadAportada2[2];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
        }
        return crearInversionC2(cantidad, cantidadAportada2, saldoTotal2, inversion2, cantidadAportada, inversiones2);
    }




    public static void inversionA1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionB1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[1]);
        System.out.print("Categoría: ");
        System.out.println(categoria[1]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[1]+ "€");
        System.out.println();
    }
    public static void inversionC1 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[2]);
        System.out.print("Categoría: ");
        System.out.println(categoria[2]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[2]+ "€");
        System.out.println();
    }
    public static void inversionA2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionB2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionC2 (String[]nombreProyecto, String[]categoria, int[]cantidadAportada) {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }








    //-------------------------------------------------------------------------------------------------------------------------------------

    public static void anadirSaldo1 (int opcion, int saldoTotal1,int saldo){
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. Saldo actual");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(s.next());
            switch (opcion) {
                case 1:
                    if (saldoTotal1 == 0) {
                        System.out.println("Usted no dispone de saldo.");
                    } else {
                        System.out.printf("Saldo: %d€", saldoTotal1);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("¿Cuánto dinero desea ingresar?");
                    saldo = Integer.parseInt(s.next());
                    saldoTotal1 += saldo;
                    System.out.println("Su saldo ha sido añadido correctamente");
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado salir.");
                    break;
                default:
                    System.out.println("Opcion seleccionada inválida.");
                    break;
            }
        } while (opcion != 3);
    }



    public static void anadirSaldo2 (int opcion, int saldoTotal1,int saldo){
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("1. Saldo actual");
            System.out.println("2. Añadir saldo");
            System.out.println("3. Salir");
            opcion = Integer.parseInt(s.next());
            switch (opcion) {
                case 1:
                    if (saldoTotal1 == 0) {
                        System.out.println("Usted no dispone de saldo.");
                    } else {
                        System.out.printf("Saldo: %d€", saldoTotal1);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("¿Cuánto dinero desea ingresar?");
                    saldo = Integer.parseInt(s.next());
                    saldoTotal1 += saldo;
                    System.out.println("Su saldo ha sido añadido correctamente");
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado salir.");
                    break;
                default:
                    System.out.println("Opcion seleccionada inválida.");
                    break;
            }
        } while (opcion != 3);
    }
}