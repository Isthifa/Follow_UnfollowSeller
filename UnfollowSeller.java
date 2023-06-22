public Follow unfollowSeller(UUID userID, UUID sellerID) throws AgriTradeException {
        Optional<SellerInfo> sellerInfo=sellerInfoRepository.findBySellerId(sellerID);
        // Find the follow data between the user and the seller whether exists in db
        Optional<Follow> follows=followRepository.findByUserIdandSellerId(userID,sellerID);
        //Check if seller exists in db
        if(sellerInfo.isEmpty())
        {
            throw new AgriTradeException("Seller Not Exist");
        }
        else if(!follows.isPresent())
        {
            //if not present throw the exception
            throw new AgriTradeException("Not Following");
        }
        followRepository.delete(follows.get());
        return follows.get();
    }
