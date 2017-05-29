package com.example.administrator.lecturesmanagerdemo.base;



import com.example.administrator.lecturesmanagerdemo.bean.CollectionListResult;
import com.example.administrator.lecturesmanagerdemo.bean.CommentListResult;
import com.example.administrator.lecturesmanagerdemo.bean.EnrollListResult;
import com.example.administrator.lecturesmanagerdemo.bean.IpInfo;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesDetail;
import com.example.administrator.lecturesmanagerdemo.bean.LecturesResult;
import com.example.administrator.lecturesmanagerdemo.bean.Movies;
import com.example.administrator.lecturesmanagerdemo.bean.TokenResult;
import com.example.administrator.lecturesmanagerdemo.bean.User;
import com.example.administrator.lecturesmanagerdemo.bean.UserHttpResult;
import com.example.administrator.lecturesmanagerdemo.bean.UserResult;
import com.example.administrator.lecturesmanagerdemo.bean.VideoResult;
import com.example.administrator.lecturesmanagerdemo.bean.baseResult;
import com.example.administrator.lecturesmanagerdemo.bean.queryuserenrollBydate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API--接口  服务[这里处理的是同一的返回格式 resultCode  resultInfo Data<T> --->这里的data才是返回的结果,T就是泛型 具体返回的been对象或集合]
 * Created by HDL on 2016/8/3.
 */
public interface APIService {
    /**
     * 用户登录的接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return RxJava 对象
     */
    @POST("okhttp/UserInfoServlert")
    Observable<UserHttpResult<TokenResult>> userLogin(@Query("username") String username, @Query("pwd") String pwd);


    /**
     * 查询豆瓣排名前250的电影
     *
     * @param start 从第几部开始
     * @param count 几页(一页有12部)
     * @return
     */
    @POST("v2/movie/top250")
    Observable<Movies> getMovies(@Query("start") int start, @Query("count") int count);

    @POST("api/lecturesQuery")
    Call<LecturesResult> getLectures(@Query("pageNo") int pageNo,@Query("pageSize") int pageSize);

    @POST("api/image")
    Call<IpInfo> getImage( @Query("image") String image,@Query("imagename") String imagename,@Query("userid")long userid);

    @POST("api/lecturesDetailQuery")
    Call<LecturesDetail> getlecturesDetail(@Query("lecturesid") int lecturesid , @Query("userid")long userid);
    @POST("api/queryuserenrollBydate")
    Call<queryuserenrollBydate> queryuserenrollBydate( @Query("userid")long userid,@Query("date") String date );
    @POST("api/spendlecturesComment")
    Call<baseResult> spendlecturesComment(@Query("userid")long userid, @Query("lecturesid") int lecturesid , @Query("commentcontent") String commentcontent);
    @POST("api/lecturesQuerylikelecturesname")
    Call<LecturesResult> queryByPagelikename( @Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("lecturesname") String lecturesname);
    @POST("api/userenroll")
    Call<baseResult>  userenroll(@Query("lecturesid") int lecturesid , @Query("userid")long userid);
    @POST("api/lecturesQuerybyuserid")
    Call<EnrollListResult>  lecturesQuerylikebyuserid(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("userid")long userid);
    @POST("api/querycommentlist")
    Call<CommentListResult>  querycommentlist(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("lecturesid") int lecturesid );
    @POST("api/lecturesCollectionQuerybyuserid")
    Call<CollectionListResult>  lecturesCollectionQuerybyuserid(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("userid")long userid);
    @POST("api/usercollection")
    Call<baseResult>  usercollection(@Query("lecturesid") int lecturesid , @Query("userid")long userid);
    @POST("api/getVideolist")
    Call<VideoResult>  getVideolist();
    @POST("api/getuser")
    Call<UserResult>  getuser(@Query("userid") long userid);
    @POST("api/updateuser")
    Call<baseResult>  updateuser(@Body User user);
    @POST("api/usersignin")
    Call<baseResult>  usersignin(@Query("lecturesid") int lecturesid , @Query("userid")long userid);
}
