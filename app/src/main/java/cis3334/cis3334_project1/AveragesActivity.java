package cis3334.cis3334_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AveragesActivity extends AppCompatActivity {

    TextView textViewPointsAverage;
    TextView textViewReboundsAverage;
    TextView textViewAssistsAverage;
    TextView textViewStealsAverage;
    TextView textViewBlocksAverage;
    TextView textViewFgAverage;
    TextView textView3pAverage;
    TextView textViewFtAverage;
    Button buttonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_averages);

        setupDoneButton();
    }

    private void setupDoneButton() {
        buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}