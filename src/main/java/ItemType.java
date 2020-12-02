public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  public final String code;

  /**
   * ItemType constructor that sets the item code.
   *
   * @param code ItemType code
   */
  ItemType(String code) {
    this.code = code;
  }

  /**
   * This method sets the ItemType code.
   *
   * @return ItemType code
   */
  public String code() {
    return code;
  }
}
