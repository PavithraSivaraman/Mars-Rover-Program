package marsRover;

import java.util.*;

//Command Factory to avoid if-else
public class CommandFactory {
 private final Map<String, Command> commandMap = new HashMap<>();

 public CommandFactory(Rover rover) {
     commandMap.put("M", new MoveCommand(rover));
     commandMap.put("L", new TurnLeftCommand(rover));
     commandMap.put("R", new TurnRightCommand(rover));
 }

 public Command getCommand(String code) {
     Command command = commandMap.get(code);
     if (command == null) {
         throw new IllegalArgumentException("Invalid command: " + code);
     }
     return command;
 }
}
