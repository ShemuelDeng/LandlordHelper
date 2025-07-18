package com.shemuel.landlordhelper.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.shemuel.landlordhelper.entity.Users;
import com.shemuel.landlordhelper.service.UsersService;
import com.shemuel.landlordhelper.common.RestResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;

/**
 *  控制器
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "管理")
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/list")
    @Operation(summary = "获取列表")
    public RestResult<IPage<Users>> list(Users users) {
        return RestResult.success(usersService.selectPage(users));
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取详情")
    public RestResult<Users> getInfo(@PathVariable("id") Long id) {
        return RestResult.success(usersService.getById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "添加")
    public RestResult<Object> add(@RequestBody Users users) {
        return RestResult.success(usersService.insert(users));
    }

    @PutMapping("/update")
    @Operation(summary = "修改")
    public RestResult<Object> edit(@RequestBody Users users) {
        return RestResult.success(usersService.update(users));
    }

    @DeleteMapping("/delete/{ids}")
    @Operation(summary = "删除")
    public RestResult<Object> remove(@PathVariable List<Long> ids) {
        return RestResult.success(usersService.deleteByIds(ids));
    }
}
