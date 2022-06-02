package Extra;

public class clickDaten {
    private int topX;
    private int topY;
    private int downX;
    private int downY;

    public clickDaten(int topX, int topY, int downX, int downY) {
        this.topX = topX;
        this.topY = topY;
        this.downX = downX;
        this.downY = downY;
    }

    public int getTopX() {
        return topX;
    }

    public void setTopX(int topX) {
        this.topX = topX;
    }

    public int getTopY() {
        return topY;
    }

    public void setTopY(int topY) {
        this.topY = topY;
    }

    public int getDownX() {
        return downX;
    }

    public void setDownX(int downX) {
        this.downX = downX;
    }

    public int getDownY() {
        return downY;
    }

    public void setDownY(int downY) {
        this.downY = downY;
    }

}
