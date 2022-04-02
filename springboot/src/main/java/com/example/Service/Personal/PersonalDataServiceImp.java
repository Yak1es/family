package com.example.Service.Personal;

import com.example.Dao.Personal.PersonalData;
import com.example.Entity.Data.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonalDataServiceImp implements PersonalDataService {
    @Autowired
    PersonalData personalData;

    @Override
    public List<Month> PersonalSpendRecord(String year, String familyid) {
        return personalData.PersonalSpendRecord(year, familyid);
    }

    @Override
    public List<Month> PersonalIncomeRecord(String year, String familyid) {
        return personalData.PersonalIncomeRecord(year, familyid);
    }

    @Override
    public List<Month> PersonalSpendMonthRecord(String dates, String familyid) {
        return personalData.PersonalSpendMonthRecord(dates, familyid);
    }

    @Override
    public List<Month> PersonalIncomeMonthRecord(String dates, String familyid) {
        return personalData.PersonalIncomeMonthRecord(dates, familyid);
    }
}
