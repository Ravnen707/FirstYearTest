package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;



public class Controller {
    public TextField SearchBar;

    public void buttonOnAction() {
    String search = SearchBar.getText();
    int numbers = Integer.parseInt(search);
    switch(numbers) {
        case 1:
            System.out.println("Pasta Carbonara"); // Viser det i Terminalen.
            break;
        case 2:
            System.out.println("Bøf med løg");
            break;
        case 3:
            System.out.println("Salat med Tun");
            break;
    }
    }
        public void searchbarOnAction(ActionEvent actionEvent) {
            System.out.println("Enter"); // for terminalen
        }
}
