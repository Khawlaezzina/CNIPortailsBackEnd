package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import com.example.stage.Entities.CIProbleme;

import java.util.List;

public interface CIProblemeService {
    CIProbleme saveCIProbleme(CIProbleme CIChang);
    List<CI> getCIsByProbleme(Long idChangement);
}
