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
   /* private Random random = new Random();
    private Label createLabel(){
        Label label = LabelBuilder.create().text("Some Text").prefWidth(100).prefHeight(50).alignment(Pos.CENTER).layoutX(random.nextInt(windowWidth-100))
        return label;
    }*/
   public void print(Node node) {
       ChoiceDialog dialog = new ChoiceDialog(Printer.getDefaultPrinter(), Printer.getAllPrinters());
       dialog.setHeaderText("Choose the printer!");
       dialog.setContentText("Choose a printer from available printers");
       dialog.setTitle("Printer Choice");
       Optional<Printer> opt = dialog.showAndWait();
       if (opt.isPresent()) {
           Printer printer = opt.get();
          // PageLayout pageLayout = printer.createPageLayout(file,PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
           PrinterJob job = PrinterJob.createPrinterJob();
           job.setPrinter(printer);
           if (job != null) {
               boolean success = job.printPage(node);
               if (success) {
                   job.endJob();
               }
           }
       }
   }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setTitle("Hello World");
       // Group root1 = new Group();
      //  Scene scene = new Scene(root1, 300, 275);
        File pdfFile = new File("C:/Users/sereo_000/Downloads/magistratura_1_kurs_4_f-t.pdf");

       //root1.getChildren().add(pdfFile);
        //Printer.getAllPrinters();
        //public static ObservableSet<Printer> getAllPrinters();
        //ChoiceDialog dialog = new ChoiceDialog(Printer.getAllPrinters());
        Node node = null;
        final VBox root = new VBox(5);
        Scene scene1 = new Scene(root);
        scene1.setUserData(pdfFile);
        // Add the scene to the Stage
        primaryStage.setScene(scene1);
        // Set the title of the Stage
        primaryStage.setTitle("A Printing Nodes Example");
        // Display the Stage
        primaryStage.show();
        //node.getTransforms().add(pdfFile);
        print(root);
       // ObservableSet<Printer> printer = Printer.getAllPrinters();
       // Button btn = new Button();
       // btn.setLayoutX(100);
      //  btn.setLayoutY(80);
       // btn.setText("Hello World");
/*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
*/
       /* root1.getChildren().add(btn);
        //root1.getChildren().add((Node) printer);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
