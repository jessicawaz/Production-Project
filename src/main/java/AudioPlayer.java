public class AudioPlayer extends Product implements MultimediaControl {

  // fields
  public String supportedAudioFormats;
  public String supportedPlaylistFormats;

  /**
   * AudioPlayer Constructor.
   *
   * @param name Product name
   * @param manufacturer Product manufacturer
   * @param supportedPlaylistFormats Supported playlists
   * @param supportedAudioFormats Supported Audio
   */
  public AudioPlayer(
      String name,
      String manufacturer,
      String supportedPlaylistFormats,
      String supportedAudioFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
  }

  /** Plays the product and displays play message. */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /** Stops the product and displays stop message. */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /** Rewinds and displays previous message. */
  @Override
  public void previous() {
    System.out.println("Previous");
  }

  /** Skips and displays skip message. */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * toString method that formats the AudioPlayer information.
   *
   * @return formatted string with audio/playlist information
   */
  @Override
  public String toString() {
    return super.toString()
        + "\nSupported Audio Formats: "
        + supportedAudioFormats
        + "\nSupported Playlist Formats: "
        + supportedPlaylistFormats;
  }
}
