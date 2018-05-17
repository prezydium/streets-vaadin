package org.prezydium.streets.logic;

import org.prezydium.streets.repository.StreetsRepository;

import java.util.List;
import java.util.Random;

public class RandomStreet {

    public String getRandomStreet() {
        List<String> streets = new StreetsRepository().getStreets();
        int boundary = streets.size() - 1;
        int randomNumber = new Random().nextInt(boundary);
        return streets.get(randomNumber);
    }


}
