package org.hibernate.examples.hibernate.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.examples.model.UpdatedTimestampEntity;

import java.util.Iterator;

/**
 * org.hibernate.examples.hibernate.interceptor.UpdatedTimestampInterceptor
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 1:50
 */
@Slf4j
public class UpdatedTimestampInterceptor extends EmptyInterceptor {

    @Override
    public void preFlush(Iterator entities) {
        while (entities.hasNext()) {
            Object entity = entities.next();
            if (entity instanceof UpdatedTimestampEntity) {
                ((UpdatedTimestampEntity) entity).updateUpdatedTimestamp();
            }
        }
    }


    private static final long serialVersionUID = -1965299893946137808L;
}
