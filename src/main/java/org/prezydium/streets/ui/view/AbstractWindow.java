package org.prezydium.streets.ui.view;

import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

public abstract class AbstractWindow extends Window {

    protected VerticalLayout verticalLayout = new VerticalLayout();
    protected Label header = new Label("Guess Gdańsk Street:");
    protected Label body = new Label();
    protected Panel panel = new Panel(body);


    public AbstractWindow() {
        this.setWidth("50%");
        body.setWidth("100%");
        panel.setWidth("100%");
        setModal(true);
        verticalLayout.addComponents(header, panel);
        this.setContent(verticalLayout);
    }

    public VerticalLayout getVerticalLayout() {
        return verticalLayout;
    }

    public void setVerticalLayout(VerticalLayout verticalLayout) {
        this.verticalLayout = verticalLayout;
    }

    public Label getHeader() {
        return header;
    }

    public void setHeader(Label header) {
        this.header = header;
    }

    public Label getBody() {
        return body;
    }

    public void setBody(Label body) {
        this.body = body;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public void setBodyText(String s){
        body.setValue(s);
    }
}
