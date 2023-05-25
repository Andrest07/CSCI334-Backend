package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.model.Reviewer;
import com.csci334.RCMS.repository.PaperRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaperService {
    private final PaperRepository paperRepository;

    Logger log = LoggerFactory.getLogger(PaperService.class);

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getPapers() {
		return paperRepository.findAll();
	}

	public List<Long> getPaperIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Paper> papers = getPapers();
		for(int i=0;i<papers.size();i++) {
			ids.add(papers.get(i).getId());
		}
		return ids;
	}

    public Paper getPaperById(Long id) throws Exception{
        return paperRepository.findById(id).orElseThrow();
    }

    public Paper createPaper(Paper newPaper) {
        try {
            return paperRepository.save(newPaper);
        } finally {
            log.info("Creating Paper:" + newPaper);
        }
    }

    public Paper updatePaper(Paper paper, Long id) throws Exception {
        Paper foundPaper = getPaperById(id);
        if (foundPaper == null) {
            throw new Exception("Paper invalid");
        }
        foundPaper.setPaper(paper);
        log.info("Updating Author:" + foundPaper);
        Paper paper2 = paperRepository.save(foundPaper);
        return paper2;
    }

    public void deletePaper(Long id) throws Exception {
        log.info("Deleting Paper:" + getPaperById(id));
        paperRepository.deleteById(id);
    }

    public Paper addPaperAuthor(Long pId, Long aId) throws Exception {
        Paper p = getPaperById(pId);
        p.addAuthorId(aId);
        log.info("Adding Author to Paper: " + p);
        return paperRepository.save(p);
    }

    public Paper addPaperReviewer(Long pId, Long rId) throws Exception {
        Paper p = getPaperById(pId);
        p.addReviewerId(rId);
        log.info("Adding Reviewer to Paper: " + p);
        return paperRepository.save(p);
    }
}
