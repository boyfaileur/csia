import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Button {

    private int x, y, w, h;
    private String l;
    private Color bC, tC;

    public Button(){

    }

    public Button(String label, int x1, int y1){

        x = x1;
        y = y1;
        l = label;

        
    }

    public Button(String label, int x1, int y1, Color boxColor, Color textColor){

        x = x1;
        y = y1;
        l = label;
        bC = boxColor;
        tC = textColor;
        
    }

    // methods
    public void setMetrics(Graphics g2d){
        FontMetrics metrics = g2d.getFontMetrics(new Font("Jersey 10", Font.PLAIN, 35));


        w = metrics.stringWidth(l)+20;
        h = metrics.getHeight()+20;
    }

    public void drawButton(Graphics g2d){
        
        g2d.setColor(bC);
        g2d.fillRoundRect(x, y, w, h, 10, 10);
        g2d.setColor(tC);
        g2d.drawString(l, x+10, y+((h/2)+10));
    }

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
}
