package com.example.wedding.http.bean;

import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * @author

 */
public class AddressAreaBean extends BmobObject {

    /**
     * id : 110000
     * parent_id : 0
     * area_name : 北京
     * level : 1
     * cid : 0
     * children : [{"id":"110100","parent_id":"110000","area_name":"北京市","level":"2","cid":"1","children":[{"id":"110101","parent_id":"110100","area_name":"东城区","level":"3","cid":"0"},{"id":"110102","parent_id":"110100","area_name":"西城区","level":"3","cid":"0"},{"id":"110105","parent_id":"110100","area_name":"朝阳区","level":"3","cid":"0"},{"id":"110106","parent_id":"110100","area_name":"丰台区","level":"3","cid":"0"},{"id":"110107","parent_id":"110100","area_name":"石景山区","level":"3","cid":"0"},{"id":"110108","parent_id":"110100","area_name":"海淀区","level":"3","cid":"0"},{"id":"110109","parent_id":"110100","area_name":"门头沟区","level":"3","cid":"0"},{"id":"110111","parent_id":"110100","area_name":"房山区","level":"3","cid":"0"},{"id":"110112","parent_id":"110100","area_name":"通州区","level":"3","cid":"0"},{"id":"110113","parent_id":"110100","area_name":"顺义区","level":"3","cid":"0"},{"id":"110114","parent_id":"110100","area_name":"昌平区","level":"3","cid":"0"},{"id":"110115","parent_id":"110100","area_name":"大兴区","level":"3","cid":"0"},{"id":"110116","parent_id":"110100","area_name":"怀柔区","level":"3","cid":"0"},{"id":"110117","parent_id":"110100","area_name":"平谷区","level":"3","cid":"0"},{"id":"110228","parent_id":"110100","area_name":"密云县","level":"3","cid":"0"},{"id":"110229","parent_id":"110100","area_name":"延庆县","level":"3","cid":"0"}]}]
     */

    private String id;
    private String parent_id;
    private String area_name;
    private String level;
    private String cid;
    private List<ChildrenBeanX> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<ChildrenBeanX> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBeanX> children) {
        this.children = children;
    }

    public static class ChildrenBeanX {
        /**
         * id : 110100
         * parent_id : 110000
         * area_name : 北京市
         * level : 2
         * cid : 1
         * children : [{"id":"110101","parent_id":"110100","area_name":"东城区","level":"3","cid":"0"},{"id":"110102","parent_id":"110100","area_name":"西城区","level":"3","cid":"0"},{"id":"110105","parent_id":"110100","area_name":"朝阳区","level":"3","cid":"0"},{"id":"110106","parent_id":"110100","area_name":"丰台区","level":"3","cid":"0"},{"id":"110107","parent_id":"110100","area_name":"石景山区","level":"3","cid":"0"},{"id":"110108","parent_id":"110100","area_name":"海淀区","level":"3","cid":"0"},{"id":"110109","parent_id":"110100","area_name":"门头沟区","level":"3","cid":"0"},{"id":"110111","parent_id":"110100","area_name":"房山区","level":"3","cid":"0"},{"id":"110112","parent_id":"110100","area_name":"通州区","level":"3","cid":"0"},{"id":"110113","parent_id":"110100","area_name":"顺义区","level":"3","cid":"0"},{"id":"110114","parent_id":"110100","area_name":"昌平区","level":"3","cid":"0"},{"id":"110115","parent_id":"110100","area_name":"大兴区","level":"3","cid":"0"},{"id":"110116","parent_id":"110100","area_name":"怀柔区","level":"3","cid":"0"},{"id":"110117","parent_id":"110100","area_name":"平谷区","level":"3","cid":"0"},{"id":"110228","parent_id":"110100","area_name":"密云县","level":"3","cid":"0"},{"id":"110229","parent_id":"110100","area_name":"延庆县","level":"3","cid":"0"}]
         */

        private String id;
        private String parent_id;
        private String area_name;
        private String level;
        private String cid;
        private List<ChildrenBean> children;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * id : 110101
             * parent_id : 110100
             * area_name : 东城区
             * level : 3
             * cid : 0
             */

            private String id;
            private String parent_id;
            private String area_name;
            private String level;
            private String cid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }
        }
    }
}
