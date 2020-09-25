package segurtasuna;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashSet;

public class Caesar {

    private Character[] alfabeto;
    private HashSet<Character> alfa;
    private int numero;

    public Caesar(int n){

        inicializarALfabeto();
        numero = n;
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

    public String encriptar(String mensaje){
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
                valorEncrip = ((index + numero) % 26) + 65;
                resultado = resultado + Character.toString((char)valorEncrip);
            }
        }
        return resultado;
    }

    public String desencriptar(String mensaje){
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
