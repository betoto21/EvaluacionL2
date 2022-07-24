package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.domain.Contract;

import java.util.List;

public interface IContractService {

    public List<Contract> listContract();

    public void saveContract(Contract contract);

    public void deleteContract(Contract contract);

    public Contract findContract(Contract contract);
}
