package org.hibernate.examples.hibernate;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.examples.AbstractNamedParameter;
import org.hibernate.examples.utils.ToStringHelper;
import org.hibernate.type.StandardBasicTypes;

/**
 * org.hibernate.examples.hibernate.HibernateParameter
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 1:59
 */
public class HibernateParameter extends AbstractNamedParameter {

    @Getter
    @Setter
    private org.hibernate.type.Type paramType = StandardBasicTypes.SERIALIZABLE;

    public HibernateParameter(String name, Object value) {
        super(name, value);
    }

    public HibernateParameter(String name, Object value, org.hibernate.type.Type paramType) {
        super(name, value);
        this.paramType = paramType;
    }

    @Override
    protected ToStringHelper buildStringHelper() {
        return super.buildStringHelper().add("paramType", paramType);
    }

    private static final long serialVersionUID = -228167603287695079L;
}
