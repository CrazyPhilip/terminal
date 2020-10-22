package com.crazyphilip.terminal.controller;

import com.crazyphilip.terminal.Service.RepositoryService;
import com.crazyphilip.terminal.entity.Repository;
import com.crazyphilip.terminal.util.ReturnCode;
import com.crazyphilip.terminal.util.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/Repositories/{lang}")
    public ReturnVO getRepositories(@PathVariable String lang) {
        System.out.println(lang);

        List<Repository> list = "All".equals(lang) ? repositoryService.selectAllRepositories() : repositoryService.selectRepositories(lang);

        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, Integer.toString(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @RequestMapping("/Repository/{id}")
    public ReturnVO getRepoById(@PathVariable Integer id){
        List<Repository> list = repositoryService.selectRepoById(id);

        if (list.size() > 0){
            return new ReturnVO(ReturnCode.SUCCESS, String.valueOf(list.size()), list);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }

    @PostMapping(path = "/AddRepository")
    public ReturnVO insertRepository(@RequestBody Repository repository){
        int count = repositoryService.insertRepository(repository);

        if(count > 0){
            return new ReturnVO();
        }
        else {
            return new ReturnVO(ReturnCode.FAIL);
        }
    }
}
