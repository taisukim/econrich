package com.example.econrich.repository;

import com.example.econrich.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final EntityManager em;

    public void save(Employee employee){
        em.persist(employee);
    }

    public List<Employee> findAll(){
        return em.createQuery("select e from Employee e join fetch e.manager m ", Employee.class)
                .getResultList();
    }
 }
