package org.prezydium.streets.jpa;


import org.prezydium.streets.model.Winner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessWinner {

    private final WinnersRepository winnersRepository;

    @Autowired
    public ProcessWinner(WinnersRepository winnersRepository) {
        this.winnersRepository = winnersRepository;
    }

    public boolean saveWinner(String nick, int chancesLeft){
        Winner winner = new Winner();
        winner.setNick(nick);
        winner.setChancesLeft(chancesLeft);
        winnersRepository.save(winner);
        return true;
    }
}
