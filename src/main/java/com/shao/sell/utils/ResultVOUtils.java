package com.shao.sell.utils;

import com.shao.sell.VO.ResultVO;
import com.sun.glass.ui.EventLoop;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
