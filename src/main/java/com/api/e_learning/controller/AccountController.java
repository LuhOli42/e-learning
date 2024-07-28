package com.api.e_learning.controller;

import com.api.e_learning.model.Account;
import com.api.e_learning.service.AccountService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/account")
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public ResponseEntity<List<Account>> accountList() {
    List<Account> accountList = accountService.findAllAccount();

    return ResponseEntity.ok(accountList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> findById(@PathVariable String id) {
    var account = accountService.findById(id);

    return ResponseEntity.ok(account);
  }

  @PostMapping
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    var accountCreated = accountService.create(account);
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(accountCreated.getId())
      .toUri();

    return ResponseEntity.created(location).body(accountCreated);
  }
  // @PostMapping("/login")
  // //login

  // @PostMapping("/addCourse")
  // //adding course to user

  // @PostMapping("/concludeCourse")
  // // conclude course
}
