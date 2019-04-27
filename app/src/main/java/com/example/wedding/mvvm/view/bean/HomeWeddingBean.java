package com.example.wedding.mvvm.view.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.wedding.BR;

/**
 * @author
 */
public class HomeWeddingBean extends BaseObservable {
    private String id;
    private String target_type;
    private String target_url;
    private String target_id;
    private String image_path;
    private String title;
    private String watch_count;
    private String extention;
    private String sub_title;
    private String is_highlight;
    private int is_valid;
    private String route;

    public HomeWeddingBean() {

    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
        notifyPropertyChanged(BR.target_type);
    }

    @Bindable
    public String getTarget_url() {
        return target_url;
    }

    public void setTarget_url(String target_url) {
        this.target_url = target_url;
        notifyPropertyChanged(BR.target_url);
    }

    @Bindable
    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
        notifyPropertyChanged(BR.target_id);
    }

    @Bindable
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
        notifyPropertyChanged(BR.image_path);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getWatch_count() {
        return watch_count;
    }

    public void setWatch_count(String watch_count) {
        this.watch_count = watch_count;
        notifyPropertyChanged(BR.watch_count);
    }

    @Bindable
    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
        notifyPropertyChanged(BR.extention);
    }

    @Bindable
    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
        notifyPropertyChanged(BR.sub_title);
    }

    @Bindable
    public String getIs_highlight() {
        return is_highlight;
    }

    public void setIs_highlight(String is_highlight) {
        this.is_highlight = is_highlight;
        notifyPropertyChanged(BR.is_highlight);
    }

    @Bindable
    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
        notifyPropertyChanged(BR.is_valid);
    }

    @Bindable
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
        notifyPropertyChanged(BR.route);
    }
}
