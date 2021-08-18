package application.example.crewdetails;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactRepository {
    private CrewDao crewDao;
    private LiveData<List<CrewEntity>> allcrew;

    public ContactRepository(Application application) {
        CrewDatabase crewDatabase = CrewDatabase.getInstance(application);
        crewDao = crewDatabase.crewDao();
        allcrew = crewDao.getAllCrew();
    }
    public void insert(CrewEntity crewEntity){
        new InsertCrewAsyncTask(crewDao).execute(crewEntity);
    }
     public void delete(CrewEntity crewEntity){
         new DeleteCrewAsyncTask(crewDao).execute(crewEntity);
     }
     public LiveData<List<CrewEntity>> getAllCrew(){
        return allcrew;
     }

     private static class InsertCrewAsyncTask extends AsyncTask<CrewEntity, Void, Void>{
         private CrewDao crewDao;
         public InsertCrewAsyncTask(CrewDao crewDao) {
            this.crewDao = crewDao;
         }

         @Override
         protected Void doInBackground(CrewEntity... crewEntities) {
             crewDao.insert(crewEntities[0]);
             return null;
         }
     }
     private static class DeleteCrewAsyncTask extends AsyncTask<CrewEntity, Void, Void>{
         private CrewDao crewDao;
         public DeleteCrewAsyncTask(CrewDao crewDao) {
            this.crewDao = crewDao;
         }

         @Override
         protected Void doInBackground(CrewEntity... crewEntities) {
             crewDao.delete(crewEntities[0]);
             return null;
         }
     }
}
