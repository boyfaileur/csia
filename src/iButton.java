import java.awt.Graphics;
import javax.swing.ImageIcon;

public class iButton extends dButton{


    public iButton(){
        super();
    }

    public iButton(String l, String d, int x, int y, int w, int h){
        super(l, d, x, y, w, h);
    }

    public void drawButton(Graphics g2d){
        g2d.drawImage(new ImageIcon(this.getL()).getImage(), getX(), getY(), getW(), getH(), null);
    }

}
