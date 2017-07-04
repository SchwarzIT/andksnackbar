package kaufland.com.snackbarlibrary;

/**
 * Created by vkos2006 on 6/29/17.
 */

public  class Configuration {


    public enum Gravity{
        GRAVITY_TOP,GRAVITY_BOTTOM;
    }

    public enum SnackbarType{
        MULTIPLE_SNACKBARS,SINGLE_SNACKBAR;
    }

    private Gravity gravity;
    private SnackbarType snackbarType;

    private Configuration(Gravity gravity,SnackbarType type){
        this.gravity = gravity;
        this.snackbarType = type;
    }

    private Configuration(){
        this(Gravity.GRAVITY_TOP,SnackbarType.SINGLE_SNACKBAR);
    }

    public static Configuration getDefaultConfiguration(){
        return  new Configuration();
    }

    public static Configuration setConfiguration(Gravity gravity,SnackbarType type){
        return  new Configuration(gravity,type);
    }


}
