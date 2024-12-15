package biblioteca;

import java.util.Scanner;
public class FuncionesInversiones {
    Scanner s = new Scanner(System.in);

    //Apartado de Invertir

    public static int cantidadAportadaA1 (int cantidadAportadaA1){
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadA + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportadaA1 = Integer.parseInt(s.next());
        if (cantidadAportadaA1 > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversionA1 = true;
            saldoTotal1 -= cantidadAportadaA1;
            cantidadAportadaA += cantidadAportadaA1;
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
    }return cantidadAportadaA1;
    public static int cantidadAportadaB1 (int cantidadAportadaB1){
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadB + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportadaB1 = Integer.parseInt(s.next());
        if (cantidadAportadaB1 > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversionB1 = true;
            saldoTotal1 -= cantidadAportadaB1;
            cantidadAportadaB += cantidadAportadaB1;
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
    }
    public static int cantidadAportadaC1 (int cantidadAportadaC1){
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidadC + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportadaC1 = Integer.parseInt(s.next());
        if (cantidadAportadaC1 > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversionC1 = true;
            saldoTotal1 -= cantidadAportadaC1;
            cantidadAportadaC += cantidadAportadaC1;
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
    }
    public static string consultainversionA1 (String consultainversionA1){
        System.out.println();
        System.out.println(nombreProyectoA);
        System.out.print("Categoría: ");
        System.out.println(categoriaA);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaA+ "€");
        System.out.println();
    }
    public static string consultainversionB1 (String consultainversionB1){
        System.out.println();
        System.out.println(nombreProyectoB);
        System.out.print("Categoría: ");
        System.out.println(categoriaB);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaB+ "€");
        System.out.println();
    }
    public static string consultainversionC1 (String consultainversionC1){
        System.out.println();
        System.out.println(nombreProyectoC);
        System.out.print("Categoría: ");
        System.out.println(categoriaC);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaC+ "€");
        System.out.println();
    }
    public static string consultainversionA2 (String consultainversionA2){
        System.out.println();
        System.out.println(nombreProyectoA);
        System.out.print("Categoría: ");
        System.out.println(categoriaA);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaA+ "€");
        System.out.println();
    }
    public static string consultainversionB2 (String consultainversionB2){
        System.out.println();
        System.out.println(nombreProyectoB);
        System.out.print("Categoría: ");
        System.out.println(categoriaB);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaB+ "€");
        System.out.println();
    }
    public static string consultainversionC2 (String consultainversionC2){
        System.out.println();
        System.out.println(nombreProyectoC);
        System.out.print("Categoría: ");
        System.out.println(categoriaC);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportadaC+ "€");
        System.out.println();
    }



}
