/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package segurtasuna;

import org.checkerframework.checker.units.qual.C;

public class App {

    public static void main(String[] args) {
        Caesar c = new Caesar(3);
        String res = c.encriptar("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("EL RESULTADO ES EL SIGUIENTE: "+res);
    }
}
