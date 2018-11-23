package greenfoot;

import java.awt.*;

public class Head extends Actor {
    public static final int DOWN = 90;
    public static final int UP = 270;
    public static final int LEFT = 180;
    public static final int RIGHT = 0;
    private Tail[] tails = new Tail[MyWorld.WORLDSIZE * MyWorld.WORLDSIZE];
    private GreenfootSound music = new GreenfootSound("hlavou.wav");
    int counter = 0;
    int numOfTails = 1;

    public Head() {
        setImage("images/head.JPG");
        tails[0] = new Tail(1,1);

    }


    @Override
    public void act() {
        String key = Greenfoot.getKey();
        int rot = getRotation();

        if (key == "up" && (rot == 0 || rot == 180)) {
            setRotation(UP);
        }

        if (key == "down" && (rot == 180 || rot == 0)) {
            setRotation(DOWN);
        }

        if (key == "left" && (rot == 90 || rot == 270)) {
            setRotation(LEFT);
        }

        if (key == "right" && (rot == 90 || rot == 270)) {
            setRotation(RIGHT);
        }
        try {
            if (++counter % 30 == 0) {
                move(1);
            }} catch(Exception e){
                gameOver();
        }
    }

    @Override
    public void move(int distance) {
        int dx = 0, dy = 0;
        if (getRotation() == UP) {
            dy = -1;
        }
        if (getRotation() == DOWN) {
            dy = 1;
        }
        if (getRotation() == LEFT) {
            dx = -1;
        }
        if (getRotation() == RIGHT) {
            dx = 1;
        }

        if ((getOneObjectAtOffset(dx, dy, Obstacle.class) != null) ||
                (getOneObjectAtOffset(dx,dy,Tail.class) != null)) {
            throw new IllegalStateException("Obstacle collision.");
        }

        eat();
        moveTail();
        setLocation(getX() + dx, getY() + dy);
    }

    private void eat() {

            if(MyWorld.WORLDSIZE == numOfTails){
                Greenfoot.stop();
            }

            if(getWorld().getObjectsAt(getX(),getY(),Fox.class).isEmpty() == false){
                Actor fox = getOneObjectAtOffset(0,0, Fox.class);
                getWorld().removeObject(fox);
                music = new GreenfootSound("hlavou.wav");
                music.play();

                tails[numOfTails] = new Tail(this.getX(), this.getY());
                getWorld().addObject(tails[numOfTails], this.getX(), this.getY());
                numOfTails++;

                MyWorld myWorld = (MyWorld) getWorld();
                Fox.putRandom(myWorld);
        }
     }

    private void moveTail(){
        if(numOfTails>0) {
            tails[0].setDy(getY());
            tails[0].setDx(getX());

            for(int i=numOfTails -1; i>=1; i--){
                tails[i].setDx(tails[i-1].getDx());
                tails[i].setDy(tails[i-1].getDy());
            }

            for(int i=0;i<numOfTails;i++){
                tails[i].move(1);
            }
        }
    }

    private void gameOver() {
        ((MyWorld)getWorld()).removeFoxesAndTails();
        setLocation(8,7);
        setRotation(RIGHT);
        setImage(new GreenfootImage("Kolko si si nakradol?", 48, Color.WHITE, Color.BLACK));
        music = new GreenfootSound("andrej.mp3");
        music.play();
        Greenfoot.stop();
    }
}

