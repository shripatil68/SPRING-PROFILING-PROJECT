package com.shridhar.springbootwebtutorial.service.Impl;

import com.shridhar.springbootwebtutorial.service.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class DataServiceImplProd implements DataService {

    @Override
    public String getData() {
        return "Prod Data";
    }
}
