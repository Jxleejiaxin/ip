package duke.task;

import java.util.ArrayList;

public class TaskList {
    protected final ArrayList<Task> list;

    /** In the event that task list failed to load */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public void add(Task task) {
        list.add(task);
    }

    public Task delete(int index) {
        return list.remove(index);
    }

    public ArrayList<Task> getList() {
        return this.list;
    }

    public void mark(int index) {
        Task currentTask = list.get(index);
        currentTask.markAsDone();
    }

    public void unmark(int index) {
        Task currentTask = list.get(index);
        currentTask.markAsUndone();
    }

    /**
     * Finds tasks that match a specific keyword by iterating through the list.
     * @param keyword derived from user input
     * @return ArrayList containing all matching tasks
     */
    public ArrayList<Task> find(String keyword) {
        ArrayList<Task> foundList = new ArrayList<>();
        for (Task t: list) {
            if (t.contains(keyword)) {
                foundList.add(t);
            }
        }
        return foundList;
    }

    public int getSize() {
        return list.size();
    }
}
