package application.example.crewdetails;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CrewViewModel extends AndroidViewModel {
    private ContactRepository contactRepository;
    private LiveData<List<CrewEntity>> allCrew;

    public CrewViewModel(@NonNull Application application) {
        super(application);
        contactRepository = new ContactRepository((application));
        allCrew = contactRepository.getAllCrew();
    }

    public void insert(CrewEntity crewEntity){
        contactRepository.insert(crewEntity);
    }

    public void delete(CrewEntity crewEntity){
        contactRepository.delete(crewEntity);
    }

    public LiveData<List<CrewEntity>> getAllCrew(){
        return allCrew;
    }
}
