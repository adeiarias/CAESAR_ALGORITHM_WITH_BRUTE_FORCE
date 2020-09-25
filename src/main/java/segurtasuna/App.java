/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package segurtasuna;

import jdk.swing.interop.SwingInterOpUtils;
import org.checkerframework.checker.units.qual.C;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ESTE ES UN PROGRAMA PARA ENCRIPTAR Y DESENCRIPTAR MENSAJES CON EL METODO CAESAR");
        System.out.println("QUE QUIERES HACER:");

        int numero = 0;
        do {
            System.out.println("ESCRIBE 1 SI QUIERES ENCRIPTAR UN MENSAJE");
            System.out.println("ESCRIBE 2 SI QUIERES DESENCRIPTAR UN MENSAJE");
            try {
                numero = sc.nextInt();
                sc.nextLine();
                System.out.println(" ");
            }catch (InputMismatchException e){
                System.out.println("SAR EZAZU ZENBAKI BAT MESEDEZ");
                System.out.println(" ");
                sc.next();
            }
        }while(numero!=1 && numero!=2);



        if(numero == 1){

            System.out.println("ESCRIBE EL MENSAJE QUE QUIERES ENCRIPTAR");
            String mensaje = sc.nextLine();
            System.out.println("CUAL ES LA CLAVE(TIENE QUE SER UN NUMERO)");

            int clave = 0;
            try{
                clave = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("NO HAS PUESTO UN NUMERO...");
                System.exit(0);
            }

            String res = new Caesar(clave).encriptar(mensaje);
            System.out.println("TU MENSAJE ENCRIPTADO ES EL SIGUIENTE "+res);

        }else{

            System.out.println("ESCRIBE EL MENSAJE QUE QUIERES DESENCRIPTAR");
            String mensaje = sc.nextLine();
            System.out.println("SABES CUAL ES LA CLAVE CON LA CUAL SE HA ENCRIPTADO EL MENSAJE");
            System.out.println("ESCRIBE YES, SI LO SABES");
            System.out.println("ESCRIBE NO, SI NO LO SABES");
            String respuesta = sc.nextLine();
            respuesta = respuesta.toUpperCase();

            if(respuesta.equals("YES")) {

                System.out.println("CUAL ES LA CLAVE(TIENE QUE SER UN NUMERO)");

                int clave = 0;
                try{
                    clave = sc.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("NO HAS PUESTO UN NUMERO...");
                    System.exit(0);
                }

                String res = new Caesar(clave).desencriptar(mensaje);
                System.out.println("TU MENSAJE DESENCRIPTADO ES EL SIGUIENTE "+res);

            }else if(respuesta.equals("NO")){

                System.out.println("SE APLICARA BRUTE FORCE...");
                new Brute_Force().crackear(mensaje);

            }else{
                System.out.println("NO TE PUEDO AYUDAR, LO SIENTO");
            }
        }
    }
}
