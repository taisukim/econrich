package com.example.econrich.repository;

import com.example.econrich.domain.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobRepository {

    private final EntityManager em;

    public void save(Job job) {
        em.persist(job);
    }

    public List<Job> findAll() {
        return em.createQuery("select j from Job j ", Job.class)
                .getResultList();
    }
}
