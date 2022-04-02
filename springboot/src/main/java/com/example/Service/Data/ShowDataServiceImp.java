package com.example.Service.Data;

import com.example.Dao.ShowRecord.ShowData;
import com.example.Entity.Data.Month;
import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShowDataServiceImp implements ShowDataService {
    @Autowired
    ShowData showData;

    @Override
    public List<Integer> getYearIncome(String year) {
        return showData.getYearIncome(year);
    }

    @Override
    public List<Integer> getYearSpend(String year) {
        return showData.getYearSpend(year);
    }

    @Override
    public List<Month> getMonthIncome(String year, String month) {
        return showData.getMonthIncome(year, month);
    }

    @Override
    public List<Month> getMonthSpend(String year, String month) {
        return showData.getMonthSpend(year, month);
    }

    @Override
    public List<Month> getDayOfMotherSpend(String date) {
        return showData.getDayOfMotherSpend(date);
    }

    @Override
    public List<Month> getDayOfFatherSpend(String date) {
        return showData.getDayOfFatherSpend(date);
    }

    @Override
    public List<Month> getDayOfSonSpend(String date) {
        return showData.getDayOfSonSpend(date);
    }

    @Override
    public List<Month> getDayOfMotherIncome(String date) {
        return showData.getDayOfMotherIncome(date);
    }

    @Override
    public List<Month> getDayOfFatherIncome(String date) {
        return showData.getDayOfFatherIncome(date);
    }

    @Override
    public List<Month> getDayOfSonIncome(String date) {
        return showData.getDayOfSonIncome(date);
    }

    @Override
    public List<SpendRecord> getSpendRecord(String familyid) {
        return showData.getSpendRecord(familyid);
    }

    @Override
    public List<IncomeRecord> getIncomeRecord(String familyid) {
        return showData.getIncomeRecord(familyid);
    }
}
