package com.xiaobu.entity;

import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author xiaobu
 * @since 2017-07-11
 */
@Table(name = "sys_notice")
public class Notice extends Base {

    private static final long serialVersionUID = 1L;
    /**
     * 标题
     */
    private String  title;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 内容
     */
    private String  content;
    /**
     * 创建时间
     */
    private Date    createtime;
    /**
     * 创建人
     */
    private Integer creater;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title=" + title +
                ", type=" + type +
                ", content=" + content +
                ", createtime=" + createtime +
                ", creater=" + creater +
                "}";
    }
}
