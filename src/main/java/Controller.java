/*
 * Author: Jessica Wazbinski
 * Purpose: Controller for production project. Utilizes sql and database
 * for adding and updating products.
 * Date: 9/19/2020
 */

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

  @FXML private TextField txtProdName;

  @FXML private TextField txtManufacturer;

  @FXML private TextArea txtAreaProdLog;

  @FXML private TableView<Product> tableView;

  @FXML private TableColumn<?, ?> colName;

  @FXML private TableColumn<?, ?> colManu;

  @FXML private TableColumn<?, ?> colType;

  @FXML private ListView<String> listViewProduce;

  @FXML
  void buttonAddProduct(ActionEvent event) {
    connectToDb();
    addToListView();
    setUpProductLineTable();
  }

  @FXML
  void buttonRecordProd(ActionEvent event) {
    record();
  }

  @FXML private ChoiceBox<String> chcBoxItemType;

  @FXML private ComboBox<String> cmbQuantity;

  // list of products in product line tab
  ObservableList<Product> productLine =
      FXCollections.observableArrayList(
          // new Widget(txtProdName.getText(), txtManufacturer.getText(),
          );

  /** Adds products to list view on produce tab */
  public void addToListView() {
    // add product to ListView in produce tab
    listViewProduce.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    listViewProduce
        .getItems()
        .addAll(
            txtProdName.getText()
                + "\n"
                + txtManufacturer.getText()
                + "\n"
                + chcBoxItemType.getValue());
  }

  /** Updates table on product line tab. */
  public void setUpProductLineTable() {
    // add column data
    colName.setCellValueFactory(new PropertyValueFactory("name"));
    colManu.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    colType.setCellValueFactory(new PropertyValueFactory("type"));
    tableView.setItems(productLine);
  }

  /** Records product to production log. */
  public void record() {
    // for loop to add to product log selected amount of times
    for (int q = 0; q <= cmbQuantity.getSelectionModel().getSelectedIndex(); q++) {
      // add text from ProductionRecord to product log text area
      Product product =
          new Product(txtProdName.getText(), txtManufacturer.getText(), ItemType.AUDIO) {};
      ProductionRecord pr = new ProductionRecord(product, product.getId());
      txtAreaProdLog.appendText(String.valueOf(pr));
    }
  }

  /**
   * initializes combobox values and allows for editing. initializes choicebox values. initializes
   * product log text area
   */
  public void initialize() {

    // initialize combo box, sets editable
    for (int count = 1; count <= 10; count++) {
      cmbQuantity.getItems().add(String.valueOf(count));
    }
    cmbQuantity.setEditable(true);
    cmbQuantity.getSelectionModel().selectFirst();

    // initializes choice box
    for (ItemType itemType : ItemType.values()) {
      chcBoxItemType.getItems().add(String.valueOf(itemType));
    }
  }

  /** Connect to database & add SQL. */
  public void connectToDb() {

    // spotbugs problem
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./resources/db";

    //  Database credentials
    // spotbugs problem
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      // spotbugs problem because there is no password
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // STEP 3: Execute a query
      // spotbugs problem
      stmt = conn.createStatement();

      // get text from input
      String nameTxt = txtProdName.getText();
      String manuTxt = txtManufacturer.getText();
      String typeChc = chcBoxItemType.getValue();

      // add values from input to product table
      final String sql = "INSERT INTO PRODUCT (name, type, manufacturer)" + "VALUES (?,?,?)";

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, nameTxt);
      ps.setString(2, typeChc);
      ps.setString(3, manuTxt);

      //      ps.executeUpdate();

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
      ps.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
