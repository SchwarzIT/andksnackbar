package kaufland.com.snackbarlibrary.view;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import kaufland.com.snackbarlibrary.R;


public class ActionSnackbarViewBuilderTest {

    private ActionSnackbarView.Builder mDefaultSnackbarViewBuilder;


    @Before
    public void init(){

        mDefaultSnackbarViewBuilder = new ActionSnackbarView.Builder();
    }


    @Test
    public void testBackgroundColor(){
        mDefaultSnackbarViewBuilder.withBackgroundColor(R.color.white);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getBackgroundColor());
        Assert.assertEquals(actionSnackbarView.getBackgroundColor(),new Integer(R.color.white));
    }

    @Test
    public void testTitleColor(){

        mDefaultSnackbarViewBuilder.withTitleColor(R.color.white);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getTitleColor());
        Assert.assertEquals(actionSnackbarView.getTitleColor(),new Integer(R.color.white));
    }

    @Test
    public void testMessageColor(){

        mDefaultSnackbarViewBuilder.withMessageColor(R.color.white);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getMessageColor());
        Assert.assertEquals(actionSnackbarView.getMessageColor(),new Integer(R.color.white));
    }


    @Test
    public void testDuration(){

        mDefaultSnackbarViewBuilder.withDuration(2500);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getDuration());
        Assert.assertEquals(actionSnackbarView.getDuration(),new Integer(2500));
    }

    @Test
    public void testTitle(){

        String title = "Test title";
        mDefaultSnackbarViewBuilder.withTitle(title);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getTitle());
        Assert.assertEquals(actionSnackbarView.getTitle(),title);
    }


    @Test
    public void testMessage(){

        String message = "Test message";
        mDefaultSnackbarViewBuilder.withMessage(message);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(actionSnackbarView.getMessage());
        Assert.assertEquals(actionSnackbarView.getMessage(),message);
    }



    @Test
    public void testActionListener(){
        ActionListener actionListener = Mockito.mock(ActionListener.class);
        mDefaultSnackbarViewBuilder.withActionListener(actionListener);
        ActionSnackbarView defaultSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getActionListener());
        Assert.assertEquals(defaultSnackbarView.getActionListener(),actionListener);
    }

    @Test
    public void testTitleBold(){

        mDefaultSnackbarViewBuilder.withBoldTitleStyle();
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertTrue(actionSnackbarView.isTitleBold());
    }

    @Test
    public void testTitleSize(){

        mDefaultSnackbarViewBuilder.withTitleTextSize(10);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getTitleTextSize(),new Integer(10));
    }

    @Test
    public void testMessageSize(){

        mDefaultSnackbarViewBuilder.withMessageTextSize(10);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getMessageTextSize(),new Integer(10));
    }

    @Test
    public void testTitleStyle(){
        mDefaultSnackbarViewBuilder.withTitleStyle(R.style.TextAppearance_AppCompat_Light_SearchResult_Title);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getTitleStyle(),new Integer(R.style.TextAppearance_AppCompat_Light_SearchResult_Title));
    }

    @Test
    public void testMessageStyle(){
        mDefaultSnackbarViewBuilder.withMessageStyle(R.style.TextAppearance_AppCompat_Light_SearchResult_Title);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getMessageStyle(),new Integer(R.style.TextAppearance_AppCompat_Light_SearchResult_Title));
    }



    @Test
    public void testMessageBold(){

        mDefaultSnackbarViewBuilder.withBoldMessageStyle();
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertTrue(actionSnackbarView.isMessageBold());
    }


    @Test
    public void testElevation(){

        mDefaultSnackbarViewBuilder.withElevation(6);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getElevation(),new Integer(6));
    }



    @Test
    public void testTitleMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundTitle(10,20,30,40);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getTitleMarginLeft(),new Integer(10));
        Assert.assertEquals(actionSnackbarView.getTitleMarginTop(),new Integer(20));
        Assert.assertEquals(actionSnackbarView.getTitleMarginRight(),new Integer(30));
        Assert.assertEquals(actionSnackbarView.getTitleMarginBottom(),new Integer(40));
    }

    @Test
    public void testMessageMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundMessage(10,20,30,40);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getMessageMarginLeft(),new Integer(10));
        Assert.assertEquals(actionSnackbarView.getMessageMarginTop(),new Integer(20));
        Assert.assertEquals(actionSnackbarView.getMessageMarginRight(),new Integer(30));
        Assert.assertEquals(actionSnackbarView.getMessageMarginBottom(),new Integer(40));
    }


    @Test
    public void testActionButtonMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundActionButton(10,20,30,40);
        ActionSnackbarView actionSnackbarView = (ActionSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(actionSnackbarView.getActionButtonMarginLeft(),new Integer(10));
        Assert.assertEquals(actionSnackbarView.getActionButtonMarginTop(),new Integer(20));
        Assert.assertEquals(actionSnackbarView.getActionButtonMarginRight(),new Integer(30));
        Assert.assertEquals(actionSnackbarView.getActionButtonMarginBottom(),new Integer(40));
    }





}
