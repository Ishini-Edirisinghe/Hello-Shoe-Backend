package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.VarietyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VarietyServiceDAO extends JpaRepository<VarietyEntity,String> {
}

