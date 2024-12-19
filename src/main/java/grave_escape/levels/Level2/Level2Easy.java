package grave_escape.levels.Level2;

import java.util.ArrayList;
import java.util.List;

import static grave_escape.game.Values.MANDATORY_VALUE;
import static grave_escape.game.Values.OPTIONAL_VALUE;
import grave_escape.enemy.Enemy;
import grave_escape.enemy.MovingEnemy;
import grave_escape.enemy.StationaryEnemy;
import grave_escape.structure.Position;
import grave_escape.levels.Level;
import grave_escape.objectives.Objective;
import grave_escape.structure.Wall;

/**
 * Represents the easy version of Level 2.
 * This class extends the Level class and initializes specific configurations
 * such as enemies, objectives, walls, starting position, and exit position
 * for easy difficulty of Level 2.
 */
public class Level2Easy extends Level {
    /**
     * Constructs the Level2Easy object with predefined settings for the level,
     * including its grid size, starting and ending positions, enemies, objectives, and walls.
     */
    public Level2Easy(){
        super(
                10,
                15,
                new Position(1,1),
                createEnemies(),
                createObjectives(),
                new Position(15,10),
                createWalls()
        );

        this.levelName = "Level 2";
        this.difficulty = "Easy";
    }

    private static List<Enemy> createEnemies(){
        return List.of(
                new MovingEnemy(new Position(13,4)),
                new MovingEnemy(new Position(9,8)),
                new MovingEnemy(new Position(5,8)),

                new StationaryEnemy(new Position(1,2)),
                new StationaryEnemy(new Position(2,2)),
                new StationaryEnemy(new Position(3,2)),
                new StationaryEnemy(new Position(4,2)),
                new StationaryEnemy(new Position(5,2)),
                new StationaryEnemy(new Position(6,2)),
                new StationaryEnemy(new Position(7,2)),
                new StationaryEnemy(new Position(8,2)),
                new StationaryEnemy(new Position(9,2)),
                new StationaryEnemy(new Position(10,2)),
                new StationaryEnemy(new Position(11,2)),
                new StationaryEnemy(new Position(12,2)),
                new StationaryEnemy(new Position(13,2)),
                new StationaryEnemy(new Position(14,2)),
                new StationaryEnemy(new Position(14,6)),
                new StationaryEnemy(new Position(7,4))

        );
    }
    /**
     * Creates a list of objectives for the level.
     *
     * @return an ArrayList of Objective objects
     */
    private static ArrayList<Objective> createObjectives(){
        ArrayList<Objective> objectives = new ArrayList<>();
        objectives.add(new Objective(new Position(14,1), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(12,6), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(13,10), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(15,4), false, OPTIONAL_VALUE));
        objectives.add(new Objective(new Position(1,8), false, OPTIONAL_VALUE));


        return objectives;
    }
    /**
     * Creates a list of walls for the level.
     *
     * @return an ArrayList of Wall objects, defining the boundaries in the level.
     */
    private static ArrayList<Wall> createWalls(){
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(new Wall(new Position(1,3)));
        walls.add(new Wall(new Position(2,3)));
        walls.add(new Wall(new Position(3,3)));
        walls.add(new Wall(new Position(4,3)));
        walls.add(new Wall(new Position(5,3)));
        walls.add(new Wall(new Position(6,3)));
        walls.add(new Wall(new Position(7,3)));
        walls.add(new Wall(new Position(8,3)));
        walls.add(new Wall(new Position(9,3)));
        walls.add(new Wall(new Position(10,3)));
        walls.add(new Wall(new Position(11,3)));
        walls.add(new Wall(new Position(12,3)));
        walls.add(new Wall(new Position(13,3)));
        walls.add(new Wall(new Position(14,3)));

        walls.add(new Wall(new Position(14,4)));

        walls.add(new Wall(new Position(14,5)));
        walls.add(new Wall(new Position(1,5)));
        walls.add(new Wall(new Position(2,5)));
        walls.add(new Wall(new Position(3,5)));
        walls.add(new Wall(new Position(4,5)));
        walls.add(new Wall(new Position(5,5)));
        walls.add(new Wall(new Position(6,5)));
        walls.add(new Wall(new Position(7,5)));
        walls.add(new Wall(new Position(8,5)));
        walls.add(new Wall(new Position(9,5)));
        walls.add(new Wall(new Position(10,5)));
        walls.add(new Wall(new Position(11,5)));
        walls.add(new Wall(new Position(12,5)));
        walls.add(new Wall(new Position(13,5)));

        walls.add(new Wall(new Position(14,8)));
        walls.add(new Wall(new Position(15,8)));
        walls.add(new Wall(new Position(13,8)));
        walls.add(new Wall(new Position(12,8)));
        walls.add(new Wall(new Position(12,7)));
        walls.add(new Wall(new Position(11,7)));
        walls.add(new Wall(new Position(10,7)));
        walls.add(new Wall(new Position(9,7)));
        walls.add(new Wall(new Position(8,7)));
        walls.add(new Wall(new Position(7,7)));
        walls.add(new Wall(new Position(6,7)));
        walls.add(new Wall(new Position(5,7)));
        walls.add(new Wall(new Position(4,7)));
        walls.add(new Wall(new Position(3,7)));
        walls.add(new Wall(new Position(2,7)));

        walls.add(new Wall(new Position(14,9)));
        walls.add(new Wall(new Position(15,9)));
        walls.add(new Wall(new Position(13,9)));
        walls.add(new Wall(new Position(12,9)));
        walls.add(new Wall(new Position(11,9)));
        walls.add(new Wall(new Position(10,9)));
        walls.add(new Wall(new Position(9,9)));
        walls.add(new Wall(new Position(8,9)));
        walls.add(new Wall(new Position(7,9)));
        walls.add(new Wall(new Position(6,9)));
        walls.add(new Wall(new Position(5,9)));
        walls.add(new Wall(new Position(4,9)));
        walls.add(new Wall(new Position(3,9)));
        walls.add(new Wall(new Position(2,9)));
        walls.add(new Wall(new Position(2,8)));

        walls.add(new Wall(new Position(7,8)));
        return walls;
    }
}
