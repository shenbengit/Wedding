package com.example.wedding.http.bean;

import java.util.List;

/**
 * 商家列表信息实体bean
 */
public class BusinessListBean {

    /**
     * status : {"RetCode":0,"msg":"success"}
     * data : {"popular_merchant":{"list":[],"total_count":0,"page_count":10},"normal_merchant":{"page_count":11,"total_count":204,"list":[{"id":"127165","property_id":"13","name":"南京瑞庭婚礼宴会中心（情侣园店）","logo_path":"http://qnm.hunliji.com/o_1aqbf7v0v18vq1tlt1ahncb3fbqg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.069749","longitude":"118.812986","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"336","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3399","table_min":"22","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124958","property_id":"13","name":"玫瑰里·南京1865","logo_path":"https://qnm.hunliji.com/5F8EABE80B123382663F5E121CE83417.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.007054","longitude":"118.788161","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"254","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"预定即免15%的服务费","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3988","table_min":"24","table_max":"45","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124850","property_id":"13","name":"玫瑰里\u2022南京外秦淮","logo_path":"http://qnm.hunliji.com/4B1B18A8A26E1C7E3EF16A76E81761F7","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.026270","longitude":"118.770352","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"222","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3888","table_min":"12","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"337125","property_id":"13","name":"南京朗昇希尔顿酒店","logo_path":"http://qnm.hunliji.com/o_1bqa5qpuds7418773vp1djj1vkhn.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.030719","longitude":"118.738246","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":1,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"奢华五星","price_start":"4288","table_min":"0","table_max":"0","category_id":"9"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"121974","property_id":"13","name":"南京熊猫金陵大酒店","logo_path":"http://qnm.hunliji.com/o_1bp5g4vr7150oqsa1k96j7p18tin.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.091000","longitude":"118.773188","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"137","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"南京市","privilege":{"exclusive_offer":"免费送签到本一本，签名笔一支，提供使用平面舞台。投影设备（投影仪，幕布）香槟一瓶、15桌以上送3层喜庆蛋糕,免费提供婚房。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2299","table_min":"6","table_max":"45","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119675","property_id":"13","name":"南京金太隆国际酒店","logo_path":"http://qnm.hunliji.com/o_1ajeli8kc1bmnsh9stoa3nkr5b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.041093","longitude":"118.791481","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"24","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"免费提供新娘更衣室一件；12桌以上赠送12寸结婚蛋糕一个；15桌以上赠指定婚房一间，次日双早；20桌以上每桌赠软饮2瓶；使用LED屏享受8.5折优惠；更多惊喜欢迎到店咨询！","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"2299","table_min":"8","table_max":"30","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"376916","property_id":"13","name":"花嫁丽舍高端婚礼殿堂(国展店)","logo_path":"http://qnm.hunliji.com/CB8DF068ACF93ABE516C57D96FF9C357.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"13","latitude":"32.074598","longitude":"118.809079","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"43","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"预定指定档期宴会厅送价值38888元高科技剧院式全场舞美灯光","is_platform_gift":1,"feature":"仪式堂 层高高 大厅无柱 地铁沿线","is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3888","table_min":"10","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"122981","property_id":"13","name":"南京太和紫金大酒店","logo_path":"http://qnm.hunliji.com/o_1amdb2vm9hph1hv1v5710f6g64o.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045439","longitude":"118.794957","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"订婚宴席满十桌即可赠送婚房一间","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"豪华四星","price_start":"1999","table_min":"20","table_max":"25","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119067","property_id":"13","name":"十朝春餐饮管理有限公司","logo_path":"http://qnm.hunliji.com/o_1akagoqa9195144g1s5bs6s0eb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.011348","longitude":"118.735061","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"特色餐厅","price_start":"2088","table_min":"30","table_max":"40","category_id":"3"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"119197","property_id":"13","name":"米兰假日大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1eqju91nipof5iu4rf43j9b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.090190","longitude":"118.780113","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"12","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供停车位 下单立减1000元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2088","table_min":"10","table_max":"15","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119639","property_id":"13","name":"南京中心大酒店","logo_path":"http://qnm.hunliji.com/o_1ajdtpejc1vp41gt0130l1e6mcgob.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045521","longitude":"118.783452","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"42","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"1、20人西式茶歇\n2、贵宾休息厅\n3、LED屏优惠：钻石厅减800元；紫晶厅减500元\n4、婚房过夜，赠送次日花园早餐\n5、场地升级\n6、制定婚庆公司1000.00/万优惠\n7、增加固定停车位2-4个\n8、高管洽谈开列菜单\n16年新增优惠项目，8选2","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"奢华五星","price_start":"2999","table_min":"6","table_max":"40","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119190","property_id":"13","name":"宁邦大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1cjggdomvqm01kkr1r7f1dgdd.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.094065","longitude":"118.786498","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"1","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"赠送新婚贺喜礼物一份，赠送主桌鲜花装饰一份，免费提供新人化妆间，免费赠送签到本笔一套","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1588","table_min":"16","table_max":"35","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"141184","property_id":"13","name":"丁香御品大酒店","logo_path":"http://qnm.hunliji.com/o_1b95gi8e9172218j4170p19f816nkg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.040966","longitude":"118.783094","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"124","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"0","table_min":"10","table_max":"34","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123579","property_id":"13","name":"正晴和大酒店","logo_path":"http://qnm.hunliji.com/o_1amsnqrga1491rmdhk41eiabtjb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.087742","longitude":"118.772576","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供音响设备","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1288","table_min":"20","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120183","property_id":"13","name":"烟波渔港江东店","logo_path":"http://qnm.hunliji.com/o_1ajocukrag60184o1qcdmpi6tsl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.066492","longitude":"118.737925","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"订购2880十桌以上赠送红酒一瓶，饮料两瓶，二十桌以上享超值大礼包。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1880","table_min":"16","table_max":"42","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"147174","property_id":"13","name":"罗曼园高级婚礼会馆","logo_path":"http://qnm.hunliji.com/o_1bomjnjed1g4ce2112iun351hsa1c.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.065259","longitude":"118.792145","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"180","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"到店赠送进口红酒礼盒一份，预定婚宴可享婚礼纪独家优惠","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3988","table_min":"3","table_max":"37","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120337","property_id":"13","name":"珍宝舫","logo_path":"http://qnm.hunliji.com/o_1ajteq0to55117046m1ovu160vl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.019525","longitude":"118.792936","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"每桌两瓶饮料，一瓶红酒。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"1588","table_min":"8","table_max":"10","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"128108","property_id":"13","name":"五号大院","logo_path":"http://qnm.hunliji.com/o_1ar0ippnpq561ea418v21g6l8nhl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.122801","longitude":"118.739790","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"浦口区","privilege":{"exclusive_offer":"1、每桌送可乐1瓶，雪碧1瓶，价值10元/瓶。\n2、5桌以上每桌再送红酒1瓶，价值98元/瓶。\n3、8桌以上再送一对新人1瓶香槟酒，价值188元/瓶。\n4、15桌以上我们免费在送您1桌。\n5、20桌以上我们免费送您15平方米LED大屏。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"浦口区","kind":"特色餐厅","price_start":"1099","table_min":"8","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"329579","property_id":"13","name":"东郊国宾馆","logo_path":"http://qnm.hunliji.com/o_1bi5dj7fai661kth119k1ronhikq.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.060169","longitude":"118.846563","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"2","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"奢华五星","price_start":"0","table_min":"0","table_max":"0","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123485","property_id":"13","name":"江苏天盛大酒店","logo_path":"http://qnm.hunliji.com/o_1amqbn85tlva4d1sk31t5s1tuab.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.032365","longitude":"118.782979","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"订婚宴每桌送今世缘一瓶和红酒一瓶！每桌送2瓶软饮！定今年婚期和17年1和2月婚期，每桌可再减200元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"1999","table_min":"0","table_max":"0","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}}]},"parent_cid":null,"parent_city":null,"show_aroundmerchant":false}
     * current_time : 1556163923
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
         * popular_merchant : {"list":[],"total_count":0,"page_count":10}
         * normal_merchant : {"page_count":11,"total_count":204,"list":[{"id":"127165","property_id":"13","name":"南京瑞庭婚礼宴会中心（情侣园店）","logo_path":"http://qnm.hunliji.com/o_1aqbf7v0v18vq1tlt1ahncb3fbqg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.069749","longitude":"118.812986","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"336","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3399","table_min":"22","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124958","property_id":"13","name":"玫瑰里·南京1865","logo_path":"https://qnm.hunliji.com/5F8EABE80B123382663F5E121CE83417.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.007054","longitude":"118.788161","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"254","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"预定即免15%的服务费","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3988","table_min":"24","table_max":"45","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124850","property_id":"13","name":"玫瑰里\u2022南京外秦淮","logo_path":"http://qnm.hunliji.com/4B1B18A8A26E1C7E3EF16A76E81761F7","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.026270","longitude":"118.770352","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"222","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3888","table_min":"12","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"337125","property_id":"13","name":"南京朗昇希尔顿酒店","logo_path":"http://qnm.hunliji.com/o_1bqa5qpuds7418773vp1djj1vkhn.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.030719","longitude":"118.738246","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":1,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"奢华五星","price_start":"4288","table_min":"0","table_max":"0","category_id":"9"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"121974","property_id":"13","name":"南京熊猫金陵大酒店","logo_path":"http://qnm.hunliji.com/o_1bp5g4vr7150oqsa1k96j7p18tin.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.091000","longitude":"118.773188","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"137","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"南京市","privilege":{"exclusive_offer":"免费送签到本一本，签名笔一支，提供使用平面舞台。投影设备（投影仪，幕布）香槟一瓶、15桌以上送3层喜庆蛋糕,免费提供婚房。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2299","table_min":"6","table_max":"45","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119675","property_id":"13","name":"南京金太隆国际酒店","logo_path":"http://qnm.hunliji.com/o_1ajeli8kc1bmnsh9stoa3nkr5b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.041093","longitude":"118.791481","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"24","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"免费提供新娘更衣室一件；12桌以上赠送12寸结婚蛋糕一个；15桌以上赠指定婚房一间，次日双早；20桌以上每桌赠软饮2瓶；使用LED屏享受8.5折优惠；更多惊喜欢迎到店咨询！","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"2299","table_min":"8","table_max":"30","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"376916","property_id":"13","name":"花嫁丽舍高端婚礼殿堂(国展店)","logo_path":"http://qnm.hunliji.com/CB8DF068ACF93ABE516C57D96FF9C357.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"13","latitude":"32.074598","longitude":"118.809079","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"43","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"预定指定档期宴会厅送价值38888元高科技剧院式全场舞美灯光","is_platform_gift":1,"feature":"仪式堂 层高高 大厅无柱 地铁沿线","is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3888","table_min":"10","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"122981","property_id":"13","name":"南京太和紫金大酒店","logo_path":"http://qnm.hunliji.com/o_1amdb2vm9hph1hv1v5710f6g64o.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045439","longitude":"118.794957","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"订婚宴席满十桌即可赠送婚房一间","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"豪华四星","price_start":"1999","table_min":"20","table_max":"25","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119067","property_id":"13","name":"十朝春餐饮管理有限公司","logo_path":"http://qnm.hunliji.com/o_1akagoqa9195144g1s5bs6s0eb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.011348","longitude":"118.735061","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"特色餐厅","price_start":"2088","table_min":"30","table_max":"40","category_id":"3"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"119197","property_id":"13","name":"米兰假日大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1eqju91nipof5iu4rf43j9b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.090190","longitude":"118.780113","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"12","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供停车位 下单立减1000元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2088","table_min":"10","table_max":"15","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119639","property_id":"13","name":"南京中心大酒店","logo_path":"http://qnm.hunliji.com/o_1ajdtpejc1vp41gt0130l1e6mcgob.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045521","longitude":"118.783452","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"42","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"1、20人西式茶歇\n2、贵宾休息厅\n3、LED屏优惠：钻石厅减800元；紫晶厅减500元\n4、婚房过夜，赠送次日花园早餐\n5、场地升级\n6、制定婚庆公司1000.00/万优惠\n7、增加固定停车位2-4个\n8、高管洽谈开列菜单\n16年新增优惠项目，8选2","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"奢华五星","price_start":"2999","table_min":"6","table_max":"40","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119190","property_id":"13","name":"宁邦大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1cjggdomvqm01kkr1r7f1dgdd.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.094065","longitude":"118.786498","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"1","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"赠送新婚贺喜礼物一份，赠送主桌鲜花装饰一份，免费提供新人化妆间，免费赠送签到本笔一套","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1588","table_min":"16","table_max":"35","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"141184","property_id":"13","name":"丁香御品大酒店","logo_path":"http://qnm.hunliji.com/o_1b95gi8e9172218j4170p19f816nkg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.040966","longitude":"118.783094","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"124","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"0","table_min":"10","table_max":"34","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123579","property_id":"13","name":"正晴和大酒店","logo_path":"http://qnm.hunliji.com/o_1amsnqrga1491rmdhk41eiabtjb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.087742","longitude":"118.772576","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供音响设备","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1288","table_min":"20","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120183","property_id":"13","name":"烟波渔港江东店","logo_path":"http://qnm.hunliji.com/o_1ajocukrag60184o1qcdmpi6tsl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.066492","longitude":"118.737925","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"订购2880十桌以上赠送红酒一瓶，饮料两瓶，二十桌以上享超值大礼包。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1880","table_min":"16","table_max":"42","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"147174","property_id":"13","name":"罗曼园高级婚礼会馆","logo_path":"http://qnm.hunliji.com/o_1bomjnjed1g4ce2112iun351hsa1c.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.065259","longitude":"118.792145","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"180","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"到店赠送进口红酒礼盒一份，预定婚宴可享婚礼纪独家优惠","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3988","table_min":"3","table_max":"37","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120337","property_id":"13","name":"珍宝舫","logo_path":"http://qnm.hunliji.com/o_1ajteq0to55117046m1ovu160vl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.019525","longitude":"118.792936","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"每桌两瓶饮料，一瓶红酒。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"1588","table_min":"8","table_max":"10","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"128108","property_id":"13","name":"五号大院","logo_path":"http://qnm.hunliji.com/o_1ar0ippnpq561ea418v21g6l8nhl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.122801","longitude":"118.739790","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"浦口区","privilege":{"exclusive_offer":"1、每桌送可乐1瓶，雪碧1瓶，价值10元/瓶。\n2、5桌以上每桌再送红酒1瓶，价值98元/瓶。\n3、8桌以上再送一对新人1瓶香槟酒，价值188元/瓶。\n4、15桌以上我们免费在送您1桌。\n5、20桌以上我们免费送您15平方米LED大屏。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"浦口区","kind":"特色餐厅","price_start":"1099","table_min":"8","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"329579","property_id":"13","name":"东郊国宾馆","logo_path":"http://qnm.hunliji.com/o_1bi5dj7fai661kth119k1ronhikq.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.060169","longitude":"118.846563","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"2","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"奢华五星","price_start":"0","table_min":"0","table_max":"0","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123485","property_id":"13","name":"江苏天盛大酒店","logo_path":"http://qnm.hunliji.com/o_1amqbn85tlva4d1sk31t5s1tuab.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.032365","longitude":"118.782979","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"订婚宴每桌送今世缘一瓶和红酒一瓶！每桌送2瓶软饮！定今年婚期和17年1和2月婚期，每桌可再减200元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"1999","table_min":"0","table_max":"0","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}}]}
         * parent_cid : null
         * parent_city : null
         * show_aroundmerchant : false
         */

        private PopularMerchantBean popular_merchant;
        private NormalMerchantBean normal_merchant;
        private Object parent_cid;
        private Object parent_city;
        private boolean show_aroundmerchant;

        public PopularMerchantBean getPopular_merchant() {
            return popular_merchant;
        }

        public void setPopular_merchant(PopularMerchantBean popular_merchant) {
            this.popular_merchant = popular_merchant;
        }

        public NormalMerchantBean getNormal_merchant() {
            return normal_merchant;
        }

        public void setNormal_merchant(NormalMerchantBean normal_merchant) {
            this.normal_merchant = normal_merchant;
        }

        public Object getParent_cid() {
            return parent_cid;
        }

        public void setParent_cid(Object parent_cid) {
            this.parent_cid = parent_cid;
        }

        public Object getParent_city() {
            return parent_city;
        }

        public void setParent_city(Object parent_city) {
            this.parent_city = parent_city;
        }

        public boolean isShow_aroundmerchant() {
            return show_aroundmerchant;
        }

        public void setShow_aroundmerchant(boolean show_aroundmerchant) {
            this.show_aroundmerchant = show_aroundmerchant;
        }

        public static class PopularMerchantBean {
            /**
             * list : []
             * total_count : 0
             * page_count : 10
             */

            private int total_count;
            private int page_count;
            private List<?> list;

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public int getPage_count() {
                return page_count;
            }

            public void setPage_count(int page_count) {
                this.page_count = page_count;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }

        public static class NormalMerchantBean {
            /**
             * page_count : 11
             * total_count : 204
             * list : [{"id":"127165","property_id":"13","name":"南京瑞庭婚礼宴会中心（情侣园店）","logo_path":"http://qnm.hunliji.com/o_1aqbf7v0v18vq1tlt1ahncb3fbqg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.069749","longitude":"118.812986","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"336","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3399","table_min":"22","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124958","property_id":"13","name":"玫瑰里·南京1865","logo_path":"https://qnm.hunliji.com/5F8EABE80B123382663F5E121CE83417.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.007054","longitude":"118.788161","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"254","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"预定即免15%的服务费","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3988","table_min":"24","table_max":"45","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"124850","property_id":"13","name":"玫瑰里\u2022南京外秦淮","logo_path":"http://qnm.hunliji.com/4B1B18A8A26E1C7E3EF16A76E81761F7","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.026270","longitude":"118.770352","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"222","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"婚礼会所","price_start":"3888","table_min":"12","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"337125","property_id":"13","name":"南京朗昇希尔顿酒店","logo_path":"http://qnm.hunliji.com/o_1bqa5qpuds7418773vp1djj1vkhn.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.030719","longitude":"118.738246","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":1,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"奢华五星","price_start":"4288","table_min":"0","table_max":"0","category_id":"9"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"121974","property_id":"13","name":"南京熊猫金陵大酒店","logo_path":"http://qnm.hunliji.com/o_1bp5g4vr7150oqsa1k96j7p18tin.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.091000","longitude":"118.773188","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"137","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"南京市","privilege":{"exclusive_offer":"免费送签到本一本，签名笔一支，提供使用平面舞台。投影设备（投影仪，幕布）香槟一瓶、15桌以上送3层喜庆蛋糕,免费提供婚房。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2299","table_min":"6","table_max":"45","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119675","property_id":"13","name":"南京金太隆国际酒店","logo_path":"http://qnm.hunliji.com/o_1ajeli8kc1bmnsh9stoa3nkr5b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.041093","longitude":"118.791481","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"24","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"免费提供新娘更衣室一件；12桌以上赠送12寸结婚蛋糕一个；15桌以上赠指定婚房一间，次日双早；20桌以上每桌赠软饮2瓶；使用LED屏享受8.5折优惠；更多惊喜欢迎到店咨询！","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"2299","table_min":"8","table_max":"30","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"376916","property_id":"13","name":"花嫁丽舍高端婚礼殿堂(国展店)","logo_path":"http://qnm.hunliji.com/CB8DF068ACF93ABE516C57D96FF9C357.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"13","latitude":"32.074598","longitude":"118.809079","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"43","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"预定指定档期宴会厅送价值38888元高科技剧院式全场舞美灯光","is_platform_gift":1,"feature":"仪式堂 层高高 大厅无柱 地铁沿线","is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3888","table_min":"10","table_max":"40","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":"5.0"}},{"id":"122981","property_id":"13","name":"南京太和紫金大酒店","logo_path":"http://qnm.hunliji.com/o_1amdb2vm9hph1hv1v5710f6g64o.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045439","longitude":"118.794957","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"订婚宴席满十桌即可赠送婚房一间","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"豪华四星","price_start":"1999","table_min":"20","table_max":"25","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119067","property_id":"13","name":"十朝春餐饮管理有限公司","logo_path":"http://qnm.hunliji.com/o_1akagoqa9195144g1s5bs6s0eb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.011348","longitude":"118.735061","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"建邺区","privilege":null,"hotel":{"area":"建邺区","kind":"特色餐厅","price_start":"2088","table_min":"30","table_max":"40","category_id":"3"},"is_adv":null,"merchant_circle_name":null,"price_start":"0","marks":null,"coupon":"","merchant_comment":{"score":0}},{"id":"119197","property_id":"13","name":"米兰假日大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1eqju91nipof5iu4rf43j9b.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.090190","longitude":"118.780113","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"12","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供停车位 下单立减1000元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"豪华四星","price_start":"2088","table_min":"10","table_max":"15","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119639","property_id":"13","name":"南京中心大酒店","logo_path":"http://qnm.hunliji.com/o_1ajdtpejc1vp41gt0130l1e6mcgob.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.045521","longitude":"118.783452","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"42","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"1、20人西式茶歇\n2、贵宾休息厅\n3、LED屏优惠：钻石厅减800元；紫晶厅减500元\n4、婚房过夜，赠送次日花园早餐\n5、场地升级\n6、制定婚庆公司1000.00/万优惠\n7、增加固定停车位2-4个\n8、高管洽谈开列菜单\n16年新增优惠项目，8选2","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"奢华五星","price_start":"2999","table_min":"6","table_max":"40","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"119190","property_id":"13","name":"宁邦大酒店","logo_path":"http://qnm.hunliji.com/o_1aj1cjggdomvqm01kkr1r7f1dgdd.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.094065","longitude":"118.786498","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"1","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"赠送新婚贺喜礼物一份，赠送主桌鲜花装饰一份，免费提供新人化妆间，免费赠送签到本笔一套","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1588","table_min":"16","table_max":"35","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"141184","property_id":"13","name":"丁香御品大酒店","logo_path":"http://qnm.hunliji.com/o_1b95gi8e9172218j4170p19f816nkg.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.040966","longitude":"118.783094","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"124","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"0","table_min":"10","table_max":"34","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123579","property_id":"13","name":"正晴和大酒店","logo_path":"http://qnm.hunliji.com/o_1amsnqrga1491rmdhk41eiabtjb.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.087742","longitude":"118.772576","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"免费提供音响设备","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1288","table_min":"20","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120183","property_id":"13","name":"烟波渔港江东店","logo_path":"http://qnm.hunliji.com/o_1ajocukrag60184o1qcdmpi6tsl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.066492","longitude":"118.737925","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"鼓楼区","privilege":{"exclusive_offer":"订购2880十桌以上赠送红酒一瓶，饮料两瓶，二十桌以上享超值大礼包。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"鼓楼区","kind":"特色餐厅","price_start":"1880","table_min":"16","table_max":"42","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"147174","property_id":"13","name":"罗曼园高级婚礼会馆","logo_path":"http://qnm.hunliji.com/o_1bomjnjed1g4ce2112iun351hsa1c.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.065259","longitude":"118.792145","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"180","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":"到店赠送进口红酒礼盒一份，预定婚宴可享婚礼纪独家优惠","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"婚礼会所","price_start":"3988","table_min":"3","table_max":"37","category_id":"2"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"120337","property_id":"13","name":"珍宝舫","logo_path":"http://qnm.hunliji.com/o_1ajteq0to55117046m1ovu160vl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.019525","longitude":"118.792936","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"每桌两瓶饮料，一瓶红酒。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"特色餐厅","price_start":"1588","table_min":"8","table_max":"10","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"128108","property_id":"13","name":"五号大院","logo_path":"http://qnm.hunliji.com/o_1ar0ippnpq561ea418v21g6l8nhl.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.122801","longitude":"118.739790","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"0","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":3,"name":"特色餐厅"}},"merchant_comments_count":0,"area":"浦口区","privilege":{"exclusive_offer":"1、每桌送可乐1瓶，雪碧1瓶，价值10元/瓶。\n2、5桌以上每桌再送红酒1瓶，价值98元/瓶。\n3、8桌以上再送一对新人1瓶香槟酒，价值188元/瓶。\n4、15桌以上我们免费在送您1桌。\n5、20桌以上我们免费送您15平方米LED大屏。","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"浦口区","kind":"特色餐厅","price_start":"1099","table_min":"8","table_max":"30","category_id":"3"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"329579","property_id":"13","name":"东郊国宾馆","logo_path":"http://qnm.hunliji.com/o_1bi5dj7fai661kth119k1ronhikq.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.060169","longitude":"118.846563","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"2","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":9,"name":"奢华五星"}},"merchant_comments_count":0,"area":"玄武区","privilege":{"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"玄武区","kind":"奢华五星","price_start":"0","table_min":"0","table_max":"0","category_id":"9"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}},{"id":"123485","property_id":"13","name":"江苏天盛大酒店","logo_path":"http://qnm.hunliji.com/o_1amqbn85tlva4d1sk31t5s1tuab.jpg","shop_type":"3","is_pro":"0","active_works_pcount":"0","grade":"0","comments_count":"0","latitude":"32.032365","longitude":"118.782979","merchant_achievement":{},"is_multi_property":0,"merchant_tags":[],"is_chain_merchant":0,"is_collected":0,"is_bond_sign":"0","is_bond":"0","is_franchisee":"0","hotel_order_view_count":"3","property":{"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":10,"name":"豪华四星"}},"merchant_comments_count":0,"area":"秦淮区","privilege":{"exclusive_offer":"订婚宴每桌送今世缘一瓶和红酒一瓶！每桌送2瓶软饮！定今年婚期和17年1和2月婚期，每桌可再减200元","is_platform_gift":1,"feature":null,"is_free_order":0},"hotel":{"area":"秦淮区","kind":"豪华四星","price_start":"1999","table_min":"0","table_max":"0","category_id":"10"},"is_adv":"1","merchant_circle_name":null,"price_start":"0","marks":["婚宴豪礼"],"coupon":"","merchant_comment":{"score":0}}]
             */

            private int page_count;
            private int total_count;
            private List<ListBean> list;

            public int getPage_count() {
                return page_count;
            }

            public void setPage_count(int page_count) {
                this.page_count = page_count;
            }

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 127165
                 * property_id : 13
                 * name : 南京瑞庭婚礼宴会中心（情侣园店）
                 * logo_path : http://qnm.hunliji.com/o_1aqbf7v0v18vq1tlt1ahncb3fbqg.jpg
                 * shop_type : 3
                 * is_pro : 0
                 * active_works_pcount : 0
                 * grade : 0
                 * comments_count : 0
                 * latitude : 32.069749
                 * longitude : 118.812986
                 * merchant_achievement : {}
                 * is_multi_property : 0
                 * merchant_tags : []
                 * is_chain_merchant : 0
                 * is_collected : 0
                 * is_bond_sign : 0
                 * is_bond : 0
                 * is_franchisee : 0
                 * hotel_order_view_count : 336
                 * property : {"id":"13","name":"婚宴酒店","bond_fee":"5000.00","category":{"id":2,"name":"婚礼会所"}}
                 * merchant_comments_count : 0
                 * area : 玄武区
                 * privilege : {"exclusive_offer":null,"is_platform_gift":1,"feature":null,"is_free_order":0}
                 * hotel : {"area":"玄武区","kind":"婚礼会所","price_start":"3399","table_min":"22","table_max":"40","category_id":"2"}
                 * is_adv : 1
                 * merchant_circle_name : null
                 * price_start : 0
                 * marks : ["婚宴豪礼"]
                 * coupon :
                 * merchant_comment : {"score":0}
                 */

                private String id;
                private String property_id;
                private String name;
                private String logo_path;
                private String shop_type;
                private String is_pro;
                private String active_works_pcount;
                private String grade;
                private String comments_count;
                private String latitude;
                private String longitude;
                private MerchantAchievementBean merchant_achievement;
                private int is_multi_property;
                private int is_chain_merchant;
                private int is_collected;
                private String is_bond_sign;
                private String is_bond;
                private String is_franchisee;
                private String hotel_order_view_count;
                private PropertyBean property;
                private int merchant_comments_count;
                private String area;
                private PrivilegeBean privilege;
                private HotelBean hotel;
                private String is_adv;
                private Object merchant_circle_name;
                private String price_start;
                private String coupon;
                private MerchantCommentBean merchant_comment;
                private List<?> merchant_tags;
                private List<String> marks;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getProperty_id() {
                    return property_id;
                }

                public void setProperty_id(String property_id) {
                    this.property_id = property_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLogo_path() {
                    return logo_path;
                }

                public void setLogo_path(String logo_path) {
                    this.logo_path = logo_path;
                }

                public String getShop_type() {
                    return shop_type;
                }

                public void setShop_type(String shop_type) {
                    this.shop_type = shop_type;
                }

                public String getIs_pro() {
                    return is_pro;
                }

                public void setIs_pro(String is_pro) {
                    this.is_pro = is_pro;
                }

                public String getActive_works_pcount() {
                    return active_works_pcount;
                }

                public void setActive_works_pcount(String active_works_pcount) {
                    this.active_works_pcount = active_works_pcount;
                }

                public String getGrade() {
                    return grade;
                }

                public void setGrade(String grade) {
                    this.grade = grade;
                }

                public String getComments_count() {
                    return comments_count;
                }

                public void setComments_count(String comments_count) {
                    this.comments_count = comments_count;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public MerchantAchievementBean getMerchant_achievement() {
                    return merchant_achievement;
                }

                public void setMerchant_achievement(MerchantAchievementBean merchant_achievement) {
                    this.merchant_achievement = merchant_achievement;
                }

                public int getIs_multi_property() {
                    return is_multi_property;
                }

                public void setIs_multi_property(int is_multi_property) {
                    this.is_multi_property = is_multi_property;
                }

                public int getIs_chain_merchant() {
                    return is_chain_merchant;
                }

                public void setIs_chain_merchant(int is_chain_merchant) {
                    this.is_chain_merchant = is_chain_merchant;
                }

                public int getIs_collected() {
                    return is_collected;
                }

                public void setIs_collected(int is_collected) {
                    this.is_collected = is_collected;
                }

                public String getIs_bond_sign() {
                    return is_bond_sign;
                }

                public void setIs_bond_sign(String is_bond_sign) {
                    this.is_bond_sign = is_bond_sign;
                }

                public String getIs_bond() {
                    return is_bond;
                }

                public void setIs_bond(String is_bond) {
                    this.is_bond = is_bond;
                }

                public String getIs_franchisee() {
                    return is_franchisee;
                }

                public void setIs_franchisee(String is_franchisee) {
                    this.is_franchisee = is_franchisee;
                }

                public String getHotel_order_view_count() {
                    return hotel_order_view_count;
                }

                public void setHotel_order_view_count(String hotel_order_view_count) {
                    this.hotel_order_view_count = hotel_order_view_count;
                }

                public PropertyBean getProperty() {
                    return property;
                }

                public void setProperty(PropertyBean property) {
                    this.property = property;
                }

                public int getMerchant_comments_count() {
                    return merchant_comments_count;
                }

                public void setMerchant_comments_count(int merchant_comments_count) {
                    this.merchant_comments_count = merchant_comments_count;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public PrivilegeBean getPrivilege() {
                    return privilege;
                }

                public void setPrivilege(PrivilegeBean privilege) {
                    this.privilege = privilege;
                }

                public HotelBean getHotel() {
                    return hotel;
                }

                public void setHotel(HotelBean hotel) {
                    this.hotel = hotel;
                }

                public String getIs_adv() {
                    return is_adv;
                }

                public void setIs_adv(String is_adv) {
                    this.is_adv = is_adv;
                }

                public Object getMerchant_circle_name() {
                    return merchant_circle_name;
                }

                public void setMerchant_circle_name(Object merchant_circle_name) {
                    this.merchant_circle_name = merchant_circle_name;
                }

                public String getPrice_start() {
                    return price_start;
                }

                public void setPrice_start(String price_start) {
                    this.price_start = price_start;
                }

                public String getCoupon() {
                    return coupon;
                }

                public void setCoupon(String coupon) {
                    this.coupon = coupon;
                }

                public MerchantCommentBean getMerchant_comment() {
                    return merchant_comment;
                }

                public void setMerchant_comment(MerchantCommentBean merchant_comment) {
                    this.merchant_comment = merchant_comment;
                }

                public List<?> getMerchant_tags() {
                    return merchant_tags;
                }

                public void setMerchant_tags(List<?> merchant_tags) {
                    this.merchant_tags = merchant_tags;
                }

                public List<String> getMarks() {
                    return marks;
                }

                public void setMarks(List<String> marks) {
                    this.marks = marks;
                }

                public static class MerchantAchievementBean {
                }

                public static class PropertyBean {
                    /**
                     * id : 13
                     * name : 婚宴酒店
                     * bond_fee : 5000.00
                     * category : {"id":2,"name":"婚礼会所"}
                     */

                    private String id;
                    private String name;
                    private String bond_fee;
                    private CategoryBean category;

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

                    public String getBond_fee() {
                        return bond_fee;
                    }

                    public void setBond_fee(String bond_fee) {
                        this.bond_fee = bond_fee;
                    }

                    public CategoryBean getCategory() {
                        return category;
                    }

                    public void setCategory(CategoryBean category) {
                        this.category = category;
                    }

                    public static class CategoryBean {
                        /**
                         * id : 2
                         * name : 婚礼会所
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

                public static class PrivilegeBean {
                    /**
                     * exclusive_offer : null
                     * is_platform_gift : 1
                     * feature : null
                     * is_free_order : 0
                     */

                    private Object exclusive_offer;
                    private int is_platform_gift;
                    private Object feature;
                    private int is_free_order;

                    public Object getExclusive_offer() {
                        return exclusive_offer;
                    }

                    public void setExclusive_offer(Object exclusive_offer) {
                        this.exclusive_offer = exclusive_offer;
                    }

                    public int getIs_platform_gift() {
                        return is_platform_gift;
                    }

                    public void setIs_platform_gift(int is_platform_gift) {
                        this.is_platform_gift = is_platform_gift;
                    }

                    public Object getFeature() {
                        return feature;
                    }

                    public void setFeature(Object feature) {
                        this.feature = feature;
                    }

                    public int getIs_free_order() {
                        return is_free_order;
                    }

                    public void setIs_free_order(int is_free_order) {
                        this.is_free_order = is_free_order;
                    }
                }

                public static class HotelBean {
                    /**
                     * area : 玄武区
                     * kind : 婚礼会所
                     * price_start : 3399
                     * table_min : 22
                     * table_max : 40
                     * category_id : 2
                     */

                    private String area;
                    private String kind;
                    private String price_start;
                    private String table_min;
                    private String table_max;
                    private String category_id;

                    public String getArea() {
                        return area;
                    }

                    public void setArea(String area) {
                        this.area = area;
                    }

                    public String getKind() {
                        return kind;
                    }

                    public void setKind(String kind) {
                        this.kind = kind;
                    }

                    public String getPrice_start() {
                        return price_start;
                    }

                    public void setPrice_start(String price_start) {
                        this.price_start = price_start;
                    }

                    public String getTable_min() {
                        return table_min;
                    }

                    public void setTable_min(String table_min) {
                        this.table_min = table_min;
                    }

                    public String getTable_max() {
                        return table_max;
                    }

                    public void setTable_max(String table_max) {
                        this.table_max = table_max;
                    }

                    public String getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(String category_id) {
                        this.category_id = category_id;
                    }
                }

                public static class MerchantCommentBean {
                    /**
                     * score : 0
                     */

                    private int score;

                    public int getScore() {
                        return score;
                    }

                    public void setScore(int score) {
                        this.score = score;
                    }
                }
            }
        }
    }
}
