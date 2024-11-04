package com.documentor.backend.casodeuso.service.Info;

import com.documentor.backend.domain.model.Info;
import com.documentor.backend.infrastructure.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoRepository infoRepository;

    @Override
    public List<Info> findAll() {
        return infoRepository.findAll();
    }


    @Override
    public  Info updateInfo(long infoID, Info Info){
       Info infoDB= this.findById(infoID).orElse(null);
      if(infoDB.equals(null))
          this.save(Info);
      return Info;

    }
    @Override
    public Info save(Info infoAlta) {
        return infoRepository.save(infoAlta);
    }
    @Override
    public Optional<Info> findById(Long id) {
        return infoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        infoRepository.deleteById(id);
    }



}