package org.hibernate.examples.mapping.associations.join.repository;

import org.hibernate.examples.mapping.associations.join.JoinCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * org.hibernate.examples.mapping.associations.join.repository.JoinCustomerRepository
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 11:18
 */
public interface JoinCustomerRepository extends JpaRepository<JoinCustomer, Long>, QueryDslPredicateExecutor<JoinCustomer> {

    JoinCustomer findByName(String name);

    List<JoinCustomer> findByNameLike(String name);

    JoinCustomer findByEmail(String email);
}
