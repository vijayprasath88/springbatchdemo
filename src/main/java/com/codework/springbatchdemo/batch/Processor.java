package com.codework.springbatchdemo.batch;

import com.codework.springbatchdemo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class Processor implements ItemProcessor<User, User> {

    private static final Map<String, String> deptNames = new HashMap<>();

    public Processor() {
        deptNames.put("001","Technology");
        deptNames.put("002","Operations");
        deptNames.put("003","Accounts");
    }

    @Override
    public User process(User user) throws Exception {
        String deptCode = user.getDept();
        user.setDept(deptNames.get(deptCode));
        user.setTime(new Date());
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, deptNames.get(deptCode)));
        return user;
    }
}
