package com.example.econrich.repository;

import com.example.econrich.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> findById(Long employeeId) {
        return Optional.of(
                em.createQuery(
            "select e from Employee e " +
                    "join fetch e.manager m " +
                    "join fetch e.department d " +
                    "join fetch d.location l " +
                    "join fetch l.country c " +
                    "join fetch c.region r " +
                    "join fetch e.job j " +
                    "where e.id = :employeeId"
                , Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult());
    }
}
