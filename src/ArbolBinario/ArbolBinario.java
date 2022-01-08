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
public class ArbolBinario {

    private ArbolBinario izquierdo;
    private ArbolBinario derecho;
    private Character raiz;

    static public ArbolBinario arbolVacio() {
        return new ArbolBinario();
    }

    static public ArbolBinario armarAB(ArbolBinario izquierdo, Character raiz, ArbolBinario derecho) {

        if (raiz == null) {
            return null;
        }

        ArbolBinario nuevo = arbolVacio();

        if (izquierdo == null) {
            nuevo.izquierdo = arbolVacio();
        } else {
            nuevo.izquierdo = izquierdo;
        }

        if (derecho == null) {
            nuevo.derecho = arbolVacio();
        } else {
            nuevo.derecho = derecho;
        }

        nuevo.raiz = raiz;

        return nuevo;

    }

    public boolean esABVacio() {

        return raiz == null;

    }

    public boolean pertenece(Character caracter) {
        if (this.esABVacio()) {
            return false;
        }

        if (this.raiz == caracter) {
            return true;
        }

        return this.izquierdo().pertenece(caracter) || this.derecho().pertenece(caracter);

    }

    public void preorden() {

        if (!this.esABVacio()) {

            System.out.println(raiz());
            izquierdo().preorden();
            derecho().preorden();

        }

    }

    public void posorden() {

        if (!this.esABVacio()) {

            izquierdo().preorden();
            derecho().preorden();
            System.out.println(raiz());

        }

    }

    public void inorden() {

        if (!this.esABVacio()) {

            izquierdo().preorden();
            System.out.println(raiz());
            derecho().preorden();

        }

    }

    public ArbolBinario izquierdo() {
        return this.izquierdo;
    }

    public Character raiz() {
        return this.raiz;
    }

    public ArbolBinario derecho() {
        return this.derecho;
    }

}
