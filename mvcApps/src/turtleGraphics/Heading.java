package turtleGraphics;

public enum Heading {
    NORTH, EAST, SOUTH, WEST;

    public static Heading parse(String cmd) {
        return switch (cmd.toLowerCase()) {
            case "north" -> NORTH;
            case "east" -> EAST;
            case "south" -> SOUTH;
            case "west" -> WEST;
            default -> throw new IllegalArgumentException("Invalid command: " + cmd);
        };
    }
}