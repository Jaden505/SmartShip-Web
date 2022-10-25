package com.server.server.service;

import com.server.server.domain.Ship;
import com.server.server.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class ShipServiceImpl implements ShipService{
    private final ShipRepository shipRepository;

    @Override
    public List<Ship> getShips() {
        log.info("Log all ships");
        return shipRepository.findAll();
    }
}
