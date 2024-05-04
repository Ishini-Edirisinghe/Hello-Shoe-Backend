package lk.ijse.helloshoebackend.dao;

import lk.ijse.helloshoebackend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceDao extends JpaRepository<CustomerEntity,String> {
    CustomerEntity findFirstByOrderByCustomerIdDesc();
}