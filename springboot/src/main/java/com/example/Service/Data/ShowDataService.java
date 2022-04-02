package com.example.Service.Data;

import com.example.Entity.Data.Month;
import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;

import java.util.List;

public interface ShowDataService {
    /*显示某年每月的收入*/
    List<Integer> getYearIncome(String year);

    /*显示某年每月的支出*/
    List<Integer> getYearSpend(String year);

    List<Month> getMonthIncome(String year, String month);

    List<Month> getMonthSpend(String year, String month);

    /*查询家人的支出*/
    List<Month> getDayOfMotherSpend(String date);

    List<Month> getDayOfFatherSpend(String date);

    List<Month> getDayOfSonSpend(String date);

    /*查询家人的收入*/
    List<Month> getDayOfMotherIncome(String date);

    List<Month> getDayOfFatherIncome(String date);

    List<Month> getDayOfSonIncome(String date);

    /*家庭成员的支出*/
    List<SpendRecord> getSpendRecord(String familyid);
    /*家庭成员的收入*/
    List<IncomeRecord> getIncomeRecord(String familyid);
}
