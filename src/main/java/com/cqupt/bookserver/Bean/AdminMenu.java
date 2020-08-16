package com.cqupt.bookserver.Bean;

import java.util.List;

/**
 * @ClassName: AdminMenu
 * @Description: 管理员菜单
 * @Author: wsz
 * @Date: 2020/3/27 22:19
 * @Version 1.0
 **/
public class AdminMenu {

    private int id;

    private String path;

    private String name;

    private String nameZh;

    private String iconCls;

    private List< AdminMenu> children;

    private String component;

    private int parentid;

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getComponent() {
        return component;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public List<AdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }

}
