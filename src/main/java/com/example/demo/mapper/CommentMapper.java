package com.example.demo.mapper;

import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentPo;
import com.example.demo.domain.ProductPo;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
/**
 * @author
 */
public interface CommentMapper {
    /**
     * 根据评论id删除评论
     * @param id
     * @return
     */
 int delete(Integer id);
    /**
     * 根据货品id删除评论
     * @param id
     * @return
     */

    int deletecommentbyproduct(Integer id);

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
 List<Comment> adminlist( Integer userid, Integer productid);

    /**
     * 创建评论
     * @param commentPo
     * @return
     */
    int createcomment(CommentPo commentPo);

    /**
     * 获得商品信息
     * @param id
     * @return
     */
    CommentPo goodscomment(Integer id);

    /**
     * 更新商品信息
     * @param commentPo
     * @return
     */
    int update(CommentPo commentPo);
}
