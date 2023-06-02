package com.example.blogssm.mapper;

import com.example.blogssm.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/04/21  18:23
 */
@Mapper
public interface ArticleMapper {
    int getArtCountByUid(@Param("uid") Integer uid);
    List<ArticleInfo> getMylist(@Param("uid") Integer uid);
    int del(@Param("id")Integer id,@Param(("uid"))Integer uid);

    ArticleInfo getDetail(@Param("id")Integer id);

    int incrrcount(@Param("id")Integer id);
    int add(ArticleInfo articleInfo);
    int update(ArticleInfo articleinfo);
    List<ArticleInfo>getListByPage(@Param("psize")Integer psize,@Param("offsize") Integer offsize);

}
