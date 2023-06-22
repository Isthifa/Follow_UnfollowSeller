public List<Crop> getCropsByFollowedSeller(UUID userID, UUID sellerID) throws AgriTradeException {
        // Find the follow data between the user and the seller whether exists in db
        Optional<Follow> follows=followRepository.findByUserIdandSellerId(userID,sellerID);
        //initialize the crop list as null
        List<Crop> cropList=null;
        //check it
        if(follows.isPresent()) {
            //if present then get the crop list
            cropList = userCropXrefRepository.findByUserId(sellerID);
            if (cropList.isEmpty()) {
                throw new AgriTradeException("No Crops");
            }
            //return the crop list
            return cropList;
        }
        else{
            //if not present throw the exception as you not following the seller
            throw new AgriTradeException("you are not following seller");
        }
    }
