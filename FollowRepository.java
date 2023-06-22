package com.agritrade.jwt.service.repository;

import com.agritrade.jwt.service.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<Follow, UUID> {
    Optional<Follow> findUserById(UUID userID);

    @Query("select o from Follow o where o.user.id=:userID and o.sellerInfo.user.id=:sellerID and o.isFollowed=true ")
    Optional<Follow> findByUserIdandSellerId(UUID userID, UUID sellerID);
}
