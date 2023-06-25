package GamePackage;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


import java.util.List;

public class SceneBuilder {
    public static List<Rectangle> lx;
    private static GameGrid x=GameGrid.getinstance();
    private static BorderPane Bp;

   static Pane buildPvPScene(){
        Shape px=x.MakeGrid();
        lx=x.PlayerHint();
        Pane p=new Pane();
        for(int i=0;i<lx.size();i++){
            p.getChildren().add(lx.get(i));
        }
        p.getChildren().add(px);
       return p;
    }
    static Pane BuildMenu(Stage stage){
        Menu m=Menu.getInstance();
        Bp=m.drawMenu();
        m.setPvp(e->{
            stage.setScene(new Scene(buildPvPScene()));
            new PlayerVsPlayer();
        });
        return Bp;
    }
}
