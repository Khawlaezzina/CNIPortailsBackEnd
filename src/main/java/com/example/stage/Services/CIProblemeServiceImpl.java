package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIProbleme;
import com.example.stage.Repositories.CIProblemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("CIProblemeService")
@Transactional
public class CIProblemeServiceImpl  implements CIProblemeService{
    @Autowired
    private CIProblemeRepository CIProblemeRepository;

    @Autowired
    public CIProblemeServiceImpl(com.example.stage.Repositories.CIProblemeRepository CIProblemeRepository) {
        this.CIProblemeRepository = CIProblemeRepository;
    }

    @Override
    public CIProbleme saveCIProbleme(CIProbleme CIChang) {
        return CIProblemeRepository.save(CIChang);
    }

    @Override
    public List<CI> getCIsByProbleme(Long idChangement) {
        return CIProblemeRepository.getCIsByProbleme(idChangement);
    }
}
