package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import com.example.stage.Repositories.CIChangementRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service("CIChangementService")
@Transactional
public class CIChangementServiceImpl implements CIChangementService{

    private CIChangementRepository CIChangRepository;
    @Override
    public CIChangement saveCIChangement(CIChangement CIChang) {
        return CIChangRepository.save(CIChang);
    }

    @Override
    public List<CI> getCIsByChangement(Long idChangement) {
        return CIChangRepository.getCIsByChangement(idChangement);
    }
}
