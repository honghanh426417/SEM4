package hanh.codelean.crudspringrestau.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanh.codelean.crudspringrestau.dao.FeedbackRepository;
import hanh.codelean.crudspringrestau.entity.Feedback;

@Service
public class FeedbackServiceFb implements FeedbackService {
    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceFb(FeedbackRepository theFeedbackRepository) {
        feedbackRepository = theFeedbackRepository;
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Feedback findById(int theId) {
        Optional<Feedback> result = feedbackRepository.findById(theId);

        Feedback theFeedback = null;

        if (result.isPresent()) {
            theFeedback = result.get();
        } else {
            throw new RuntimeException("Did not find feedback id - " + theId);
        }
        return theFeedback;
    }

    @Override
    public void save(Feedback theFeedback) {
        feedbackRepository.save(theFeedback);
    }

    @Override
    public void deleteById(int theId) {
        feedbackRepository.deleteById(theId);
    }
}
