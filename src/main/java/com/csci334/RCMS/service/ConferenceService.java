package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Conference;
import com.csci334.RCMS.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    public Conference getConferenceById(Long id) throws Exception{
        return conferenceRepository.findById(id).orElseThrow();
    }

    public Conference createConference(Conference newConference) {
        return conferenceRepository.save(newConference);
    }

    public Conference updateConference(Conference conference, Long id) throws Exception {
        Conference foundConference = getConferenceById(id);
        if (foundConference == null) {
            throw new Exception("Conference invalid");
        }
        foundConference.setConference(conference);
        return conferenceRepository.save(foundConference);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }


}
