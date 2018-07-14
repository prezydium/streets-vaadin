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

/*        Grid<DebtTableView> grid = new Grid<>();
        Set<DebtTableView> debtorViewList = debtorTableView.getDebtViewSet();
        grid.setItems(debtorViewList);
        grid.addColumn(DebtTableView::getDebtViewName).setId("Debt Name").setCaption("Debt Name");
        grid.addColumn(DebtTableView::getUuid).setId("Debt uuid").setCaption("Debt uuid");
        grid.addColumn(DebtTableView::getDebtViewDate).setId("Repayment Date").setCaption("Repayment Date");
        grid.addColumn(DebtTableView::getDebtViewAmount).setId("Debt Amount").setCaption("Debt Amount");
        grid.addColumn(DebtTableView::getSumPaymentViewAmount).setId("Debt Sum Payment").setCaption("Debt Sum Payment Amount");
        grid.addColumn(DebtTableView::getRemainingAmountView).setId("Remaining Amount").setCaption("Remaining Amount");
        return grid;*/
