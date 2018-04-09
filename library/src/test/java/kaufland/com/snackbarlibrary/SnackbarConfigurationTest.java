package kaufland.com.snackbarlibrary;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by vkos2006 on 7/21/17.
 */

public class SnackbarConfigurationTest {


    @Test
    public void testSnackbarConfigurationWithGravityTopAndSingleType() {

        SnackbarConfiguration snackbarConfiguration = new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_TOP)
                .setType(SnackbarConfiguration.SnackbarType.SINGLE_SNACKBAR).build();
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_TOP, snackbarConfiguration.getGravity());
        Assert.assertEquals(SnackbarConfiguration.SnackbarType.SINGLE_SNACKBAR, snackbarConfiguration.getSnackbarType());
    }

    @Test
    public void testSnackbarConfigurationWithGravityBottomAndMultipleSnackbarType() {

        SnackbarConfiguration snackbarConfiguration = new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM)
                .setType(SnackbarConfiguration.SnackbarType.MULTIPLE_SNACKBARS).build();
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM, snackbarConfiguration.getGravity());
        Assert.assertEquals(SnackbarConfiguration.SnackbarType.MULTIPLE_SNACKBARS, snackbarConfiguration.getSnackbarType());
    }
}
