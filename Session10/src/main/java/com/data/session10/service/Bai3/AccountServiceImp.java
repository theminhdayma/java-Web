package com.data.session10.service.Bai3;

import com.data.session10.dao.Bai3.AccountDao;
import com.data.session10.model.Bai3.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }
}
