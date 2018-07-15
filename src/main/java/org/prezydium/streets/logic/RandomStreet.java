package org.prezydium.streets.logic;

import com.vaadin.server.VaadinSession;
import org.prezydium.streets.repository.StreetsRepository;

import java.util.List;
import java.util.Random;

public class RandomStreet {

    public String getRandomStreet() {
        List<String> streets = new StreetsRepository().getStreets();
        int boundary = streets.size() - 1;
        int randomNumber = new Random().nextInt(boundary);
        String street = streets.get(randomNumber);
        setStreetToSession(street);
        return street;
    }

    private void setStreetToSession(String street) {
        VaadinSession vaadinSession = VaadinSession.getCurrent();
        if (vaadinSession != null) {
            VaadinSession.getCurrent().setAttribute("streetToGuess", street);
        }
    }
}
