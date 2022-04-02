package com.example.Dao.Personal;

import com.example.Entity.Data.Month;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalData {
    /*年收入*/
    List<Month> PersonalSpendRecord(String year, String familyid);

    List<Month> PersonalIncomeRecord(String year, String familyid);
    /*月收入*/
    List<Month> PersonalSpendMonthRecord(String dates, String familyid);
    List<Month> PersonalIncomeMonthRecord(String dates, String familyid);
}
