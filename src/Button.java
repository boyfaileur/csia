import java.awt.Color;

public class Button {

    private int x, y, w, h;
    private String l, d;
    private Color bC, tC;

    public Button(){

    }

    public Button(String label, String destination, int x1, int y1){

        x = x1;
        y = y1;
        l = label;
        d = destination;

        
    }


    // methods
    

    public boolean clicked(int mx, int my ){
        boolean temp;

        if ((mx > x && mx < x+w)&&(my> y && my< y + h)){
            temp = true;

        } else {
            temp = false;
        }

        return temp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public Color getbC() {
        return bC;
    }

    public void setbC(Color bC) {
        this.bC = bC;
    }

    public Color gettC() {
        return tC;
    }

    public void settC(Color tC) {
        this.tC = tC;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
