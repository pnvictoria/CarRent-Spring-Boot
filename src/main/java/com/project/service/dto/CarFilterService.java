package com.project.service.dto;

import com.project.dao.interfaces.FilterDAO;
import com.project.dto.CarFilterDTO;
import com.project.entity.Car;
import com.project.service.interfaces.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class CarFilterService implements FilterService<Car, CarFilterDTO> {
    private static final Logger LOG = LoggerFactory.getLogger(CarFilterService.class);

    private FilterDAO<Car, CarFilterDTO> filterDAO;

    public CarFilterService(FilterDAO<Car, CarFilterDTO> filterDAO) {
        this.filterDAO = filterDAO;
    }

    @Override
    public List<Car> getFilteredObjects(CarFilterDTO dto) {
        try {
            return filterDAO.getFilteredObjects(dto);
        } catch (SQLException e) {
            LOG.error("Exception: {}", e.getMessage(), e);
        }
        return List.of(Car.builder().build());
    }
}
