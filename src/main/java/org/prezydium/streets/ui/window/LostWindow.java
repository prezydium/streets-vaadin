package org.prezydium.streets.ui.window;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import org.prezydium.streets.ui.StreetsUI;

public class LostWindow extends AbstractWindow {

    private VerticalLayout verticalLayout = new VerticalLayout();

    private Panel streetPanel;
    private Label streetLabel;

    public LostWindow(String unguessedWord) {
        header = new Label("Przegrałeś! To był/a:");
        streetLabel = new Label(unguessedWord);
        streetPanel = new Panel(streetLabel);
        header.setWidth("100%");
        streetLabel.setWidth("100%");
        streetPanel.setWidth("100%");
        verticalLayout.setWidth("100%");
        this.setWidth("50%");
        this.center();
        this.setModal(true);
        verticalLayout.addComponents(header, streetPanel);
        this.setContent(verticalLayout);
        this.addCloseListener(closeEvent -> StreetsUI.resetGame());
    }
}
