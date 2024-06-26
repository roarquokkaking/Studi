package manager.dao;

import manager.bean.ManagerDTO;
import manager.bean.ManagerReport;
import manager.bean.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Mapper
public interface ManagerDAO {
    public List<Map<String, Object>> getTodayMember();
    public List<Map<String, Object>> boardUpload();

    public List<ManagerDTO> getUserList(int startNum);
    public int getTotalA();

    public int getTotalA2(Map<String, Object> map);

    public List<ManagerDTO> getUserList2(Map<String, Object> map);

    List<Map<String, Object>> pichart1();

    List<Map<String, Object>> pichart2();

    void registerNotice(Map<String, String> map);

    List<NoticeDTO> getNotice();

    void notiDelete(int id);

    List<ManagerReport> getReport();

    List<ManagerReport> reportSelect(int reportNum);

    void reportStatus(Map<String,String> map);

    void reportUser(Map<String, String> map);

    List<String> pichart3();

    void userBan(Map<String, String> map);

    void userBanInsert(Map<String, String> map);
}
