package grave_escape.levels.Level3;

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
 * Represents the normal version of Level 3.
 * This class extends the Level class and initializes specific configurations
 * such as enemies, objectives, walls, starting position, and exit position
 * for normal difficulty of Level 3.
 */
public class Level3Normal extends Level {
    /**
     * Constructs the Level3Normal object with predefined settings for the level,
     * including its grid size, starting and ending positions, enemies, objectives, and walls.
     */
    public Level3Normal(){
        super(
                10,
                15,
                new Position(5,6),//hero
                createEnemies(),
                createObjectives(),
                new Position(10,6),//door
                createWalls()
        );

        this.levelName = "Level 3";
        this.difficulty = "Normal";
    }
    /**
     * Creates a list of enemies for the level.
     *
     * @return a list of Enemy objects including moving and stationary enemies.
     */
    private static List<Enemy> createEnemies(){
        return List.of(
                new MovingEnemy(new Position(14,9)),
                new MovingEnemy(new Position(1,1)),
                new MovingEnemy(new Position(11,1)),

                new StationaryEnemy(new Position(1,8)),
                new StationaryEnemy(new Position(1,7)),
                new StationaryEnemy(new Position(1,3)),
                new StationaryEnemy(new Position(2,8)),

                new StationaryEnemy(new Position(3,1)),
                new StationaryEnemy(new Position(4,1)),
                new StationaryEnemy(new Position(5,1)),

                new StationaryEnemy(new Position(3,5)),
                new StationaryEnemy(new Position(6,9)),
                new StationaryEnemy(new Position(8,8)),
                new StationaryEnemy(new Position(7,6)),
                new StationaryEnemy(new Position(9,3)),

                new StationaryEnemy(new Position(11,8)),
                new StationaryEnemy(new Position(14,8)),

                new StationaryEnemy(new Position(12,6)),
                new StationaryEnemy(new Position(12,5)),
                new StationaryEnemy(new Position(13,5)),
                new StationaryEnemy(new Position(13,4)),
                new StationaryEnemy(new Position(9,14))


        );
    }
    /**
     * Creates a list of objectives for the level.
     *
     * @return an ArrayList of Objective objects
     */
    private static ArrayList<Objective> createObjectives(){
        ArrayList<Objective> objectives = new ArrayList<>();
        objectives.add(new Objective(new Position(1,9), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(5,9), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(14,1), true, MANDATORY_VALUE));
        objectives.add(new Objective(new Position(1,1), false, OPTIONAL_VALUE));
        objectives.add(new Objective(new Position(11,4), false, OPTIONAL_VALUE));
        objectives.add(new Objective(new Position(7,4), false, OPTIONAL_VALUE));

        return objectives;
    }
    /**
     * Creates a list of walls for the level.
     *
     * @return an ArrayList of Wall objects, defining the boundaries in the level.
     */
    private static ArrayList<Wall> createWalls(){
        ArrayList<Wall> walls = new ArrayList<>();
        walls.add(new Wall(new Position(4,9)));
        walls.add(new Wall(new Position(4,8)));
        walls.add(new Wall(new Position(4,7)));
        walls.add(new Wall(new Position(5,7)));
        walls.add(new Wall(new Position(6,7)));
        walls.add(new Wall(new Position(6,6)));
        walls.add(new Wall(new Position(6,5)));
        walls.add(new Wall(new Position(6,4)));
        walls.add(new Wall(new Position(6,3)));
        walls.add(new Wall(new Position(3,3)));
        walls.add(new Wall(new Position(3,4)));
        walls.add(new Wall(new Position(4,3)));
        walls.add(new Wall(new Position(4,4)));
        walls.add(new Wall(new Position(5,3)));
        walls.add(new Wall(new Position(4,4)));
        walls.add(new Wall(new Position(7,3)));
        walls.add(new Wall(new Position(7,2)));

        walls.add(new Wall(new Position(12,1)));
        walls.add(new Wall(new Position(12,2)));
        walls.add(new Wall(new Position(12,3)));
        walls.add(new Wall(new Position(12,4)));

        walls.add(new Wall(new Position(11,5)));
        walls.add(new Wall(new Position(11,6)));
        walls.add(new Wall(new Position(11,7)));
        walls.add(new Wall(new Position(10,5)));
        walls.add(new Wall(new Position(9,5)));
        walls.add(new Wall(new Position(9,6)));
        walls.add(new Wall(new Position(9,7)));

        return walls;
    }
}
