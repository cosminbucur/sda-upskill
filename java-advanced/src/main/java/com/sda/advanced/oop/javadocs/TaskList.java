package com.sda.advanced.oop.javadocs;

// used to create documentation
// use javadoc -d doc src\* to generate html document

/**
 * Interface for a list of tasks.
 *
 * @author yours truly
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/"></a>
 */
public interface TaskList {

    /**
     * You can not handle more than 5 tasks.
     */
    int maxTaskCount = 5;

    /**
     * Add a task to the list.
     *
     * @param task the task to be added
     * @see Task
     */
    void addTask(Task task);

    /**
     * Removes a task from the list.
     *
     * @param task the task to be removed
     */
    void removeTask(Task task);

    /**
     * Returns the number of elements in this list.
     *
     * @return total number of tasks
     */
    int countTask();
}
