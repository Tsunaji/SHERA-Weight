package main.java.com.shera.sheraweight.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.com.shera.sheraweight.model.MasterData;
import main.java.com.shera.sheraweight.util.ConfigManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MasterDataControllerImpl implements MasterDataController {

    Logger logger = Logger.getLogger(MasterDataControllerImpl.class.getName());

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ConfigManager cm = new ConfigManager();
    Gson gson = new Gson();

    @Override
    public MasterData getMasterData(int id) {
        String url = cm.getHostServerAPI() + "/weight/masterData/" + id;
        MasterData masterData = null;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                masterData = gson.fromJson(response.body().string(), MasterData.class);
            }
        } catch (IOException ex) {
            Logger.getLogger(MasterDataControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return masterData;
    }

    @Override
    public List<MasterData> getAllMasterData() {
        List<MasterData> masterDatas = new ArrayList<>();
        String url = cm.getHostServerAPI() + "/weight/masterData";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
            } else {
                masterDatas = gson.fromJson(response.body().string(), new TypeToken<List<MasterData>>() {
                }.getType());
            }
        } catch (IOException ex) {
            Logger.getLogger(MasterDataControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return masterDatas;
    }

    @Override
    public boolean insertMasterData(MasterData masterData) {
        String url = cm.getHostServerAPI() + "/weight/vehicles";
        String json = gson.toJson(masterData);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateMasterData(MasterData masterData, int id) {
        String url = cm.getHostServerAPI() + "/weight/vehicle/" + id;
        String json = gson.toJson(masterData);

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(LoginControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean deleteMasterData(int id) {
        String url = cm.getHostServerAPI() + "/weight/masterData/" + id;

        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.log(Level.SEVERE, response.toString());
                return false;
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MasterDataControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
