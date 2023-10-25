package cis3334.cis3334_project1;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GameFirebaseData {

    DatabaseReference myGameDbRef;
    public static final String GameDataTag = "GAME DATA";
    List<Game> gameList;

    public DatabaseReference open() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myGameDbRef = database.getReference(GameDataTag);
        gameList = new ArrayList();
        return myGameDbRef;
    }

    public void close() {
    }

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

    public void deleteGame(Game game) {
        String key = game.getKey();
        myGameDbRef.child(key).removeValue();
    }

    public List<Game> updateGameList(DataSnapshot dataSnapshot) {
        gameList.clear();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Game game = data.getValue(Game.class);
            gameList.add(game);
        }
        return gameList;
    }

    public List<Game> getAllGames() {
        return gameList;
    }

    public Game getGame(Integer position) {
        return gameList.get(position);
    }

    public Integer getNumberOfGames() {
        return gameList.size();
    }
}
