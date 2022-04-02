package com.example.Dao.ShowRecord;

import com.example.Entity.Data.Month;
import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowData {

    /*某年每月的收入*/
    List<Integer> getYearIncome(String year);

    /*某年每月的支出*/
    List<Integer> getYearSpend(String year);

    /*每月的数据*/
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


    /*显示家庭成员的支出*/
    List<SpendRecord> getSpendRecord(String familyid);
    /*显示家庭成员的收入*/
    List<IncomeRecord> getIncomeRecord(String familyid);
}
