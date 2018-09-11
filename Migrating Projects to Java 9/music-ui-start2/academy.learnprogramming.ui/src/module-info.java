module academy.learnprogramming.ui {
    requires javafx.fxml;
    requires javafx.controls;
    requires academy.learnprogramming.db;

    opens academy.learnprogramming.ui to javafx.fxml;
    exports academy.learnprogramming.ui to javafx.graphics;
}