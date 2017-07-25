package kaufland.com.snackbarlibrary.view;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import kaufland.com.snackbarlibrary.R;


public class SnackbarViewWithTitleAndMessageBuilderTest {

    private SnackbarViewWithTitleAndMessage.Builder mSnackbarViewWithTitleAndMessageBuilder;


    @Before
    public void init(){

        mSnackbarViewWithTitleAndMessageBuilder = new SnackbarViewWithTitleAndMessage.Builder();
    }


    @Test
    public void testBackgroundColor(){
        mSnackbarViewWithTitleAndMessageBuilder.withBackgroundColor(R.color.white);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getBackgroundColor());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getBackgroundColor(),new Integer(R.color.white));
    }

    @Test
    public void testTitleColor(){

        mSnackbarViewWithTitleAndMessageBuilder.withTitleColor(R.color.white);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getTitleColor());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitleColor(),new Integer(R.color.white));
    }

    @Test
    public void testMessageColor(){

        mSnackbarViewWithTitleAndMessageBuilder.withMessageColor(R.color.white);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getMessageColor());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessageColor(),new Integer(R.color.white));
    }


    @Test
    public void testDuration(){

        mSnackbarViewWithTitleAndMessageBuilder.withDuration(2500);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getDuration());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getDuration(),new Integer(2500));
    }

    @Test
    public void testTitle(){

        String title = "Test title";
        mSnackbarViewWithTitleAndMessageBuilder.withTitle(title);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getTitle());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitle(),title);
    }


    @Test
    public void testMessage(){

        String message = "Test message";
        mSnackbarViewWithTitleAndMessageBuilder.withMessage(message);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(snackbarViewWithTitleAndMessage.getMessage());
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessage(),message);
    }

    @Test
    public void testTitleBold(){

        mSnackbarViewWithTitleAndMessageBuilder.withBoldTitleStyle();
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertTrue(snackbarViewWithTitleAndMessage.isTitleBold());
    }

    @Test
    public void testMessageBold(){

        mSnackbarViewWithTitleAndMessageBuilder.withBoldMessageStyle();
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertTrue(snackbarViewWithTitleAndMessage.isMessageBold());
    }


    @Test
    public void testTitleMargins(){
        mSnackbarViewWithTitleAndMessageBuilder.withMarginsAroundTitle(10,20,30,40);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitleMarginLeft(),new Integer(10));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitleMarginTop(),new Integer(20));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitleMarginRight(),new Integer(30));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getTitleMarginBottom(),new Integer(40));
    }

    @Test
    public void testMessageMargins(){
        mSnackbarViewWithTitleAndMessageBuilder.withMarginsAroundMessage(10,20,30,40);
        SnackbarViewWithTitleAndMessage snackbarViewWithTitleAndMessage = (SnackbarViewWithTitleAndMessage) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessageMarginLeft(),new Integer(10));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessageMarginTop(),new Integer(20));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessageMarginRight(),new Integer(30));
        Assert.assertEquals(snackbarViewWithTitleAndMessage.getMessageMarginBottom(),new Integer(40));
    }


}
