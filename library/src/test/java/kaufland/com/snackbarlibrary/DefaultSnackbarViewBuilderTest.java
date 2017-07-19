package kaufland.com.snackbarlibrary;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import kaufland.com.snackbarlibrary.view.DefaultSnackbarView;

/**
 * Created by vkos2006 on 7/19/17.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(DefaultSnackbarView.class)
public class DefaultSnackbarViewBuilderTest {

    @Mock
    private DefaultSnackbarView mDefaultSnackbarView;


    DefaultSnackbarView.Builder mDefalultSnackbarViewBuilder;



    @Before
    public void init(){

        mDefalultSnackbarViewBuilder = new DefaultSnackbarView.Builder();
    }





}
