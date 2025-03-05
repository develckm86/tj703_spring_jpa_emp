package com.tj703.l06_spring_jpa_emp_final.repository;

import com.tj703.l06_spring_jpa_emp_final.enitity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFirstName(Pageable pageable, String firstName );

    //강제로 조인하는 방법
    @EntityGraph(attributePaths = {"salaries","deptEmps","deptEmps.department"})
    Employee findWithSalariesWithDeptEmpsById(Integer id);

}
