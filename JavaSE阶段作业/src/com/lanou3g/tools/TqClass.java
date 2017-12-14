package com.lanou3g.tools;

import java.util.List;

public class TqClass {


    /**
     * date : 20171214
     * message : Success !
     * status : 200
     * city : 北京
     * count : 118
     * data : {"shidu":"34%","pm25":47,"pm10":63,"quality":"良","wendu":"-6","ganmao":"极少数敏感人群应减少户外活动","yesterday":{"date":"13日星期三","sunrise":"07:26","high":"高温 0.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":46,"fx":"东风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},"forecast":[{"date":"14日星期四","sunrise":"07:27","high":"高温 0.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":47,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"15日星期五","sunrise":"07:28","high":"高温 4.0℃","low":"低温 -6.0℃","sunset":"16:50","aqi":54,"fx":"无持续风向","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"},{"date":"16日星期六","sunrise":"07:29","high":"高温 2.0℃","low":"低温 -8.0℃","sunset":"16:50","aqi":30,"fx":"西北风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"17日星期日","sunrise":"07:29","high":"高温 5.0℃","low":"低温 -8.0℃","sunset":"16:51","aqi":74,"fx":"西南风","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"18日星期一","sunrise":"07:30","high":"高温 6.0℃","low":"低温 -5.0℃","sunset":"16:51","aqi":50,"fx":"西北风","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 34%
         * pm25 : 47.0
         * pm10 : 63.0
         * quality : 良
         * wendu : -6
         * ganmao : 极少数敏感人群应减少户外活动
         * yesterday : {"date":"13日星期三","sunrise":"07:26","high":"高温 0.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":46,"fx":"东风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"}
         * forecast : [{"date":"14日星期四","sunrise":"07:27","high":"高温 0.0℃","low":"低温 -5.0℃","sunset":"16:50","aqi":47,"fx":"南风","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"15日星期五","sunrise":"07:28","high":"高温 4.0℃","low":"低温 -6.0℃","sunset":"16:50","aqi":54,"fx":"无持续风向","fl":"3-4级","type":"多云","notice":"悠悠的云里有淡淡的诗"},{"date":"16日星期六","sunrise":"07:29","high":"高温 2.0℃","low":"低温 -8.0℃","sunset":"16:50","aqi":30,"fx":"西北风","fl":"<3级","type":"晴","notice":"天气干燥，请适当增加室内湿度"},{"date":"17日星期日","sunrise":"07:29","high":"高温 5.0℃","low":"低温 -8.0℃","sunset":"16:51","aqi":74,"fx":"西南风","fl":"<3级","type":"晴","notice":"晴空万里，去沐浴阳光吧"},{"date":"18日星期一","sunrise":"07:30","high":"高温 6.0℃","low":"低温 -5.0℃","sunset":"16:51","aqi":50,"fx":"西北风","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 13日星期三
             * sunrise : 07:26
             * high : 高温 0.0℃
             * low : 低温 -5.0℃
             * sunset : 16:50
             * aqi : 46.0
             * fx : 东风
             * fl : <3级
             * type : 晴
             * notice : 天气干燥，请适当增加室内湿度
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 14日星期四
             * sunrise : 07:27
             * high : 高温 0.0℃
             * low : 低温 -5.0℃
             * sunset : 16:50
             * aqi : 47.0
             * fx : 南风
             * fl : <3级
             * type : 阴
             * notice : 阴天没有晴天的明朗，却依然明亮
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
