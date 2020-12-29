package ui.window;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.lang.Math;

class Panel extends JPanel{

    private DimensionsHandler dimensions;
    public ButtonBar buttonBar;

	public Panel(){
		super();
        dimensions = DimensionsHandler.getInstance();
        buttonBar = new ButtonBar();
        
        addMouseMotionListener(new LogifyMouseMotionListener(this));
	}

	public void paint(Graphics g){	
       background(g);
       buttonBar.render(g);
	}

    private void background(Graphics g){
		g.setColor(new Color(0x2e466b));
		g.fillRect(0,0,dimensions.window_width,dimensions.window_height);
    }
}

class LogifyMouseMotionListener extends MouseMotionAdapter{
    boolean doResize = false;
    private Panel parentPanel;
    private DimensionsHandler dimensions;

    public LogifyMouseMotionListener(Panel parentPanel){
        this.parentPanel = parentPanel;
        dimensions = DimensionsHandler.getInstance();
    }

    public void mouseMoved(MouseEvent e){
        if(dimensions.window_width == 0 || dimensions.window_height == 0) return;
        if(Math.abs(e.getY() - dimensions.getButtonBarY()) < 4) {
            e.getComponent().setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            doResize = true;
        }else{
            e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            doResize = false;
        }
    }

    public void mouseDragged(MouseEvent e){
        if(dimensions.window_width == 0 || dimensions.window_height == 0) return;
        if(doResize){
            dimensions.setButtonBarY(e.getY());
            parentPanel.repaint();
        }
    }
}