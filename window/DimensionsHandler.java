package window;
/*
    This is a dimensions class that stores the dimensions of the major comonents
    the dimensions handler must be called from the static getInstance method
    as it is a singleton.
*/
public class DimensionsHandler{
    private static DimensionsHandler dimensionsHandlerInstance = null;

    private final double initialHeightRatio = 0.25;
    int window_width = 800;
    int window_height = 800;
    private int buttonBar_Y = window_height - (int)(window_height * initialHeightRatio);

    // to make sure that you can't create newer instances
    private DimensionsHandler(){}

    public int getButtonBarY(){
        return buttonBar_Y;
    }
    
    public boolean setButtonBarY(int buttonBar_Y){
        if(buttonBar_Y < 10) return false;
        if(buttonBar_Y > window_height - 50) return false;
        this.buttonBar_Y = buttonBar_Y;
        return true;
    }

    public static DimensionsHandler getInstance(){
        if(dimensionsHandlerInstance == null)
            dimensionsHandlerInstance = new DimensionsHandler();
        return dimensionsHandlerInstance;
    }
}