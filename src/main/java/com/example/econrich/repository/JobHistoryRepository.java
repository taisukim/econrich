package com.example.econrich.repository;

import com.example.econrich.domain.JobHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobHistoryRepository {

    private final EntityManager em;

    public void save(JobHistory jobHistory) {
        em.persist(jobHistory);
    }

    public List<JobHistory> findById(Long employeeId) {
        return em.createQuery(
                "select j from JobHistory j " +
                        "join fetch j.department d " +
                        "join fetch j.job jo " +
                        "where j.employeeId.id = :employeeId", JobHistory.class)
                .setParameter("employeeId", employeeId)
                .getResultList();
    }
}
