import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ComputerPaint  extends Application {

    Color[] rainbow = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PURPLE, Color.PINK};
    
    public static void main (String [] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        Rectangle ground = new Rectangle(0,300,300,100);
        ground.setFill(Color.DARKGREEN);
        Rectangle trunck = new Rectangle(140, 220, 20, 100);
        trunck.setFill(Color.SADDLEBROWN);
        Ellipse leaves = new Ellipse(150, 220, 40, 50);
        leaves.setFill(Color.rgb(30,120,80));
        root.getChildren().addAll(ground, trunck, leaves);

        for(int i = 0; i <7; i++) {
            int k = i*7;
            Ellipse random = new Ellipse(150, 300+k, 250, 250);
            random.setStroke(rainbow[i]);
            random.setStrokeWidth(7);
            random.setFill(Color.TRANSPARENT);
            root.getChildren().add(random);
        }

        Scene scene = new Scene(root, 300,400);
        primaryStage.setTitle("FX SHAPES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
