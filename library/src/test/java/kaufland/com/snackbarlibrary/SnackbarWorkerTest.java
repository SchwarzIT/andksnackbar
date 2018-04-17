package kaufland.com.snackbarlibrary;

import android.os.Handler;
import android.os.Message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;

@RunWith(PowerMockRunner.class)
@PrepareForTest({kaufland.com.snackbarlibrary.worker.WorkerHandler.class, Semaphore.class, Handler.class})
public class SnackbarWorkerTest {

    private SnackbarView mSnackbarView;

    private Handler mHandler;

    private SnackbarConfiguration sSnackbarConfiguration;

    @Before
    public void init() {
        mSnackbarView = PowerMockito.mock(SnackbarView.class);
        mHandler = PowerMockito.spy(new Handler());
//        sSnackbarConfiguration = PowerMockito.spy(new SnackbarConfiguration.Builder().setLimit(SnackbarConfiguration.Limit.SINGLE).build());
    }

    @Test
    public void testRunMethod() throws InterruptedException {

        Message messageToReturn = new Message();
//        messageToReturn.what = SnackbarManager.MSG_SHOW;
        messageToReturn.obj = mSnackbarView;
//        PowerMockito.doReturn(messageToReturn).when(mSnackbarHandler).createMessage(Mockito.anyInt());
//        mSnackbarHandler.start();
//        mSnackbarHandler.join();
//        Mockito.verify(mSnackbarHandler, Mockito.times(1)).run();
    }

    @Test
    public void testMessageShowCalled() throws InterruptedException {
//        Message messageShow = new Message();
//        messageShow.what = SnackbarManager.MSG_SHOW;
//        messageShow.obj = mSnackbarView;
//        PowerMockito.doReturn(messageShow).when(mSnackbarHandler).createMessage(SnackbarManager.MSG_SHOW);
//        mSnackbarHandler.start();
//        mSnackbarHandler.join();
//        Mockito.verify(mSnackbarHandler, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
    }

    @Test
    public void testMessageDismissCalled() throws InterruptedException {
//        Message messageShow = new Message();
//        messageShow.what = SnackbarManager.MSG_SHOW;
//        messageShow.obj = mSnackbarView;
//
//        Message messageDismiss = new Message();
//        messageShow.what = SnackbarManager.MSG_DISMISS;
//        messageShow.obj = mSnackbarView;

//        PowerMockito.doReturn(messageShow).when(mSnackbarHandler).createMessage(SnackbarManager.MSG_SHOW);
//        PowerMockito.doReturn(messageDismiss).when(mSnackbarHandler).createMessage(SnackbarManager.MSG_DISMISS);
//        PowerMockito.doReturn(2500).when(mSnackbarView).getDuration();
//        mSnackbarHandler.start();
//        mSnackbarHandler.join();
//        Mockito.verify(mSnackbarHandler, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
//        Mockito.verify(mSnackbarHandler, Mockito.times(1)).createMessage(SnackbarManager.MSG_DISMISS);
    }

    @Test
    public void testMessageShowCalledDismissNotCalled() throws InterruptedException {

//        Message messageShow = new Message();
//        messageShow.what = SnackbarManager.MSG_SHOW;
//        messageShow.obj = mSnackbarView;
//
//        Message messageDismiss = new Message();
//        messageShow.what = SnackbarManager.MSG_DISMISS;
//        messageShow.obj = mSnackbarView;

//        PowerMockito.doReturn(messageShow).when(mSnackbarHandler).createMessage(SnackbarManager.MSG_SHOW);
//        PowerMockito.doReturn(messageDismiss).when(mSnackbarHandler).createMessage(SnackbarManager.MSG_DISMISS);
//        PowerMockito.doReturn(null).when(mSnackbarView).getDuration();
//        mSnackbarHandler.start();
//        mSnackbarHandler.join();
//        Mockito.verify(mSnackbarHandler, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
//        Mockito.verify(mSnackbarHandler, Mockito.times(0)).createMessage(SnackbarManager.MSG_DISMISS);
    }
}
