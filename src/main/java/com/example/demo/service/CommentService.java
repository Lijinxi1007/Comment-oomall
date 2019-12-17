package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentPo;
import com.example.demo.domain.ProductPo;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * @author
 */
public interface CommentService {
    /**
     * 根据评论id删除评论
     * @param id
     * @return int
     */
    int delete(Integer id);//已完成

    /**
     * 根据货品id删除评论
     * @param id
     * @return int
     */
    int deletecommentbyproduct(Integer id);//已完成
    /**
     * 用户根据评论货品id获取所有评论
     * @param id
     * @return
     */
    List<Comment> goodscommentlist(Integer id);

    /**
     * 管理员获取评论
     * @param userid
     * @param productid
     * @return
     */
    List<Comment> adminlist(Integer userid, Integer productid);

    /**
     * 创建评论
     * @param commentPo
     * @return
     */
    CommentPo createcomment(CommentPo commentPo);
    /**
     * 更新商品信息
     * @param commentPo
     * @return
     */
    CommentPo update(CommentPo commentPo);
}
