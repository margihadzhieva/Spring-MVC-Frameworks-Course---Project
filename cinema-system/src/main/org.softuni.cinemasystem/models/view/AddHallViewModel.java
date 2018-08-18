package org.softuni.cinemasystem.models.view;

import java.util.ArrayList;
import java.util.List;

public class AddHallViewModel {

    private String id;

    private List<String> cinemas;

    public AddHallViewModel() {
        this.cinemas = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<String> cinemas) {
        this.cinemas = cinemas;
    }
}
