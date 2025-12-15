public class Pic {

    private String p;
    private int w, h, x, y;

    public Pic(){

    }

    public Pic(String pic, int width, int height, int x1, int y1){
        p = pic;
        w = width;
        h = height;
        x= x1;
        y = y1;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
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



}
