package marsRover;

import java.util.*;

//Composite Grid
public class Grid implements GridComponent {
 private final int width;
 private final int height;
 private final List<GridComponent> children = new ArrayList<>();

 public Grid(int width, int height) {
     this.width = width;
     this.height = height;
 }

 public void add(GridComponent component) {
     children.add(component);
 }

 @Override
 public boolean isObstacle(int x, int y) {
     // Boundary check
     boolean outOfBounds = x < 0 || x >= width || y < 0 || y >= height;
     if (outOfBounds) return true;

     // Check obstacles
     return children.stream().anyMatch(c -> c.isObstacle(x, y));
 }
}
