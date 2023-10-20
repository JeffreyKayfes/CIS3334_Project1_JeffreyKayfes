package cis3334.cis3334_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextPoints;
    EditText editTextRebounds;
    EditText editTextAssists;
    EditText editTextSteals;
    EditText editTextBlocks;
    EditText editTextFgm;
    EditText editTextFga;
    EditText editText3pm;
    EditText editText3pa;
    EditText editTextFtm;
    EditText editTextFta;
    RecyclerView recyclerViewStats;
    Button buttonAverages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton();
    }

    private void setupButton() {
        buttonAverages = findViewById(R.id.buttonAverages);
        buttonAverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secActIntent = new Intent(MainActivity.this, AveragesActivity.class);
                startActivity(secActIntent);
            }
        });
    }
}