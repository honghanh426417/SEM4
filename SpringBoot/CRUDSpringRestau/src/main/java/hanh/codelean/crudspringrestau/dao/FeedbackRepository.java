package hanh.codelean.crudspringrestau.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hanh.codelean.crudspringrestau.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    public List<Feedback> findAllByOrderByNameAsc();
}
