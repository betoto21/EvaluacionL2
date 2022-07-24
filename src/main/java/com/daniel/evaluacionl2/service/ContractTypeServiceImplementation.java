package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.dao.IContractTypeDAO;
import com.daniel.evaluacionl2.domain.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractTypeServiceImplementation implements IContractTypeService{

    @Autowired
    private IContractTypeDAO contractTypeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ContractType> listContractType() {
        return (List<ContractType>) contractTypeDAO.findAll();
    }

    @Override
    @Transactional
    public void saveContractType(ContractType contractType) {
        contractTypeDAO.save(contractType);
    }

    @Override
    @Transactional
    public void deleteContractType(ContractType contractType) {
        contractTypeDAO.deleteById(contractType.getContractTypeId());
    }

    @Override
    @Transactional(readOnly = true)
    public ContractType findContractType(ContractType contractType) {
        return contractTypeDAO.findById(contractType.getContractTypeId()).orElse(null);
    }
}
