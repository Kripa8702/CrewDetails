package application.example.crewdetails;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CrewViewModel crewViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);

        final CrewAdapter ad= new CrewAdapter();
        recyclerView.setAdapter(ad);

        crewViewModel = ViewModelProviders.of(this).get(CrewViewModel.class);
        crewViewModel.getAllCrew().observe(this, new Observer<List<CrewEntity>>() {
            @Override
            public void onChanged(@Nullable List<CrewEntity> crewEntities) {
                ad.setCrew(crewEntities);
            }
        });
    }
}