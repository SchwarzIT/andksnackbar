package kaufland.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaufland.com.snackbarlibrary.Snackbar;
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
                Snackbar.getInstance(getApplicationContext()).make(new DefaultSnackbarView.Builder()
                        .withMessage("Hello there!").withTitle("Example title")
                        .withActionDrawable(R.mipmap.ic_launcher)
                        .withActionListener(new ActionListener() {
                            @Override
                            public boolean onAction() {
                                //dismiss snackbar
                                return true;
                            }
                        })
                        .build());
            }
        });
        createTextSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.getInstance(getApplicationContext()).make(new SnackbarViewWithTitleAndMessage.Builder()
                        .withTitle("Text snackbar title")
                        .withMessage("Text snackbar message")
                        .withDuration(2500)
                        .build());
            }
        });

    }

}
