package com.example.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.Entity.Data.Month;
import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import com.example.Service.Data.ShowDataServiceImp;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/ShowData")
public class ShowDataController {

    @Autowired
    ShowDataServiceImp showDataServiceImp;

    /*显示某年的数据*/
    @PostMapping("/Year")
    public HashMap<String, List<Integer>> Year(@RequestBody Map<String, String> map) {
        String year = JSONObject.parseObject(JSONArray.toJSONString(map.get("year")), String.class);
        List<Integer> yearIncome = showDataServiceImp.getYearIncome(year);
        List<Integer> yearSpend = showDataServiceImp.getYearSpend(year);
        HashMap<String, List<Integer>> YearInfo = new HashMap<>();
        YearInfo.put("yearIncome", yearIncome);
        YearInfo.put("yearSpend", yearSpend);
        return YearInfo;
    }

    /*显示某年某月的数据*/
    @PostMapping("/Month")
    public HashMap<String, List<Month>> Month(@RequestBody Map<String, String> map) {
        String year = JSONObject.parseObject(JSONArray.toJSONString(map.get("Year")), String.class);

        String month = JSONObject.parseObject(JSONArray.toJSONString(map.get("Month")), String.class);
        if (Integer.valueOf(month) < 10) {
            month = "0" + month;
        }
        HashMap<String, List<Month>> MonthInfo = new HashMap<>();
        MonthInfo.put("MonthIncome", showDataServiceImp.getMonthIncome(year, month));
        MonthInfo.put("MonthSpend", showDataServiceImp.getMonthSpend(year, month));
        return MonthInfo;
    }

    /*显示每天的支出*/
    @PostMapping("/SpendDay")
    public HashMap<String, List<Month>> SpendDay(@RequestBody Map<String, String> map) {
        String dates = JSONObject.parseObject(JSONArray.toJSONString(map.get("Date")), String.class);
        HashMap<String, List<Month>> MonthInfo = new HashMap<>();

        MonthInfo.put("FatherSpend", showDataServiceImp.getDayOfFatherSpend(GetDate(dates)));
        MonthInfo.put("MotherSpend", showDataServiceImp.getDayOfMotherSpend(GetDate(dates)));
        MonthInfo.put("SonSpend", showDataServiceImp.getDayOfSonSpend(GetDate(dates)));
        return MonthInfo;
    }

    /*显示每天的收入*/
    @PostMapping("/IncomeDay")
    public HashMap<String, List<Month>> IncomeDay(@RequestBody Map<String, String> map) {
        String dates = JSONObject.parseObject(JSONArray.toJSONString(map.get("Date")), String.class);
        HashMap<String, List<Month>> MonthInfo = new HashMap<>();

        MonthInfo.put("FatherIncome", showDataServiceImp.getDayOfFatherIncome(GetDate(dates)));
        MonthInfo.put("MotherIncome", showDataServiceImp.getDayOfMotherIncome(GetDate(dates)));
        MonthInfo.put("SonIncome", showDataServiceImp.getDayOfSonIncome(GetDate(dates)));
        return MonthInfo;
    }

    /*时间转换函数*/
    public String GetDate(String dates) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);

    }

    /*显示对应家庭成员的支出*/
    @PostMapping("/ShowSpendRecord")
    public List<SpendRecord> getSpendRecord(@RequestBody Map<String, String> map) {
        String familyId = JSONObject.parseObject(JSONArray.toJSONString(map.get("FamilyId")), String.class);
        System.out.println(familyId);
        return showDataServiceImp.getSpendRecord(familyId);
    }

    @PostMapping("/ShowIncomeRecord")
    public List<IncomeRecord> getIncomeRecord(@RequestBody Map<String, String> map) {

        String familyId = JSONObject.parseObject(JSONArray.toJSONString(map.get("FamilyId")), String.class);

        System.out.println(familyId);
        return showDataServiceImp.getIncomeRecord(familyId);
    }


}
