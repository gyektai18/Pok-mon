


public class InheritanceDriver {
  
  // The main driver method.
  public static void main(String args[]) {
    
    MYaREA area = new MYaREA();
    area.addKeyListener(area);
    area.setFocusable(true);
    
    // Use our area, and show the window.
    Window window = new Window("Inheritance Lecture");
    window.add(area);
    window.setVisible(true);
    
  }
  
}
