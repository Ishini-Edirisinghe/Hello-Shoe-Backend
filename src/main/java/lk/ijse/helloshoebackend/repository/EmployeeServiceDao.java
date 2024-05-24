package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeServiceDao extends JpaRepository<EmployeeEntity,String> {
    EmployeeEntity findFirstByOrderByEmployeeCodeDesc();
}
