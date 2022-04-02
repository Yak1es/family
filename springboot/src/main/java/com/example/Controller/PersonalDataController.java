package com.example.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.Entity.Data.Month;
import com.example.Service.Personal.PersonalDataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/PersonalData")
public class PersonalDataController {
    @Autowired
    PersonalDataServiceImp personalDataServiceImp;
/*年记录*/
    @PostMapping("/PersonalRecord")
    public HashMap<String, List<Month>> getPersonalRecord(@RequestBody Map<String, String> map) {
        String Year = JSONObject.parseObject(JSONArray.toJSONString(map.get("Year")), String.class);
        String familyId = JSONObject.parseObject(JSONArray.toJSONString(map.get("FamilyId")), String.class);
        HashMap<String, List<Month>> personal = new HashMap<>();
        List<Month> family1 = personalDataServiceImp.PersonalSpendRecord(Year, familyId);
        List<Month> family2 = personalDataServiceImp.PersonalIncomeRecord(Year, familyId);
        personal.put("PersonalSpend", family1);
        personal.put("PersonalIncome", family2);
        return personal;
    }
/*月记录*/
    @PostMapping("/PersonalMonth")
    public HashMap<String, List<Month>> getPersonalMonth(@RequestBody Map<String, String> map) {

        String familyId = JSONObject.parseObject(JSONArray.toJSONString(map.get("FamilyId")), String.class);
        HashMap<String, List<Month>> personal = new HashMap<>();

        List<Month> family1 = personalDataServiceImp.PersonalSpendMonthRecord(GetDate(JSONObject.parseObject(JSONArray.toJSONString(map.get("Date")), String.class)), familyId);
        List<Month> family2 = personalDataServiceImp.PersonalIncomeMonthRecord(GetDate(JSONObject.parseObject(JSONArray.toJSONString(map.get("Date")), String.class)), familyId);

        personal.put("PersonalSpendMonth", family1);
        personal.put("PersonalIncomeMonth", family2);

        return personal;
    }

    /*时间转换函数*/
    public String GetDate(String dates) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM").parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("yyyy-MM").format(date);

    }
}
