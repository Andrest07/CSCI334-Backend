package com.csci334.RCMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csci334.RCMS.model.Bid;
import com.csci334.RCMS.service.BidService;

@RestController
public class BidController {
    @Autowired
    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("/bids")
	List<Bid> all() {
		return bidService.getBids();
	}

	@GetMapping("/bids/ids")
	List<Long> getBidIds(){
		return bidService.getBidIds();
	}

    @GetMapping("/bid/{id}")
    Bid getBidById(@PathVariable Long id) throws Exception {
        return bidService.getBidById(id);
    }

    @PostMapping("/createBid")
    Bid createBid(@RequestBody Bid newBid) {
        return bidService.createBid(newBid);
    }

    @PutMapping("/updateBid/{id}")
    Bid updateBid(@RequestBody Bid bid, @PathVariable Long id) throws Exception {
        return bidService.updateBid(bid, id);
    }

    @DeleteMapping({"/deleteBid/{id}"})
    void deleteBid(@PathVariable Long id) throws Exception {
        bidService.deleteBid(id);
    }

    @PutMapping("/addBidPaper/{rId}/{aId}")
	Bid putBidPaper(@PathVariable Long rId, @PathVariable Long pId) throws Exception {
		return bidService.addBidPaper(rId, pId);
	}

    @PutMapping("/addBidReviewer/{rId}/{rId}")
	Bid putProfessionalRating(@PathVariable Long rId, @PathVariable Long rrId) throws Exception {
		return bidService.addBidReviewer(rId, rrId);
	}
}
