package sample;



import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    public TextField SearchBar;
    public TextArea OpskriftP; // Klasse Variabler
    public TextField PPersEa;

    public ArrayList arraypasta() { // Metode Der returner en ArrayList
        ArrayList<Pasta> pastas = new ArrayList<Pasta>(); // Arraylist her fra og ned til pastas.add.
        pastas.add(new Pasta(100, "Gram Pasta"));
        pastas.add(new Pasta(25, "Gram Bacon"));
        pastas.add(new Pasta(1, "Tsk Smør"));
        pastas.add(new Pasta(1, "Løg i tern"));
        pastas.add(new Pasta(1, "Æg"));
        pastas.add(new Pasta(13, "Gram Parmesan"));
        pastas.add(new Pasta(13, "Gram Parmesan for tilbehør"));
        return pastas; // returner
    }

    public void buttonOnAction() throws IOException { //metode første button i KogebogGUI.fxml.
        String search = SearchBar.getText(); // text fra textfield.
        int numbers = Integer.parseInt(search); // lavet om til en "int".
        switch (numbers) { // Start på Switch.
            case 1:
                System.out.println("Pasta Carbonara"); // Viser det i Terminalen.
                Parent root = FXMLLoader.load(getClass().getResource("PastaCabonaraGUI.fxml")); // kalder efter rigtige GUI.
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show(); // Lave en ny Scene.
                break;
            case 2:
                System.out.println("Bøf med løg");
                Parent root1 = FXMLLoader.load(getClass().getResource("BøfMedLøg.fxml"));
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
                break;
            case 3:
                System.out.println("Salat med Tun");
                Parent root2 = FXMLLoader.load(getClass().getResource("SalatMedTun.fxml"));
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root2));
                stage2.show();
                break;

        }
    }
    public void searchbarOnAction() { // metode SeachBar for KogebogGUI.fxml
        System.out.println("Enter"); // for terminalen
        SearchBar.setOnKeyPressed(new EventHandler<KeyEvent>() { //Key Handler. Der gør at den kan reagere med "Enter" når trykket på.
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    try { // Try/Catch til fejl håndtering.
                        buttonOnAction();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void PPersEach() { // metode for Pasta Scene for TextArea
        ArrayList<Pasta> pasto = arraypasta(); // Arraylist der kalder efter "arrayish return"
        String search = PPersEa.getText(); // String der gør det muligt at bruge ord.
        int antal = Integer.parseInt(search); // int der gør det muligt at bruge tal.
        PPersEa.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ENTER) {
                    OpskriftP.clear();
                    int total = 0;
                    for (Pasta p : pasto) {
                        total += p.tal;
                        System.out.println(p.tal + " " + p.ord);
                        OpskriftP.appendText(p.tal * antal + " " + p.ord + "\n");
                    }
                }
            }
        });
        System.out.println("___________________________________________________");
        System.out.println("Mad for hvor mange mennesker?");
        System.out.println(antal);
        System.out.println("Enter");
// De her 4 linjer skriver det ned i Terminalen.
    }
}


