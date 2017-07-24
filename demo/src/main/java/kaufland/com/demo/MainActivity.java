package kaufland.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import kaufland.com.snackbarlibrary.SnackbarManager;
import kaufland.com.snackbarlibrary.view.ActionListener;
import kaufland.com.snackbarlibrary.view.DefaultSnackbarView;
import kaufland.com.snackbarlibrary.view.SnackbarViewWithTitleAndMessage;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDefaultSnackbarButton = (Button) findViewById(R.id.create_snackbar_button);
        Button createTextSnackbarButton = (Button) findViewById(R.id.create_text_snackbar_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createDefaultSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SnackbarManager.showSnackbar(new DefaultSnackbarView.Builder()
                        .withBackgroundColor(R.color.colorGreen)
                        .withTitle("Example default title")
                        .withTitleColor(R.color.colorWhite)
                        .withBoldTitleStyle()
                        .withMessage("Example default message")
                        .withMessageColor(R.color.colorWhite)
                        .withBoldMessageStyle()
                        .withActionDrawable(R.mipmap.ic_launcher)
                        .withActionListener(new ActionListener() {
                            @Override
                            public boolean onAction() {
                                //dismiss snackbar view
                                return true;
                            }
                        })
                        .withMarginsAroundTitle(16,16,16,0)
                        .withMarginsAroundMessage(16,16,16,16)
                        .withMarginsAroundActionButton(10,10,10,10)
                        .build());
            }
        });
        createTextSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SnackbarManager.showSnackbar(new SnackbarViewWithTitleAndMessage.Builder()
                        .withBackgroundColor(R.color.colorRed)
                        .withTitle("Example title")
                        .withTitleColor(R.color.colorWhite)
                        .withBoldTitleStyle()
                        .withMarginsAroundTitle(16,16,16,0)
                        .withMessage("Example message")
                        .withMessageColor(R.color.colorWhite)
                        .withBoldMessageStyle()
                        .withMarginsAroundMessage(16,16,16,16)
                        .withDuration(2500)
                        .build());

            }
        });

    }

}
