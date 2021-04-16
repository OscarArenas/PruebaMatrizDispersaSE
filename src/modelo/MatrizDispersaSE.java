/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

/**
 *
 * @author Oscar Arenas
 */
public class MatrizDispersaSE {

    // Campos
    public final int filas;
    public final int columnas;
    private int n;
    private Nodo primerNodo;

    public MatrizDispersaSE(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        n = 0;
        primerNodo = null;
    }

    public boolean agregar(int fila, int columna, double valor) {
        if (valor != 0 && fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            Nodo actual = primerNodo;
            Nodo anterior = null;

            while (actual != null && fila > actual.fila) {
                anterior = actual;
                actual = actual.siguiente;
            }
            while (actual != null && fila == actual.fila && columna > actual.columna) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual != null && fila == actual.fila && columna == actual.columna) {
                return false; // No se permite posiciones repetidas
            }
            Nodo nuevoNodo = new Nodo(fila, columna, valor, actual);

            if (anterior == null) {
                primerNodo = nuevoNodo;
            } else {
                anterior.siguiente = nuevoNodo;
            }

            n++;
            return true;
        }
        return false;
    }

    public boolean eliminar(int fila, int columna) {
        if (n > 0 && fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            Nodo actual = primerNodo;
            Nodo anterior = null;

            while (actual != null && fila > actual.fila) {
                anterior = actual;
                actual = actual.siguiente;
            }
            while (actual != null && fila == actual.fila && columna > actual.columna) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual != null && fila == actual.fila && columna == actual.columna) {
                if (anterior == null) {
                    primerNodo = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                n--;
                return true;
            }
        }
        return false;
    }

    public int cantidadTripletas() {
        return n;
    }

    @Override
    public String toString() {
        String cadena = "";

        if (n > 0) {
            String[] etiquetas = {"Fila", "Columna", "Valor"};
            int[] mayorAncho = {4, 7, 5};
            Nodo actual = primerNodo;

            // Buscamos el valor de la matriz con más caracteres
            while (actual != null) {
                String numero = actual.fila + "";

                if (numero.length() > mayorAncho[0]) {
                    mayorAncho[0] = numero.length();
                }

                numero = actual.columna + "";

                if (numero.length() > mayorAncho[1]) {
                    mayorAncho[1] = numero.length();
                }
                numero = actual.valor + "";

                if (numero.length() > mayorAncho[2]) {
                    mayorAncho[2] = numero.length();
                }

                actual = actual.siguiente;
            }

            for (int j = 0; j < 3; j++) {
                mayorAncho[j]++;
                int delta = mayorAncho[j] - etiquetas[j].length();
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena += etiquetas[j];
            }
            cadena += "\n";

            // Formamos la cadena con los valores de la matriz por filas
            actual = primerNodo;

            while (actual != null) {
                String numero = actual.fila + "";

                int delta = mayorAncho[0] - numero.length();
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena += actual.fila;

                numero = actual.columna + "";

                delta = mayorAncho[1] - numero.length();
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena += actual.columna;

                numero = actual.valor + "";

                delta = mayorAncho[2] - numero.length();
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena += actual.valor + "\n";

                actual = actual.siguiente;
            }

        }

        return cadena;
    }
}
