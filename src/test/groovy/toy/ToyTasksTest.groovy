package toy

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 *
 */
class ToyTasksTest {

    boolean task1Run = false
    boolean task2Run = false

    @Test
    public void taskDependencies(){


        Project p = ProjectBuilder.builder().build()

        p.task("task1") << {
            p.logger.info("task1 running")
            task1Run = true
        }

        def task2 = p.task("task2", dependsOn: 'task1') << {
            p.logger.info("task2 running")
            task2Run = true
        }
        task2.execute() // <--- what magjc do I need here instead of .execute()

        assert task2Run == true
        assert task1Run == true
    }
}
