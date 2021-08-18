package application.example.crewdetails;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CrewDao {
    @Insert(onConflict = REPLACE)
    void insert(CrewEntity crewEntity);

    @Insert
    void insertAll(CrewEntity...crewEntities);

    @Delete
    void delete(CrewEntity crewEntity);

    @Query("SELECT * FROM crew")
    LiveData<List<CrewEntity>> getAllCrew();

}
