/*
 * Polygone.java
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
public class Polygone extends Courbe{

    public APoint [] sommets;

    public Polygone(APoint [] b) {
        sommets = new APoint [b.length];
        for (int i = 0; i < b.length; i++){
            sommets[i] = new APoint(b[i].x, b[i].y);
        }
        this.ordonner();
    }
    public Polygone(APoint [] b, Color c) {
        super(c);
        sommets = new APoint [b.length];
        for (int i = 0; i < b.length; i++){
            sommets[i] = new APoint(b[i].x, b[i].y);
        }
        this.ordonner();
    }

    public Polygone(){}

    public double longeur(){
        double perim = 0;
        for (int i = 0; i < this.sommets.length ; i++){
            perim = perim + this.sommets[i].distance(sommets[(i+1) % this.sommets.length]);
        }
        return perim;
    }
    public void ordonner(){
        double norm = 1000000;
        int indi = 0;
        for (int i = 0; i<this.sommets.length; i++){
            if(this.sommets[i].norme()<norm){
                norm = this.sommets[i].norme();
                indi = i;
            }
        }
        APoint shiftpoint = new APoint(this.sommets[indi].x, this.sommets[indi].y);
        this.sommets[indi] = new APoint(this.sommets[0].x, this.sommets[0].y);
        this.sommets[0] = new APoint(shiftpoint.x, shiftpoint.y);
        double tetas = -Math.PI;
        double tetamin = Math.PI;
        int indmin = 0;
        double [] teta = new double [(this.sommets.length - 1)];
        APoint [] temp = new APoint [(this.sommets.length - 1)];
        for(int i = 0; i<this.sommets.length; i++){
            this.sommets[i].shift(shiftpoint);
        }
        for(int i = 0; i<teta.length; i++){
            teta[i] = Math.atan2(sommets[i+1].y , sommets[i+1].x);
        }
        for(int k = 0; k<teta.length; k++){
            for (int i = 0; i<teta.length; i++){
                if (teta[i] <= tetamin && teta[i]>tetas){
                    tetamin = teta[i];
                    indmin = i;
                }
            }
            tetas = tetamin;
            temp[k] = this.sommets[indmin+1];
            tetamin = Math.PI;
        }
        for(int i= 0; i<temp.length; i++){
            this.sommets[i+1] = temp[i];
        }
        for(int i = 0; i<this.sommets.length; i++){
            this.sommets[i].deShift();
        }
    }

    public double aire(){
        double a = 0;
        for (int i = 0; i<(this.sommets.length - 1); i++){
            a = a + this.sommets[i].x*this.sommets[i+1].y - this.sommets[i+1].x*this.sommets[i].y;
        }
        return a / 2;
    }

    public APoint barycentre(){
        double x = 0;
        double y = 0;
        for(int i = 0; i<(this.sommets.length - 1); i++){
            x = x + (this.sommets[i].x + this.sommets[i+1].x)*(this.sommets[i].x*this.sommets[i+1].y - this.sommets[i+1].x*this.sommets[i].y);
            y = y + (this.sommets[i].y + this.sommets[i+1].y)*(this.sommets[i].x*this.sommets[i+1].y - this.sommets[i+1].x*this.sommets[i].y);
        }
        x = x / (6*this.aire());
        y = y / (6*this.aire());
        return new APoint(x, y);
    }

    public String toString() {
        String res ="";
        res= "Polygone avec " + this.sommets.length + " sommets : ";
        for (int i = 0; i < this.sommets.length; i++){
            res = res + sommets[i].toString() + " ";
        }
        return res + super.couleur();
    }
}

