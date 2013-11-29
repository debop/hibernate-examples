package org.hibernate.examples.model;

import org.hibernate.examples.utils.HashTool;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;

/**
 * org.hibernate.examples.model.AbstractHibernateEntity
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:36
 */
@MappedSuperclass
public abstract class AbstractHibernateEntity<TId> extends AbstractPersistentObject implements HibernateEntity<TId> {

    abstract public TId getId();

    @Override
    @PostPersist
    public final void onSave() {
        setPersisted(true);
    }


    @Override
    @PostLoad
    public final void onLoad() {
        setPersisted(true);
    }


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
                                 : HashTool.compute(getId());
    }

    private boolean hasSameNonDefaultIdAs(HibernateEntity<TId> entity) {
        if (entity == null) return false;

        TId id = getId();
        TId entityId = entity.getId();
        return (id != null) && (entityId != null) && (id.equals(entityId));
    }

    private boolean hasSameBusinessSignature(HibernateEntity<TId> other) {
        boolean notNull = (other != null);
        int hash = (getId() != null) ? HashTool.compute(getId()) : hashCode();
        if (notNull) {
            int otherHash = (other.getId() != null) ? HashTool.compute(other.getId()) : other.hashCode();
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
