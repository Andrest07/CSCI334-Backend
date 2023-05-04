package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConferenceController {
    @Autowired
    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conference/{id}")
    Conference getConferenceById(@PathVariable Long id) throws Exception {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping("/createConference")
    Conference createConference(@RequestBody Conference newConference) {
        return conferenceService.createConference(newConference);
    }

    @PutMapping("/updateConference/{id}")
    Conference updateConference(@RequestBody Conference conference, @PathVariable Long id) throws Exception {
        return conferenceService.updateConference(conference, id);
    }

    @DeleteMapping({"/deleteConference/{id}"})
    void deleteConference(@PathVariable Long id) throws Exception {
        conferenceService.deleteConference(id);
    }
}
