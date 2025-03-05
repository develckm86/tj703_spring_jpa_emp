package com.tj703.l06_spring_jpa_emp_final.enitity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinFormula;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

//@Data @EqualsAndHashCode 사용하지 않는 이유
//지연조회와 프록시객체와 hashcode
//지연조회시 entity에 존재하지 않는(나중에 조회될) 필드가 있어서 대리인 프록시 객체를 생성해서 조회에 사용합니다.
//만약 프록시객체에서 존재하지 않는 필드를 조회하면 entity 가 그 필드를 조회하는 것이 지연조회의 구현 형태입니다.

//프록시 객체는 entity를 부모객체로 사용하고 있지만 다른 객체기때문에 hashCode를 사용 것을 권장하지 않는다.
//또한 entity 에 set 필드가 있다면 Set 에는 이미 hashCode 가 구현되어 있기 때문에 또 정의하게 되면
//문제가 발생할 수 있다.

@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer id;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;
    //Formula 서브쿼리를 실행해서 필드조회
    @Formula(value = "(SELECT de.dept_no FROM dept_emp de WHERE de.to_date='9999-01-01'AND de.emp_no=emp_no)")
    private String deptNoNow;
    //현재 직책

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DeptEmp> deptEmps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Salary> salaries = new LinkedHashSet<>();
    //직책 조인

}