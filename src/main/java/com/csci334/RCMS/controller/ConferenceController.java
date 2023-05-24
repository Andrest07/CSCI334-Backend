package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.service.ConferenceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ConferenceController {
    @Autowired
    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping("/conferences")
	List<Conference> all() {
		return conferenceService.getConferences();
	}

	@GetMapping("/conferences/ids")
	List<Long> getConferenceIds(){
		return conferenceService.getConferenceIds();
	}

    @GetMapping("/conference/{id}")
    Conference getConferenceById(@PathVariable Long id) throws Exception {
        return conferenceService.getConferenceById(id);
    }

    @GetMapping("/conference/findConferenceUsername/{username}")
    Conference getConferenceFindUsername(@PathVariable String username) throws Exception {
        return conferenceService.getConferenceFindUsername(username);
    }

    @GetMapping("/conference/findConferencePassword/{password}")
    Conference getConferenceFindPassword(@PathVariable String password) throws Exception {
        return conferenceService.getConferenceFindPassword(password);
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
