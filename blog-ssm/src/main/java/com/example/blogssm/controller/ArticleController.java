package com.example.blogssm.controller;

import com.example.blogssm.common.AjaxResult;
import com.example.blogssm.common.UserSessionUtils;
import com.example.blogssm.entity.ArticleInfo;
import com.example.blogssm.entity.UserInfo;
import com.example.blogssm.service.ArticleService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/05/15  12:22
 */
@RestController
@RequestMapping("/art")
public class ArticleController {
@Autowired
    private ArticleService articleService;

@RequestMapping("/mylist")
    public AjaxResult getMyList(HttpServletRequest request){
    UserInfo userInfo= UserSessionUtils.getSessUser(request);
if(userInfo==null){
    return AjaxResult.fail(-1,"非法请求");
}
List<ArticleInfo> list =articleService.getMylist(userInfo.getId());
return AjaxResult.success(list);
}
@RequestMapping("/del")
    public AjaxResult del(HttpServletRequest request,Integer id){
    if(id==null || id <= 0){
        return AjaxResult.fail(-1,"参数异常！");
    }

    UserInfo user =UserSessionUtils.getSessUser(request);
    if(user==null){
        return AjaxResult.fail(-2,"用户未登录");
    }
    System.out.println("成功了");
    return AjaxResult.success(articleService.del(id, user.getId()));
}
@RequestMapping("/detail")
    public AjaxResult getDetail(Integer id){
    if(id==null || id<=0){
        return AjaxResult.fail(-1,"非法参数");
    }
    return AjaxResult.success(articleService.getDetail(id));
}
@RequestMapping("/incr-rcount")
public AjaxResult incrRcount(Integer id)
{
if(id!=null && id>0){
    return AjaxResult.success(articleService.incrrcount(id));
}
    return AjaxResult.fail(-1,"未知错误!");
}
    @RequestMapping("/add")
    public AjaxResult add(HttpServletRequest request, ArticleInfo articleinfo) {
        // 1.非空效验
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent())) {
            // 非法参数
            return AjaxResult.fail(-1, "非法参数");
        }
        // 2.数据库添加操作
        // a.得到当前登录用户的 uid
        UserInfo userinfo = UserSessionUtils.getSessUser(request);
        if (userinfo == null || userinfo.getId() <= 0) {
            // 无效的登录用户
            return AjaxResult.fail(-2, "无效的登录用户");
        }
        articleinfo.setUid(userinfo.getId());
        // b.添加数据库并返回结果
        return AjaxResult.success(articleService.add(articleinfo));
    }
    @RequestMapping("/update")
    public AjaxResult update(HttpServletRequest request, ArticleInfo articleinfo) {
        // 非空效验
        if (articleinfo == null || !StringUtils.hasLength(articleinfo.getTitle()) ||
                !StringUtils.hasLength(articleinfo.getContent()) ||
                articleinfo.getId() == null) {
            // 非法参数
            return AjaxResult.fail(-1, "非法参数");
        }
        // 得到当前登录用户的 id
        UserInfo userinfo = UserSessionUtils.getSessUser(request);
        if (userinfo == null && userinfo.getId() == null) {
            // 无效用户
            return AjaxResult.fail(-2, "无效用户");
        }
        // 很核心的代码（解决了修改文章归属人判定的问题）
        articleinfo.setUid(userinfo.getId());
        articleinfo.setUpdatetime(LocalDateTime.now());
        return AjaxResult.success(articleService.update(articleinfo));
    }
    /**
    * @explain
    * @param pindex 当前页码，从1开始
    * @param psize 每页显示条数
    * @return com.example.blogssm.common.AjaxResult
    * @author DUT-SUN
    * @date   2023/5/29
    */
    @RequestMapping("listbypage")
    public AjaxResult getListByPage(Integer pindex, Integer psize){
//        1.参数矫正
        if(pindex==null || pindex<=1){
            pindex=1;
        }
        if(psize==null || psize<=1){
            psize=2;
        }
        int offset=(pindex-1)*psize;
        List<ArticleInfo>list=articleService.getListByPage(psize,offset);
    return AjaxResult.success(list);
    };

}
