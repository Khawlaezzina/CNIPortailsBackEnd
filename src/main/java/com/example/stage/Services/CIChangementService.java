package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface CIChangementService {
    CIChangement saveCIChangement(CIChangement CIChang);
    List<CI> getCIsByChangement(Long idChangement);
}
