package GamePackage;

import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerVsPlayer extends Shape implements iLogic {

    private static final int TILE_SIZE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private Pane x;
    private Disc[][] discGrid = new Disc[COLUMNS][ROWS];
    private boolean flag = true;
    List<Rectangle> listx = new ArrayList<>();


    public  PlayerVsPlayer(){
        System.out.println("i am here");
        placeIT();
    }

    private void placeIT(){

        for(int i = 0;i<COLUMNS;i++){
            final int co = i;
            listx.get(i).setOnMouseClicked(e -> DiscPlace(new Disc(flag),co));


        }



    }

    private void DiscPlace(Disc d, int co) {
        int row = ROWS - 1;
        do {
            if (!DiscAva(co, row).isPresent())
                break;

            row--;
        } while (row >= 0);

        if (row < 0)
            return;

        discGrid[co][row] = d;
        x.getChildren().add(d);
        d.setTranslateX(co * (TILE_SIZE + 5) + TILE_SIZE / 4);

        final int currentRow = row;

        TranslateTransition animation = new TranslateTransition(Duration.seconds(1), d);
        animation.setToY(row * (TILE_SIZE + 5) + TILE_SIZE / 4);
        animation.setOnFinished(e -> {
            if (GameWinRules(co, currentRow)) {
                End();
            }
            flag = !flag;
        });
        animation.play();
    }


    public Optional<Disc> DiscAva(int col, int row) {
        if (col < 0 || col >= COLUMNS || row < 0 || row >= ROWS) {
            return Optional.empty();
        }
        return Optional.ofNullable(discGrid[col][row]);
    }







    @Override
    public boolean GameWinRules(int column, int currentRow) {
        List<Point2D> vertical = IntStream.rangeClosed(currentRow - 3, currentRow + 3)
                .mapToObj(r -> new Point2D(column, r))
                .collect(Collectors.toList());

        List<Point2D> horizontal = IntStream.rangeClosed(column - 3, column + 3)
                .mapToObj(c -> new Point2D(c, currentRow))
                .collect(Collectors.toList());

        Point2D topLeft = new Point2D(column - 3, currentRow - 3);
        List<Point2D> diagonal1 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> topLeft.add(i, i))
                .collect(Collectors.toList());

        Point2D botLeft = new Point2D(column - 3, currentRow + 3);
        List<Point2D> diagonal2 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> botLeft.add(i, -i))
                .collect(Collectors.toList());


        return checkRange(vertical) || checkRange(horizontal)
                || checkRange(diagonal1) || checkRange(diagonal2);
    }

    @Override
    public boolean checkRange(List<Point2D> tokenz) {
        int chain = 0;

        for (Point2D p : tokenz) {
            int column = (int) p.getX();
            int row = (int) p.getY();

            Disc disc = DiscAva(column, row).orElse(new Disc(!flag));
            if (disc.getflag() == flag) {
                chain++;
                if (chain == 4) {
                    return true;
                }
            } else {
                chain = 0;
            }
        }

        return false;
    }

    @Override
    public void End() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Winner: " + (flag ? "RED" : "BLACK"));
        alert.show();
        x.getChildren().clear();
        Label lb = new Label("Game Ended");
        x.getChildren().add(lb);

    }


}
