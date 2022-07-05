package com.example.scerri.graphqljava.service;

import com.example.scerri.graphqljava.generated.types.User;

import java.util.List;

public interface UserService {

    List<User> users();
}
