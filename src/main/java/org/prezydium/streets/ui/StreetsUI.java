package org.prezydium.streets.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
@SpringViewDisplay
public class StreetsUI extends UI {

    private VerticalLayout mainLayout = new VerticalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
       setContent(mainLayout);
    }
}
