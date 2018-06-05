package org.prezydium.streets.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.ui.view.GameView;

@SpringUI
@Theme("tests-valo-flatdark")
@SpringViewDisplay
public class StreetsUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    }

    public static void resetGame(){
        UI.getCurrent().getNavigator().navigateTo(GameView.VIEW_NAME);
    }

}
