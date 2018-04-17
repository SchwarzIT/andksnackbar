package kaufland.com.snackbarlibrary;

import junit.framework.Assert;

import org.junit.Test;

public class SnackbarConfigurationTest {

    @Test
    public void testSnackbarConfigurationWithGravityTopAndSingleType() {

        SnackbarConfiguration snackbarConfiguration = new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_TOP).build();
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_TOP, snackbarConfiguration.getGravity());
    }

    @Test
    public void testSnackbarConfigurationWithGravityBottomAndMultipleSnackbarType() {

        SnackbarConfiguration snackbarConfiguration = new SnackbarConfiguration.Builder()
                .setGravity(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM).build();
        Assert.assertEquals(SnackbarConfiguration.Gravity.GRAVITY_BOTTOM, snackbarConfiguration.getGravity());
    }
}
