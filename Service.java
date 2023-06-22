  Follow followSeller(UUID userId, UUID sellerID) throws AgriTradeException;

  Follow unfollowSeller(UUID userID, UUID sellerID) throws AgriTradeException;

  List<Crop> getCropsByFollowedSeller(UUID userID, UUID sellerID) throws AgriTradeException;

