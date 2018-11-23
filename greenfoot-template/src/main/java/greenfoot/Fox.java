package greenfoot;

public class Fox extends Actor {

    public Fox() {
        setImage("images/banknotes.png");
    }

    public static void putRandom(MyWorld world){
        int x,y;
        do {
            x = Greenfoot.getRandomNumber(world.WORLDSIZE);
            y = Greenfoot.getRandomNumber(world.WORLDSIZE);
        } while(world.getObjectsAt(x,y,Actor.class).isEmpty() == false);
        world.addObject(new Fox(), x, y);
    }
}