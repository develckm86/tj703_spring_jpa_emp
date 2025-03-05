package com.tj703.l06_spring_jpa_emp_final.enitity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
//    @EmbeddedId
//    private SalaryId id;
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;
    @Id
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @JoinColumn(name = "emp_no")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference // 객체를 json 으로 직렬화할때 해당 필드는 참조하지 않는다.
    private Employee employee;

}