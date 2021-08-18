package application.example.crewdetails;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {CrewEntity.class}, version = 1)
public abstract class CrewDatabase extends RoomDatabase {

    private static CrewDatabase instance;
    public abstract CrewDao crewDao();
    public static synchronized CrewDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), CrewDatabase.class, "crew_database")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private CrewDao crewDao;
        public PopulateDbAsyncTask(CrewDatabase db) {
            crewDao = db.crewDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            crewDao.insert(new CrewEntity("5ebf1a6e23a9a60006e03a7a", "Robert Behnken", "NASA", "https://en.wikipedia.org/wiki/Robert_L._Behnken","5eb87d46ffd86e000604b388", "active" ));
            crewDao.insert(new CrewEntity("5ebf1b7323a9a60006e03a7b", "Douglas Hurley", "NASA", "https://en.wikipedia.org/wiki/Douglas_G._Hurley","5eb87d46ffd86e000604b388", "active" ));
            return null;
        }
    }
}
