package marsRover;

import java.util.*;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Grid size
        System.out.print("Enter grid width: ");
        int width = scanner.nextInt();
        System.out.print("Enter grid height: ");
        int height = scanner.nextInt();
        Grid grid = new Grid(width, height);

        // Starting position
        System.out.print("Enter starting X coordinate: ");
        int startX = scanner.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        int startY = scanner.nextInt();
        System.out.print("Enter starting direction (N/E/S/W): ");
        String dirInput = scanner.next().toUpperCase();
        Direction direction = Direction.valueOf(dirInput);

        // Obstacles
        System.out.print("Enter number of obstacles: ");
        int numObstacles = scanner.nextInt();
        for (int i = 0; i < numObstacles; i++) {
            System.out.print("Enter obstacle " + (i + 1) + " position (x y): ");
            int ox = scanner.nextInt();
            int oy = scanner.nextInt();
            grid.add(new Obstacle(ox, oy));
        }

        Rover rover = new Rover(startX, startY, direction, grid);
        CommandFactory factory = new CommandFactory(rover);

        // Commands
        System.out.print("Enter commands (e.g., MMRMLM): ");
        String commandStr = scanner.next().toUpperCase();

        for (char cmd : commandStr.toCharArray()) {
            try {
                Command command = factory.getCommand(String.valueOf(cmd));
                command.execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Final output
        System.out.println("Final Position: " + rover.getPosition());
        System.out.println(rover.statusReport());

        scanner.close();
    }
}
