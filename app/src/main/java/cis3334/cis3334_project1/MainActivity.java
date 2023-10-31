package cis3334.cis3334_project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * The `MainActivity` class represents the main activity of the application. It allows users
 * to input basketball game statistics and view statistics data using a RecyclerView. This class
 * manages the user interface, interaction with a Firebase database, and navigation to the
 * `AveragesActivity` for displaying average statistics.
 */
public class MainActivity extends AppCompatActivity {

    // Class fields representing various UI elements and data sources used in the MainActivity.
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
    RecycleViewAdapter recycleViewAdapter;
    Button buttonAverages;
    Button buttonAddGame;
    GameFirebaseData gameDataSource;
    DatabaseReference myGameDbRef;

    /**
     * Called when the activity is created. Initializes the user interface components, Firebase data source,
     * and sets up event listeners for buttons and database updates.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link each editText variable to the xml layout
        editTextPoints = (EditText) findViewById(R.id.editTextPoints);
        editTextRebounds = (EditText) findViewById(R.id.editTextRebounds);
        editTextAssists = (EditText) findViewById(R.id.editTextAssists);
        editTextSteals = (EditText) findViewById(R.id.editTextSteals);
        editTextBlocks = (EditText) findViewById(R.id.editTextBlocks);
        editTextFgm = (EditText) findViewById(R.id.editTextFgm);
        editTextFga = (EditText) findViewById(R.id.editTextFga);
        editText3pm = (EditText) findViewById(R.id.editText3pm);
        editText3pa = (EditText) findViewById(R.id.editText3pa);
        editTextFtm = (EditText) findViewById(R.id.editTextFtm);
        editTextFta = (EditText) findViewById(R.id.editTextFta);

        gameDataSource = new GameFirebaseData();
        gameDataSource.open();

        setupButtonAverages();
        setupButtonAddGame();
        setupFirebaseDataChange();
        setupRecycleView();
    }

    /**
     * Sets up the behavior for the "Averages" button, which navigates to the `AveragesActivity`.
     */
    private void setupButtonAverages() {
        buttonAverages = findViewById(R.id.buttonAverages);
        buttonAverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secActIntent = new Intent(MainActivity.this, AveragesActivity.class);
                startActivity(secActIntent);
            }
        });
    }

    /**
     * Sets up the behavior for the "Add Game" button, which adds a new game entry to the database.
     */
    private void setupButtonAddGame() {
        buttonAddGame = findViewById(R.id.buttonAddGame);
        buttonAddGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add the game to the database
                Integer points = Integer.parseInt(editTextPoints.getText().toString());
                Integer rebounds = Integer.parseInt(editTextRebounds.getText().toString());
                Integer assists = Integer.parseInt(editTextAssists.getText().toString());
                Integer steals = Integer.parseInt(editTextSteals.getText().toString());
                Integer blocks = Integer.parseInt(editTextBlocks.getText().toString());
                Integer fgm = Integer.parseInt(editTextFgm.getText().toString());
                Integer fga = Integer.parseInt(editTextFga.getText().toString());
                Integer threePM = Integer.parseInt(editText3pm.getText().toString());
                Integer threePA = Integer.parseInt(editText3pa.getText().toString());
                Integer ftm = Integer.parseInt(editTextFtm.getText().toString());
                Integer fta = Integer.parseInt(editTextFta.getText().toString());

                gameDataSource.createGame(points, rebounds, assists, steals, blocks, fgm, fga, threePM, threePA, ftm, fta);
            }
        });
    }

    /**
     * Sets up the Firebase data change listener to retrieve and update game data from the Firebase database.
     */
    private void setupFirebaseDataChange() {
        myGameDbRef = gameDataSource.open();
        myGameDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                gameDataSource.updateGameList(dataSnapshot);
                recycleViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }

    /**
     * Sets up the RecyclerView to display game statistics using a custom adapter.
     */
    private void setupRecycleView() {
        recyclerViewStats = findViewById(R.id.recyclerViewStats);
        recycleViewAdapter = new RecycleViewAdapter(gameDataSource);
        recyclerViewStats.setAdapter(recycleViewAdapter);
        recyclerViewStats.setLayoutManager(new LinearLayoutManager(this));
        recycleViewAdapter.notifyDataSetChanged();
    }
}