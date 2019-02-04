package assignment2;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Font;


public class WordGenerator {

  // field
  String filename;
  int wordCount = 0;
  int sentCount = 0;


  // constructor
  public WordGenerator(String fname) {
    this.filename = fname;
  }

  // methods
  public boolean hasNext() throws IOException {
    Scanner text = new Scanner(new File(this.filename));
    return text.hasNext();
  }

  public String next() throws IOException {
    Scanner text = new Scanner(new File(this.filename));
    this.wordCount++;
    String current = text.next();
    char last = current.charAt(current.length() - 1);
    if (last == '.' || last == '!' || last == '?') {
      this.sentCount++;
    }
    return current;
  }

  public int getWordCount() {
    return this.wordCount;
  }

  public int getSentenceCount() {
    return this.sentCount;
  }
}
