package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.dto.BranchDTO;
import lk.ijse.helloshoebackend.exception.InvalidException;


public interface BranchService {
    void saveBranch(BranchDTO branchDTO) throws InvalidException;
}
