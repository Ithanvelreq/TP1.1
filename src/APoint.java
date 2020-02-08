/**
 * Classe permettant de gérer un point dans un espace 2D
 * @author Equipe pédagogique IF2A
 */

public class APoint {

    // Attributs
    public double x;
    public double y;
    public double [] psh = {0, 0};

    /**
     * Le constructeur
     * @param les coordonnées du point
     */
    public APoint(double ax, double ay){
        x = ax;
        y = ay;
    }

    /**
     * pour calculer la distance euclidienne par rapport à un autre point
     * @param le point à partir duquel il faut calculer la distance
     * @return la distance euclidienne
     */
    public double distance( APoint otherPoint ) {
        double dx = x - otherPoint.x;
        double dy = y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Pour afficher les coordonnées du point
     * @return les coordonnées du point sous la forme [x=1.0,y=1.0]
     */
    public String toString() {
        String res ="";
        res="[x=" + x + ",y=" + y + "]";
        return res;
    }

    public void shift(APoint a){
        this.psh[0] = a.x;
        this.psh[1] = a.y;
        this.x = this.x - a.x;
        this.y = this.y - a.y;
    }

    public void deShift(){
        this.x = this.x + this.psh[0];
        this.y = this.y + this.psh[1];
    }

    public double norme(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}