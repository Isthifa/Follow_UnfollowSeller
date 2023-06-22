public Follow followSeller(UUID userID, UUID sellerID) throws AgriTradeException {
        //find the user id present in user db
        Optional<User> user=userRepository.findUserById(userID);
        //find the seller id present in sellerinfo db
        Optional<SellerInfo> sellerInfo=sellerInfoRepository.findBySellerId(sellerID);
        //check if they already exist in follow db
        Optional<Follow> follows=followRepository.findByUserIdandSellerId(user.get().getId(),
                sellerInfo.get().getUser().getId());
        //if the user id not found in user and seller id in sellerinfo db
        if(!user.isPresent() && !sellerInfo.isPresent()) {
            throw new RuntimeException("User and seller incorrect");
        }
        //if not present then save to db
        else if(!follows.isPresent()) {
            Follow follow = Follow.builder()
                    .user(user.get())
                    .sellerInfo(sellerInfo.get())
                    .isFollowed(true).build();
            return followRepository.save(follow);
        }
        //if present then already following
        else
        {
            throw new AgriTradeException("Already following");
        }

    }
