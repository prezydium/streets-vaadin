package org.prezydium.streets.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.ui.window.AboutWindow;

@SpringView(name = WelcomeView.VIEW_NAME)
public class WelcomeView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    private Button gameButton = new Button("Start Game", this::startGame);
    private Button toplistButton = new Button("See Winners", this::openTopllist);
    private Button aboutButton = new Button("About", this::openAboutWindow);

    public WelcomeView() {
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        addComponents(gameButton, toplistButton, aboutButton);
    }

    public void startGame(Button.ClickEvent clickEvent) {
        UI.getCurrent().getNavigator().navigateTo(GameView.VIEW_NAME);
    }

    public void openTopllist(Button.ClickEvent clickEvent) {
        UI.getCurrent().getNavigator().navigateTo(WinnersListView.VIEW_NAME);
    }

    public void openAboutWindow(Button.ClickEvent clickEvent) {
        UI.getCurrent().addWindow(new AboutWindow());
    }
}
