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
                .count(1));
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_TOP, snackbarConfiguration.getGravity());
        Assert.assertEquals(1,snackbarConfiguration.getSnackbarCount());
    }


    @Test
    public void  testSnackbarConfigurationWithGravityBottomAndMultipleSnackbarType(){

        SnackbarConfiguration snackbarConfiguration = SnackbarConfiguration.configure(new SnackbarConfiguration.Builder()
                .gravity(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM)
                .count(3));
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM, snackbarConfiguration.getGravity());
        Assert.assertEquals(3,snackbarConfiguration.getSnackbarCount());
    }

}
