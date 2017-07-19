package kaufland.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        createDefaultSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SnackbarManager.showSnackbar(new DefaultSnackbarView.Builder()
                        .withBackgroundColor(R.color.colorGreen)
                        .withTitle("Example default title")
                        .withMessage("Example default message")
                        .withActionDrawable(R.mipmap.ic_launcher)
                        .withActionListener(new ActionListener() {
                            @Override
                            public boolean onAction() {
                                return true;
                            }
                        })
                        .build());
            }
        });
        createTextSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnackbarManager.showSnackbar(new SnackbarViewWithTitleAndMessage.Builder()
                        .withBackgroundColor(R.color.colorRed)
                        .withTitle("Example title")
                        .withMessage("Example message")
                        .withDuration(2500)
                        .build());

            }
        });

    }

}
