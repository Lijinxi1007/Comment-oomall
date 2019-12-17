package com.example.demo.controller;


import com.example.demo.feign.GoodsServiceApi;
import com.example.demo.feign.UserServiceApi;
import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentPo;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import com.example.demo.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/commentService")
/**
 * @author
 */
public class CommentController {

    @Autowired
    private CommentService commentService;
    private List<Comment> commentLists;
    private Comment comment;
    @Resource
    private CommentMapper commentMapper;

    @Autowired
    GoodsServiceApi goodsServiceApi;
    @Autowired
    UserServiceApi userServiceApi;

    /**
     * 根据货品id删除评论
     */
    @DeleteMapping("/products/{id}/comments")
    public void  deletecommentbyproduct(@PathVariable(value= "id") Integer id) {
        commentService.deletecommentbyproduct(id);
    }
    @DeleteMapping("/comments/{id}")
    /**
     * 删除一条评论,pass!!!!!!
     */
    public Object delete(@PathVariable(value = "id") Integer id) {
        Object retObj;
       if(commentService.delete(id)==1) {
           retObj =ResponseUtil.ok();
       } else {
           retObj=ResponseUtil.notexist();
       }
        return retObj;
    }

    @GetMapping("/product/{id}/comments")
    /**
     * 用户根据货品id获取该商品所有评论信息
     * @param page   分页页数
     * @param limit   分页大小
     */
    public Object goodslist(@PathVariable(value="id") Integer id, @RequestParam(defaultValue = "1")  Integer page, @RequestParam (defaultValue = "10")  Integer limit){

        PageHelper.startPage(page,limit);
        List<Comment> commentList=commentService.goodscommentlist(id);
        PageInfo<Comment> commentPageInfo=new PageInfo<>(commentList);
        List<Comment> pagelist=commentPageInfo.getList();

        commentLists=new ArrayList<>();
        for(int i=0;i<pagelist.size();i++)
        {
            comment=pagelist.get(i);
           // comment.setUser( userServiceApi.getUserById(comment.getUserId()));
            comment.setProductPo(goodsServiceApi.getProductById(comment.getProductId()));
            commentLists.add(comment);
        }
        Object retObj = ResponseUtil.ok(commentLists);
        return retObj;
    }


    @GetMapping("/admin/comments")
    //管理员调用所有商品评论
    /**

     * @param page   分页页数
     * @param limit   分页大小
     */
    public Object adminlist(@RequestParam Integer userid, @RequestParam Integer productid, @RequestParam(defaultValue = "1")  Integer page, @RequestParam(defaultValue = "10")  Integer limit) {

        PageHelper.startPage(page,limit);
        List<Comment> commentList=commentService.adminlist(userid,productid);
        PageInfo<Comment> commentPageInfo1=new PageInfo<>(commentList);
        List<Comment> pagelist=commentPageInfo1.getList();
        commentLists=new ArrayList<>();
        for(int i=0;i<pagelist.size();i++)
        {
            comment=pagelist.get(i);
           // comment.setUser( userServiceApi.getUserById(comment.getUserId()));
            comment.setProductPo(goodsServiceApi.getProductById(comment.getProductId()));
            commentLists.add(comment);
        }
        Object retObj = ResponseUtil.ok(commentLists);
        return retObj;
    }


    @PostMapping("/product/{id}/comments")
    /**
     * 创建货品id的评论,通过！！！！！
     *   {
     *         "userId": 1,
     *         "content": "通过了",
     *         "statusCode": 2,
     *         "star": 4,
     *         "productId":518
     * }
     */
    public  Object createcomment(@PathVariable Integer id, @RequestBody CommentPo commentPo) {
        Object retObj;
        if(commentMapper.createcomment(commentPo)==1) {
            retObj=ResponseUtil.ok(commentMapper.goodscomment(commentPo.getId()));
        } else {
            retObj=ResponseUtil.badArgumentValue();
        }
        return retObj;
    }

    @PutMapping("/admin/comments/{id}")
    /**
     * 审核评论
     *   {
     *         "userId": 1,
     *         "content": "通过了",
     *         "statusCode": 2,
     *         "star": 4,
     *         "productId":518
     * }
     */

    public Object update(@PathVariable Integer id, @RequestBody  CommentPo commentPo) {
       Object retObj ;
       commentPo.setId(id);
        if(commentMapper.update(commentPo)==1) {
          retObj= ResponseUtil.ok(commentService.update(commentPo));
        }
        else {
            retObj=ResponseUtil.badArgumentValue();
        }
        return retObj;
    }
}
