package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryServiceDAO extends JpaRepository<GenderEntity,String> {
}

