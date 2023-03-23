package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.repository.PaperRepository;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public Paper getPaperById(Long id) throws Exception{
        return paperRepository.findById(id).orElseThrow();
    }

    public Paper createPaper(Paper newPaper) {
        return paperRepository.save(newPaper);
    }

    public Paper updatePaper(Paper paper, Long id) throws Exception {
        Paper foundPaper = getPaperById(id);
        if (foundPaper == null) {
            throw new Exception("Paper invalid");
        }
        foundPaper.setPaper(paper);
        return paperRepository.save(foundPaper);
    }

    public void deletePaper(Long id) {
        paperRepository.deleteById(id);
    }
}
