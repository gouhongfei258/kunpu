package com.sx.sports.Controller;
import com.sx.sports.entity.Result;
import com.sx.sports.entity.Role;
import com.sx.sports.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    /**
     * 查询所有角色
     */
    @GetMapping("/role-list")
    public Result roleList() {
        return Result.ok(roleService.findRoleList());
    }
    @GetMapping("/role-findByCode")
    public Result findRoleByCode(String userName) {
        roleService.findRoleByCode(userName);
        return Result.ok(roleService.findRoleList());
    }
    /**
     * 添加角色
     */
    @PostMapping("/role-add")
    public Result addRole(@RequestBody Role role) {
// 检查该角色是否已经存在
        Role roleTable = roleService.findRoleByCode(role.getUserName());
        if(roleTable!=null) return Result.err(Result.CODE_ERR_REGISTER, "该角色已存在");
// 获取当前登录用户id
        int createBy = 1;
// 将创建人id设置到role对象中
        role.setGrade(createBy);
        role.setGrade(5);
// 添加角色
        int updateRows = roleService.insertRole(role);
        if(updateRows>0) {
            return Result.ok("添加成功！");
        }else{
            return Result.err(Result.CODE_ERR_SYS, "添加失败！");
        }
    }
    /**
     * 修改角色信息
     */
    @PutMapping("/role-update")
    public Result updateRole(@RequestBody Role role) {
// 获取当前登录用户id

        int updateBy = 1;
// 将创建人id设置到role对象中
        role.setGrade(updateBy);
        int updateRows = roleService.updateRole(role);
        if(updateRows>0) {
            return Result.ok("修改成功！");
        }else{
            return Result.err(Result.CODE_ERR_SYS, "修改失败！");
        }
    }
    /**
     * 删除角色
     */
    @DeleteMapping("/role-delete/{roleId}")
    public Result deleteRole(@PathVariable int roleId) {
        roleService.deleteRole(roleId);
        return Result.ok("角色删除成功！");
    }
}