package kaufland.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import kaufland.com.snackbarlibrary.view.ActionListener;
import kaufland.com.snackbarlibrary.view.ActionSnackbarView;
import kaufland.com.snackbarlibrary.view.DefaultSnackbarView;
import kaufland.com.snackbarlibrary.worker.WorkerHandler;


public class MainActivity extends AppCompatActivity {

    private Button mCreateDefaultSnackbarButton;
    private Button mCreateActionSnackbarButton;
    private Toolbar mToolbar;

    @Override
    protected void onStart() {
        super.onStart();
        WorkerHandler.getInstance().rebindContext(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCreateDefaultSnackbarButton = findViewById(R.id.create_snackbar_button);
        mCreateActionSnackbarButton = findViewById(R.id.create_text_snackbar_button);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mCreateDefaultSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WorkerHandler.getInstance().showSnackbar(new DefaultSnackbarView.Builder()
                        .withBackgroundColor(R.color.colorGreen)
                        .withTitle("Example default title")
                        .withTitleColor(R.color.colorWhite)
                        .withBoldTitleStyle()
                        .withTitleTextSize(16)
                        .withMarginsAroundTitle(16, 16, 16, 0)
                        .withMessage("Example default message")
                        .withMessageColor(R.color.colorWhite)
                        .withBoldMessageStyle()
                        .withMessageTextSize(10)
                        .withMarginsAroundMessage(16, 16, 16, 16)
                        .withDuration(2500)
                        .withElevation(6)
                        .build());

                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        mCreateActionSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WorkerHandler.getInstance().showSnackbar(new ActionSnackbarView.Builder()
                        .withBackgroundColor(R.color.colorRed)
                        .withTitle("Example title")
                        .withTitleColor(R.color.colorWhite)
                        .withBoldTitleStyle()
                        .withTitleTextSize(16)
                        .withMessage("Example message")
                        .withMessageColor(R.color.colorWhite)
                        .withBoldMessageStyle()
                        .withMessageTextSize(10)
                        .withActionDrawable(R.mipmap.ic_launcher)
                        .withActionListener(new ActionListener() {
                            @Override
                            public boolean onAction() {
                                //dismiss snackbar view
                                return true;
                            }
                        })
                        .withMarginsAroundTitle(16, 16, 16, 0)
                        .withMarginsAroundMessage(16, 16, 16, 16)
                        .withMarginsAroundActionButton(10, 10, 10, 10)
                        .withElevation(6)
                        .build());
            }
        });
    }
}
