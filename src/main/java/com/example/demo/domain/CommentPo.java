package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
/**
 * @author
 */
public class CommentPo {
    private Integer id;
    /**
     * 发表评论的用户的id
     */
    private Integer userId;
    /**
     * 发表评论的内容
     */
    private String content;
    /**
     * 评论的状态 0：未审核 1：审核通过 2：审核失败
     */
    private Integer statusCode;

    /**
     * 发表评论的星级
     */
    private Integer star;
    /**
     * 评论的产品的id
     */
    private Integer productId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
    private Boolean beDeleted;


}