package lk.ijse.helloshoebackend.repository;

import lk.ijse.helloshoebackend.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchServiceDAO extends JpaRepository<BranchEntity,String> {
}
