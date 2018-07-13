package org.prezydium.streets.jpa;

import org.prezydium.streets.model.Winner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WinnersList {

    private final WinnersRepository winnersRepository;

    public WinnersList(WinnersRepository winnersRepository) {
        this.winnersRepository = winnersRepository;
    }

    public List<Winner> getWinnersList(){
        return winnersRepository.findAll();
    }
}
