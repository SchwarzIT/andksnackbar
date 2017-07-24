package kaufland.com.snackbarlibrary;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vkos2006 on 7/21/17.
 */

public class SnackbarConfigurationTest {


    @Test
    public void testSnackbarConfigurationWithGravityTopAndSingleType() {

        SnackbarConfiguration snackbarConfiguration = SnackbarConfiguration.configure(new SnackbarConfiguration.Builder()
                .gravity(SnackbarConfiguration.Gravity.GRAVITY_TOP)
                .type(SnackbarConfiguration.SnackbarType.SINGLE_SNACKBAR));
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_TOP, snackbarConfiguration.getGravity());
        Assert.assertEquals(SnackbarConfiguration.SnackbarType.SINGLE_SNACKBAR,snackbarConfiguration.getSnackbarType());
    }


    @Test
    public void  testSnackbarConfigurationWithGravityBottomAndMultipleSnackbarType(){

        SnackbarConfiguration snackbarConfiguration = SnackbarConfiguration.configure(new SnackbarConfiguration.Builder()
                .gravity(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM)
                .type(SnackbarConfiguration.SnackbarType.MULTIPLE_SNACKBARS));
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM, snackbarConfiguration.getGravity());
        Assert.assertEquals(SnackbarConfiguration.SnackbarType.MULTIPLE_SNACKBARS,snackbarConfiguration.getSnackbarType());
    }

}
