package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.OccasionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccasionServiceDAO extends JpaRepository<OccasionEntity,String> {
}

