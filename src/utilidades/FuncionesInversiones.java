package utilidades;

import java.util.Scanner;
public class FuncionesInversiones {
    Scanner s = new Scanner(System.in);

    int saldo = 0, saldoTotal1 = 0, saldoTotal2 = 0;
    String inversionesA1=" ", inversionesB1=" ", inversionesC1=" ", inversionesA2=" ", inversionesB2=" ", inversionesC2=" ";

    public static void MenuProyectoInversion(){
        System.out.println("¿En qué proyecto desea invertir?");
        System.out.println("1. Proyecto 1: " + nombreProyecto[0]);
        System.out.println("2. Proyecto 2: " + nombreProyecto[1]);
        System.out.println("3. Proyecto 3: " + nombreProyecto[2]);
        System.out.println("4. Salir");
    }

    public static int cantidadAportadaA1 (){
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[0] = Integer.parseInt(s.next());
        if (cantidadAportada1[0] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversion1[0] = true;
            saldoTotal1 -= cantidadAportada1[0];
            cantidadAportada[0] += cantidadAportada1[0];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaA1();
    }
    public static int cantidadAportadaB1 () {
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[1] = Integer.parseInt(s.next());
        if (cantidadAportada1[1] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversion1[1] = true;
            saldoTotal1 -= cantidadAportada1[0];
            cantidadAportada[1] += cantidadAportada1[1];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaB1();
    }
    public static int cantidadAportadaC1 () {
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada1[2] = Integer.parseInt(s.next());
        if (cantidadAportada1[2] > saldoTotal1) {
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: " + saldoTotal1 + "€");
            break;
        } else {
            inversion1[2] = true;
            saldoTotal1 -= cantidadAportada1[2];
            cantidadAportada[2] += cantidadAportada1[2];
            inversiones1++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaC1();
    }

    public static int cantidadAportadaA2 (){
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[0] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[0] = Integer.parseInt(s.next());
        if (cantidadAportada2[0]>saldoTotal1){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
            break;
        }else{
            inversion2[0] = true;
            saldoTotal2-=cantidadAportada2[0];
            cantidadAportada[0]+=cantidadAportada2[0];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaA2();
    }
    public static int cantidadAportadaB2 () {
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[1] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[1] = Integer.parseInt(s.next());
        if (cantidadAportada2[1]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
            break;
        }else{
            inversion2[1] = true;
            saldoTotal2-=cantidadAportada2[1];
            cantidadAportada[1]+=cantidadAportada2[1];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaB2();
    }
    public static int cantidadAportadaC2 () {
        System.out.println("La cantidad necesaria de este proyecto es de " + cantidad[2] + "€");
        System.out.println("¿Que cantidad desea aportar?");
        cantidadAportada2[2] = Integer.parseInt(s.next());
        if (cantidadAportada2[2]>saldoTotal2){
            System.out.println("No dispone de saldo suficiente para realizar la aportación.");
            System.out.println("Su saldo es de: "+saldoTotal2 + "€");
            break;
        }else{
            inversion2[2] = true;
            saldoTotal2-=cantidadAportada2[2];
            cantidadAportada[2]+=cantidadAportada2[2];
            inversiones2++;
            System.out.println("¡¡¡Gracias por aportar su parte!!!");
            break;
        }
        return cantidadAportadaC2();
    }

    public static void inversionA1 () {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionB1 () {
        System.out.println();
        System.out.println(nombreProyecto[1]);
        System.out.print("Categoría: ");
        System.out.println(categoria[1]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[1]+ "€");
        System.out.println();
    }
    public static void inversionC1 () {
        System.out.println();
        System.out.println(nombreProyecto[2]);
        System.out.print("Categoría: ");
        System.out.println(categoria[2]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[2]+ "€");
        System.out.println();
    }
    public static void inversionA2 () {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionB2 () {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
    public static void inversionC2 () {
        System.out.println();
        System.out.println(nombreProyecto[0]);
        System.out.print("Categoría: ");
        System.out.println(categoria[0]);
        System.out.print("Cantidad aportada: ");
        System.out.println(cantidadAportada[0]+ "€");
        System.out.println();
    }
}
