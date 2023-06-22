 
public class UserController {

    private final UserService userService;

@PostMapping("/public/follow")
    public ResponseEntity<SellerFollowedDTO> followSellers(@RequestParam("userid") UUID userID,@RequestParam("sellerid") UUID sellerID) throws AgriTradeException {
        Follow follow=userService.followSeller(userID,sellerID);
        SellerFollowedDTO sellerFollowedDTO=new SellerFollowedDTO();
        if(follow!=null) {
           sellerFollowedDTO.setFollowedStatus(true);
           sellerFollowedDTO.setSellerName(follow.getSellerInfo().getUser().getFirstName());
           sellerFollowedDTO.setCompanyName(follow.getSellerInfo().getCompanyName());
        }
        return ResponseEntity.ok(sellerFollowedDTO);
    }

    @DeleteMapping ("/public/unfollow")
    public ResponseEntity<SellerFollowedDTO> unfollowSellers(@RequestParam("userid") UUID userID,
                                                             @RequestParam("sellerid") UUID sellerID) throws AgriTradeException {


        Follow follow = userService.unfollowSeller(userID, sellerID);
        SellerFollowedDTO sellerFollowedDTO=new SellerFollowedDTO();
        if(follow!=null) {
           sellerFollowedDTO.setSellerName(follow.getSellerInfo().getUser().getFirstName());
           sellerFollowedDTO.setCompanyName(follow.getSellerInfo().getCompanyName());
           sellerFollowedDTO.setFollowedStatus(false);
        }
            return ResponseEntity.ok(sellerFollowedDTO);
    }

      @GetMapping("/public/follow/crops")
      public ResponseEntity<List<Crop>> showFollowedSellerCrops(@RequestParam("userid") UUID userID,
                                                       @RequestParam("sellerid") UUID sellerID) throws AgriTradeException {

        List<Crop> cropList=userService.getCropsByFollowedSeller(userID,sellerID);
        if(cropList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(cropList);
    }



