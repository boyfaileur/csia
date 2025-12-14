import java.awt.Color;
import java.awt.Graphics;

public class textInput extends Button{

    private String s;
    private Boolean beingTyped;

    public textInput(int x ,int y, int w, int h){
        super(x, y, w, h);
        s = "";
        beingTyped = false;
    }

    public void drawTextInput(Graphics g2d){
        g2d.setColor(Color.white);
        g2d.fillRect(getX(), getY(), getW(), getH());
        g2d.setColor(Color.BLACK);
        g2d.drawRect(getX(), getY(), getW(), getH());

        g2d.drawString(s, getX()+5, getY()+(getH()-3));

    }

    public String getS() {
        return s;
    }

    public Boolean getBeingTyped() {
        return beingTyped;
    }

    public void setBeingTyped(Boolean beingTyped) {
        this.beingTyped = beingTyped;
    }

    public void setS(String s) {
        this.s = s;
    }

    

}
