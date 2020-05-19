package com.github.arham4.turtle.utils.processable;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

public class LoggableCopyOnWriteArrayList<E> extends CopyOnWriteArrayList<E> implements LoggableCollection<E> {
    private List<Change<E>> changes = new ArrayList<>();
    private Queue<Change<E>> queuedChanges = new LinkedBlockingQueue<>();

    @Override
    public void commit(Change<E> change) {
        queuedChanges.add(change);
    }

    @Override
    public Change<E> process() {
        Change<E> change = queuedChanges.remove();
        changes.add(change);
        return change;
    }

    @Override
    public List<Change<E>> getLog() {
        return changes;
    }

    @Override
    public int getUnprocessedChangesCount() {
        return queuedChanges.size();
    }

    @Override
    public boolean add(E e) {
        final boolean success = super.add(e);
        if (success) {
            commit(Change.add(e));
        }
        return success;
    }

    @Override
    public void add(int index, E element) {
        super.add(index, element);
        commit(Change.add(element));
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        final boolean success = super.addAll(c);
        if (success) {
            c.forEach(element -> commit(Change.add(element)));
        }
        return success;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        final boolean success = super.addAll(index, c);
        if (success) {
            c.forEach(element -> commit(Change.add(element)));
        }
        return success;
    }

    @Override
    public boolean addIfAbsent(E e) {
        final boolean success = super.addIfAbsent(e);
        if (success) {
            commit(Change.add(e));
        }
        return success;
    }

    @Override
    public int addAllAbsent(Collection<? extends E> c) {
        final int result = super.addAllAbsent(c);
        int processed = 0;
        for (E e : c) {
            if (processed == result) {
                break;
            }
            commit(Change.add(e));
            processed++;
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        final boolean success = super.remove(o);
        Class<E> type = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];;
        if (success && type.isInstance(o)) {
            commit(Change.remove((E) o));
        }
        return success;
    }

    @Override
    public E remove(int index) {
        E result = super.remove(index);
        if (result != null) {
            commit(Change.remove(result));
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean success = super.removeAll(c);
        if (success) {
            for (Object o : c) {
                Class<E> type = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                if (type.isInstance(o)) {
                    commit(Change.remove((E) o));
                }
            }
        }
        return success;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        for (E e : this) {
            if (filter.test(e)) {
                commit(Change.remove(e));
            }
        }
        return super.removeIf(filter);
    }
}
