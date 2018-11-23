package greenfoot;

public class Tail extends Actor {
    int dx;
    int dy;

    public Tail(int dx, int dy) {
        setImage("images/banknotes.png");
        setDx(dx);
        setDy(dy);
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    @Override
    public void move(int distance) {
        setLocation(getDx(), getDy());
    }
}
