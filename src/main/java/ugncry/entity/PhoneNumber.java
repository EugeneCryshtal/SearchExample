package ugncry.entity;

import org.hibernate.search.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ugncry on 09.07.2016.
 */
@Entity
@Table(name = "phone_number")
public class PhoneNumber extends BaseEntity {

    @Column(nullable = false)
    @Field
    private Integer number;

    public PhoneNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
