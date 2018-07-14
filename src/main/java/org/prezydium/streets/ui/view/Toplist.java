package org.prezydium.streets.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = Toplist.VIEW_NAME)
public class Toplist extends VerticalLayout implements View {

    public static final String VIEW_NAME = "toplist";

    private WinnersTable winnersTable;

    public Toplist(WinnersTable winnersTable){

        this.addComponent(winnersTable);
    }
}
