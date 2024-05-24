package lk.ijse.helloshoebackend.service;

import lk.ijse.helloshoebackend.dto.VarietyDTO;


import java.util.List;

public interface VarietyService {
    void saveVariety(VarietyDTO varietyDTO);

    List<VarietyDTO> getAllVariety();

    void deleteVariety(String id);

    void updateVariety(String id,VarietyDTO varietyDTO);
}