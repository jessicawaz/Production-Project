import java.sql.Date;
import java.util.ArrayList;

public class Widget extends Product {

  /**
   * Widget constructor calls Product class super.
   *
   * @param name Product name
   * @param manufacturer Product manufacturer
   * @param type Product type
   */
  public Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  /** Tests Multimedia Control. */
  public static void testMultimedia() {
    // new AudioPlayer object
    AudioPlayer newAudioProduct =
        new AudioPlayer(
            "DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");

    // new Screen object
    Screen newScreen = new Screen("720x480", 40, 22);

    // new MoviePlayer object
    MoviePlayer newMovieProduct =
        new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen, MonitorType.LCD);

    // ArrayList
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();

    // add objects to ProductList
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);

    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
}
