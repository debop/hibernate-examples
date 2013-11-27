package org.hibernate.examples.model;

import org.hibernate.examples.ValueObject;
import org.hibernate.examples.utils.ToStringHelper;

/**
 * org.hibernate.examples.model.AbstractValueObject
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 2:39
 */
public abstract class AbstractValueObject implements ValueObject {

    @Override
    public boolean equals(Object obj) {
        return (obj != null) && (getClass().equals(obj.getClass())) && (hashCode() == obj.hashCode());
    }

    @Override
    public String toString() {
        return buildStringHelper().toString();
    }

    protected ToStringHelper buildStringHelper() {
        return ToStringHelper.create(this);
    }

    private static final long serialVersionUID = 529523546260095342L;
}
