import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoList extends Application {
    private ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>(list);
        TextField taskInput = new TextField();
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove");

        addButton.setOnAction(event -> {
            String task = taskInput.getText();
            list.add(task);
            taskInput.clear();
        });

        removeButton.setOnAction(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                list.remove(selectedIndex);
            }
        });

        HBox taskInputContainer = new HBox(taskInput, addButton, removeButton);
        taskInputContainer.setSpacing(10);
        taskInputContainer.setPadding(new Insets(10));

        VBox root = new VBox(listView, taskInputContainer);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}