package segurtasuna;

import java.util.HashSet;

public class Brute_Force {

    private Character[] alfabeto;
    private HashSet<Character> alfa;

    public Brute_Force(){
        inicializarALfabeto();
    }

    private void inicializarALfabeto(){
        alfabeto = new Character[26];
        alfa = new HashSet<Character>();
        int j = 0;
        for(int i = 65; i < 91; i++){
            alfabeto[j] = (char)i;
            alfa.add((char)i);
            j++;
        }
    }

    public void crackear(String mensaje){
        String res;
        for(int i = 0; i < 26; i++){
            res = "";
            res = desen(mensaje,i);
            System.out.println("ITERACION "+(i+1)+": "+res+" | CLAVE DE ENCRIPTACION: "+i);
        }
    }

    private String  desen(String mensaje, int numero){
            mensaje = mensaje.toUpperCase();
            Character c;
            int valorAscii,valorEncrip,index;
            String resultado = "";
            for(int i = 0; i < mensaje.length(); i++){
                c = mensaje.charAt(i);
                if(!alfa.contains(c)){
                    resultado = resultado + Character.toString(c);
                }else{
                    valorAscii = (int)c;
                    index = valorAscii - 65;
                    valorEncrip = (((index - numero) + 26) % 26) + 65;
                    resultado = resultado + Character.toString((char)valorEncrip);
                }
            }
            return resultado;
    }

}
