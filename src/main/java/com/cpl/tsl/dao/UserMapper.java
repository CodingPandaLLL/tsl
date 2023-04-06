package com.cpl.tsl.dao;



import com.cpl.tsl.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lll
 * @description: UserMapper
 * @Date : 2022/10/10
 */
@Repository
public interface UserMapper { //
    /**
     * @author lll
     * @description 保存用户
     * @params [user]
     * @date 2022/10/10 17:14
     */
    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void addUser(User user);
    /**
     * @author lll
     * @description 保存用户
     * @params [user]
     * @date 2022/10/10 17:14
     */
    @Select("select * from employee")
    List<User> findUsers();
}