package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierServiceDAO extends JpaRepository<SupplierEntity,String> {
    SupplierEntity findFirstByOrderBySupplierCode();
}
