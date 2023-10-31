package cis3334.cis3334_project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * The `AveragesActivity` class represents an activity for displaying and calculating averages
 * of various statistics from basketball games. It interacts with a Firebase database to retrieve
 * game data and calculates the averages for points, rebounds, assists, steals, blocks, field goals,
 * three-pointers, and free throws.
 */
public class AveragesActivity extends AppCompatActivity {

    // Class fields for various UI elements and data sources used in the AveragesActivity
    TextView textViewPointsAverage;
    TextView textViewReboundsAverage;
    TextView textViewAssistsAverage;
    TextView textViewStealsAverage;
    TextView textViewBlocksAverage;
    TextView textViewFgAverage;
    TextView textView3pAverage;
    TextView textViewFtAverage;
    GameFirebaseData gameDataSource;
    DatabaseReference myGameDbRef;
    Button buttonDone;

    /**
     * Called when the activity is created. Initializes the layout, views, and Firebase data source.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_averages);

        textViewPointsAverage = (TextView) findViewById(R.id.textViewPointsAverage);
        textViewReboundsAverage = (TextView) findViewById(R.id.textViewReboundsAverage);
        textViewAssistsAverage = (TextView) findViewById(R.id.textViewAssistsAverage);
        textViewStealsAverage = (TextView) findViewById(R.id.textViewStealsAverage);
        textViewBlocksAverage = (TextView) findViewById(R.id.textViewBlocksAverage);
        textViewFgAverage = (TextView) findViewById(R.id.textViewFgAverage);
        textView3pAverage = (TextView) findViewById(R.id.textView3pAverage);
        textViewFtAverage = (TextView) findViewById(R.id.textViewFtAverage);

        gameDataSource = new GameFirebaseData();
        gameDataSource.open();

        setupFirebaseDataChange();

        setupDoneButton();
    }

    /**
     * Calculates and displays the average statistics for points, rebounds, assists, steals, blocks,
     * field goals, three-pointers, and free throws using data from the Firebase database.
     */
    private void calculateAndDisplayAverages() {
        // Retrieve a list of game data from the Firebase database
        List<Game> games = gameDataSource.getAllGames();

        // Log the number of games retrieved
        Log.d("AveragesActivity", "Number of games: " + games.size());

        // Initialize variables to calculate totals
        Integer totalPoints = 0;
        Integer totalRebounds = 0;
        Integer totalAssists = 0;
        Integer totalSteals = 0;
        Integer totalBlocks = 0;
        Integer totalFgm = 0;
        Integer totalFga = 0;
        Integer totalThreePM = 0;
        Integer totalThreePA = 0;
        Integer totalFtm = 0;
        Integer totalFta = 0;

        // Calculate the totals for each statistical category
        for (Game game : games) {
            totalPoints += game.getPoints();
            totalRebounds += game.getRebounds();
            totalAssists += game.getAssists();
            totalSteals += game.getSteals();
            totalBlocks += game.getBlocks();
            totalFgm += game.getFgm();
            totalFga += game.getFga();
            totalThreePM += game.getThreePM();
            totalThreePA += game.getThreePA();
            totalFtm += game.getFtm();
            totalFta += game.getFta();
        }

        // Log the total points and the total number of games
        Log.d("AveragesActivity", "Total Points: " + totalPoints);
        Log.d("AveragesActivity", "Total Games: " + games.size());

        // Calculate average statistics and format them to two decimal places
        Integer totalGames = games.size();
        double averagePoints = totalGames > 0 ? (double) totalPoints / totalGames : 0.0;
        double averageRebounds = totalGames > 0 ? (double) totalRebounds / totalGames : 0.0;
        double averageAssists = totalGames > 0 ? (double) totalAssists / totalGames : 0.0;
        double averageSteals = totalGames > 0 ? (double) totalSteals / totalGames : 0.0;
        double averageBlocks = totalGames > 0 ? (double) totalBlocks / totalGames : 0.0;
        double averageFgPercent = totalFga > 0 ? (double) totalFgm / totalFga * 100 : 0.0;
        double averageThreePercent = totalThreePA > 0 ? (double) totalThreePM / totalThreePA * 100 : 0.0;
        double averageFtPercent = totalFta > 0 ? (double) totalFtm / totalFta * 100 : 0.0;

        // Set the calculated averages to the respective TextViews and format to two decimal places
        textViewPointsAverage.setText(String.format("%.2f", averagePoints));
        textViewReboundsAverage.setText(String.format("%.2f", averageRebounds));
        textViewAssistsAverage.setText(String.format("%.2f", averageAssists));
        textViewStealsAverage.setText(String.format("%.2f", averageSteals));
        textViewBlocksAverage.setText(String.format("%.2f", averageBlocks));
        textViewFgAverage.setText(String.format("%.2f", averageFgPercent));
        textView3pAverage.setText(String.format("%.2f", averageThreePercent));
        textViewFtAverage.setText(String.format("%.2f", averageFtPercent));
    }

    /**
     * Sets up the "Done" button and defines its click behavior.
     */
    private void setupDoneButton() {
        buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
                Log.d("CIS3334", "Starting onDataChange() in AveragesActivity");        // debugging log
                gameDataSource.updateGameList(dataSnapshot);
                calculateAndDisplayAverages();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }
}