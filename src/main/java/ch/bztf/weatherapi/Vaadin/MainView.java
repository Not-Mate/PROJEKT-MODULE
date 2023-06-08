package ch.bztf.weatherapi.Vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public static TextField stockSymbolField;
    private Button executeStrategyButton;
    private Button refreshLogsButton;
    public static Checkbox checkbox;
    public static String symbol;
    TextArea dynamicLog = new TextArea();

    public MainView() {
        init();
    }

    public void init() {
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        Label titleLabel = new Label("TesicForsterHumbelWetterApp");
        titleLabel.getStyle().set("font-size", "60px");
        titleLabel.getStyle().set("margin-top", "20px");
        titleLabel.getStyle().set("font-family", "'Roboto', sans-serif");
        titleLabel.getStyle().set("font-weight", "bold");
        add(titleLabel);
        HorizontalLayout searchBarLayout = new HorizontalLayout();
        stockSymbolField = new TextField();
        stockSymbolField.setWidth("500px");
        stockSymbolField.setPlaceholder("Nenne die Region der Wettervorhersage");
        stockSymbolField.getStyle().set("font-size", "24px");
        stockSymbolField.getStyle().set("color", "grey");

        searchBarLayout.add(stockSymbolField);
        searchBarLayout.getStyle().set("display", "flex");
        searchBarLayout.getStyle().set("justify-content", "center");
        add(searchBarLayout);

        HorizontalLayout buttonLayout = new HorizontalLayout();

        executeStrategyButton = new Button("Wetter anzeigen");
        refreshLogsButton = new Button("Wetter aktualisiseren");
        buttonLayout.add(executeStrategyButton, refreshLogsButton);
        buttonLayout.getStyle().set("width", "80vw");
        // center the buttons
        buttonLayout.getStyle().set("display", "flex");
        buttonLayout.getStyle().set("justify-content", "center");

        add(buttonLayout);

        dynamicLog.setPlaceholder("Wetterdaten werden hier angezeigt");
        dynamicLog.setReadOnly(true);
        dynamicLog.setWidth("10vw");
        dynamicLog.scrollIntoView();

    }
}