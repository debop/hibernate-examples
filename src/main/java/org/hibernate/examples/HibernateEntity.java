package org.hibernate.examples;

/**
 * org.hibernate.examples.HibernateEntity
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:36
 */
public interface HibernateEntity<TId> extends PersistentObject {

    TId getId();
}
