import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.*;

public class Controller {

    @FXML
    private TextField txtProdName;

    @FXML
    private TextField txtManufacturer;

    @FXML
    private Button buttonAddProduct;

    @FXML
    void buttonAddProduct(ActionEvent event) {
        connectToDb();
    }

    @FXML
    private Label lblAdded;

    @FXML
    void buttonRecordProd(ActionEvent event) {

    }

    @FXML
    private ComboBox<String> cmbItemType;

    // add to comboBox
    public void initialize() {
        for (int count = 1; count <= 10; count++) {
            cmbItemType.getItems().add(String.valueOf(count));
        }
        cmbItemType.setEditable(true);
        cmbItemType.getSelectionModel().selectFirst();
    }

    public void connectToDb() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./resources/db";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            // set values to text
            String nameTxt = txtProdName.getText();
            String manuTxt = txtManufacturer.getText();
            String typeCmb = cmbItemType.getValue();

            // update name, type, & manu
            String sql = "update product set name=? , type=? , manufacturer=? ";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, nameTxt);
            preparedStatement.setString(2, typeCmb);
            preparedStatement.setString  (3, manuTxt);
            int row = preparedStatement.executeUpdate();

            // print to console
            System.out.println(nameTxt);
            System.out.println(manuTxt);
            System.out.println(typeCmb);


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
}

