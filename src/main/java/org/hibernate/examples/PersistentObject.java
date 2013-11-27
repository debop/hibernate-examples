package org.hibernate.examples;

/**
 * org.hibernate.examples.PersistentObject
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:37
 */
public interface PersistentObject extends ValueObject {

    boolean isPersisted();

    void onPersist();

    void onLoad();
}
