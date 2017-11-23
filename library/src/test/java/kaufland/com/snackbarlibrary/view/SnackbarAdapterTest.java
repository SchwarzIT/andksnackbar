package kaufland.com.snackbarlibrary.view;

import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({SnackbarAdapter.class, SnackbarAdapter.ViewHolder.class})
public class SnackbarAdapterTest {

    private SnackbarAdapter mAdapter;

    private SnackbarView viewMock;


    private SnackbarAdapter.ViewHolder mViewHolder;

    @Before
    public void init() throws Exception {
        mAdapter = PowerMockito.spy(new SnackbarAdapter());
        View holderView = Mockito.mock(View.class);
        mViewHolder = PowerMockito.spy(new SnackbarAdapter.ViewHolder(holderView));
        PowerMockito.doNothing().when(mAdapter).notifyItemInserted(Mockito.anyInt());
        PowerMockito.doNothing().when(mAdapter).notifyItemRemoved(Mockito.anyInt());
        viewMock = Mockito.mock(SnackbarView.class);
    }

    @Test
    public void testZeroAdapterSize(){
        Assert.assertTrue(mAdapter.isEmpty());
    }


    @Test
    public void testOnCreateViewHolder() throws Exception {

        mAdapter.addItem(viewMock);
        PowerMockito.whenNew(SnackbarAdapter.ViewHolder.class).withAnyArguments().thenReturn(mViewHolder);

        mAdapter.onCreateViewHolder(null, 0);

        Mockito.verify(viewMock, Mockito.times(1)).onCreateView(null);
    }

    @Test
    public void testOnBindViewHolder() throws Exception{

        mAdapter.addItem(viewMock);
        PowerMockito.whenNew(SnackbarAdapter.ViewHolder.class).withAnyArguments().thenReturn(mViewHolder);
        mAdapter.onCreateViewHolder(null, 0);
        mAdapter.onBindViewHolder(mViewHolder,0);
        Mockito.verify(viewMock, Mockito.times(1)).onBindView();
    }

    @Test
    public void testAddItem(){
        mAdapter.addItem(viewMock);
        Assert.assertEquals(mAdapter.getItemCount(),1);

    }

    @Test
    public void testRemoveItem(){
        mAdapter.addItem(viewMock);
        Assert.assertEquals(mAdapter.getItemCount(),1);
        mAdapter.removeItem(viewMock);
        Assert.assertEquals(mAdapter.getItemCount(),0);
    }
}
