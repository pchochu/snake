package greenfoot;

public class MyWorld extends World {

    public static final int WORLDSIZE = 16;
    public MyWorld() {
        super(WORLDSIZE, WORLDSIZE, 30);

        for(int i=0;i<=WORLDSIZE;i++){
            addObject(new Wall(), 0, i);
            addObject(new Wall(), i, 0);
            addObject(new Wall(), 15, i);
            addObject(new Wall(), i, 15);
        }

        addObject(new Head(), 1,1);
        addFox(4);
    }

    public void addFox(int number){
        for(int i=0;i<number;i++){
            Fox.putRandom(this);
        }
    }

    public void removeFoxesAndTails(){
        removeObjects(getObjects(Fox.class));
        removeObjects(getObjects(Tail.class));
    }
}