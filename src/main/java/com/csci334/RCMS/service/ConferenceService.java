package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.repository.ConferenceRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    Logger log = LoggerFactory.getLogger(ConferenceService.class);

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public List<Conference> getConferences() {
		return conferenceRepository.findAll();
	}

	public List<Long> getConferenceIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Conference> conferences = getConferences();
		for(int i=0;i<conferences.size();i++) {
			ids.add(conferences.get(i).getId());
		}
		return ids;
	}

    public Conference getConferenceById(Long id) throws Exception{
        return conferenceRepository.findById(id).orElseThrow();
    }

    public Conference createConference(Conference newConference) {
        try {
            return conferenceRepository.save(newConference);
        } finally {
            log.info("Creating Conference: " + newConference);
        }
        
    }

    public Conference updateConference(Conference conference, Long id) throws Exception {
        Conference foundConference = getConferenceById(id);
        if (foundConference == null) {
            throw new Exception("Conference invalid");
        }
        foundConference.setConference(conference);
        log.info("Updating Conference: " + foundConference);
        return conferenceRepository.save(foundConference);
    }

    public void deleteConference(Long id) throws Exception {
        log.info("Deleting Conference: " + getConferenceById(id));
        conferenceRepository.deleteById(id);
    }


}
