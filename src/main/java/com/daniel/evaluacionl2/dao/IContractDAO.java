package com.daniel.evaluacionl2.dao;

import com.daniel.evaluacionl2.domain.Contract;
import org.springframework.data.repository.CrudRepository;

public interface IContractDAO extends CrudRepository<Contract, Long> {

}
