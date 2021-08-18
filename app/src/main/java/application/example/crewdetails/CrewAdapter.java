package application.example.crewdetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.CrewHolder> {

    private List<CrewEntity> crew = new ArrayList<>();


    @NonNull
    @Override
    public CrewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new CrewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewAdapter.CrewHolder holder, int position) {
        CrewEntity currCrew = crew.get(position);
        holder.id.setText(currCrew.getId());
        holder.name.setText(currCrew.getName());
        holder.agency.setText(currCrew.getAgency());
        holder.wikipedia.setText(currCrew.getWikipedia());
        holder.launches.setText(currCrew.getLaunches());
        holder.status.setText(currCrew.getStatus());
    }

    @Override
    public int getItemCount() {
        return crew.size();
    }

    public void setCrew(List<CrewEntity> crew){
        this.crew = crew;
        notifyDataSetChanged();
    }

    public class CrewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;
        private TextView agency;
        private TextView wikipedia;
        private TextView status;
        private TextView launches;
        public CrewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            agency = itemView.findViewById(R.id.agency);
            wikipedia = itemView.findViewById(R.id.wikipedia);
            status = itemView.findViewById(R.id.status);
            launches = itemView.findViewById(R.id.launches);
        }
    }
}
