package com.springboot.caseStudy.balance;

        import com.springboot.caseStudy.account.Balance;
        import com.springboot.caseStudy.repositories.BalanceRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository repo;

    public List<Balance> listAll() {
        return (List<Balance>) repo.findAll();
    }

    public void save(Balance balance) {
        repo.save(balance);
    }



    public Balance get(Integer user_id) throws BalanceNotFoundException {
        Optional<Balance> result = repo.findById(user_id);
        if (result.isPresent()){
            return result.get();
        }
        throw new BalanceNotFoundException("Could not find accounts with ID"+ user_id);

    }

}
