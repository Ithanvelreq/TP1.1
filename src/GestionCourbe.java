/*
 * GestionCourbe.java
 *
 * Copyright 2019 Hammami Maryam <mhammami@pc107-042-12>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */
import java.util.LinkedList;
import java.awt.Color;

public class GestionCourbe {

    public static void main (String args[]) {
        LinkedList<Courbe> listeCourbe = new LinkedList<Courbe>();

        APoint a = new APoint(100.0, 100.0);
        APoint b = new APoint(300.0, 100.0);
        APoint c = new APoint(200.0, 200.0);
        APoint d = new APoint(100.0, 210.0);
        APoint [] tab1 = {a, b, c, d};
        APoint [] tab2 = {c, d, a};
        Cercle cer1 = new Cercle(a, 50);
        Cercle cer2 = new Cercle(c, 75);
        Cercle cer3 = new Cercle(d, 100);
        Polygone p1 = new Polygone(tab1, Color.red);
        Polygone p2 = new Polygone(tab2, Color.blue);
        PolygoneRegulier p3 = new PolygoneRegulier(a, b, 5);
        System.out.println(p1.aire());
        System.out.println(cer1.aire());
        System.out.println(p1.barycentre());
        System.out.println(cer1.barycentre());
        listeCourbe.add(cer1);
        listeCourbe.add(cer2);
        listeCourbe.add(cer3);
        listeCourbe.add(p1);
        listeCourbe.add(p2);
        listeCourbe.add(p3);
        for (int i = 0; i<listeCourbe.size(); i++) {
            System.out.println(listeCourbe.get(i));
        }
    }
}
