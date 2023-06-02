package com.example.blogssm.controller;

import com.example.blogssm.common.AjaxResult;
import com.example.blogssm.common.AppVarible;
import com.example.blogssm.common.PasswordUtils;
import com.example.blogssm.common.UserSessionUtils;
import com.example.blogssm.entity.UserInfo;
import com.example.blogssm.entity.vo.UserinfoVO;
import com.example.blogssm.service.ArticleService;
import com.example.blogssm.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/13  18:58
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/reg")
    public AjaxResult reg(UserInfo userInfo){
        //非空校验
        if(userInfo==null||!StringUtils.hasLength(userInfo.getUsername())||!StringUtils.hasLength(userInfo.getPassword())){
            return AjaxResult.fail(-1,"非法参数");
        }else{
            userInfo.setPassword(PasswordUtils.encrypt(userInfo.getPassword()));
            return AjaxResult.success(userService.reg(userInfo));
        }
    }
@RequestMapping("/login")
    public  AjaxResult login(HttpServletRequest request,UserInfo userInfo) {
    //非空校验
    if (!StringUtils.hasLength(userInfo.getUsername()) || !StringUtils.hasLength(userInfo.getPassword())) {
        return AjaxResult.fail(-1, "非法请求");
    }

    //查询数据库
    UserInfo user = userService.getUserByName(userInfo.getUsername());
    if (user != null && user.getId() > 0) {
        System.out.println(userInfo.getPassword());
        System.out.println(user.getPassword());

        if (PasswordUtils.check(userInfo.getPassword(), user.getPassword())) {

            user.setPassword("");
            //将用户session存储
            HttpSession session = request.getSession();
            session.setAttribute(AppVarible.USER_SESSION_KEY, user);
            return AjaxResult.success(user);
        }
    }
    return AjaxResult.success(0, null);
}
@RequestMapping("/showInfo")
    public AjaxResult showInfo(HttpServletRequest request){
    UserinfoVO userinfoVO=new UserinfoVO();
//1.得到当前用户（从session中获取）
 UserInfo userInfo= UserSessionUtils.getSessUser(request);
 if(userInfo==null){
     return AjaxResult.fail(-1,"非法请求");
 }
 //spring提供的深克隆方法
    BeanUtils.copyProperties(userInfo,userinfoVO);
    //2.得到用户发表文章的总数
    userinfoVO.setArticleCount(articleService.getArtCountByUid(userInfo.getId()));
    return AjaxResult.success(userinfoVO);
}
@RequestMapping("/logout")
    public AjaxResult logout(HttpSession session){
        session.removeAttribute(AppVarible.USER_SESSION_KEY);
        return AjaxResult.success(1);
}
@RequestMapping("/getuserbyid")
    public AjaxResult getUserById(Integer id){
        if(id==null ||id<=0){
            return AjaxResult.fail(-1,"无效id");
        }
        UserInfo userinfo=userService.getUserById(id);
        if(userinfo==null || userinfo.getId()<=0){
            return AjaxResult.fail(-1,"非法参数");
        }
        userinfo.setPassword("");
        UserinfoVO userinfoVO=new UserinfoVO();
        BeanUtils.copyProperties(userinfo,userinfoVO);
        userinfoVO.setArticleCount(articleService.getArtCountByUid(id));
        return AjaxResult.success(userinfoVO);
}

}
