package fr.ensibs.util.sync;

/**
 * A class that allows to schedule tasks running periodically in a separate thread.
 * A single thread is associated to the scheduler to execute the task, and only one
 * task can be scheduled at a time (i.e. the task must be stopped before starting
 * another task).
 * <p>
 * The task is executed repeatedly at fixed rate at a given period. If the task execution
 * time is greater than the period, the successive execution will occur immediately to
 * catch up the delay.
 *
 * @author Pascale Launay
 */
public interface IScheduler
{
    /**
     * Start running the given task. If another task has already been scheduled and
     * has not been stopped, do nothing.
     *
     * @param period the time (in ms) between successive executions of the task
     * @param task   the task to be executed
     * @pre {@code period > 0}
     * @pre {@code task != null}
     */
    void start(int period, Runnable task);

    /**
     * Stop the execution of the task
     */
    void stop();
}