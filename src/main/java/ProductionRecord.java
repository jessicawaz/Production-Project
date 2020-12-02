import java.util.Date;

public class ProductionRecord {

  // fields
  private int productionNumber = 0;
  private int productID;
  private String serialNumber;
  private Date dateProduced;
  private static int prodCount = 1;

  // spotbugs error because never used
  /**
   * First ProductionRecord constructor.
   *
   * @param productID sets productID to local productID variable.
   */
  public ProductionRecord(int productID) {
    productionNumber++;
    serialNumber = "0";
    dateProduced = new Date();
    this.productID = productID;
  }

  // spotbugs error because never used
  /**
   * Second ProductionRecord constructor.
   *
   * @param dateProduced Product's production Nnmber.
   * @param productID Product's ID number.
   * @param productionNumber Product's unique serial number.
   * @param serialNumber Date that product was produced.
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * ProductionRecord constructor used in controller for product log text area.
   *
   * @param product New Product object.
   * @param prodCount Count of products.
   */
  public ProductionRecord(Product product, int prodCount) {
    productionNumber = prodCount;
    productID = product.getId();
    this.serialNumber = genSerialNum(product);
    dateProduced = new Date();
  }

  /**
   * Generates a serial number for each product.
   *
   * @param product New product object.
   * @return Product's unique serial number.
   */
  public String genSerialNum(Product product) {
    String serialNum;
    serialNum =
        product.getManufacturer().substring(0, 3)
            + product.type.code
            + String.format("%05d", prodCount);
    prodCount++;
    return serialNum;
  }

  /**
   * Gets production number.
   *
   * @return productionNumber
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * Sets production number.
   *
   * @param prodNum Production Number
   */
  public void setProductionNum(int prodNum) {
    productionNumber = prodNum;
  }

  /**
   * Sets production ID.
   *
   * @param prodID Production ID
   */
  public void setProductID(int prodID) {
    productID = prodID;
  }

  /**
   * Gets production ID.
   *
   * @return productID ID of product created
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Sets serial number.
   *
   * @param serialNum Serial Number of the created product
   */
  public void setSerialNum(String serialNum) {
    serialNumber = serialNum;
  }

  /**
   * Gets serial number.
   *
   * @return serial number of the product
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * Sets the date that the product is produced.
   *
   * @param dateProduced Date that the product was produced
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Gets produced date.
   *
   * @return date that the product was produced
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * Formats product information.
   *
   * @return Formatted product information.
   */
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
