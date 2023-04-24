package com.example.econrich.repository;

import com.example.econrich.domain.Department;
import com.example.econrich.domain.Employee;
import com.example.econrich.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    private final EntityManager em;

    public void save(Department department) {
        em.persist(department);
    }

    public List<Department> findAll() {
        return em.createQuery("select d from Department d", Department.class)
                .getResultList();
    }

    public Optional<Department> findById(Long departmentId) {
        return Optional.of(
                em.createQuery(
            "select d from Department d " +
                    "join fetch d.location l " +
                    "join fetch l.country c " +
                    "join fetch c.region r " +
                    "where d.id = :departmentId"
                , Department.class)
                .setParameter("departmentId", departmentId)
                .getSingleResult()
        );
    }

    public Optional<Department> findEmployeeByDepartmentId(Long departmentId) {
        return Optional.of(em.createQuery(
            "select d from Department d " +
                    "join fetch d.employee e " +
                    "join fetch e.job j " +
                    "where d.id = :departmentId ", Department.class)
                .setParameter("departmentId", departmentId)
                .getSingleResult());
    }
}
