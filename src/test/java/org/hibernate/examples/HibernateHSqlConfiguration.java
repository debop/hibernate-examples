package org.hibernate.examples;

import org.hibernate.cfg.Environment;
import org.hibernate.examples.hibernate.config.AbstractHSqlHibernateConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * org.hibernate.examples.HibernateHSqlConfiguration
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 3:39
 */
@Configuration
@EnableTransactionManagement
public class HibernateHSqlConfiguration extends AbstractHSqlHibernateConfiguration {

    @Override
    public String[] getMappedPackageNames() {
        return new String[]{
                "org.hibernate.examples.mapping"
        };
    }

    @Override
    public Properties hibernateProperties() {
        Properties props = super.hibernateProperties();

        props.put(Environment.HBM2DDL_AUTO, "create"); // create | spawn | spawn-drop | update | validate | none

        return props;
    }
}
