package com.example.analysisretrofit;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

import Model.IpModel;
import Model.User;
import annotationapi.IpService;
import annotationapi.IpServiceForPath;
import annotationapi.UploadFileForPart;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
    @author  zhenglize
    使用Retrofit发送Http请求
*/
public class RetrofitMainActivity extends AppCompatActivity {
    //主机（Host）
    String url="http://ip.taobao.com/service/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendHttpRequest();
    }
    private void sendFileRequest(){
        //创建Retrofit对象,建造者模式，请求的URL是拼接而成的
        Retrofit retrofit=new Retrofit.Builder()
                //绑定主机
                .baseUrl(url)
                //增加返回值为Json支持
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建接口实例
       UploadFileForPart uploadFileForPart= retrofit.create(UploadFileForPart.class);
       //读取图片
        File file=new File(Environment.getDataDirectory(),"text.png");
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part photo=MultipartBody.Part.createFormData("photos",
                "test.png",requestBody);
        //调用接口方法
        Call<User> call = uploadFileForPart.updateUser(photo, RequestBody.create(null,
                "test"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    //使用拼接URL的方式传输URL数据
    private void sendHttpRequest() {
        //创建Retrofit对象,建造者模式，请求的URL是拼接而成的
        Retrofit retrofit=new Retrofit.Builder()
                            //绑定主机
                            .baseUrl(url)
                            //增加返回值为Json支持
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        //动态代理获取接口对象
        IpService ipService=retrofit.create(IpService.class);
        IpServiceForPath ipServiceForPath=retrofit.create(IpServiceForPath.class);
        //调用接口中的方法，得到返回值Call对象
        Call<IpModel> call=ipService.getIpMsg();
        //@path注解，与上面不同的是需要在调用接口的时候，传入你要传的参数
        Call<IpModel> call2=ipServiceForPath.getIpMsg("path");
        //使用Retrofit发送异步HTTP请求
        call.enqueue(new Callback<IpModel>() {
            //发送请求之后回调的两个函数，onResponse是成功的，onFailure是失败的
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                //提取返回值country，toast出来。
                // 若想要同步请求则使用call.execute();
                //返回的CallBack是在UI线程执行的
                //若想要中断网络请求可以使用call.cancel（）
                String country=response.body().getData().getCountry();
                Toast.makeText(getApplicationContext(),country,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {

            }
        });
    }
}
