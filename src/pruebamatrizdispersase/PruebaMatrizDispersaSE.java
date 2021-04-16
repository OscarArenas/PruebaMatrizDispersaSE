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
package pruebamatrizdispersase;

import modelo.MatrizDispersaSE;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaMatrizDispersaSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrizDispersaSE matriz = new MatrizDispersaSE(8, 12);

        matriz.agregar(0, 2, 45);
        matriz.agregar(0, 0, 23);
        matriz.agregar(2, 7, 49);
        matriz.agregar(0, 0, -26);
        matriz.agregar(3, 5, 17);

        System.out.println("Matriz dispersa:");
        System.out.println(matriz);

        matriz.eliminar(2, 7);

        System.out.println("Después de borrada:");
        System.out.println(matriz);
    }
}
