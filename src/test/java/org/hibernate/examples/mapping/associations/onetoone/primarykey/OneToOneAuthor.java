package org.hibernate.examples.mapping.associations.onetoone.primarykey;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.utils.HashTool;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * org.hibernate.examples.mapping.associations.onetoone.primarykey.OneToOneAuthor
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 29. 오후 3:18
 */
@Entity
@Proxy
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class OneToOneAuthor extends AbstractHibernateEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "authorId")
    private Long id;

    private String name;

    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)   // eager면 outer join을 하고, lazy면 따로 로드합니다.
    @PrimaryKeyJoinColumn
    @LazyToOne(LazyToOneOption.PROXY)
    private OneToOneBiography biography = new OneToOneBiography(this);

    @OneToOne(cascade = { CascadeType.ALL })
    @PrimaryKeyJoinColumn
    @LazyToOne(LazyToOneOption.PROXY)
    private OneToOnePicture picture = new OneToOnePicture(this);

    @Override
    public int hashCode() {
        return HashTool.compute(name);
    }

    @Override
    public ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                    .add("name", name);
    }

    private static final long serialVersionUID = 9107358535833367961L;
}
