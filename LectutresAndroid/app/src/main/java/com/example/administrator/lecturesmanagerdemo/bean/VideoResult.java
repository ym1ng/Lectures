package com.example.administrator.lecturesmanagerdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/21.
 */

public class VideoResult {

    /**
     * code : 200
     * data : [{"videoid":1,"videoname":"1","videocontent":"1233","videourl":"/video/1705191951583576.mp4","videopic":"/video/1705191951583576.jpg","addtime":1493645308000},{"videoid":3,"videoname":"qewww","videocontent":"qqqq","videourl":"/video/1705210841505935.mp4","videopic":"/video/1705210841505935.jpg","addtime":1495184792000},{"videoid":4,"videoname":"aaaa","videocontent":"wwwww","videourl":"/video/1705210843099066.mp4","videopic":"/video/1705210843099066.jpg","addtime":1495184921000},{"videoid":5,"videoname":"qqaazzz","videocontent":"zzzzz","videourl":"/video/1705191712476038.mp4","videopic":"/video/1705191712476038.jpg","addtime":1495185168000}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * videoid : 1
         * videoname : 1
         * videocontent : 1233
         * videourl : /video/1705191951583576.mp4
         * videopic : /video/1705191951583576.jpg
         * addtime : 1493645308000
         */

        private int videoid;
        private String videoname;
        private String videocontent;
        private String videourl;
        private String videopic;
        private long addtime;

        public int getVideoid() {
            return videoid;
        }

        public void setVideoid(int videoid) {
            this.videoid = videoid;
        }

        public String getVideoname() {
            return videoname;
        }

        public void setVideoname(String videoname) {
            this.videoname = videoname;
        }

        public String getVideocontent() {
            return videocontent;
        }

        public void setVideocontent(String videocontent) {
            this.videocontent = videocontent;
        }

        public String getVideourl() {
            return videourl;
        }

        public void setVideourl(String videourl) {
            this.videourl = videourl;
        }

        public String getVideopic() {
            return videopic;
        }

        public void setVideopic(String videopic) {
            this.videopic = videopic;
        }

        public long getAddtime() {
            return addtime;
        }

        public void setAddtime(long addtime) {
            this.addtime = addtime;
        }
    }
}
