package main.java.shera.controller;

import java.util.List;
import main.java.shera.model.MasterData;

public interface MasterDataController {

    MasterData getMasterData(int id);

    List<MasterData> getAllMasterData();

    boolean insertMasterData(MasterData masterData);

    boolean updateMasterData(MasterData masterData, int id);

    boolean deleteMasterData(int id);
}
