package kaufland.com.snackbarlibrary.view;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import kaufland.com.snackbarlibrary.R;


public class DefaultSnackbarViewBuilderTest {

    private DefaultSnackbarView.Builder mDefaultSnackbarViewBuilder;


    @Before
    public void init(){

        mDefaultSnackbarViewBuilder = new DefaultSnackbarView.Builder();
    }


    @Test
    public void testBackgroundColor(){
        mDefaultSnackbarViewBuilder.withBackgroundColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getBackgroundColor());
        Assert.assertEquals(defaultSnackbarView.getBackgroundColor(),new Integer(R.color.white));
    }

    @Test
    public void testTitleColor(){

        mDefaultSnackbarViewBuilder.withTitleColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getTitleColor());
        Assert.assertEquals(defaultSnackbarView.getTitleColor(),new Integer(R.color.white));
    }

    @Test
    public void testMessageColor(){

        mDefaultSnackbarViewBuilder.withMessageColor(R.color.white);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getMessageColor());
        Assert.assertEquals(defaultSnackbarView.getMessageColor(),new Integer(R.color.white));
    }


    @Test
    public void testDuration(){

        mDefaultSnackbarViewBuilder.withDuration(2500);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getDuration());
        Assert.assertEquals(defaultSnackbarView.getDuration(),new Integer(2500));
    }

    @Test
    public void testTitle(){

        String title = "Test title";
        mDefaultSnackbarViewBuilder.withTitle(title);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getTitle());
        Assert.assertEquals(defaultSnackbarView.getTitle(),title);
    }


    @Test
    public void testMessage(){

        String message = "Test message";
        mDefaultSnackbarViewBuilder.withMessage(message);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getMessage());
        Assert.assertEquals(defaultSnackbarView.getMessage(),message);
    }



    @Test
    public void testActionListener(){
        ActionListener actionListener = Mockito.mock(ActionListener.class);
        mDefaultSnackbarViewBuilder.withActionListener(actionListener);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertNotNull(defaultSnackbarView.getActionListener());
        Assert.assertEquals(defaultSnackbarView.getActionListener(),actionListener);
    }

    @Test
    public void testTitleBold(){

        mDefaultSnackbarViewBuilder.withBoldTitleStyle();
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertTrue(defaultSnackbarView.isTitleBold());
    }

    @Test
    public void testMessageBold(){

        mDefaultSnackbarViewBuilder.withBoldMessageStyle();
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertTrue(defaultSnackbarView.isMessageBold());
    }


    @Test
    public void testTitleMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundTitle(10,20,30,40);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(defaultSnackbarView.getTitleMarginLeft(),new Integer(10));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginTop(),new Integer(20));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginRight(),new Integer(30));
        Assert.assertEquals(defaultSnackbarView.getTitleMarginBottom(),new Integer(40));
    }

    @Test
    public void testMessageMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundMessage(10,20,30,40);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(defaultSnackbarView.getMessageMarginLeft(),new Integer(10));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginTop(),new Integer(20));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginRight(),new Integer(30));
        Assert.assertEquals(defaultSnackbarView.getMessageMarginBottom(),new Integer(40));
    }


    @Test
    public void testActionButtonMargins(){
        mDefaultSnackbarViewBuilder.withMarginsAroundActionButton(10,20,30,40);
        DefaultSnackbarView defaultSnackbarView = (DefaultSnackbarView) mDefaultSnackbarViewBuilder.build();
        Assert.assertEquals(defaultSnackbarView.getActionButtonMarginLeft(),new Integer(10));
        Assert.assertEquals(defaultSnackbarView.getActionButtonMarginTop(),new Integer(20));
        Assert.assertEquals(defaultSnackbarView.getActionButtonMarginRight(),new Integer(30));
        Assert.assertEquals(defaultSnackbarView.getActionButtonMarginBottom(),new Integer(40));
    }





}
