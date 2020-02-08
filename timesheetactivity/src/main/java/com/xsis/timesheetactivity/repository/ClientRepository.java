package com.xsis.timesheetactivity.repository;

import com.xsis.timesheetactivity.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>
{
}
