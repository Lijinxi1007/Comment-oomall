package com.example.demo.service.impl;

import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentPo;
import com.example.demo.domain.ProductPo;
import com.example.demo.domain.User;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
/**
 * @author
 */
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public int delete(Integer id) {

        return commentMapper.delete(id);
    }

    @Override
    public int deletecommentbyproduct(Integer id) {

        return commentMapper.deletecommentbyproduct(id);
    }
    @Override
    public List<Comment> goodscommentlist(Integer id) {
        return commentMapper.goodscommentlist(id);
    }

    @Override
    public List<Comment> adminlist(Integer userid, Integer productid) {

        return commentMapper.adminlist(userid,productid);
    }

    @Override
    public CommentPo createcomment(CommentPo commentPo) {

        commentMapper.createcomment(commentPo);
        return commentMapper.goodscomment(commentPo.getId());
    }

    @Override
    public CommentPo update( CommentPo commentPo) {
        commentMapper.update(commentPo);
        return commentMapper.goodscomment(commentPo.getId());
    }
}
