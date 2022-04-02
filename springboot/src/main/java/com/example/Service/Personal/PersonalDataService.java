package com.example.Service.Personal;

import com.example.Entity.Data.Month;

import java.util.List;

public interface PersonalDataService {
    List<Month> PersonalSpendRecord(String year , String familyid);
    List<Month> PersonalIncomeRecord(String year ,String familyid);

    List<Month> PersonalSpendMonthRecord(String date,String familyid);
    List<Month> PersonalIncomeMonthRecord(String date, String familyid);
}
