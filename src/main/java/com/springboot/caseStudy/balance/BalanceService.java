package com.springboot.caseStudy.balance;

import com.springboot.caseStudy.account.Balance;
import com.springboot.caseStudy.exceptions.NotFoundException;
import com.springboot.caseStudy.repositories.BalanceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {


    private BalanceRepository repo;

    public BalanceService(BalanceRepository repo) {
        this.repo = repo;
    }

    public List<Balance> listAll() {
        return (List<Balance>) repo.findAll();
    }

    public Balance save(Balance balance) {
        return repo.save(balance);
    }



    public Balance get(Integer user_id) throws NotFoundException {
        Optional<Balance> result = repo.findById(user_id);
        if (result.isPresent()){
            return result.get();
        }
        throw new NotFoundException("Could not find accounts with ID"+ user_id);
    }

}
