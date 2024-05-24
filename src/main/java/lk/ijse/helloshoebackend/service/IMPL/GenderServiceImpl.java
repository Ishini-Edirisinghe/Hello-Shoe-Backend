package lk.ijse.helloshoebackend.service.IMPL;

import lk.ijse. helloshoebackend.conversion.ConversionData;
import lk.ijse.helloshoebackend.dto.GenderDTO;
import lk.ijse.helloshoebackend.exception.DuplicateException;
import lk.ijse.helloshoebackend.exception.NotFoundException;
import lk.ijse.helloshoebackend.repository.GenderServiceDAO;
import lk.ijse.helloshoebackend.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class GenderServiceImpl implements GenderService {
    private final GenderServiceDAO genderServiceDao;
    private final ConversionData conversionData;
    @Override
    public void saveGender(GenderDTO genderDTO) {
        if (genderServiceDao.existsById(genderDTO.getGenderCode())) throw new DuplicateException("Gender Id Duplicate");
        genderServiceDao.save(conversionData.toGenderEntity(genderDTO));
    }

    @Override
    public List<GenderDTO> getAllGenders() {
        return conversionData.convertToGenderDTO(genderServiceDao.findAll());
    }

    @Override
    public void deleteGender(String id) {
        if (!genderServiceDao.existsById(id)) throw new NotFoundException("Gender Not Found");
        genderServiceDao.deleteById(id);
    }

    @Override
    public void updateGender(String id, GenderDTO genderDTO) {
        if (!genderServiceDao.existsById(id)) throw new NotFoundException("Gender Not Found");
        genderServiceDao.save(conversionData.toGenderEntity(genderDTO));
    }
}
