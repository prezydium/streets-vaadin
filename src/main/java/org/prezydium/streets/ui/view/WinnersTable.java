package org.prezydium.streets.ui.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.jpa.WinnersRepository;
import org.prezydium.streets.model.Winner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class WinnersTable extends VerticalLayout {

    private Grid<Winner> grid;
    private WinnersRepository winnersRepository;

    public WinnersTable(WinnersRepository winnersRepository) {
        List<Winner> listOfWinners = winnersRepository.findAll();
        grid = new Grid<Winner>();
        grid.setItems(listOfWinners);
        grid.addColumn(Winner::getNick).setId("Nick").setCaption("Nick");
        grid.addColumn(Winner::getChancesLeft).setId("Chances Left").setCaption("Chances Left");
        this.addComponent(grid);
    }
}
