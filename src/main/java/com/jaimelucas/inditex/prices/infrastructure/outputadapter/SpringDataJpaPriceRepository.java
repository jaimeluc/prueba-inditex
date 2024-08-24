package com.jaimelucas.inditex.prices.infrastructure.outputadapter;

import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceEntity;
import com.jaimelucas.inditex.prices.infrastructure.outputport.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpringDataJpaPriceRepository extends JpaRepository<PriceEntity, PriceId> {

    @Query("select p from PriceEntity p " +
            "where p.id.brandId = :brandId and p.id.productId = :productId and p.endDate >= :applicationDate and p.id.startDate <= :applicationDate")
    List<PriceEntity> findByDateAndProductAndBrand(Integer brandId, Long productId, LocalDateTime applicationDate);

}
