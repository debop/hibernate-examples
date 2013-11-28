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
 * org.hibernate.examples.mapping.associations.manytomany.AccountOwner
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 11:45
 */
@Entity
@Getter
@Setter
public class AccountOwner extends AbstractHibernateEntity<Long> {

    @Id
    @GeneratedValue
    @Column(name = "ownerId")
    private Long id;

    @Column(length = 32)
    private String SSN;

    // many-to-many 에서는 둘 중 하나는 mappedBy 를 지정해야 한다.
    //
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "BankAccountOwners",
               joinColumns = { @JoinColumn(name = "ownerId") },
               inverseJoinColumns = { @JoinColumn(name = "accountId") })
    private Set<BankAccount> bankAccounts = new HashSet<BankAccount>();

    @Override
    public int hashCode() {
        return Hashs.hash(SSN);
    }

    @Override
    protected ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                .add("SSN", SSN);
    }

    private static final long serialVersionUID = 6041020627741330687L;
}
