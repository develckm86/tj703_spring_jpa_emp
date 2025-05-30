package com.tj703.l06_spring_jpa_emp_final.enitity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class TitleId implements java.io.Serializable {
    private static final long serialVersionUID = 8457267322743265947L;
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TitleId entity = (TitleId) o;
        return Objects.equals(this.fromDate, entity.fromDate) &&
                Objects.equals(this.empNo, entity.empNo) &&
                Objects.equals(this.title, entity.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDate, empNo, title);
    }

}