package application.example.crewdetails;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "crew")
public class CrewEntity {
    @PrimaryKey
    @NonNull
    private String id;
    private String name;

    private String agency;

    private String wikipedia;
    private String launches;
    private String status;

    public CrewEntity(String id, String name, String agency, String wikipedia, String launches,  String status) {
        this.id = id;
        this.name = name;
        this.agency = agency;
        this.wikipedia = wikipedia;
        this.launches = launches;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getLaunches() {
        return launches;
    }

    public void setLaunches(String launches) {
        this.launches = launches;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
