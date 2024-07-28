package com.api.e_learning.service;

import com.api.e_learning.model.Account;
import java.util.List;

public interface AccountService {
  List<Account> findAllAccount();
  Account findById(String id);
  Account create(Account accountToCreate);
  Account addCourse(String id, String courseId);
  Account concludeCourse(String id, String courseId);
}
