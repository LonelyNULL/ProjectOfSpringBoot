package com.sword.demo.common;

import java.util.List;

/**
 * 基础转换类
 * @author sword
 * @date 2020-07-07 11:13:57
 */
public interface BaseConvert<Origin, Target> {

  /**
   * 源对象转目标对象
   *
   * @param origin 源对象
   * @return Target 目标对象
   * @author sword
   * @date 2020-07-07 11:13:57
   */
  Target convertTo(Origin origin);

  /**
   * 目标对象转回源对象
   *
   * @param target 目标对象
   * @return Origin 源对象
   * @author sword
   * @date 2020-07-07 11:13:57
   */
  Origin convertFrom(Target target);

  /**
   * 源对象列表转目标对象列表
   *
   * @param originList 源对象列表
   * @return List<Target> 目标对象列表
   * @author sword
   * @date 2020-07-07 11:13:57
   */
  List<Target> convertToList(List<Origin> originList);

  /**
   * 目标对象列表转回源对象列表
   *
   * @param targetList 目标对象列表
   * @return List<Origin> 源对象列表
   * @author sword
   * @date 2020-07-07 11:13:57
   */
  List<Origin> convertFromList(List<Target> targetList);


}
