package ugncry.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by ugncry on 09.07.2016.
 */
@Entity
@Table(name = "user")
@Indexed
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Field
    private String name;

    @Column
    @Field
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Field
    private Skill skill;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @IndexedEmbedded
//    @Fetch(FetchMode.SELECT)
    private List<PhoneNumber> numbers;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @IndexedEmbedded
    private Set<Study> studies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }
}
