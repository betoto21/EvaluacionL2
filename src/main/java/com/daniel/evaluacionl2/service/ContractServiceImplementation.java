package com.daniel.evaluacionl2.service;

import com.daniel.evaluacionl2.dao.IContractDAO;
import com.daniel.evaluacionl2.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContractServiceImplementation implements IContractService{

    @Autowired
    private IContractDAO contractDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Contract> listContract() {
        return (List<Contract>) contractDAO.findAll();
    }

    @Override
    @Transactional
    public void saveContract(Contract contract) {
        List<Contract> contracts = listContract();
        for (Contract con : contracts){
            if (con.getEmployeeId() == contract.getEmployeeId() && con.getIsActive() == 1) {
                con.setIsActive(0);
                con.setDateTo(contract.getDateFrom());
                saveContract(con);
            }
        }
        contractDAO.save(contract);
    }

    @Override
    @Transactional
    public void deleteContract(Contract contract) {
        contractDAO.deleteById(contract.getContractId());
    }

    @Override
    @Transactional(readOnly = true)
    public Contract findContract(Contract contract) {
        return contractDAO.findById(contract.getContractId()).orElse(null);
    }
}
