package com.github.arham4.turtle.utils.processable;

import java.util.List;
import java.util.Queue;

public interface Loggable<E> {
    void commit(Change<E> change);
    Change<E> process();
    List<Change<E>> getLog();
    int getUnprocessedChangesCount();
}
