package lk.ijse.helloshoebackend.service.IMPL;

import lk.ijse.helloshoebackend.conversion.ConversionData;
import lk.ijse.helloshoebackend.dto.OccasionDTO;
import lk.ijse.helloshoebackend.exception.DuplicateException;
import lk.ijse.helloshoebackend.exception.NotFoundException;
import lk.ijse.helloshoebackend.repository.OccasionServiceDAO;
import lk.ijse.helloshoebackend.service.OccasionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OccasionServiceImpl implements OccasionService {

    private final OccasionServiceDAO occasionServiceDao;
    private final ConversionData conversionData;


    @Override
    public void saveOccasion(OccasionDTO occasionDTO) {
        if (occasionServiceDao.existsById(occasionDTO.getOccasionCode())) throw new DuplicateException("Occasion Id Duplicate");
        occasionServiceDao.save(conversionData.toOccasionEntity(occasionDTO));
    }

    @Override
    public List<OccasionDTO> getAllOccasion() {
        return conversionData.convertToOccasionDTO(occasionServiceDao.findAll());
    }

    @Override
    public void deleteOccasion(String id) {
        if (!occasionServiceDao.existsById(id)) throw new NotFoundException("Occasion Not Found");
        occasionServiceDao.deleteById(id);
    }

    @Override
    public void updateOccasion(String id, OccasionDTO occasionDTO) {
        if (!occasionServiceDao.existsById(id)) throw new NotFoundException("Occasion Not Found");
        occasionServiceDao.save(conversionData.toOccasionEntity(occasionDTO));
    }
}