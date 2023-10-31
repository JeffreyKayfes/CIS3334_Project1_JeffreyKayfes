package cis3334.cis3334_project1;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

/**
 * The `RecycleViewAdapter` class serves as the adapter for populating a RecyclerView with game statistics.
 * It is responsible for creating and binding views for individual game rows in the RecyclerView.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<GameRowViewHolder> {

    GameFirebaseData gameDataSource;

    /**
     * Constructor for creating a `RecycleViewAdapter` instance.
     *
     * @param gameDataSource The data source providing game statistics.
     */
    RecycleViewAdapter (GameFirebaseData gameDataSource) {
        this.gameDataSource = gameDataSource;
    }

    /**
     * Called when a new `GameRowViewHolder` instance needs to be created.
     *
     * @param parent The parent ViewGroup in which the new view will be added.
     * @param viewType The view type of the new view.
     * @return A new `GameRowViewHolder` instance.
     */
    @NonNull
    @Override
    public GameRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stats_row, parent, false);
        GameRowViewHolder holder = new GameRowViewHolder(view);
        return holder;
    }

    /**
     * Called to bind a `GameRowViewHolder` to a specific position in the RecyclerView.
     *
     * @param holder The `GameRowViewHolder` to bind.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull GameRowViewHolder holder, int position) {
        Game game = gameDataSource.getGame(position);
        Log.d("CIS 3334", "RecycleViewAdapter: Display game of "+game);

        // Calculate Percentages
        Double fieldGoalPercent = (1.0*game.getFgm()/game.getFga()*100);
        Double threePointPercent = (1.0*game.getThreePM()/game.getThreePA()*100);
        Double freeThrowPercent = (1.0*game.getFtm()/game.getFta()*100);

        // Round to 2 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String fieldGoalPercentFormatted = decimalFormat.format(fieldGoalPercent);
        String threePointPercentFormatted = decimalFormat.format(threePointPercent);
        String freeThrowPercentFormatted = decimalFormat.format(freeThrowPercent);

        holder.textViewGameNumber.setText("Game " + String.valueOf(position + 1) + ":");
        holder.textViewPoints.setText(game.getPoints().toString());
        holder.textViewRebounds.setText(game.getRebounds().toString());
        holder.textViewAssists.setText(game.getAssists().toString());
        holder.textViewSteals.setText(game.getSteals().toString());
        holder.textViewBlocks.setText(game.getBlocks().toString());
        holder.textViewFg.setText(fieldGoalPercentFormatted);
        holder.textView3p.setText(threePointPercentFormatted);
        holder.textViewFt.setText(freeThrowPercentFormatted);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The number of game statistics entries.
     */
    @Override
    public int getItemCount() {
        Log.d("CIS 3334", "RecycleViewAdapter: getItemCount = "+gameDataSource.getNumberOfGames());
        return gameDataSource.getNumberOfGames();
    }
}
