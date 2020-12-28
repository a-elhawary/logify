package window;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;

public class Window extends JFrame{
	/*int width = 800;
	int height = 800;*/
	DimensionsHandler dimensions;
		
	public Window(){
		super("Logify - by Abdelrahman Elhawary");
		dimensions = DimensionsHandler.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimensions.window_width, dimensions.window_height);	
		setLocationRelativeTo(null);
		Panel panel = new Panel();
		add(panel);
		addComponentListener(new ResizeListener());
		setMinimumSize(new Dimension(600,600));
		setVisible(true);
	}
}

class ResizeListener extends ComponentAdapter{
	DimensionsHandler dimensions;

	public ResizeListener(){
		dimensions = DimensionsHandler.getInstance();
	}

	public void componentResized(ComponentEvent e){
		dimensions.window_height = e.getComponent().getHeight();		
		dimensions.window_width = e.getComponent().getWidth();		
	}
}



