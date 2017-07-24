package cuit.edu.cn.tool;

import org.junit.runners.JUnit4;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lijie on 2017/7/21.
 */

public class GetCourse {
  static final int CLASS_COURSE=1;
  static final int CLASSROOM_COURSE=2;
  static final int TEACHER_COURSE=3;
  static final int MY_COURSE=0;

  static Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("http://pkxt.cuit.edu.cn/") // 设置 网络请求 Url
    .build();

  //从文件中获取数据
  public static void getMyCourse(){

  }

  public static void getClassCourse(){

    //步骤4:创建Retrofit对象


    // 步骤5:创建 网络请求接口 的实例
    CourseInterface request = retrofit.create(CourseInterface.class);

    //对 发送请求 进行封装(设置需要翻译的内容)
    Call<ResponseBody> call = request.getCall();

    //步骤6:发送网络请求(异步)
    call.enqueue(new Callback<ResponseBody>() {
      //请求成功时回调
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        // 请求处理,输出结果
        // 输出翻译的内容
        try {
          System.out.println("翻译是22："+ response.body().string().toString());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      //请求失败时回调
      @Override
      public void onFailure(Call<ResponseBody> call, Throwable throwable) {
        System.out.println("请求失败");
        System.out.println(throwable.getMessage());
      }
    });
  }


  interface CourseInterface{
    @POST("showfunction.asp?user=guest&passwd=guest&B1=%CC%E1+%BD%BB")
    @FormUrlEncoded
    Call<ResponseBody> getCall();
    //采用@Post表示Post方法进行请求（传入部分url地址）
    // 采用@FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
    // 需要配合@Field使用
  }

}
