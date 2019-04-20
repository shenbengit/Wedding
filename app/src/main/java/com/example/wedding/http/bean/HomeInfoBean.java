package com.example.wedding.http.bean;

import java.util.List;

/**
 * @author
 * @date 2019/4/6 16:34
 * @email 714081644@qq.com
 */
public class HomeInfoBean {

    private StatusBean status;
    private DataBeanXX data;
    private int current_time;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBeanXX getData() {
        return data;
    }

    public void setData(DataBeanXX data) {
        this.data = data;
    }

    public int getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(int current_time) {
        this.current_time = current_time;
    }

    public static class StatusBean {
        /**
         * RetCode : 0
         * msg : success
         */

        private int RetCode;
        private String msg;

        public int getRetCode() {
            return RetCode;
        }

        public void setRetCode(int RetCode) {
            this.RetCode = RetCode;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class DataBeanXX {

        private TabListBean tab_list;
        private List<ListBeanXX> list;

        public TabListBean getTab_list() {
            return tab_list;
        }

        public void setTab_list(TabListBean tab_list) {
            this.tab_list = tab_list;
        }

        public List<ListBeanXX> getList() {
            return list;
        }

        public void setList(List<ListBeanXX> list) {
            this.list = list;
        }

        public static class TabListBean {

            private String dynamic_style;
            private boolean dynamic_flag;
            private List<ListBean> list;

            public String getDynamic_style() {
                return dynamic_style;
            }

            public void setDynamic_style(String dynamic_style) {
                this.dynamic_style = dynamic_style;
            }

            public boolean isDynamic_flag() {
                return dynamic_flag;
            }

            public void setDynamic_flag(boolean dynamic_flag) {
                this.dynamic_flag = dynamic_flag;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {

                private DataBean data;
                private String dynamic_action;
                private DynamicTrackBean dynamic_track;

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                public String getDynamic_action() {
                    return dynamic_action;
                }

                public void setDynamic_action(String dynamic_action) {
                    this.dynamic_action = dynamic_action;
                }

                public DynamicTrackBean getDynamic_track() {
                    return dynamic_track;
                }

                public void setDynamic_track(DynamicTrackBean dynamic_track) {
                    this.dynamic_track = dynamic_track;
                }

                public static class DataBean {
                    /**
                     * name : 精选
                     */

                    private String name;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class DynamicTrackBean {
                    /**
                     * track_enable_view : 1
                     * track_tag : 精选
                     */

                    private int track_enable_view;
                    private String track_tag;

                    public int getTrack_enable_view() {
                        return track_enable_view;
                    }

                    public void setTrack_enable_view(int track_enable_view) {
                        this.track_enable_view = track_enable_view;
                    }

                    public String getTrack_tag() {
                        return track_tag;
                    }

                    public void setTrack_tag(String track_tag) {
                        this.track_tag = track_tag;
                    }
                }
            }
        }

        public static class ListBeanXX {

            private DataBeanX data;
            private String dynamic_style;
            private String dynamic_action;
            private String dynamic_section_name;

            public DataBeanX getData() {
                return data;
            }

            public void setData(DataBeanX data) {
                this.data = data;
            }

            public String getDynamic_style() {
                return dynamic_style;
            }

            public void setDynamic_style(String dynamic_style) {
                this.dynamic_style = dynamic_style;
            }

            public String getDynamic_action() {
                return dynamic_action;
            }

            public void setDynamic_action(String dynamic_action) {
                this.dynamic_action = dynamic_action;
            }

            public String getDynamic_section_name() {
                return dynamic_section_name;
            }

            public void setDynamic_section_name(String dynamic_section_name) {
                this.dynamic_section_name = dynamic_section_name;
            }

            public static class DataBeanX {
                private List<ListBeanX> list;

                public List<ListBeanX> getList() {
                    return list;
                }

                public void setList(List<ListBeanX> list) {
                    this.list = list;
                }

                public static class ListBeanX {

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

                    public String getTarget_url() {
                        return target_url;
                    }

                    public void setTarget_url(String target_url) {
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

                    public String getExtention() {
                        return extention;
                    }

                    public void setExtention(String extention) {
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

                    public int getIs_valid() {
                        return is_valid;
                    }

                    public void setIs_valid(int is_valid) {
                        this.is_valid = is_valid;
                    }

                    public String getRoute() {
                        return route;
                    }

                    public void setRoute(String route) {
                        this.route = route;
                    }
                }
            }
        }
    }
}
