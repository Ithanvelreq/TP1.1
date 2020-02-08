/*
 * Cercle.java
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

import java.awt.Color;
public class Cercle extends Courbe{

    public APoint centre;
    public double rayon;

    public Cercle(APoint a, double r) {
        this.centre = new APoint(a.x, a.y);
        this.rayon = r;
    }

    public Cercle(APoint a, double r, Color c) {
        super(c);
        this.centre = new APoint(a.x, a.y);
        this.rayon = r;
    }

    public double longeur(){
        return this.rayon * 2 * Math.PI;
    }

    public double aire() { return Math.pow(this.rayon, 2)*Math.PI;}

    public APoint barycentre() { return this.centre; }

    public String toString() {
        String res ="";
        res= "Cercle de centre " + this.centre.toString() + " et de rayon " + this.rayon + super.couleur();
        return res;
    }
}