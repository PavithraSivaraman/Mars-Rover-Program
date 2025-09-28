package marsRover;

//Rover Class
public class Rover {
 private int x, y;
 private Direction direction;
 private final Grid grid;

 public Rover(int x, int y, Direction direction, Grid grid) {
     this.x = x;
     this.y = y;
     this.direction = direction;
     this.grid = grid;
 }

 public void move() {
     int newX = x + direction.getDx();
     int newY = y + direction.getDy();
     if (!grid.isObstacle(newX, newY)) {
         x = newX;
         y = newY;
     }
 }

 public void turnLeft() {
     direction = direction.turnLeft();
 }

 public void turnRight() {
     direction = direction.turnRight();
 }

 public String statusReport() {
     int nextX = x + direction.getDx();
     int nextY = y + direction.getDy();
     boolean obstacleAhead = grid.isObstacle(nextX, nextY);
     return String.format("Rover is at (%d, %d) facing %s. %s",
             x, y, direction.name(),
             obstacleAhead ? "Obstacle detected ahead." : "No Obstacles detected.");
 }

 public String getPosition() {
     return String.format("(%d, %d, %s)", x, y, direction.name());
 }
}
