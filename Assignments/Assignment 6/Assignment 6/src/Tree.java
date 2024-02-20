import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * Class Tree will create a Tree object based on the height and the width that the user chooses
 * the x and Y coordinate will be the center of the Tree.
 */
public class Tree {
    private Rectangle trunk;
    private Ellipse leaves;

    /**
     * default constructor will creat a Tree with 20 width and 100 height.
     * @param x is the x coordinate of the Tree,
     * @param y is the y coordinate of the Tree,
     */
    public Tree(int x, int y){

        trunk = new Rectangle(x-10, y -100, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);

        leaves = new Ellipse(x, y-100, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));
    }

    /**
     * constructor will creat a Tree with the width and  height that user chooses.
     * @param x is the x coordinate of the Tree,
     * @param y is the y coordinate of the Tree,
     */
    public Tree (int x, int y, int width, int height, Color color)
    {
        trunk = new Rectangle(x-width/8,y-height/2,width/4, height/2);
        trunk.setFill((Color.SADDLEBROWN));

        leaves = new Ellipse(x,y-(height/1.25), width/2,height/2);
        leaves.setFill((color));
    }

    /**
     * this function will return all the nodes based their priority so the animal looks like a Tree.
     * @return the nodes for the pane to be added in order.
     */
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves};
    }
}
