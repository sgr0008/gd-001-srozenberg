package com.backend.business.service.Info;

import com.backend.domain.model.Info;

import java.util.List;
import java.util.Optional;

public interface InfoService {

    List<Info> findAll();

    Info save(Info infoAlta);

    Optional<Info> findById(Long id);

    void deleteById(Long id);

    Info updateInfo(long infoID, Info info);

}
