package net.castroebarros.babbage;
public class Job {
  private String printer;
  private String content;

  public Job(String printer, String content) {
    this.printer = printer;
    this.content = content;
  }

  public String getPrinter() {
    return this.printer;
  }

  public String getContent() {
    return this.content;
  }
}
