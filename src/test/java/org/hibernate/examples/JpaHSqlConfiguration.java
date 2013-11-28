package org.hibernate.examples;

import org.hibernate.cfg.Environment;
import org.hibernate.examples.jpa.config.AbstractHSqlJpaConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * org.hibernate.examples.JpaHSqConfig
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 3:36
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class JpaHSqlConfiguration extends AbstractHSqlJpaConfiguration {


    @Override
    public String[] getMappedPackageNames() {
        return new String[] {
                "org.hibernate.examples.mapping"
        };
    }

    @Override
    public Properties jpaProperties() {
        Properties props = super.jpaProperties();

        props.put(Environment.HBM2DDL_AUTO, "create"); // create | spawn | spawn-drop | update | validate | none

        return props;
    }
}
