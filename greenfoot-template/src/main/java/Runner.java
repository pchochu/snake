import bh.greenfoot.runner.GreenfootRunner;
import greenfoot.MyWorld;

/**
 * A sample runner for a greenfoot project.
 */
public class Runner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(Runner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(MyWorld.class)
                        // Set the project name as you wish
                        .projectName("Demo project")
                        .hideControls(true)
        );
    }
}