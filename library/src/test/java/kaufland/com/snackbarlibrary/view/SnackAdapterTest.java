package kaufland.com.snackbarlibrary.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by sbra0902 on 25.07.17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SnackbarAdapter.class, SnackbarAdapter.ViewHolder.class})
public class SnackAdapterTest {

    private SnackbarAdapter mAdapter;

    private SnackbarView viewMock;


    @Before
    public void init() throws Exception {
        mAdapter = PowerMockito.spy(new SnackbarAdapter());
        PowerMockito.doNothing().when(mAdapter).notifyItemInserted(Mockito.anyInt());


        viewMock = Mockito.mock(SnackbarView.class);
        mAdapter.addItem(viewMock);
    }


    @Test
    public void testOnCreateViewHolder() throws Exception {
        
        PowerMockito.whenNew(SnackbarAdapter.ViewHolder.class).withAnyArguments().thenReturn(null);

        mAdapter.onCreateViewHolder(null, 0);

        Mockito.verify(viewMock, Mockito.times(1)).onCreateView(null);
    }
}
