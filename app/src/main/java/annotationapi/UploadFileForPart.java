package annotationapi;

import Model.User;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UploadFileForPart {
    /**
        @author zhenglize
        Multipart表示允许多个@part
     @param photo 准备上传的图片文件
     @param description 传递简单的键值对
    */
    @Multipart
    @POST("user/photo")
    Call<User> updateUser (@Part MultipartBody.Part photo,@Part("description") RequestBody description);
}
