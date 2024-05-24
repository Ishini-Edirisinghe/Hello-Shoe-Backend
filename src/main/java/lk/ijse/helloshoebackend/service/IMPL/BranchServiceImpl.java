package lk.ijse.helloshoebackend.service.IMPL;

import lk.ijse.helloshoebackend.conversion.ConversionData;
import lk.ijse.helloshoebackend.dto.BranchDTO;
import lk.ijse.helloshoebackend.exception.InvalidException;
import lk.ijse.helloshoebackend.repository.BranchServiceDAO;
import lk.ijse.helloshoebackend.service.BranchService;
import lk.ijse.helloshoebackend.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    final private ConversionData conversionData;

    final private BranchServiceDAO branchServiceDao;
    @Override
    public void saveBranch(BranchDTO branchDTO){
        if (!branchDTO.getProductCode().equals(UtilMatters.productActivationCode())) throw new InvalidException("Invalid Product Code");
        branchDTO.setBranchId(UtilMatters.generateId());
        branchServiceDao.save(conversionData.toBranchEntity(branchDTO));
    }
}
