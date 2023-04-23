package com.csci334.RCMS.service;

import com.csci334.RCMS.model.Author;
import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.model.Reviewer;
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

    public Paper addPaperAuthor(Long pId, Long aId) throws Exception {
        Paper p = getPaperById(pId);
        return paperRepository.findById(p.getId())
                .map(Paper -> {
                    Paper.addAuthorId(aId);
                return paperRepository.save(Paper);
                }).orElseGet(() -> {
                    p.setId(pId);
                    return paperRepository.save(p);
                });
    }

    public Paper addPaperReviewer(Long pId, Long rId) throws Exception {
        Paper p = getPaperById(pId);
        return paperRepository.findById(p.getId())
                .map(Paper -> {
                    Paper.addReviewerId(rId);
                return paperRepository.save(Paper);
                }).orElseGet(() -> {
                    p.setId(pId);
                    return paperRepository.save(p);
                });
    }
}
