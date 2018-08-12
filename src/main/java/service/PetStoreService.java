package service;

import com.zm.beans.factory.annotation.Autowired;
import com.zm.stereotype.Component;


@Component(value = "petStore")
public class PetStoreService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private ItemDao itemDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

}
