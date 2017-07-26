package kaufland.com.snackbarlibrary;

import android.os.Handler;
import android.os.Message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.concurrent.Semaphore;

import kaufland.com.snackbarlibrary.view.SnackbarView;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SnackbarWorker.class,Semaphore.class,Handler.class})
public class SnackbarWorkerTest {

    private SnackbarWorker mSnackbarWorker;

    private SnackbarView mSnackbarView;

    private Semaphore mSemaphore;

    private Handler mHandler;

    @Before
    public void init() {
        mSnackbarView = PowerMockito.mock(SnackbarView.class);
        mHandler = PowerMockito.spy(new Handler());
        mSemaphore = PowerMockito.spy(new Semaphore(1));
        mSnackbarWorker = PowerMockito.spy(new SnackbarWorker(mSnackbarView, mSemaphore, mHandler));
    }


    @Test
    public void testRunMethod() throws InterruptedException {

        Message messageToReturn = new Message();
        messageToReturn.what = SnackbarManager.MSG_SHOW;
        messageToReturn.obj = mSnackbarView;
        PowerMockito.doReturn(messageToReturn).when(mSnackbarWorker).createMessage(Mockito.anyInt());
        mSnackbarWorker.start();
        mSnackbarWorker.join();
        Mockito.verify(mSnackbarWorker, Mockito.times(1)).run();
    }

    @Test
    public void testMessageShowCalled() throws InterruptedException {
        Message messageShow = new Message();
        messageShow.what = SnackbarManager.MSG_SHOW;
        messageShow.obj = mSnackbarView;
        PowerMockito.doReturn(messageShow).when(mSnackbarWorker).createMessage(SnackbarManager.MSG_SHOW);
        mSnackbarWorker.start();
        mSnackbarWorker.join();
        Mockito.verify(mSnackbarWorker, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
    }

    @Test
    public void testMessageDismissCalled() throws InterruptedException {
        Message messageShow = new Message();
        messageShow.what = SnackbarManager.MSG_SHOW;
        messageShow.obj = mSnackbarView;

        Message messageDismiss = new Message();
        messageShow.what = SnackbarManager.MSG_DISMISS;
        messageShow.obj = mSnackbarView;

        PowerMockito.doReturn(messageShow).when(mSnackbarWorker).createMessage(SnackbarManager.MSG_SHOW);
        PowerMockito.doReturn(messageDismiss).when(mSnackbarWorker).createMessage(SnackbarManager.MSG_DISMISS);
        PowerMockito.doReturn(2500).when(mSnackbarView).getDuration();
        mSnackbarWorker.start();
        mSnackbarWorker.join();
        Mockito.verify(mSnackbarWorker, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
        Mockito.verify(mSnackbarWorker, Mockito.times(1)).createMessage(SnackbarManager.MSG_DISMISS);
    }

    @Test
    public void testMessageShowCalledDismissNotCalled() throws InterruptedException{

        Message messageShow = new Message();
        messageShow.what = SnackbarManager.MSG_SHOW;
        messageShow.obj = mSnackbarView;

        Message messageDismiss = new Message();
        messageShow.what = SnackbarManager.MSG_DISMISS;
        messageShow.obj = mSnackbarView;

        PowerMockito.doReturn(messageShow).when(mSnackbarWorker).createMessage(SnackbarManager.MSG_SHOW);
        PowerMockito.doReturn(messageDismiss).when(mSnackbarWorker).createMessage(SnackbarManager.MSG_DISMISS);
        PowerMockito.doReturn(null).when(mSnackbarView).getDuration();
        mSnackbarWorker.start();
        mSnackbarWorker.join();
        Mockito.verify(mSnackbarWorker, Mockito.times(1)).createMessage(SnackbarManager.MSG_SHOW);
        Mockito.verify(mSnackbarWorker, Mockito.times(0)).createMessage(SnackbarManager.MSG_DISMISS);
    }
}
