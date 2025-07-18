package com.shemuel.landlordhelper.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import java.time.LocalDateTime;
import java.io.Serializable;

@Data
@TableName("users")
@Tag(name = "对象")
public class Users implements Serializable {

    @TableId(type = IdType.AUTO)
    @Schema(description = "")
    private Long id;

    @Schema(description = "微信openid")
    private String openid;

    @Schema(description = "")
    private String nickname;

    @Schema(description = "")
    private String avatarUrl;

    @Schema(description = "")
    private LocalDateTime createdAt;

    @Schema(description = "")
    private LocalDateTime updatedAt;
}
