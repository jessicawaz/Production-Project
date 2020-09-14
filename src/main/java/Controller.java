import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtProdName;

    @FXML
    private TextField txtManufacturer;

    @FXML
    private Button buttonAddProduct;

    @FXML
    void buttonAddProduct(ActionEvent event) {
        System.out.println("button pressed");
    }

    @FXML
    void buttonRecordProd(ActionEvent event) {
        System.out.println("button record");
    }
}