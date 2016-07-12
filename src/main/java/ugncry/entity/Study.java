package ugncry.entity;

import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ugncry on 09.07.2016.
 */
@Entity
@Table(name = "study")
public class Study extends BaseEntity {

    @Column(nullable = false)
    @Field
    private String name;

    public Study(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
