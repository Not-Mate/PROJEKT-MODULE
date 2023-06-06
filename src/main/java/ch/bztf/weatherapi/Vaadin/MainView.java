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
    private Button deleteLogsButtom;
    public static Checkbox checkbox;
    public static String symbol;
    TextArea dynamicLog = new TextArea();

    private boolean autonomously = false;


    public MainView() {
        init();
    }
    public void init(){
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        Label titleLabel = new Label("NiederbergerHumljanTradeBot");
        titleLabel.getStyle().set("font-size", "60px");
        titleLabel.getStyle().set("margin-top", "20px");
        titleLabel.getStyle().set("font-family", "'Roboto', sans-serif");
        titleLabel.getStyle().set("font-weight", "bold");
        add(titleLabel);
        HorizontalLayout searchBarLayout = new HorizontalLayout();
        stockSymbolField = new TextField();
        stockSymbolField.setWidth("500px");
        stockSymbolField.getStyle().set("padding-left", "10vw");
        stockSymbolField.setPlaceholder("Which Stock would you like to Track?");
        stockSymbolField.getStyle().set("font-size", "24px");
        stockSymbolField.getStyle().set("color", "grey");

        checkbox = new Checkbox("Trade autonomously?");
        checkbox.getStyle().set("padding-top", "7.5px");

        searchBarLayout.add(stockSymbolField, checkbox);
        searchBarLayout.getStyle().set("display", "flex");
        searchBarLayout.getStyle().set("justify-content", "center");
        add(searchBarLayout);

        HorizontalLayout buttonLayout = new HorizontalLayout();

        executeStrategyButton = new Button("Execute Trading Strategy");
        refreshLogsButton = new Button("Refresh Logs");
        deleteLogsButtom = new Button("Delete Logs");
        refreshLogsButton.getStyle().set("margin-left", "1vw");
        buttonLayout.add(executeStrategyButton, refreshLogsButton, deleteLogsButtom);
        buttonLayout.getStyle().set("width", "80vw");
        //center the buttons
        buttonLayout.getStyle().set("display", "flex");
        buttonLayout.getStyle().set("justify-content", "center");
        add(buttonLayout);

        dynamicLog.setWidth("500px");
        dynamicLog.setPlaceholder("Logs will apear here");
        dynamicLog.setReadOnly(true);
        dynamicLog.setWidth("90vw");
        dynamicLog.scrollIntoView();

        add(dynamicLog);
    }
}