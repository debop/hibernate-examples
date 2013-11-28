package org.hibernate.examples.mapping.associations.join;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.utils.Hashs;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * org.hibernate.examples.mapping.associations.join.JoinAddressEntity
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 11:13
 */
@Entity
@Getter
@Setter
public class JoinAddressEntity extends AbstractHibernateEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String city;
    private String zipcode;

    @Override
    public int hashCode() {
        return Hashs.hash(street, city, zipcode);
    }

    @Override
    protected ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                .add("street", street)
                .add("city", city)
                .add("zipcode", zipcode);
    }

    private static final long serialVersionUID = 6610359502465293056L;
}
