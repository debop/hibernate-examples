package org.hibernate.examples.model;

import org.hibernate.examples.utils.Hashs;
import org.hibernate.examples.utils.ToStringHelper;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * org.hibernate.examples.model.TreeNodePosition
 *
 * @author 배성혁 sunghyouk.bae@gmail.com
 * @since 2013. 11. 27. 오후 4:30
 */
@Embeddable
public class TreeNodePosition extends AbstractValueObject {

    @Column(name = "treeLevel")
    private Integer level;

    @Column(name = "treeOrder")
    private Integer order;

    public TreeNodePosition() {this(0, 0); }

    public TreeNodePosition(int level, int order) {
        this.level = level;
        this.order = order;
    }

    public TreeNodePosition(TreeNodePosition src) {
        this(src.level, src.order);
    }

    public void setPosition(int level, int order) {
        this.level = level;
        this.order = order;
    }

    @Override
    public int hashCode() {
        return Hashs.hash(level, order);
    }

    @Override
    protected ToStringHelper buildStringHelper() {
        return super.buildStringHelper()
                .add("level", level)
                .add("order", order);
    }

    private static final long serialVersionUID = -5552929284039433528L;
}
