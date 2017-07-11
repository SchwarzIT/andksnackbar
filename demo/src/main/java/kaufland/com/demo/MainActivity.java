package kaufland.com.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kaufland.com.snackbarlibrary.SnackbarManager;
import kaufland.com.snackbarlibrary.view.DefaultSnackbarView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createSnackbarButton = (Button) findViewById(R.id.create_snackbar_button);
        createSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnackbarManager.makeSnackbar(getApplicationContext(), new DefaultSnackbarView.Builder().
                        withMessage("Hello there!").withTitle("Example title").
                        withActionDrawable(R.mipmap.ic_launcher).
                        build());
            }
        });

    }

}
