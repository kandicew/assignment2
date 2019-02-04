package assignment2;

import java.io.PrintWriter;
import java.lang.Thread;
import java.awt.Graphics;
import java.awt.Font;


public class SpeedReader {
  // fields
  String filename;
  int width;
  int height;
  String fontSize;
  int wpm;
  Font font = new Font("Courier", Font.BOLD, 46);

  /*
   * //constructor public SpeedReader (String fname, int w, int h, String fSize, int wPerM) throws
   * Exception{ 
   * this.filename = fname; 
   * this.width = w; 
   * this.height = h; 
   * this.fontSize = fSize;
   * this.wpm = wPerM; }
   */

  public void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 5) {
      System.err.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
      System.exit(1);
    } else {
      this.filename = args[0];
      this.width = Integer.parseInt(args[1]);
      this.height = Integer.parseInt(args[2]);
      this.fontSize = args[3];
      this.wpm = Integer.parseInt(args[4]);
    }

    WordGenerator input = new WordGenerator(this.filename);
    DrawingPanel panel = new DrawingPanel(this.width, this.height);
    Graphics output = panel.getGraphics();
    output.setFont(font);
    while (input.hasNext()) {
      output.drawString(input.next(), 100, 100);
      Thread.sleep(60000/this.wpm);
    }
  }

  // methods


}
