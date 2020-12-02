public class MoviePlayer extends Product implements MultimediaControl {

  Screen screen;
  MonitorType monitorType;

  /**
   * MoviePlayer Constructor that sets name, manufacturer, screen, and monitor type.
   *
   * @param name Product name
   * @param manufacturer Product manufacturer
   * @param screen Product screen type
   * @param monitorType Product monitor type
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    this(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * MoviePlayer constructor that uses super from Product class.
   *
   * @param name Product name
   * @param manufacturer Product manufacturer
   * @param type Product type
   */
  public MoviePlayer(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  /** Plays movie. */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /** Stops movie. */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /** Previous movie. */
  @Override
  public void previous() {
    System.out.println("Going back");
  }

  /** Skips movie. */
  @Override
  public void next() {
    System.out.println("Skipping");
  }

  /**
   * toString method that formats the monitor type and screen type.
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return super.toString()
        + "\nScreen             : "
        + screen
        + "\nMonitor Type       : "
        + monitorType;
  }
}
