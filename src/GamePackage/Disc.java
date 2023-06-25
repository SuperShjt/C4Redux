package GamePackage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class Disc extends Circle {

   private boolean colorFlag=true;

    public Disc(Boolean flag){
        super(80,flag ? Color.RED : Color.BLACK);
        colorFlag=flag;
        this.setCenterX(40);
        this.setCenterY(40);
    }
    public boolean getflag(){

        return colorFlag;
    }


}
