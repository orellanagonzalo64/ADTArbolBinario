/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinario;

/**
 *
 * @author Gonzalo Orellana
 */
public class CodigoMorse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArbolBinario morse;

        morse = ArbolBinario.arbolVacio();
        morse = ArbolBinario.armarAB(null, '|', null);

        morse = insertarMorse(morse, ".", 'E');
        morse = insertarMorse(morse, "..", 'I');
        morse = insertarMorse(morse, "...", 'S');
        morse = insertarMorse(morse, "....", 'H');
        morse = insertarMorse(morse, ".....", '5');
        morse = insertarMorse(morse, "....-", '4');
        morse = insertarMorse(morse, "...-", 'V');
        morse = insertarMorse(morse, "...--", '3');
        morse = insertarMorse(morse, "..-", 'U');
        morse = insertarMorse(morse, "..-.", 'F');
        morse = insertarMorse(morse, "..--", ' ');
        morse = insertarMorse(morse, "..---", '2');
        morse = insertarMorse(morse, ".-", 'A');
        morse = insertarMorse(morse, ".-.", 'R');
        morse = insertarMorse(morse, ".-..", 'L');
        morse = insertarMorse(morse, ".-.-", ' ');
        morse = insertarMorse(morse, ".-.-.", '+');
        morse = insertarMorse(morse, ".--", 'W');
        morse = insertarMorse(morse, ".--.", 'P');
        morse = insertarMorse(morse, ".---", 'J');
        morse = insertarMorse(morse, ".----", '1');
        morse = insertarMorse(morse, "-", 'T');
        morse = insertarMorse(morse, "-.", 'N');
        morse = insertarMorse(morse, "-..", 'D');
        morse = insertarMorse(morse, "-...", 'B');
        morse = insertarMorse(morse, "-....", '6');
        morse = insertarMorse(morse, "-...-", '=');
        morse = insertarMorse(morse, "-..-", 'X');
        morse = insertarMorse(morse, "-..-.", '/');
        morse = insertarMorse(morse, "-.-", 'K');
        morse = insertarMorse(morse, "-.-.", 'C');
        morse = insertarMorse(morse, "-.--", 'Y');
        morse = insertarMorse(morse, "--", 'M');
        morse = insertarMorse(morse, "--.", 'G');
        morse = insertarMorse(morse, "---", 'O');
        morse = insertarMorse(morse, "--..", 'Z');
        morse = insertarMorse(morse, "--.-", 'Q');
        morse = insertarMorse(morse, "--...", '7');
        morse = insertarMorse(morse, "---.", ' ');
        morse = insertarMorse(morse, "----", ' ');
        morse = insertarMorse(morse, "---..", '8');
        morse = insertarMorse(morse, "----.", '9');
        morse = insertarMorse(morse, "-----", '0');

        morse.preorden();

        System.out.println(traducir("... --- ...", morse));

    }

    public static String traducir(String codigo, ArbolBinario arbol) {

        String traduccion = "";
        String aux[];

        aux = codigo.split(" ");

        for (String string : aux) {

            traduccion = traduccion + traducirMorse(string, arbol);

        }

        return traduccion;

    }

    static public Character traducirMorse(String codigo, ArbolBinario arbol) {

        if (codigo.length() == 0) {
            return arbol.raiz();
        } else {
            if (codigo.charAt(0) == '.') {
                return traducirMorse(codigo.substring(1), arbol.izquierdo());
            } else {
                return traducirMorse(codigo.substring(1), arbol.derecho());
            }
        }
    }

    public static ArbolBinario insertarMorse(ArbolBinario arbol, String codigo, Character c) {

        if (codigo.length() == 0 || arbol.esABVacio()) {
            return ArbolBinario.armarAB(null, c, null);

        } else {

            if (codigo.charAt(0) == '.') {

                return ArbolBinario.armarAB(insertarMorse(arbol.izquierdo(), codigo.substring(1), c), arbol.raiz(), arbol.derecho());

            } else {
                return ArbolBinario.armarAB(arbol.izquierdo(), arbol.raiz(), insertarMorse(arbol.derecho(), codigo.substring(1), c));
            }
        }

    }

}
