package org.hibernate.examples.model;

import org.hibernate.examples.PersistentObject;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

/**
 * org.hibernate.examples.model.AbstractPersistentObject
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:37
 */
public abstract class AbstractPersistentObject extends AbstractValueObject implements PersistentObject {

    private boolean persisted;

    @Override
    public boolean isPersisted() {

        return persisted;
    }

    @Override
    @PostPersist
    public void onPersist() {
        persisted = true;
    }


    @Override
    @PostLoad
    public void onLoad() {
        persisted = true;
    }

    private static final long serialVersionUID = -1668910261730798160L;
}
