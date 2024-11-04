package com.documentor.backend.infrastructure.repositories;

import com.documentor.backend.domain.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {


}
