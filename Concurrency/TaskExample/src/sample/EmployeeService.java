package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {

    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Jack Daniels",
                        "Mary Jane",
                        "Jim Beam",
                        "Chivas Regal",
                        "Johnny Walker",
                        "Captain Morgan"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                for(int i = 0; i < names.length; i++) {
                    updateMessage("Added " + names[i] + " to the list");
                    Thread.sleep(200);
                    employees.add(names[i]);
                    updateProgress(i+1, names.length);
                }

                return employees;
            }
        };
    }
}
