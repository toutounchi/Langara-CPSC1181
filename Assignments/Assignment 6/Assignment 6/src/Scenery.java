import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Scenery Class is an extension of abstract Application class from Java FX package.
 */
public class Scenery extends Application {

    /**
     * main method will launch the program.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * We have to override the start method since it is an abstract method from abstract class of Application.
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {

        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.DARKBLUE, Color.PURPLE};
        Pane root = new Pane();
        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        Tree t1 = new Tree (100, 420);
        root.getChildren().addAll(t1.getAllNodes());

        Tree t2 = new Tree(200, 440, 100, 100, Color.rgb(100, 100, 80));
        root.getChildren().addAll(t2.getAllNodes());

        Tree t3 = new Tree(250, 440, 100, 250, Color.rgb(120, 120, 10));
        root.getChildren().addAll(t3.getAllNodes());

        Animal palang = new Animal(450,380, Color.rgb(204,204,0));
        root.getChildren().addAll(palang.getAllNodes());

        for (int i = 0; i<7; i++)
        {
            Ellipse temp = new Ellipse(300, 575 + i*10, 500,550 );
            temp.setFill(Color.TRANSPARENT);
            temp.setStrokeWidth(10);
            temp.setStroke(colors[i]);
            root.getChildren().add(temp);
        }
        
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
