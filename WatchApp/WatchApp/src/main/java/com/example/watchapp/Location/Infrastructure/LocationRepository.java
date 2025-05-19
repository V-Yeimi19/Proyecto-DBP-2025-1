package com.example.watchapp.Location.Infrastructure;

import com.example.watchapp.Location.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByDepartmentAndProvinceAndDistrict(String department, String province, String district);
}
