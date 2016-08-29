package com.ex2.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
interface UserMapper {
    
    UserDTO[] findAll();
    
 
}


