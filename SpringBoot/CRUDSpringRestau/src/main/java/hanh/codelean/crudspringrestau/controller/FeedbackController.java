package hanh.codelean.crudspringrestau.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hanh.codelean.crudspringrestau.entity.Feedback;
import hanh.codelean.crudspringrestau.service.FeedbackService;

@Controller
@RequestMapping("/feedbacks")
public class FeedbackController {

    private FeedbackService feedbackService;

    public FeedbackController(FeedbackService theFeedbackService) {
        feedbackService = theFeedbackService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listFeedbacks(Model theModel) {

        // get feedbacks from db
        List<Feedback> theFeedbacks = feedbackService.findAll();

        // add to the spring model
        theModel.addAttribute("feedbacks", theFeedbacks);

        return "feedbacks/list-feedbacks";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Feedback theFeedback = new Feedback();

        theModel.addAttribute("feedback", theFeedback);

        return "feedbacks/feedback-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("feedbackId") int theId,
                                    Model theModel) {

        // get the feedback from the service
        Feedback theFeedback = feedbackService.findById(theId);

        // set feedback as a model attribute to pre-populate the form
        theModel.addAttribute("feedback", theFeedback);

        // send over to our form
        return "feedbacks/feedback-form";
    }

    @PostMapping("/save")
    public String saveFeedback(@ModelAttribute("feedback") Feedback theFeedback) {

        // save the feedback
        feedbackService.save(theFeedback);

        // use a redirect to prevent duplicate submissions
        return "redirect:/feedbacks/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("feedbackId") int theId) {

        // delete the feedback
        feedbackService.deleteById(theId);

        // redirect to /feedbacks/list
        return "redirect:/feedbacks/list";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam("keyword") String keyword, Model theModel) {
//
//        // search feedbacks by keyword
//        List<Feedback> theFeedbacks = feedbackService.search(keyword);
//
//        // add to the spring model
//        theModel.addAttribute("feedbacks", theFeedbacks);
//
//        return "feedbacks/list-feedbacks";
//    }
}
