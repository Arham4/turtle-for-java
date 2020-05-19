package com.github.arham4.turtle.utils.processable;

public interface Change<E> {
    static <E> Change<E> add(E change) {
        return new Change<>() {
            @Override
            public E getChange() {
                return change;
            }

            @Override
            public ChangeType getType() {
                return ChangeType.ADD;
            }
        };
    }

    static <E> Change<E> remove(E change) {
        return new Change<>() {
            @Override
            public E getChange() {
                return change;
            }

            @Override
            public ChangeType getType() {
                return ChangeType.REMOVE;
            }
        };
    }

    E getChange();
    ChangeType getType();
}
