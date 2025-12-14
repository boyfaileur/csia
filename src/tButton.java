import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class tButton extends dButton{

    private Color bC, tC;


    public tButton(){
        super();
    }

    public tButton(String l, String d, int x, int y, Color bC1, Color tC1){
        super(l, d, x, y);
        bC = bC1;
        tC = tC1;

    }


    public void setMetrics(Graphics g2d){

        FontMetrics metrics = g2d.getFontMetrics(new Font("Jersey 10", Font.PLAIN, 35));

        setW(metrics.stringWidth(getL())+20);
        setH(metrics.getHeight()+20);
    }

    public void drawButton(Graphics g2d){
        
        g2d.setColor(bC);
        g2d.fillRoundRect(getX(), getY(), getW(), getH(), 10, 10);
        g2d.setColor(tC);
        g2d.drawString(getL(), getX()+10, getY()+((getH()/2)+10));
    }
}
