package Classes;

import java.util.ArrayList;

public class Auctioneer {

	private ArrayList<AuctionListing> auctionListings;

	public Auctioneer() {

	}

	public ArrayList<AuctionListing> getMyOpenAuctionListings(User user) {
		ArrayList<AuctionListing> results = new ArrayList<AuctionListing>();

		for (AuctionListing listing : auctionListings) {
			if ((listing.getSellerUsername() == user.getUsername()) && (listing.getStatus() != "Closed"))
				results.add(listing);
		}

		return results;
	}

	public ArrayList<AuctionListing> getMyClosedAuctionListings(User user) {
		ArrayList<AuctionListing> results = new ArrayList<AuctionListing>();

		for (AuctionListing listing : auctionListings) {
			if ((listing.getSellerUsername() == user.getUsername()) && (listing.getStatus() == "Closed"))
				results.add(listing);
		}

		return results;
	}

	public ArrayList<AuctionListing> getOtherAuctionListings(User user) {
		ArrayList<AuctionListing> results = new ArrayList<AuctionListing>();

		for (AuctionListing listing : auctionListings) {
			if ((listing.getSellerUsername() != user.getUsername()) && (listing.getStatus() == "Active"))
				results.add(listing);
		}

		return results;
	}

	public ArrayList<AuctionListing> getWonListings(User user) {
		ArrayList<AuctionListing> results = new ArrayList<AuctionListing>();

		for (AuctionListing listing : auctionListings) {
			if ((listing.getStatus() == "Closed") && (listing.getWinningBidder() == user))
				results.add(listing);
		}

		return results;
	}

	public String bidFor(AuctionListing listing, Bid bid) {
		return listing.processBid(bid);
	}

	public void post(AuctionListing listing) {
		listing.setStatus("Active");
		auctionListings.add(listing);
	}

	public ArrayList<AuctionListing> getAuctionListings() {
		return auctionListings;
	}
}