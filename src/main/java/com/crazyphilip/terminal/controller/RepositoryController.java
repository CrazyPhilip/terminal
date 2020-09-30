package com.crazyphilip.terminal.controller;

import com.crazyphilip.terminal.Service.RepositoryService;
import com.crazyphilip.terminal.entity.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/Repositories/{lang}")
    public ResponseEntity<?> getRepositories(@PathVariable String lang) {
        System.out.println(lang);

        List<Repository> list = repositoryService.selectRepositories(lang);

        return ResponseEntity.ok(list);
    }
}
