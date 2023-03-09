package com.example.demo.service;

import com.example.demo.model.Province;
import com.example.demo.model.User;

import java.util.List;

public interface IUser {
    List<User> selectAllUser();
    Province selectProvince(int province_id);
}
