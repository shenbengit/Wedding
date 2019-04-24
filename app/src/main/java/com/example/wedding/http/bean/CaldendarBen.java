package com.example.wedding.http.bean;

import com.google.gson.annotations.SerializedName;

public class CaldendarBen {

    /**
     * reason : Success
     * result : {"data":{"avoid":"掘井.动土.破土.安葬.开光.","animalsYear":"猪","weekday":"星期四","suit":"祭祀.进人口.嫁娶.安床.解除.冠笄.出行.裁衣.扫舍.","lunarYear":"己亥年","lunar":"三月廿一","year-month":"2019-4","date":"2019-4-25"}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * data : {"avoid":"掘井.动土.破土.安葬.开光.","animalsYear":"猪","weekday":"星期四","suit":"祭祀.进人口.嫁娶.安床.解除.冠笄.出行.裁衣.扫舍.","lunarYear":"己亥年","lunar":"三月廿一","year-month":"2019-4","date":"2019-4-25"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * avoid : 掘井.动土.破土.安葬.开光.
             * animalsYear : 猪
             * weekday : 星期四
             * suit : 祭祀.进人口.嫁娶.安床.解除.冠笄.出行.裁衣.扫舍.
             * lunarYear : 己亥年
             * lunar : 三月廿一
             * year-month : 2019-4
             * date : 2019-4-25
             */

            private String avoid;
            private String animalsYear;
            private String weekday;
            private String suit;
            private String lunarYear;
            private String lunar;
            @SerializedName("year-month")
            private String yearmonth;
            private String date;

            public String getAvoid() {
                return avoid;
            }

            public void setAvoid(String avoid) {
                this.avoid = avoid;
            }

            public String getAnimalsYear() {
                return animalsYear;
            }

            public void setAnimalsYear(String animalsYear) {
                this.animalsYear = animalsYear;
            }

            public String getWeekday() {
                return weekday;
            }

            public void setWeekday(String weekday) {
                this.weekday = weekday;
            }

            public String getSuit() {
                return suit;
            }

            public void setSuit(String suit) {
                this.suit = suit;
            }

            public String getLunarYear() {
                return lunarYear;
            }

            public void setLunarYear(String lunarYear) {
                this.lunarYear = lunarYear;
            }

            public String getLunar() {
                return lunar;
            }

            public void setLunar(String lunar) {
                this.lunar = lunar;
            }

            public String getYearmonth() {
                return yearmonth;
            }

            public void setYearmonth(String yearmonth) {
                this.yearmonth = yearmonth;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            @Override
            public String toString() {
                return "DataBean{" +
                        "avoid='" + avoid + '\'' +
                        ", animalsYear='" + animalsYear + '\'' +
                        ", weekday='" + weekday + '\'' +
                        ", suit='" + suit + '\'' +
                        ", lunarYear='" + lunarYear + '\'' +
                        ", lunar='" + lunar + '\'' +
                        ", yearmonth='" + yearmonth + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "CaldendarBen{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
