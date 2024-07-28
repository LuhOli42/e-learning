package com.api.e_learning.service.impl;

import com.api.e_learning.model.Account;
import com.api.e_learning.model.Courses;
import com.api.e_learning.repository.AccountRepository;
import com.api.e_learning.repository.CoursesRepository;
import com.api.e_learning.service.AccountService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

  private final AccountRepository accountRepository;
  private final CoursesRepository coursesRepository;

  public AccountServiceImp(
    AccountRepository accountRepository,
    CoursesRepository coursesRepository
  ) {
    this.accountRepository = accountRepository;
    this.coursesRepository = coursesRepository;
  }

  @Override
  public Account findById(String id) {
    return accountRepository
      .findById(id)
      .orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Account create(Account accountToCreate) {
    return accountRepository.save(accountToCreate);
  }

  @Override
  public Account addCourse(String id, String courseId) {
    Account accountToAddCourse = accountRepository.getReferenceById(id);

    Courses courseToRegistered = coursesRepository
      .findById(courseId)
      .orElseThrow(NoSuchElementException::new);

    List<Courses> newList = accountToAddCourse.getCoursesRegistered();
    newList.add(courseToRegistered);

    accountToAddCourse.setCoursesRegistered(newList);

    return accountRepository.save(accountToAddCourse);
  }

  @Override
  public Account concludeCourse(String id, String courseId) {
    Account accountToConcludeCourse = accountRepository.getReferenceById(id);

    Courses courseToConcludes = coursesRepository
      .findById(courseId)
      .orElseThrow(NoSuchElementException::new);

    if (
      !accountToConcludeCourse
        .getCoursesRegistered()
        .contains(courseToConcludes)
    ) {
      throw new IllegalArgumentException("This course wasn't registered");
    }

    List<Courses> setNewConcludesList = accountToConcludeCourse.getCoursesConcludes();

    setNewConcludesList.add(courseToConcludes);
    accountToConcludeCourse.setCoursesConcludes(setNewConcludesList);
    return accountRepository.save(accountToConcludeCourse);
  }

  @Override
  public List<Account> findAllAccount() {
    return accountRepository.findAll();
  }
}
