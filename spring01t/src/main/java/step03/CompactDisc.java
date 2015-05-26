package step03;

import java.util.List;

public class CompactDisc {
  String artist;
  String title;
  List<String> musics;
  
  @Override
  public String toString() {
    return "CompactDisc [artist=" + artist + ", title=" + title + ", musics="
        + musics + "]";
  }

  public CompactDisc() {
    System.out.println("CompactDisc() 생성");
  }
  
  public String getArtist() {
    return artist;
  }
  public void setArtist(String artist) {
    System.out.println("setArtist() 호출");
    this.artist = artist;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    System.out.println("setTitle() 호출");
    this.title = title;
  }
  public List<String> getMusics() {
    return musics;
  }
  public void setMusics(List<String> musics) {
    System.out.println("setMusics() 호출");
    this.musics = musics;
  }
  
  
}
