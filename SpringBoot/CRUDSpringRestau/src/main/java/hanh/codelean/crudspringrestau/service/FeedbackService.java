package hanh.codelean.crudspringrestau.service;

import java.util.List;

import hanh.codelean.crudspringrestau.entity.Feedback;

public interface FeedbackService {
    public List<Feedback> findAll();
    public Feedback findById(int theId);
    public void save(Feedback theFeedback);
    public void deleteById(int theId);
}
