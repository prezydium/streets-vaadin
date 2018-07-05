package org.prezydium.streets.ui.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import org.prezydium.streets.jpa.ProcessWinner;
import org.prezydium.streets.logic.GameRound;
import org.prezydium.streets.ui.StreetsUI;
import org.prezydium.streets.util.ApplicationContextUtils;
import org.springframework.context.ApplicationContext;

public class WinWindow extends AbstractWindow {

    private final GameRound gameRound;
    private FormLayout formLayout = new FormLayout();
    private TextField nickTextField = new TextField();
    private Button submitButton = new Button("Dodaj", this::saveWinner);

    private ApplicationContext appCtx = ApplicationContextUtils
            .getApplicationContext();

    private ProcessWinner processWinner = (ProcessWinner) appCtx.getBean(ProcessWinner.class);

    public WinWindow(GameRound gameRound) {
        this.gameRound = gameRound;
        nickTextField.setValue("");
        formLayout.addComponents(nickTextField, submitButton);
        setBodyText("Gratulacje, jesteś zwycięzcą! To była: "
                + gameRound.getActualGuessedLetters() + ". Jeżeli chcesz dodaj się do listy zwycięzców");
        verticalLayout.addComponent(formLayout);
        this.addCloseListener(closeEvent -> StreetsUI.resetGame());
    }

    private void saveWinner(Button.ClickEvent clickEvent) {
        processWinner.saveWinner(nickTextField.getValue(), gameRound.getActualChances());
        this.close();
    }

}