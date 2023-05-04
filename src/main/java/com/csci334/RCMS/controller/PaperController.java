package com.csci334.RCMS.controller;

import com.csci334.RCMS.model.Paper;
import com.csci334.RCMS.service.PaperService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaperController {
    @Autowired
    private final PaperService paperService;

    public PaperController(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping("/papers")
	List<Paper> all() {
		return paperService.getPapers();
	}

	@GetMapping("/papers/ids")
	List<Long> getPaperIds(){
		return paperService.getPaperIds();
	}

    @GetMapping("/paper/{id}")
    Paper getPaperById(@PathVariable Long id) throws Exception {
        return paperService.getPaperById(id);
    }

    @PostMapping("/createPaper")
    Paper createPaper(@RequestBody Paper newPaper) {
        return paperService.createPaper(newPaper);
    }

    @PutMapping("/updatePaper/{id}")
    Paper updatePaper(@RequestBody Paper paper, @PathVariable Long id) throws Exception {
        return paperService.updatePaper(paper, id);
    }

    @DeleteMapping({"/deletePaper/{id}"})
    void deletePaper(@PathVariable Long id) throws Exception {
        paperService.deletePaper(id);
    }

    @PutMapping("/addPaperAuthor/{pId}/{aId}")
	Paper putPaperAuthor(@PathVariable Long pId, @PathVariable Long aId) throws Exception {
		return paperService.addPaperAuthor(pId, aId);
	}

    @PutMapping("/addPaperReviewer/{pId}/{rId}")
	Paper putProfessionalRating(@PathVariable Long pId, @PathVariable Long rId) throws Exception {
		return paperService.addPaperReviewer(pId, rId);
	}
}
