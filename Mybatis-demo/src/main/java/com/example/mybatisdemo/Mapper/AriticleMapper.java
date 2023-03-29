package com.example.mybatisdemo.Mapper;
import com.example.mybatisdemo.VO.AriticleInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 * <p>
 * 成略在胸，良计速出
 *
 * @author SUN
 * @date 2023/03/28  9:51
 */
@Mapper
public interface AriticleMapper  {
AriticleInfoVO getByID(@Param("id")Integer id);

}
