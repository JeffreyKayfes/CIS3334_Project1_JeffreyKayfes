package cis3334.cis3334_project1;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * The `GameFirebaseData` class is responsible for managing game data stored in a Firebase database.
 * It provides methods for creating, deleting, and retrieving game statistics, as well as updating the game list.
 */
public class GameFirebaseData {

    DatabaseReference myGameDbRef;
    public static final String GameDataTag = "GAME DATA";
    List<Game> gameList;

    /**
     * Opens a connection to the Firebase database and initializes the game data list.
     *
     * @return The database reference for game data.
     */
    public DatabaseReference open() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myGameDbRef = database.getReference(GameDataTag);
        gameList = new ArrayList();
        return myGameDbRef;
    }

    /**
     * Closes the connection to the Firebase database.
     */
    public void close() {
    }

    /**
     * Creates a new game entry in the Firebase database and returns the associated Game object.
     *
     * @param points The number of points scored in the game.
     * @param rebounds The number of rebounds in the game.
     * @param assists The number of assists in the game.
     * @param steals The number of steals in the game.
     * @param blocks The number of blocks in the game.
     * @param fgm The number of field goals made in the game.
     * @param fga The number of field goals attempted in the game.
     * @param threePM The number of three-pointers made in the game.
     * @param threePA The number of three-pointers attempted in the game.
     * @param ftm The number of free throws made in the game.
     * @param fta The number of free throws attempted in the game.
     * @return The created Game object.
     */
    public Game createGame(Integer points, Integer rebounds, Integer assists, Integer steals, Integer blocks, Integer fgm, Integer fga, Integer threePM, Integer threePA, Integer ftm, Integer fta) {
        // ---- Get a new database key for the vote
        String key = myGameDbRef.child(GameDataTag).push().getKey();
//        String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the fish object
        Game newGame = new Game(key, points, rebounds, assists, steals, blocks, fgm, fga, threePM, threePA, ftm, fta);
        // ---- write the vote to Firebase
        myGameDbRef.child(key).setValue(newGame);
        return newGame;
    }

    /**
     * Deletes a game entry from the Firebase database.
     *
     * @param game The Game object to be deleted.
     */
    public void deleteGame(Game game) {
        String key = game.getKey();
        myGameDbRef.child(key).removeValue();
    }

    /**
     * Updates the game list by retrieving game data from a DataSnapshot.
     *
     * @param dataSnapshot The DataSnapshot containing game data.
     * @return The updated game data list.
     */
    public List<Game> updateGameList(DataSnapshot dataSnapshot) {
        gameList.clear();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Game game = data.getValue(Game.class);
            gameList.add(game);
        }
        return gameList;
    }

    /**
     * Retrieves a list of all game entries.
     *
     * @return A list of all Game objects.
     */
    public List<Game> getAllGames() {
        return gameList;
    }

    /**
     * Retrieves a specific game entry based on its position in the list.
     *
     * @param position The position of the desired game entry.
     * @return The Game object at the specified position.
     */
    public Game getGame(Integer position) {
        return gameList.get(position);
    }

    /**
     * Returns the total number of game entries in the game data list.
     *
     * @return The number of game entries.
     */
    public Integer getNumberOfGames() {
        return gameList.size();
    }
}
