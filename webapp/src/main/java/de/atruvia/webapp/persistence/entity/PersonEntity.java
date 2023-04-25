package de.atruvia.webapp.persistence.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_personen")
public class PersonEntity {


    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String vorname;

    @Column(length = 30, nullable = false)
    private String nachname;

//    @Version
//    private LocalDateTime lastUpdate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final PersonEntity that = (PersonEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
