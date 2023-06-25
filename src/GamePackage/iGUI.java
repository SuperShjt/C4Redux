package GamePackage;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.List;

public interface  iGUI {
   Shape MakeGrid();
   List<Rectangle> PlayerHint();
}
