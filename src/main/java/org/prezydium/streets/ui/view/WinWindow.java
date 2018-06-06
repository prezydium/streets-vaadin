package org.prezydium.streets.ui.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import org.prezydium.streets.logic.GameRound;

public class WinWindow extends AbstractWindow {

    private FormLayout formLayout = new FormLayout();

    private TextField nickTextField = new TextField();

    private Button submitButton = new Button("Dodaj");

    public WinWindow(GameRound gameRound) {
        formLayout.addComponents(nickTextField, submitButton);
        setBodyText("Gratulacje, jesteś zwycięzcą! To była: "
                + gameRound.getActualGuessedLetters() + ". Jeżeli chcesz dodaj się do listy zwycięzców");
        verticalLayout.addComponent(formLayout);
    }
}