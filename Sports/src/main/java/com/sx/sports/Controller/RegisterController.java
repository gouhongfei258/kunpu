package com.sx.sports.Controller;


import com.sx.sports.entity.Result;
import com.sx.sports.entity.Role;
import com.sx.sports.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class  RegisterController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/role-register")
    public Result register(@RequestBody Role role){

        int updateRows = roleService.insertRole(role);

        if(updateRows>0)
            return Result.ok("注册成功");
        else

        return Result.err(Result.CODE_ERR_REGISTER,"注册失败");

    }


}
