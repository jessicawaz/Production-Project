import java.util.Date;

public class ProductionRecord {

  // fields
  private int productionNumber = 0;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  // use product object to access name, type, manu

  // spotbugs error because never used
  /** First ProductionRecord constructor. */
  public ProductionRecord(int productID) {
    productionNumber++;
    serialNumber = "0";
    dateProduced = new Date();
    this.productID = productID;
  }

  // spotbugs error because never used
  /** Second ProductionRecord constructor. */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    productionNumber++;
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /** ProductionRecord constructor used in controller for product log text area. */
  public ProductionRecord(Product product, int prodCount) {
    productionNumber++;
    productID = product.getId();
    this.serialNumber = genSerialNum(product, prodCount);
    dateProduced = new Date();
  }

  /** Generates a serial number for each product. */
  public String genSerialNum(Product product, int prodCount) {
    String serialNum;
    serialNum =
        product.getManufacturer().substring(0, 3)
            + product.type.code
            + String.format("%05d", productionNumber);
    return serialNum;
  }

  // accessors and mutators for all fields
  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductionNum(int prodNum) {
    productionNumber = prodNum;
  }

  public void setProductID(int prodID) {
    productID = prodID;
  }

  public int getProductID() {
    return productID;
  }

  public void setSerialNum(String serialNum) {
    serialNumber = serialNum;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setProdDate(Date date) {
    dateProduced = date;
  }

  public Date getProdDate() {
    return dateProduced;
  }

  // toString method
  @Override
  public String toString() {
    return "\nProd Num: "
        + productionNumber
        + "\nProduct ID: "
        + productID
        + "\nSerial Num: "
        + serialNumber
        + "\nDate: "
        + dateProduced;
  }
}
