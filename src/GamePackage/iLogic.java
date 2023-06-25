package GamePackage;

import javafx.geometry.Point2D;

import java.util.List;

public interface iLogic {
    boolean GameWinRules(int column,int currentRow);
    boolean checkRange(List<Point2D> tokenz);
    void End();
}
