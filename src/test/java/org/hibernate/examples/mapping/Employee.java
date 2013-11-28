package org.hibernate.examples.mapping;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.examples.model.AbstractHibernateEntity;
import org.hibernate.examples.model.UpdatedTimestampEntity;
import org.hibernate.examples.utils.Hashs;
import org.hibernate.examples.utils.ToStringHelper;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * org.hibernate.examples.mapping.Employee
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 28. 오후 3:49
 */
@Entity
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq")
@Getter
@Setter
@Slf4j
public class Employee extends AbstractHibernateEntity<Long> implements UpdatedTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_seq")
    @Column(name = "EmployeeId")
    private Long id;

    @Column(name = "EmpNo", nullable = false, length = 32)
    private String empNo;

    @Column(name = "EmployeeName", nullable = false, length = 32)
    private String name;

    @Column(name = "Email", length = 32)
    private String email;

    @Type(type = "org.hibernate.examples.usertype.JodaDateTimeUserType")
    private DateTime updatedTimestamp;

    /**
     * 엔티티의 최근 갱신 일자를 수정합니다.
     */
    @PrePersist
    @Override
    public void updateUpdatedTimestamp() {
        updatedTimestamp = DateTime.now();
        log.trace("저장하기 전에 UpdatedTimestamp를 갱신합니다. updatedTimestamp=[{}]", updatedTimestamp);
    }

    @Override
    public int hashCode() {
        return Hashs.hash(empNo, name);
    }

    @Override
    public ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                    .add("id", id)
                    .add("empNo", empNo)
                    .add("name", name)
                    .add("email", email);
    }


    private static final long serialVersionUID = 6878934074258579705L;


}
