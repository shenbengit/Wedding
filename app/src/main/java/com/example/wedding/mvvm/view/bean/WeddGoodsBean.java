package com.example.wedding.mvvm.view.bean;

public class WeddGoodsBean {

    /**
     * id : 30608
     * target_type : 0
     * target_url : null
     * target_id : 0
     * image_path : https://qnm.hunliji.com/o_1d74m4c0e1sf1gjla7onbg1j389.png
     * title : 新娘礼服
     * watch_count : 0
     * extention : null
     * sub_title :
     * is_highlight : 0
     * route : ://hlj/product_lib/category_channel_activity?id=1
     * is_valid : 1
     */

    private String id;
    private String target_type;
    private Object target_url;
    private String target_id;
    private String image_path;
    private String title;
    private String watch_count;
    private Object extention;
    private String sub_title;
    private String is_highlight;
    private String route;
    private int is_valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public Object getTarget_url() {
        return target_url;
    }

    public void setTarget_url(Object target_url) {
        this.target_url = target_url;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWatch_count() {
        return watch_count;
    }

    public void setWatch_count(String watch_count) {
        this.watch_count = watch_count;
    }

    public Object getExtention() {
        return extention;
    }

    public void setExtention(Object extention) {
        this.extention = extention;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getIs_highlight() {
        return is_highlight;
    }

    public void setIs_highlight(String is_highlight) {
        this.is_highlight = is_highlight;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    @Override
    public String toString() {
        return "WeddGoodsBean{" +
                "id='" + id + '\'' +
                ", target_type='" + target_type + '\'' +
                ", target_url=" + target_url +
                ", target_id='" + target_id + '\'' +
                ", image_path='" + image_path + '\'' +
                ", title='" + title + '\'' +
                ", watch_count='" + watch_count + '\'' +
                ", extention=" + extention +
                ", sub_title='" + sub_title + '\'' +
                ", is_highlight='" + is_highlight + '\'' +
                ", route='" + route + '\'' +
                ", is_valid=" + is_valid +
                '}';
    }
}
