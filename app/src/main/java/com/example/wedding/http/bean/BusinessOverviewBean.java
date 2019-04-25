package com.example.wedding.http.bean;

import java.util.List;

/**
 * 商家概况信息
 * 种类、地域、筛选条件等
 */
public class BusinessOverviewBean {

    /**
     * status : {"RetCode":0,"msg":"success"}
     * data : {"properties":[{"id":"6","name":"婚纱摄影","children":[{"id":1,"name":"影楼"},{"id":2,"name":"工作室"},{"id":3,"name":"独立摄影师"}],"icon":"https://qnm.hunliji.com/o_1d59fng9g1mdkktou9a182t4sd1h.png"},{"id":999,"name":"全球旅拍","children":null,"icon":"https://qnm.hunliji.com/o_1d59foespd9c177fqophvs1mac1r.png"},{"id":"2","name":"婚礼策划","children":[{"id":4,"name":"省心优选","desc":"非定制套餐类"},{"id":5,"name":"高端定制","desc":"个性化定制套餐"}],"icon":"https://qnm.hunliji.com/o_1d59fkb36q1d148g8hfump1cpj.png"},{"id":"12","name":"婚纱礼服","children":[{"id":6,"name":"女士婚纱"},{"id":7,"name":"男士礼服"}],"icon":"https://qnm.hunliji.com/o_1d59fn0s61cch1aum14m49k5lqt1c.png"},{"id":"13","name":"婚宴酒店","children":[{"id":2,"name":"婚礼会所"},{"id":3,"name":"特色餐厅"},{"id":4,"name":"花园洋房"},{"id":5,"name":"游轮婚礼"},{"id":9,"name":"奢华五星"},{"id":10,"name":"豪华四星"},{"id":12,"name":"四合院"}],"icon":"https://qnm.hunliji.com/o_1d59fnv8d1kpt1efpfh816kn1b3b1m.png"},{"id":"14","name":"婚戒首饰","children":null,"icon":"https://qnm.hunliji.com/o_1d59fjqut9mjch918l12tm1sa6e.png"},{"id":"7","name":"婚礼摄影","children":null,"icon":"https://qnm.hunliji.com/o_1d59flto464r1jj11lsr11bd1a8t12.png"},{"id":"8","name":"婚礼摄像","children":null,"icon":"https://qnm.hunliji.com/o_1d59flcrpqag1326dnobk2tmgt.png"},{"id":"9","name":"婚礼跟妆","children":null,"icon":"https://qnm.hunliji.com/o_1d59fktng1lgcs801ju1v918p8o.png"},{"id":"11","name":"婚礼司仪","children":null,"icon":"https://qnm.hunliji.com/o_1d59fmehgu4mqjc1j7n19kk1ce417.png"},{"id":"15","name":"花艺甜品","children":[{"id":12,"name":"花艺"},{"id":13,"name":"甜品"}],"icon":"https://qnm.hunliji.com/o_1d59fguci1rg15gm1g3a1532184u9.png"}],"city":[{"id":"320100","area_name":"南京市","parent_id":"320000","short_name":"南京","area_code":null,"short_py":"nj","pinyin":"nanjing","zip_code":null,"lng":"118.76741","lat":"32.041546","level":"2","position":"tr_0 tr_320000","cid":"63","sort":"4","is_capital":"1","kind":null}],"area":[{"id":"320102","area_name":"玄武区","parent_id":"320100","short_name":"玄武","area_code":null,"short_py":null,"pinyin":"xuanwu","zip_code":null,"lng":"118.792198","lat":"32.050678","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"10","is_capital":"0","kind":null},{"id":"320104","area_name":"秦淮区","parent_id":"320100","short_name":"秦淮","area_code":null,"short_py":null,"pinyin":"qinhuai","zip_code":null,"lng":"118.786087","lat":"32.033817","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"1","is_capital":"0","kind":null},{"id":"320105","area_name":"建邺区","parent_id":"320100","short_name":"建邺","area_code":null,"short_py":null,"pinyin":"jianye","zip_code":null,"lng":"118.732689","lat":"32.004539","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"5","is_capital":"0","kind":null},{"id":"320106","area_name":"鼓楼区","parent_id":"320100","short_name":"鼓楼","area_code":null,"short_py":null,"pinyin":"gulou","zip_code":null,"lng":"118.769737","lat":"32.066967","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"3","is_capital":"0","kind":null},{"id":"320111","area_name":"浦口区","parent_id":"320100","short_name":"浦口","area_code":null,"short_py":null,"pinyin":"pukou","zip_code":null,"lng":"118.625305","lat":"32.058392","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"8","is_capital":"0","kind":null},{"id":"320113","area_name":"栖霞区","parent_id":"320100","short_name":"栖霞","area_code":null,"short_py":"qixia","pinyin":"qixia","zip_code":null,"lng":"118.808701","lat":"32.102146","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"9","is_capital":"0","kind":null},{"id":"320114","area_name":"雨花台区","parent_id":"320100","short_name":"雨花台","area_code":null,"short_py":null,"pinyin":"yuhuatai","zip_code":null,"lng":"118.772072","lat":"31.995947","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"11","is_capital":"0","kind":null},{"id":"320115","area_name":"江宁区","parent_id":"320100","short_name":"江宁","area_code":null,"short_py":"jiangning","pinyin":"jiangning","zip_code":null,"lng":"118.850624","lat":"31.953419","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"4","is_capital":"0","kind":null},{"id":"320116","area_name":"六合区","parent_id":"320100","short_name":"六合","area_code":null,"short_py":null,"pinyin":"liuhe","zip_code":null,"lng":"118.850647","lat":"32.340656","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"7","is_capital":"0","kind":null},{"id":"320124","area_name":"溧水区","parent_id":"320100","short_name":"溧水","area_code":null,"short_py":null,"pinyin":"lishui","zip_code":null,"lng":"119.028732","lat":"31.653061","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"6","is_capital":"0","kind":null},{"id":"320125","area_name":"高淳区","parent_id":"320100","short_name":"高淳","area_code":null,"short_py":null,"pinyin":"gaochun","zip_code":null,"lng":"118.875893","lat":"31.327131","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"2","is_capital":"0","kind":null}],"sort":[{"name":"综合排序","value":"default"},{"name":"喜欢最多","value":"fan"},{"name":"作品最多","value":"work"}],"hotel":{"price":["1888","3888","6000","8888+"],"table":[{"max":10},{"min":10,"max":20},{"min":20,"max":30},{"min":30,"max":40},{"min":40}],"table_price":[{"max":2000},{"min":2000,"max":3000},{"min":3000,"max":4000},{"min":4000,"max":5000},{"min":5000}],"sort":[{"name":"智能排序","value":"default"},{"name":"桌数从少到多","value":"table_num_asc"},{"name":"桌数从多到少","value":"table_num_desc"},{"name":"价格从低到高","value":"price_start_asc"},{"name":"价格从高到低","value":"price_start_desc"}]}}
     * current_time : 1556159829
     */

    private StatusBean status;
    private DataBean data;
    private int current_time;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * properties : [{"id":"6","name":"婚纱摄影","children":[{"id":1,"name":"影楼"},{"id":2,"name":"工作室"},{"id":3,"name":"独立摄影师"}],"icon":"https://qnm.hunliji.com/o_1d59fng9g1mdkktou9a182t4sd1h.png"},{"id":999,"name":"全球旅拍","children":null,"icon":"https://qnm.hunliji.com/o_1d59foespd9c177fqophvs1mac1r.png"},{"id":"2","name":"婚礼策划","children":[{"id":4,"name":"省心优选","desc":"非定制套餐类"},{"id":5,"name":"高端定制","desc":"个性化定制套餐"}],"icon":"https://qnm.hunliji.com/o_1d59fkb36q1d148g8hfump1cpj.png"},{"id":"12","name":"婚纱礼服","children":[{"id":6,"name":"女士婚纱"},{"id":7,"name":"男士礼服"}],"icon":"https://qnm.hunliji.com/o_1d59fn0s61cch1aum14m49k5lqt1c.png"},{"id":"13","name":"婚宴酒店","children":[{"id":2,"name":"婚礼会所"},{"id":3,"name":"特色餐厅"},{"id":4,"name":"花园洋房"},{"id":5,"name":"游轮婚礼"},{"id":9,"name":"奢华五星"},{"id":10,"name":"豪华四星"},{"id":12,"name":"四合院"}],"icon":"https://qnm.hunliji.com/o_1d59fnv8d1kpt1efpfh816kn1b3b1m.png"},{"id":"14","name":"婚戒首饰","children":null,"icon":"https://qnm.hunliji.com/o_1d59fjqut9mjch918l12tm1sa6e.png"},{"id":"7","name":"婚礼摄影","children":null,"icon":"https://qnm.hunliji.com/o_1d59flto464r1jj11lsr11bd1a8t12.png"},{"id":"8","name":"婚礼摄像","children":null,"icon":"https://qnm.hunliji.com/o_1d59flcrpqag1326dnobk2tmgt.png"},{"id":"9","name":"婚礼跟妆","children":null,"icon":"https://qnm.hunliji.com/o_1d59fktng1lgcs801ju1v918p8o.png"},{"id":"11","name":"婚礼司仪","children":null,"icon":"https://qnm.hunliji.com/o_1d59fmehgu4mqjc1j7n19kk1ce417.png"},{"id":"15","name":"花艺甜品","children":[{"id":12,"name":"花艺"},{"id":13,"name":"甜品"}],"icon":"https://qnm.hunliji.com/o_1d59fguci1rg15gm1g3a1532184u9.png"}]
         * city : [{"id":"320100","area_name":"南京市","parent_id":"320000","short_name":"南京","area_code":null,"short_py":"nj","pinyin":"nanjing","zip_code":null,"lng":"118.76741","lat":"32.041546","level":"2","position":"tr_0 tr_320000","cid":"63","sort":"4","is_capital":"1","kind":null}]
         * area : [{"id":"320102","area_name":"玄武区","parent_id":"320100","short_name":"玄武","area_code":null,"short_py":null,"pinyin":"xuanwu","zip_code":null,"lng":"118.792198","lat":"32.050678","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"10","is_capital":"0","kind":null},{"id":"320104","area_name":"秦淮区","parent_id":"320100","short_name":"秦淮","area_code":null,"short_py":null,"pinyin":"qinhuai","zip_code":null,"lng":"118.786087","lat":"32.033817","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"1","is_capital":"0","kind":null},{"id":"320105","area_name":"建邺区","parent_id":"320100","short_name":"建邺","area_code":null,"short_py":null,"pinyin":"jianye","zip_code":null,"lng":"118.732689","lat":"32.004539","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"5","is_capital":"0","kind":null},{"id":"320106","area_name":"鼓楼区","parent_id":"320100","short_name":"鼓楼","area_code":null,"short_py":null,"pinyin":"gulou","zip_code":null,"lng":"118.769737","lat":"32.066967","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"3","is_capital":"0","kind":null},{"id":"320111","area_name":"浦口区","parent_id":"320100","short_name":"浦口","area_code":null,"short_py":null,"pinyin":"pukou","zip_code":null,"lng":"118.625305","lat":"32.058392","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"8","is_capital":"0","kind":null},{"id":"320113","area_name":"栖霞区","parent_id":"320100","short_name":"栖霞","area_code":null,"short_py":"qixia","pinyin":"qixia","zip_code":null,"lng":"118.808701","lat":"32.102146","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"9","is_capital":"0","kind":null},{"id":"320114","area_name":"雨花台区","parent_id":"320100","short_name":"雨花台","area_code":null,"short_py":null,"pinyin":"yuhuatai","zip_code":null,"lng":"118.772072","lat":"31.995947","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"11","is_capital":"0","kind":null},{"id":"320115","area_name":"江宁区","parent_id":"320100","short_name":"江宁","area_code":null,"short_py":"jiangning","pinyin":"jiangning","zip_code":null,"lng":"118.850624","lat":"31.953419","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"4","is_capital":"0","kind":null},{"id":"320116","area_name":"六合区","parent_id":"320100","short_name":"六合","area_code":null,"short_py":null,"pinyin":"liuhe","zip_code":null,"lng":"118.850647","lat":"32.340656","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"7","is_capital":"0","kind":null},{"id":"320124","area_name":"溧水区","parent_id":"320100","short_name":"溧水","area_code":null,"short_py":null,"pinyin":"lishui","zip_code":null,"lng":"119.028732","lat":"31.653061","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"6","is_capital":"0","kind":null},{"id":"320125","area_name":"高淳区","parent_id":"320100","short_name":"高淳","area_code":null,"short_py":null,"pinyin":"gaochun","zip_code":null,"lng":"118.875893","lat":"31.327131","level":"3","position":"tr_0 tr_320000 tr_320100","cid":"-1","sort":"2","is_capital":"0","kind":null}]
         * sort : [{"name":"综合排序","value":"default"},{"name":"喜欢最多","value":"fan"},{"name":"作品最多","value":"work"}]
         * hotel : {"price":["1888","3888","6000","8888+"],"table":[{"max":10,"min":10},{"min":10,"max":20},{"min":20,"max":30},{"min":30,"max":40},{"min":40}],"table_price":[{"max":2000,"min":2000},{"min":2000,"max":3000},{"min":3000,"max":4000},{"min":4000,"max":5000},{"min":5000}],"sort":[{"name":"智能排序","value":"default"},{"name":"桌数从少到多","value":"table_num_asc"},{"name":"桌数从多到少","value":"table_num_desc"},{"name":"价格从低到高","value":"price_start_asc"},{"name":"价格从高到低","value":"price_start_desc"}]}
         */

        private HotelBean hotel;
        private List<PropertiesBean> properties;
        private List<CityBean> city;
        private List<AreaBean> area;
        private List<SortBeanX> sort;

        public HotelBean getHotel() {
            return hotel;
        }

        public void setHotel(HotelBean hotel) {
            this.hotel = hotel;
        }

        public List<PropertiesBean> getProperties() {
            return properties;
        }

        public void setProperties(List<PropertiesBean> properties) {
            this.properties = properties;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        public List<AreaBean> getArea() {
            return area;
        }

        public void setArea(List<AreaBean> area) {
            this.area = area;
        }

        public List<SortBeanX> getSort() {
            return sort;
        }

        public void setSort(List<SortBeanX> sort) {
            this.sort = sort;
        }

        public static class HotelBean {
            private List<String> price;
            private List<TableBean> table;
            private List<TablePriceBean> table_price;
            private List<SortBean> sort;

            public List<String> getPrice() {
                return price;
            }

            public void setPrice(List<String> price) {
                this.price = price;
            }

            public List<TableBean> getTable() {
                return table;
            }

            public void setTable(List<TableBean> table) {
                this.table = table;
            }

            public List<TablePriceBean> getTable_price() {
                return table_price;
            }

            public void setTable_price(List<TablePriceBean> table_price) {
                this.table_price = table_price;
            }

            public List<SortBean> getSort() {
                return sort;
            }

            public void setSort(List<SortBean> sort) {
                this.sort = sort;
            }

            public static class TableBean {
                /**
                 * max : 10
                 * min : 10
                 */

                private int max;
                private int min;

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class TablePriceBean {
                /**
                 * max : 2000
                 * min : 2000
                 */

                private int max;
                private int min;

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }

                public int getMin() {
                    return min;
                }

                public void setMin(int min) {
                    this.min = min;
                }
            }

            public static class SortBean {
                /**
                 * name : 智能排序
                 * value : default
                 */

                private String name;
                private String value;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }

        public static class PropertiesBean {
            /**
             * id : 6
             * name : 婚纱摄影
             * children : [{"id":1,"name":"影楼"},{"id":2,"name":"工作室"},{"id":3,"name":"独立摄影师"}]
             * icon : https://qnm.hunliji.com/o_1d59fng9g1mdkktou9a182t4sd1h.png
             */

            private String id;
            private String name;
            private String icon;
            private List<ChildrenBean> children;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * id : 1
                 * name : 影楼
                 */

                private int id;
                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class CityBean {
            /**
             * id : 320100
             * area_name : 南京市
             * parent_id : 320000
             * short_name : 南京
             * area_code : null
             * short_py : nj
             * pinyin : nanjing
             * zip_code : null
             * lng : 118.76741
             * lat : 32.041546
             * level : 2
             * position : tr_0 tr_320000
             * cid : 63
             * sort : 4
             * is_capital : 1
             * kind : null
             */

            private String id;
            private String area_name;
            private String parent_id;
            private String short_name;
            private Object area_code;
            private String short_py;
            private String pinyin;
            private Object zip_code;
            private String lng;
            private String lat;
            private String level;
            private String position;
            private String cid;
            private String sort;
            private String is_capital;
            private Object kind;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public Object getArea_code() {
                return area_code;
            }

            public void setArea_code(Object area_code) {
                this.area_code = area_code;
            }

            public String getShort_py() {
                return short_py;
            }

            public void setShort_py(String short_py) {
                this.short_py = short_py;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public Object getZip_code() {
                return zip_code;
            }

            public void setZip_code(Object zip_code) {
                this.zip_code = zip_code;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getIs_capital() {
                return is_capital;
            }

            public void setIs_capital(String is_capital) {
                this.is_capital = is_capital;
            }

            public Object getKind() {
                return kind;
            }

            public void setKind(Object kind) {
                this.kind = kind;
            }
        }

        public static class AreaBean {
            /**
             * id : 320102
             * area_name : 玄武区
             * parent_id : 320100
             * short_name : 玄武
             * area_code : null
             * short_py : null
             * pinyin : xuanwu
             * zip_code : null
             * lng : 118.792198
             * lat : 32.050678
             * level : 3
             * position : tr_0 tr_320000 tr_320100
             * cid : -1
             * sort : 10
             * is_capital : 0
             * kind : null
             */

            private String id;
            private String area_name;
            private String parent_id;
            private String short_name;
            private Object area_code;
            private Object short_py;
            private String pinyin;
            private Object zip_code;
            private String lng;
            private String lat;
            private String level;
            private String position;
            private String cid;
            private String sort;
            private String is_capital;
            private Object kind;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public Object getArea_code() {
                return area_code;
            }

            public void setArea_code(Object area_code) {
                this.area_code = area_code;
            }

            public Object getShort_py() {
                return short_py;
            }

            public void setShort_py(Object short_py) {
                this.short_py = short_py;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public Object getZip_code() {
                return zip_code;
            }

            public void setZip_code(Object zip_code) {
                this.zip_code = zip_code;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getIs_capital() {
                return is_capital;
            }

            public void setIs_capital(String is_capital) {
                this.is_capital = is_capital;
            }

            public Object getKind() {
                return kind;
            }

            public void setKind(Object kind) {
                this.kind = kind;
            }
        }

        public static class SortBeanX {
            /**
             * name : 综合排序
             * value : default
             */

            private String name;
            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
