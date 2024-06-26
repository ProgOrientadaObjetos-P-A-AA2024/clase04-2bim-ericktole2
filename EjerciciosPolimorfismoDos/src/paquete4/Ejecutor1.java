/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor1 {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Arriendo> listaArriendos = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarArriendoLocalComida();
                    break;

                case 2:
                    agregarArriendoLocalComercial();
                    break;

                case 3:
                    agregarArriendoLocalSesiones();
                    break;

                case 4:
                    mostrarCentroComercial();
                    break;

                default:
                    System.out.println("Opción invalida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 4);

    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Arriendo Local de Comida");
        System.out.println("2. Arriendo Local Comercial");
        System.out.println("3. Arriendo Local de Sesiones");
        System.out.println("4. Mostrar Centro Comercial y salir");
        System.out.print("Ingrese la opcion deseada: ");
    }

    private static void agregarArriendoLocalComida() {
        System.out.print("Ingrese el nombre del arrendatario: ");
        String nombreComida = sc.nextLine();
        System.out.print("Ingrese el valor base del arriendo mensual: ");
        double valorBaseComida = sc.nextDouble();

        ArriendoLocalComida arriendoComida = new ArriendoLocalComida(nombreComida, valorBaseComida);
        System.out.print("Ingrese el valor del IVA : ");
        double ivaComida = sc.nextDouble();
        arriendoComida.establecerIva(ivaComida);

        System.out.print("Ingrese el valor del agua : ");
        double valorAguaComida = sc.nextDouble();
        arriendoComida.establecerValorAgua(valorAguaComida);

        System.out.print("Ingrese el valor de la luz : ");
        double valorLuzComida = sc.nextDouble();
        arriendoComida.establecerValorLuz(valorLuzComida);

        listaArriendos.add(arriendoComida);
    }

    private static void agregarArriendoLocalComercial() {
        System.out.print("Ingrese el nombre del arrendatario: ");
        String nombreComercial = sc.nextLine();
        System.out.print("Ingrese el valor base del arriendo mensual: ");
        double valorBaseComercial = sc.nextDouble();

        ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(nombreComercial, valorBaseComercial);
        System.out.print("Ingrese el valor adicional fijo ($): ");
        double valorAdicionalComercial = sc.nextDouble();
        arriendoComercial.establecerValorAdicionalFijo(valorAdicionalComercial);

        listaArriendos.add(arriendoComercial);
    }

    private static void agregarArriendoLocalSesiones() {
        System.out.print("Ingrese el nombre del arrendatario: ");
        String nombreSesiones = sc.nextLine();
        System.out.print("Ingrese el valor base del arriendo mensual: ");
        double valorBaseSesiones = sc.nextDouble();

        ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(nombreSesiones, valorBaseSesiones);
        System.out.print("Ingrese el valor de las sillas ($): ");
        double valorSillas = sc.nextDouble();
        arriendoSesiones.establecerValorSillas(valorSillas);

        System.out.print("Ingrese el valor de la amplificación ($): ");
        double valorAmplificacion = sc.nextDouble();
        arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);

        listaArriendos.add(arriendoSesiones);
    }

    private static void mostrarCentroComercial() {
        CentroComercial centro = new CentroComercial("La Pradera", listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);
    }
}
