package com.example.the_boxes_server.inout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface InOutRepository extends JpaRepository<InOut, Integer> {

    @Query(value = "SELECT COALESCE(SUM(in_coming * price), 0) / NULLIF(SUM(in_coming), 0) FROM in_out WHERE in_coming > 0", nativeQuery = true)
    BigDecimal findWeightedAveragePrice();
}
