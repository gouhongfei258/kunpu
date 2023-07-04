package com.sx.sports.Controller;


import com.sx.sports.entity.Role;
import com.sx.sports.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class  RegisterController {
    @Autowired
    private RoleService roleService;
    public String register(@RequestBody Role role){
        String username = role.getUserName();
        if(roleService.findRoleByCode(username) != null)
            return "注册失败！用户名已存在！" ;
        else
            roleService.insertRole(role);

        return "注册成功！请回到登录界面!" ;

    }


}
