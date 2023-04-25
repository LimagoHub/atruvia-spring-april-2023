package de.atruvia.webapp.persistence.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tbl_pigs")
public class SchweinEntity {

    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private int gewicht;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final SchweinEntity that = (SchweinEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
