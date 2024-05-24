package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderServiceDAO extends JpaRepository<GenderEntity,String> {
}
