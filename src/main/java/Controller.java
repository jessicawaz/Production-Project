/*
* Author: Jessica Wazbinski
* Purpose: Controller for production project. Utilizes sql and database
* for adding and updating products.
* Date: 9/19/2020
*/

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

  @FXML private TextField txtProdName;

  @FXML private TextField txtManufacturer;

  @FXML private Button buttonAddProduct;

  @FXML
  void buttonAddProduct(ActionEvent event) {
    connectToDb();
  }

  @FXML private Label lblAdded;

  @FXML
  void buttonRecordProd(ActionEvent event) {}

  @FXML
  private ChoiceBox<String> chcBoxItemType;

  @FXML private ComboBox<String> cmbQuantity;

  /**
   * initializes combobox values and allows for editing.
   * initialized choicebox values.
   */
  public void initialize() {
    for (int count = 1; count <= 10; count++) {
      cmbQuantity.getItems().add(String.valueOf(count));
    }
    cmbQuantity.setEditable(true);
    cmbQuantity.getSelectionModel().selectFirst();
    for (ItemType itemType : ItemType.values()) {
      chcBoxItemType.getItems().add(String.valueOf(itemType));
    }
  }

  /**
   * Connect to database & add SQL.
   */
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

      // STEP 2: Open a connection
      // findbugs problem because there is no password
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // STEP 3: Execute a query
      // findbugs problem
      stmt = conn.createStatement();


      String inSql = "INSERT INTO Product(type, manufacturer, name) "
              + "VALUES ( name=?, type=?, manufacturer=? )";

      String nameTxt = txtProdName.getText();

      String manuTxt = txtManufacturer.getText();

      String typeChc = chcBoxItemType.getValue();

      // update name, type, & manu
      String sql = "update product set name=? , type=? , manufacturer=? ";

      PreparedStatement preparedStatement = conn.prepareStatement(sql);

      preparedStatement.setString(1, nameTxt);
      preparedStatement.setString(2, typeChc);
      preparedStatement.setString(3, manuTxt);
      preparedStatement.executeUpdate();

      // print to console
      System.out.println(nameTxt);
      System.out.println(manuTxt);
      System.out.println(typeChc);

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
      preparedStatement.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
