package org.hibernate.examples.model;

import org.hibernate.examples.HibernateEntity;
import org.hibernate.examples.utils.Hashs;
import org.hibernate.examples.utils.ToStringHelper;

/**
 * org.hibernate.examples.model.AbstractHibernateEntity
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:36
 */
public abstract class AbstractHibernateEntity<TId> extends AbstractPersistentObject implements HibernateEntity<TId> {

    abstract public TId getId();

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        boolean isSampeType = (obj != null) && getClass().equals(obj.getClass());

        if (isSampeType) {
            HibernateEntity<TId> entity = (HibernateEntity<TId>) obj;
            return hasSameNonDefaultIdAs(entity) ||
                    ((!isPersisted() || !entity.isPersisted()) && hasSameBusinessSignature(entity));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? System.identityHashCode(this)
                : Hashs.compute(getId());
    }

    private boolean hasSameNonDefaultIdAs(HibernateEntity<TId> entity) {
        if (entity == null) return false;

        TId id = getId();
        TId entityId = entity.getId();
        return (id != null) && (entityId != null) && (id.equals(entityId));
    }

    private boolean hasSameBusinessSignature(HibernateEntity<TId> other) {
        boolean notNull = (other != null);
        int hash = (getId() != null) ? Hashs.compute(getId()) : hashCode();
        if (notNull) {
            int otherHash = (other.getId() != null) ? Hashs.compute(other.getId()) : other.hashCode();
            return hash == otherHash;
        }
        return false;
    }

    @Override
    public ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                .add("id", getId());
    }

    private static final long serialVersionUID = 6661386933952675946L;
}
