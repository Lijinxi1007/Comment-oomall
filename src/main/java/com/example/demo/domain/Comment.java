package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
/**
 * @author
 */
public class Comment extends CommentPo{

    /**
     * 评论信息
     */
    /**
     * @author
     */
    private User user;
    /**
     * @author
     */
    private ProductPo productPo;
}
