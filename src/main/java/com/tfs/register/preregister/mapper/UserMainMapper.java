package com.tfs.register.preregister.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfs.register.preregister.model.Company;
import com.tfs.register.preregister.model.UserMain;

@Repository
public interface UserMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMain record);

    int insertSelective(UserMain record);

    UserMain selectByPrimaryKey(Integer id);

    List<Company> selectPreregisters();

    int updateByPrimaryKeySelective(UserMain record);

    int updateByPrimaryKey(UserMain record);
}