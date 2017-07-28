package kaufland.com.snackbarlibrary.view;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import kaufland.com.snackbarlibrary.R;


public class DefaultSnackbarViewBuilderTest {

    private DefaultSnackbarView.Builder mSnackbarViewWithTitleAndMessageBuilder;


    @Before
    public void init(){

        mSnackbarViewWithTitleAndMessageBuilder = new DefaultSnackbarView.Builder();
    }


    @Test
    public void testBackgroundColor(){
        mSnackbarViewWithTitleAndMessageBuilder.withBackgroundColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getBackgroundColor());
        Assert.assertEquals(defaultSnackbarView.getBackgroundColor(),new Integer(R.color.white));
    }

    @Test
    public void testTitleColor(){

        mSnackbarViewWithTitleAndMessageBuilder.withTitleColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getTitleColor());
        Assert.assertEquals(defaultSnackbarView.getTitleColor(),new Integer(R.color.white));
    }

    @Test
    public void testMessageColor(){

        mSnackbarViewWithTitleAndMessageBuilder.withMessageColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getMessageColor());
        Assert.assertEquals(defaultSnackbarView.getMessageColor(),new Integer(R.color.white));
    }


    @Test
    public void testDuration(){

        mSnackbarViewWithTitleAndMessageBuilder.withDuration(2500);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getDuration());
        Assert.assertEquals(defaultSnackbarView.getDuration(),new Integer(2500));
    }

    @Test
    public void testTitle(){

        String title = "Test title";
        mSnackbarViewWithTitleAndMessageBuilder.withTitle(title);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getTitle());
        Assert.assertEquals(defaultSnackbarView.getTitle(),title);
    }


    @Test
    public void testMessage(){

        String message = "Test message";
        mSnackbarViewWithTitleAndMessageBuilder.withMessage(message);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getMessage());
        Assert.assertEquals(defaultSnackbarView.getMessage(),message);
    }

    @Test
    public void testTitleBold(){

        mSnackbarViewWithTitleAndMessageBuilder.withBoldTitleStyle();
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertTrue(defaultSnackbarView.isTitleBold());
    }

    @Test
    public void testMessageBold(){

        mSnackbarViewWithTitleAndMessageBuilder.withBoldMessageStyle();
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertTrue(defaultSnackbarView.isMessageBold());
    }

    @Test
    public void testTitleSize(){

        mSnackbarViewWithTitleAndMessageBuilder.withTitleTextSize(10);
        DefaultSnackbarView actionSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(actionSnackbarView.getTitleTextSize(),new Integer(10));
    }

    @Test
    public void testMessageSize(){

        mSnackbarViewWithTitleAndMessageBuilder.withMessageTextSize(10);
        DefaultSnackbarView actionSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(actionSnackbarView.getMessageTextSize(),new Integer(10));
    }
    @Test
    public void testTitleStyle(){
        mSnackbarViewWithTitleAndMessageBuilder.withTitleStyle(R.style.TextAppearance_AppCompat_Light_SearchResult_Title);
        DefaultSnackbarView actionSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(actionSnackbarView.getTitleStyle(),new Integer(R.style.TextAppearance_AppCompat_Light_SearchResult_Title));
    }

    @Test
    public void testMessageStyle(){
        mSnackbarViewWithTitleAndMessageBuilder.withMessageStyle(R.style.TextAppearance_AppCompat_Light_SearchResult_Title);
        DefaultSnackbarView actionSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(actionSnackbarView.getMessageStyle(),new Integer(R.style.TextAppearance_AppCompat_Light_SearchResult_Title));
    }



    @Test
    public void testTitleMargins(){
        mSnackbarViewWithTitleAndMessageBuilder.withMarginsAroundTitle(10,20,30,40);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(defaultSnackbarView.getTitleMarginLeft(),new Integer(10));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginTop(),new Integer(20));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginRight(),new Integer(30));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginBottom(),new Integer(40));
    }

    @Test
    public void testMessageMargins(){
        mSnackbarViewWithTitleAndMessageBuilder.withMarginsAroundMessage(10,20,30,40);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mSnackbarViewWithTitleAndMessageBuilder.build();
        Assert.assertEquals(defaultSnackbarView.getMessageMarginLeft(),new Integer(10));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginTop(),new Integer(20));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginRight(),new Integer(30));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginBottom(),new Integer(40));
    }


}
