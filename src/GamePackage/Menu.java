package GamePackage;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Menu  {
    private static Button Pvp;
    private static Button PvCo;
    private static Menu _instance;
    private BorderPane p;
    private Menu(){

        //background,music,buttonStyle
    }
    public static Menu getInstance(){
        if(_instance==null){
            _instance=new Menu();
        }
        return _instance;

    }
    public BorderPane drawMenu(){
        p=new BorderPane();
        Pvp=new Button("player vs Player");
        Pvp.setStyle("-fx-background-color: #cc0022");
        PvCo=new Button("player vs Ai");
        HBox hp=new HBox(120,Pvp,PvCo);
        p.setBottom(hp);
        return  p;
    }

    public  void setPvp(EventHandler Action){
        Pvp.setOnMouseClicked(Action);
    }
    public  void setPvCo(EventHandler Action){
        PvCo.setOnMouseClicked(Action);
    }


}
