package org.hibernate.examples.mapping.associations.onetomany.list;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.utils.HashTool;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * org.hibernate.examples.mapping.associations.onetomany.list.OneToManyOrderItem
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 29. 오후 1:18
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class OneToManyOrderItem extends AbstractHibernateEntity<Long> {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private OneToManyOrder order;

    @Override
    public int hashCode() {
        return HashTool.compute(name);
    }

    @Override
    public ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                    .add("name", name);
    }

    private static final long serialVersionUID = -4968710913293508239L;
}
