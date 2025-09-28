package marsRover;

//Enum for Direction with turning and movement delta
public enum Direction {
 N(0, 1), E(1, 0), S(0, -1), W(-1, 0);

 private final int dx;
 private final int dy;

 private static final Direction[] leftTurnOrder = {N, W, S, E};
 private static final Direction[] rightTurnOrder = {N, E, S, W};

 Direction(int dx, int dy) {
     this.dx = dx;
     this.dy = dy;
 }

 public Direction turnLeft() {
     return leftTurnOrder[(indexOf(leftTurnOrder) + 1) % 4];
 }

 public Direction turnRight() {
     return rightTurnOrder[(indexOf(rightTurnOrder) + 1) % 4];
 }

 private int indexOf(Direction[] array) {
     for (int i = 0; i < array.length; i++) {
         if (array[i] == this) return i;
     }
     throw new IllegalStateException("Direction not found");
 }

 public int getDx() { return dx; }
 public int getDy() { return dy; }
}
