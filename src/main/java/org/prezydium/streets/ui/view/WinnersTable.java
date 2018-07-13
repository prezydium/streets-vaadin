package org.prezydium.streets.ui.view;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.model.Winner;

import java.util.List;

public class WinnersTable extends VerticalLayout {

    private Grid<Winner> grid;

    public WinnersTable(List<Winner> list){
        grid =new Grid<Winner>();
grid.addColumn("position");
grid.addColumn("name");
grid.addColumn("remaining time");
    }
}
