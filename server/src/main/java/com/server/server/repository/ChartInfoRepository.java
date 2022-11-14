package com.server.server.repository;

import com.server.server.model.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartInfoRepository extends JpaRepository<Chart, Integer> {

}
