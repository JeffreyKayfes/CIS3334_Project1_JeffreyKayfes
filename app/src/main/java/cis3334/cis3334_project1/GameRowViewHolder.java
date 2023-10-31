package cis3334.cis3334_project1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The `GameRowViewHolder` class represents a ViewHolder used to hold and manage the views for
 * displaying game statistics in a RecyclerView.
 */
public class GameRowViewHolder extends RecyclerView.ViewHolder {
    TextView textViewGameNumber;
    TextView textViewPoints;
    TextView textViewRebounds;
    TextView textViewAssists;
    TextView textViewSteals;
    TextView textViewBlocks;
    TextView textViewFg;
    TextView textView3p;
    TextView textViewFt;

    /**
     * Constructor for creating a `GameRowViewHolder` instance.
     *
     * @param itemView The view item representing a single row in the RecyclerView.
     */
    public GameRowViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewGameNumber = itemView.findViewById(R.id.textViewGameNumber);
        textViewPoints = itemView.findViewById(R.id.textViewPoints);
        textViewRebounds = itemView.findViewById(R.id.textViewRebounds);
        textViewAssists = itemView.findViewById(R.id.textViewAssists);
        textViewSteals = itemView.findViewById(R.id.textViewSteals);
        textViewBlocks = itemView.findViewById(R.id.textViewBlocks);
        textViewFg = itemView.findViewById(R.id.textViewFg);
        textView3p = itemView.findViewById(R.id.textView3p);
        textViewFt = itemView.findViewById(R.id.textViewFt);
    }
}
