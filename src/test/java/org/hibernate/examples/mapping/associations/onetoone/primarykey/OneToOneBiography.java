package org.hibernate.examples.mapping.associations.onetoone.primarykey;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.utils.HashTool;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.*;

/**
 * org.hibernate.examples.mapping.associations.onetoone.primarykey.OneToOneBiography
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 29. 오후 3:20
 */
@Entity
@Proxy
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class OneToOneBiography extends AbstractHibernateEntity<Long> {

    protected OneToOneBiography() {}

    public OneToOneBiography(OneToOneAuthor author) {
        this.author = author;
    }

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "authorId")
    private OneToOneAuthor author;

    private String information;

    @Override
    public int hashCode() {
        return HashTool.compute(author);
    }

    @Override
    public ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                    .add("author", author)
                    .add("information", information);
    }

    private static final long serialVersionUID = 1698356846423798478L;
}
