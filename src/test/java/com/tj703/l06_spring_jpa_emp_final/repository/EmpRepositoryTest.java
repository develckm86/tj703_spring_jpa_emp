package com.tj703.l06_spring_jpa_emp_final.repository;

import com.tj703.l06_spring_jpa_emp_final.enitity.Employee;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class EmpRepositoryTest {
    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void proxyTest(){
        //프록시(대리인) 디자인패턴 (프록시 객체)
        //생성과 관련된 객체
        //fetType=LAZY 지연조회에서 요청하는 객체를 프록시 객체가 대신하고 있음???

        Employee proxyEmp=entityManager.getReference(Employee.class, 10001);
        System.out.println(proxyEmp.getClass()); //type 확인
        //class com.tj703.l06_spring_jpa_emp_final.enitity.Employee$HibernateProxy$dPBw8EzH
        //Employee$HibernateProxy$dPBw8EzH
        System.out.println(proxyEmp instanceof Employee); //trye
        //해당 대리객체의 부모가  Employee 인가

    }




    @Test
    @Transactional
    void findAll() {
        //Pageable pageable=Pageable.ofSize(10);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(1, 10).withSort(sort);
        Page<Employee> empPage=empRepository.findAll(pageable);
        System.out.println(empPage.getContent());
    }

    @Test
    @Transactional
    void findByFirstName() {
        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(0,10).withSort(sort);
        Page<Employee> empPage=empRepository.findByFirstName(pageable,"Parto");
        System.out.println(empPage.getContent());
    }
    @Test
    @Transactional
    void findById(){
        System.out.println(empRepository.findById(10010).get());
    }


    @Test
    @Transactional
    void findWithSalariesById() {
        System.out.println(empRepository.findWithSalariesWithDeptEmpsById(10010));
    }
}