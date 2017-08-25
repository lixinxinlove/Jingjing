package com.love.jingjing;

/**
 * 本地选择结果
 * Created by yanghongtao on 2017/8/23.
 */

public class LocalOptionsResEntity {

    //key
    private String option_flag;
    //1：单选。2：多选
    private int option_type;
    //值（用逗号隔开）
    private String options;

    public String getOption_flag() {
        return option_flag;
    }

    public void setOption_flag(String option_flag) {
        this.option_flag = option_flag;
    }

    public int getOption_type() {
        return option_type;
    }

    public void setOption_type(int option_type) {
        this.option_type = option_type;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
