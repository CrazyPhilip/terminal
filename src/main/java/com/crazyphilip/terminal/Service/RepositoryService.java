package com.crazyphilip.terminal.Service;

import com.crazyphilip.terminal.entity.Repository;
import com.crazyphilip.terminal.mapper.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepositoryService {

    @Autowired
    private RepositoryMapper repositoryMapper;

    public List<Repository> selectAllRepositories(){
        return repositoryMapper.selectAllRepositories();
    }

    public List<Repository> selectRepositories(String lang){
        return repositoryMapper.selectRepositories(lang);
    }

    public List<Repository> selectRepoById(Integer id){
        return repositoryMapper.selectRepoById(id);
    }

    public int insertRepository(Repository repository){
        return repositoryMapper.insertRepository(repository);
    }

    public int countRepository(){
        return repositoryMapper.countRepository();
    }
}
