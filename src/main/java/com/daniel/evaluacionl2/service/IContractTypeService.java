package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.domain.ContractType;

import java.util.List;

public interface IContractTypeService {

    public List<ContractType> listContractType();

    public void saveContractType(ContractType contractType);

    public void deleteContractType(ContractType contractType);

    public ContractType findContractType(ContractType contractType);
}
