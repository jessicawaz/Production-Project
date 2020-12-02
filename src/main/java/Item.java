public interface Item {

  /**
   * Gets product ID.
   *
   * @return product ID
   */
  int getId();

  /**
   * Sets product name.
   *
   * @param name Product name
   */
  void setName(String name);

  /**
   * Gets product name.
   *
   * @return product name
   */
  String getName();

  /**
   * Sets product manufacturer.
   *
   * @param manu Product manufacturer
   */
  void setManufacturer(String manu);

  /**
   * Gets product manufacturer.
   *
   * @return product manufacturer
   */
  String getManufacturer();

  /**
   * Gets product type.
   *
   * @return product type
   */
  ItemType getType();

  /**
   * Sets product type.
   *
   * @param type Product type
   */
  void setType(ItemType type);
}
