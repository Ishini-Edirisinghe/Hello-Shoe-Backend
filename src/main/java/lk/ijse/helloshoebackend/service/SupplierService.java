package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);

    SupplierDTO getSupplier(String id);

    List<SupplierDTO> getAllSuppliers();

    void deleteSupplier(String id);

    void updateSupplier(String id,SupplierDTO supplierDTO);
}
