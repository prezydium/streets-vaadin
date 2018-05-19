package org.prezydium.streets.ui.view;

import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

import java.awt.event.KeyEvent;

public class AboutWindow extends Window{

    private VerticalLayout verticalLayout = new VerticalLayout();

    private Label header = new Label("Guess Gdańsk Street:");
    private Label body = new Label("Poczuj się jak prawdziwy petent w urzędzie. " +
            "Spróbuj zgadnąć nazwa jakiej ulicy w Gdańsku została wylosowana i jest ukryta pod X-ami. " +
            "Uważaj jednak, nazwa ta odzwierciedla pełną nazwą, którą nadała rada miasta np." +
            "\"PLAC OBROŃCÓW POCZTY POLSKIEJ\". Pytasz się czemu plac jest ulicą? Takie są przepisy. Nie zadawaj pytań.");
    private Panel panel = new Panel(body);


    public AboutWindow(){
        this.addBlurListener((FieldEvents.BlurListener) event -> UI.getCurrent().removeWindow(this));
        this.setWidth("50%");
        body.setWidth("100%");
        panel.setWidth("100%");
        setModal(true);
        verticalLayout.addComponents(header, panel);
        this.setContent(verticalLayout);
    }
}
