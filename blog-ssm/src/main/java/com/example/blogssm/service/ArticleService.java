package com.example.blogssm.service;

import com.example.blogssm.entity.ArticleInfo;
import com.example.blogssm.mapper.ArticleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/21  18:30
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    public int getArtCountByUid(Integer uid){
        return articleMapper.getArtCountByUid(uid);
    }
    public List<ArticleInfo> getMylist(Integer uid){
        return articleMapper.getMylist(uid);
    }
    public int del(Integer id,Integer uid){
        return articleMapper.del(id,uid);
    }
    public ArticleInfo getDetail(Integer id){
        return articleMapper.getDetail(id);
    }
    public int incrrcount(Integer id){return articleMapper.incrrcount(id);}

    public  int add(ArticleInfo articleInfo){return articleMapper.add(articleInfo);}
    public int update(ArticleInfo articleinfo) {
        return articleMapper.update(articleinfo);
    }
    public List<ArticleInfo>getListByPage(Integer psize, Integer offsize){return articleMapper.getListByPage(psize,offsize);}

}
