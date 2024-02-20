import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 *Class Animal will make an animal based on the X and Y coordination passed through the constructor,
 * It will also set the color of the animal based on the user prefrences.
 */
public class Animal {
    private Ellipse body;
    private Ellipse head;
    private Rectangle legs1;
    private Rectangle legs2;
    private Rectangle legs3;
    private Rectangle legs4;
    private Circle eye1;
    private Circle eye2;
    private Ellipse nose;
    private Circle ear1;
    private Circle ear2;
    private Ellipse lip;
    private Ellipse lipTop;
    private Circle spot1;
    private Circle spot2;
    private Circle spot3;
    private Circle spot4;
    private Circle spot5;
    private Circle spot6;
    private Circle spot7;
    private Circle spot8;
    private Circle spot9;
    private Circle spot10;
    private Circle legButtom1;
    private Circle legButtom2;
    private Circle legButtom3;
    private Circle legButtom4;


    private Ellipse tail;

    /**
     * Constructor will create different layers of the Animal with different objects and make them ready?
     * @param x is the x coordinate of the animal.
     * @param y is the y coordinate of the animal.
     * @param color is the color of the animal that the user choose.
     */
    public Animal (int x, int y, Color color){
        body = new Ellipse(x,y,80,50);
        body.setFill(color);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(2);

        head = new Ellipse(x-80,y-50 , 35, 35);
        head.setFill(color);
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(2);

        legs1 = new Rectangle(x-60,y+25,15,40);
        legs1.setFill(color);
        legs1.setStroke(Color.BLACK);
        legs1.setStrokeWidth(2);
        legButtom1 = new Circle(x-52.5,y+65,7.5,Color.BROWN);
        legButtom1.setStroke(Color.BLACK);

        legs2 = new Rectangle(x-35,y+25,15,40);
        legs2.setFill(color);
        legs2.setStroke(Color.BLACK);
        legs2.setStrokeWidth(2);
        legButtom2 = new Circle(x-27.5,y+65,7.5,Color.BROWN);
        legButtom2.setStroke(Color.BLACK);

        legs3 = new Rectangle(x+30,y+25,15,40);
        legs3.setFill(color);
        legs3.setStroke(Color.BLACK);
        legs3.setStrokeWidth(2);
        legButtom3 = new Circle(x+37.5,y+65,7.5,Color.BROWN);
        legButtom3.setStroke(Color.BLACK);

        legs4 = new Rectangle(x+55,y+25,15,40);
        legs4.setFill(color);
        legs4.setStroke(Color.BLACK);
        legs4.setStrokeWidth(2);
        legButtom4 = new Circle(x+62.5,y+65,7.5,Color.BROWN);
        legButtom4.setStroke(Color.BLACK);

        eye1 = new Circle(x-70,y-70,4, Color.BLACK);
        eye2 = new Circle(x-90,y-70, 4, Color.BLACK);

        nose = new Ellipse(x-80,y-50,3,9);
        nose.setFill(Color.ORANGE);
        nose.setStroke(Color.BLACK);

        ear1 = new Circle(x-105, y-75, 15, color);
        ear1.setStroke(Color.BLACK);
        ear1.setStrokeWidth(2);

        ear2 = new Circle(x-55, y-75, 15, Color.BLACK);
        ear2.setStroke(Color.BLACK);
        ear2.setStrokeWidth(2);

        lip = new Ellipse(x-80, y-30, 9,4);
        lip.setFill(Color.TRANSPARENT);
        lip.setStroke(Color.BLACK);

        lipTop = new Ellipse(x-80, y-30, 7,2);
        lipTop.setFill(Color.RED);

        spot1 = new Circle(x+30, y+20, 8, Color.BLACK);
        spot2 = new Circle(x-25, y+25, 4, Color.BLACK);
        spot3 = new Circle(x-15, y-35, 6, Color.BLACK);
        spot4 = new Circle(x+25, y-25, 12, Color.BLACK);
        spot5 = new Circle(x+5, y-5,5, Color.BLACK);
        spot6 = new Circle(x-40, y, 10, Color.BLACK);
        spot7 = new Circle(x+45, y, 9, Color.BLACK);

        tail = new Ellipse(x+80,y-20,50,10);
        tail.setFill(Color.BLACK);

        spot8 = new Circle(x+82, y-15, 3,color);
        spot9 = new Circle(x+110, y-25, 4,color);
        spot10 = new Circle(x+95,y-20,5,color );

    }

    /**
     * this function will return all the nodes based their priority so the animal looks like an animal.
     * @return the nodes for the pane to be added in order.
     */
    public Node [] getAllNodes() {
        return new Node[] {ear1,ear2,head,lip,lipTop,eye1,eye2,nose,legButtom1,legs1,
                legButtom2,legs2,legButtom3,legs3,legButtom4,legs4,tail,body,spot1,
                spot2,spot3,spot4,spot5,spot6,spot7,spot8,spot9,spot10};
    }
}
