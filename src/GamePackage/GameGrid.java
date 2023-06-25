package GamePackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class GameGrid  implements iGUI {
    private Shape Grid;
    private static GameGrid _instance;
    private static final int TILE_SIZE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    public List<Rectangle> list = new ArrayList<>();


    private GameGrid(){

    }
    public static GameGrid getinstance(){
        if(_instance==null){
            _instance=new GameGrid();
        }
        return _instance;
    }

    @Override
    public  Shape MakeGrid() {
        Grid=new Rectangle((COLUMNS+1)*TILE_SIZE,(ROWS+1)*TILE_SIZE);
        for (int y = 0; y < ROWS; y++) {
            for (int i = 0; i < COLUMNS; i++) {
                Circle circle = new Circle(TILE_SIZE / 2);
                circle.setCenterX(TILE_SIZE / 2);
                circle.setCenterY(TILE_SIZE / 2);
                circle.setTranslateX(i * (TILE_SIZE + 5) + TILE_SIZE / 4);
                circle.setTranslateY(y * (TILE_SIZE + 5) + TILE_SIZE / 4);
                Grid =  Shape.subtract(Grid, circle);
            }
        }
        Grid.setFill(Color.BLUE);
        return Grid;
    }

    @Override
    public List<Rectangle> PlayerHint() {
        for (int i = 0; i < COLUMNS; i++) {
            Rectangle rect = new Rectangle(TILE_SIZE, (ROWS + 1) * TILE_SIZE);
            rect.setTranslateX(i * (TILE_SIZE + 5) + TILE_SIZE / 4);
            rect.setFill(Color.TRANSPARENT);
            rect.setOnMouseEntered(e -> rect.setFill(Color.YELLOW));
            rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));
            list.add(rect);
        }
        return list;
    }


}
