package window;
import java.awt.Graphics;
import java.awt.Color;

public class ButtonBar{
    DimensionsHandler dimensions;

    public ButtonBar(){
        super();
        dimensions = DimensionsHandler.getInstance();
    }

    public void render(Graphics g){
       g.setColor(new Color(0x23344f));
	   g.fillRect(0,dimensions.getButtonBarY(),dimensions.window_width,dimensions.window_height - dimensions.getButtonBarY());
    }
}