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
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

  Connection conn;
  Statement stmt;

  // declare ObservableList
  ObservableList<Product> productObservableList;

  // ArrayList of production records
  ArrayList<ProductionRecord> productionRun = new ArrayList<>();

  @FXML private TextField txtPass;

  @FXML private Label lblValid;

  @FXML private Label lblInvalid;

  @FXML private TextArea credentials;

  @FXML private TextField empName;

  @FXML private TextField txtProdName;

  @FXML private TextField txtManufacturer;

  @FXML private TextArea txtAreaProdLog;

  @FXML private TableView<Product> tableView;

  @FXML private TableColumn<?, ?> colName;

  @FXML private TableColumn<?, ?> colManu;

  @FXML private TableColumn<?, ?> colType;

  @FXML private ListView<Product> listViewProduce;

  @FXML
  void buttonAddProduct(ActionEvent event) {
    try {
      // add Product into DB
      String nameTxt = txtProdName.getText();
      String manuTxt = txtManufacturer.getText();
      String typeChc = chcBoxItemType.getValue();

      String sql = "INSERT INTO PRODUCT (name, type, manufacturer)" + "VALUES (?,?,?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, nameTxt);
      ps.setString(3, manuTxt);
      ps.setString(2, typeChc);

      // update table
      ps.executeUpdate();
      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    setupProductLineTable();
    loadProductList();
  }

  @FXML
  void buttonRecordProd(ActionEvent event) {
    // ArrayList for ProductionRecord DB
    ArrayList<ProductionRecord> productionRun = new ArrayList<>();

    addToProductionDB(productionRun);
    loadProductionLog(productionRun);
    showProduction(productionRun);
  }

  @FXML
  void buttonLogin(ActionEvent event) {
    String name = empName.getText();
    String pass = txtPass.getText();
    Employee e = new Employee(name, pass);
    // check if password is valid
    if (e.isValidPassword(pass)) {
      lblValid.setText("Valid Password. Continue");
    } else {
      lblValid.setText("Invalid Password. Retry");
    }
  }

  @FXML
  void signUp(ActionEvent event) {
    String name = empName.getText();
    String pass = txtPass.getText();
    Employee e = new Employee(name, pass);
    // finds employee credentials
    credentials.setText(e.toString());
  }

  @FXML private ChoiceBox<String> chcBoxItemType;

  @FXML private ComboBox<String> cmbQuantity;

  @FXML
  void connectToDB() {
    try {
      final String JDBC_DRIVER = "org.h2.Driver";
      final String DB_URL = "jdbc:h2:./resources/db";

      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      final String USER = "";
      conn = DriverManager.getConnection(DB_URL, USER, reverseString(txtPass.getText()));
    } catch (ClassNotFoundException | SQLException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Initializer method that initializes the ComboBox and the ChoiceBox. Defines the ObservableList.
   * Calls methods to set up product line table and production log.
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

    // shows password requirements
    lblInvalid.setText(
        "Password must contain:"
            + "\nA lowercase letter \nAn uppercase letter \nA special character");

    // define ObservableList
    productObservableList = FXCollections.observableArrayList();

    connectToDB();
    setupProductLineTable();
    loadProductionLog(productionRun);
  }

  /** This method sets up table view on product line tab. Adds items to list view on produce tab. */
  public void setupProductLineTable() {
    colName.setCellValueFactory(new PropertyValueFactory("name"));
    colManu.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    colType.setCellValueFactory(new PropertyValueFactory("type"));
    tableView.setItems(productObservableList);

    listViewProduce.setItems(productObservableList);
  }

  /** This method gets products from product database and adds them to observable list. */
  public void loadProductList() {
    try {
      String sql = "SELECT * FROM PRODUCT";
      stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);

      ItemType item;

      while (resultSet.next()) {
        String name = resultSet.getString(2);
        String typeCode = resultSet.getString(3);
        String manu = resultSet.getString(4);

        switch (typeCode) {
          case "AUDIO":
            item = ItemType.AUDIO;
            break;
          case "VISUAL":
            item = ItemType.VISUAL;
            break;
          case "AUDIO_MOBILE":
            item = ItemType.AUDIO_MOBILE;
            break;
          default:
            item = ItemType.VISUAL_MOBILE;
        }

        Widget w = new Widget(name, manu, item);

        // add to ObservableList from new Product
        productObservableList.add(w);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method created Production Record objects and stores them in the ArrayList.
   *
   * @param productionRun ArrayList of Production Record objects.
   */
  public void loadProductionLog(ArrayList<ProductionRecord> productionRun) {
    try {
      String sql = "SELECT * FROM PRODUCTIONRECORD";
      PreparedStatement rps = conn.prepareStatement(sql);
      ResultSet resultSet = rps.executeQuery();
      while (resultSet.next()) {
        int prodNum = resultSet.getInt(1);
        int prodID = resultSet.getInt(2);
        String serial = resultSet.getString(3);
        Date prodDate = resultSet.getDate(4);
        ProductionRecord productionRecord = new ProductionRecord(prodNum, prodID, serial, prodDate);
        productionRun.add(productionRecord);
      }
      showProduction(productionRun);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method adds text to the production log from the production run ArrayList.
   *
   * @param productionRun ArrayList of Production Record objects.
   */
  public void showProduction(ArrayList<ProductionRecord> productionRun) {
    for (ProductionRecord productionRecord : productionRun) {
      txtAreaProdLog.appendText(productionRecord.toString());
    }
  }

  /**
   * This method adds each Production Record object into the Production Record database.
   *
   * @param productionRun ArrayList of Production Record objects.
   */
  public void addToProductionDB(ArrayList<ProductionRecord> productionRun) {
    int prodCount = Integer.parseInt(cmbQuantity.getValue());
    // get selected product from Product Line ListView
    Product productFromEntry = listViewProduce.getSelectionModel().getSelectedItem();
    ProductionRecord pr = new ProductionRecord(productFromEntry, prodCount);
    Timestamp ts = new Timestamp(pr.getProdDate().getTime());
    String sql =
        "INSERT INTO PRODUCTIONRECORD (PRO"
            + "DUCTION_NUM,PRODUCT_ID,SERIAL_NUM,DATE_PRODUCED)"
            + " VALUES (?,?,?,?)";
    try {
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, pr.getProductionNum());
      ps.setInt(2, pr.getProductID());
      ps.setString(3, pr.getSerialNum());
      ps.setTimestamp(4, ts);
      ps.executeUpdate();

      ps.close();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  public String reverseString(String id) {
    if (id.isEmpty()) {
      return id;
    }

    return reverseString(id.substring(1)) + id.charAt(0);
  }
}
