package com.tj703.l06_spring_jpa_emp_final.service;

import com.tj703.l06_spring_jpa_emp_final.enitity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpService {
    /*
    * 1. 화면에 사원 리스트 (페이징)
    * 2. 사원 상세(*급여리스트,*직책리스트,*부서이동리스트 lazy)
    * 3. 사원 수정(급여리스트 등록, 직책 리스트 등록, 부서 리스트 등록)
    * 4. 사원 등록
    * */
    Page<Employee> readAll(Pageable pageable);
    //무조건 조인
    Employee readOneWithSalariesWithTitlesWithDeptEmps(Long id);
    //급여,직책,부서를 조회할때만 fetch
    Employee readOne(Long id);

    //void modify(Employee employee);
    //void register(Employee employee);
    void save(Employee employee);
}
