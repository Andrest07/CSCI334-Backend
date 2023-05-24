package com.csci334.RCMS.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csci334.RCMS.model.Bid;
import com.csci334.RCMS.repository.BidRepository;

@Service
public class BidService {
    private final BidRepository bidRepository;

    Logger log = LoggerFactory.getLogger(BidService.class);

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public List<Bid> getBids() {
		return bidRepository.findAll();
	}

	public List<Long> getBidIds() {
		List<Long> ids = new ArrayList<Long>();
		List<Bid> bids = getBids();
		for(int i=0;i<bids.size();i++) {
			ids.add(bids.get(i).getId());
		}
		return ids;
	}

    public Bid getBidById(Long id) throws Exception{
        return bidRepository.findById(id).orElseThrow();
    }

    public Bid createBid(Bid newBid) {
        try {
            return bidRepository.save(newBid);
        } finally {
            log.info("Creating Bid:" + newBid);
        }
    }

    public Bid updateBid(Bid bid, Long id) throws Exception {
        Bid foundBid = getBidById(id);
        if (foundBid == null) {
            throw new Exception("Bid invalid");
        }
        foundBid.setBid(bid);
        log.info("Updating Paper:" + foundBid);
        return bidRepository.save(foundBid);
    }

    public void deleteBid(Long id) throws Exception {
        log.info("Deleting Bid:" + getBidById(id));
        bidRepository.deleteById(id);
    }

    public Bid addBidPaper(Long rId, Long pId) throws Exception {
        Bid r = getBidById(rId);
        r.addPaperId(pId);
        log.info("Adding Paper to Bid: " + r);
        return bidRepository.save(r);
    }

    public Bid addBidReviewer(Long rId, Long rrId) throws Exception {
        Bid r = getBidById(rId);
        r.addReviewerId(rrId);
        log.info("Adding Reviewer to Bid: " + r);
        return bidRepository.save(r);
    }
}
