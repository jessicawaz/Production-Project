public class Screen implements ScreenSpec {

  // fields
  String resolution;
  int refreshRate;
  int responseTime;

  /**
   * Screen constructor that uses resolution, refresh rate, and response time.
   *
   * @param resolution Screen resolution
   * @param refreshRate Screen refresh rate
   * @param responseTime Screen response time
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Screen resolution getter method.
   *
   * @return Screen resolution
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * Screen refresh rate getter method.
   *
   * @return Screen refresh rate
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * Screen response time getter method.
   *
   * @return Screen response time
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * toString method that formats screen resolution, refresh rate, and response time.
   *
   * @return Formatted screen information
   */
  @Override
  public String toString() {
    return "\nScreen resolution  : "
        + resolution
        + "\nRefresh Rate       : "
        + refreshRate
        + "\nResponse Time      : "
        + responseTime;
  }
}
