package com.example.day09lianxicejiu.api;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 小乐乐 on 2019/6/10.
 */
@Entity
public class SjBean {
    @Id(autoincrement = true)
    private Long id;
    private String envelopePic;
    private String title;
    @Generated(hash = 1675414262)
    public SjBean(Long id, String envelopePic, String title) {
        this.id = id;
        this.envelopePic = envelopePic;
        this.title = title;
    }
    @Generated(hash = 1815906733)
    public SjBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEnvelopePic() {
        return this.envelopePic;
    }
    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


}
