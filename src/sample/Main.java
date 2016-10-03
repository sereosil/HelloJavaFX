package sample;

import javafx.application.Application;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.print.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;
import java.util.Random;

import static javafx.print.Printer.getAllPrinters;

public class Main extends Application {
   public String print(Node node) {
       ChoiceDialog dialog = new ChoiceDialog(Printer.getDefaultPrinter(), Printer.getAllPrinters());
       dialog.setHeaderText("Choose the printer!");
       dialog.setContentText("Choose a printer from available printers");
       dialog.setTitle("Printer Choice");
       Optional<Printer> opt = dialog.showAndWait();
       if (opt.isPresent()) {
           Printer printer = opt.get();
           String nameOfPrinter=printer.getName();
           return nameOfPrinter;
       }
       return null;
   }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Node node=null;
        print(node);
    }
}
