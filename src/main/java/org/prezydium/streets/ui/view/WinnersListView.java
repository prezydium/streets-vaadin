package org.prezydium.streets.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = WinnersListView.VIEW_NAME)
public class WinnersListView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "winners";

    private WinnersTable winnersTable;

    public WinnersListView(WinnersTable winnersTable){
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        this.addComponent(winnersTable);
    }
}
