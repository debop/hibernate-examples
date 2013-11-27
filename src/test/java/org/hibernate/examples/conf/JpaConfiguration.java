package org.hibernate.examples.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * org.hibernate.examples.conf.JpaConfiguration
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 5:44
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class JpaConfiguration {
}
