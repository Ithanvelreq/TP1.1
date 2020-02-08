public class PolygoneRegulier extends Polygone{
    public PolygoneRegulier(APoint centre, APoint unSommet, int nCotes){
        super();
        centre.shift(centre);
        unSommet.shift(centre);
        APoint [] somm = new APoint[nCotes];
        double r = centre.distance(unSommet);
        double beta = Math.atan2(unSommet.y, unSommet.x);
        double alpha = 2 * Math.PI / nCotes;
        unSommet.deShift();
        centre.deShift();
        for(int i = 0; i<somm.length; i++){
            somm[i] = new APoint(r * Math.cos(i * alpha + beta) + centre.x, r * Math.sin(i * alpha + beta) + centre.y);
        }
        super.sommets = somm;
        this.ordonner();
    }
}
