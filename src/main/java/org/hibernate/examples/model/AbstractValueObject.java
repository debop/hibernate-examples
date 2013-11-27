package org.hibernate.examples.model;

import org.hibernate.examples.ValueObject;

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

    protected StringBuilder buildStringHelper() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName()).append("#");
        return sb;
    }

    private static final long serialVersionUID = 529523546260095342L;
}
