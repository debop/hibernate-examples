package org.hibernate.examples.mapping.associations.manytomany;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.utils.Hashs;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * org.hibernate.examples.mapping.associations.manytomany.BankAccount
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 11:45
 */
@Entity
@Getter
@Setter
public class BankAccount extends AbstractHibernateEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "accountId")
    private Long id;

    @Column(length = 32)
    private String accountNumber;

    // many-to-many 에서는 둘 중 하나는 mappedBy 를 지정해야 한다. ( hbm에서는 inverse )
    @ManyToMany(mappedBy = "bankAccounts", cascade = { CascadeType.REFRESH })
    private Set<AccountOwner> owners = new HashSet<AccountOwner>();

    @Override
    public int hashCode() {
        return Hashs.hash(accountNumber);
    }

    @Override
    protected ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                .add("accountNumber", accountNumber);
    }

    private static final long serialVersionUID = -4101571945249649442L;
}
