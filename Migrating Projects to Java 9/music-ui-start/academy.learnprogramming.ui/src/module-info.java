module academy.learnprogramming.ui {
    requires javafx.fxml;
    requires javafx.controls;
    requires academy.learnprogramming.db;
    requires academy.learnprogramming.common;

    opens academy.learnprogramming.ui to javafx.fxml;
    exports academy.learnprogramming.ui to javafx.graphics;
}