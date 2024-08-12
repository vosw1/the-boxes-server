package com.example.the_boxes_server.inout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InOutRepository extends JpaRepository<InOut, Integer> {
}
