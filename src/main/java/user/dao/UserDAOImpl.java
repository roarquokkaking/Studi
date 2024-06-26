package user.dao;

import lombok.RequiredArgsConstructor;
import manager.bean.ManagerUserBan;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import user.bean.UserDTO;
import user.bean.UserIntro;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDao {

    private final SqlSessionTemplate sql;

    public int save(UserDTO userDTO) {
        return sql.insert("USER.save", userDTO);
    }

    public UserDTO login(UserDTO userDTO) {
        return sql.selectOne("USER.login", userDTO);
    }

    public UserDTO findByUserId(String userId) {
        return sql.selectOne("USER.findByUserId", userId);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return sql.selectOne("USER.findByEmail", email);
    }

    public UserIntro getIntro(String userId) {
        return sql.selectOne("USER.getIntro", userId);
    }

    public void writeIntroduce(UserIntro userIntro) {
        sql.insert("USER.writeIntroduce", userIntro);
    }

    public void delete(String userId) {
        sql.delete("USER.delete", userId);
    }

    public void update(UserIntro userIntro) {
        sql.update("USER.update", userIntro);
    }
    @Override
    public boolean isEmailExist(String email) {
        Integer count = sql.selectOne("USER.countByEmail", email);
        return count != null && count > 0;
    }

    @Override
    public UserIntro showProfile(String userid) {
        return sql.selectOne("USER.showProfile",userid);
    }

    @Override
    public String userIconChange(Map<String, String> map) {
        int su =sql.update("USER.userIconChange",map);
        if(su==0){
            sql.insert("USER.userIconInsert",map);
        }

        return "";
    }

    @Override
    public String userIconCheck(String userid) {
        return sql.selectOne("USER.userIconCheck",userid);
    }

    @Override
    public ManagerUserBan findByUserId2(Model model) {
        return sql.selectOne("USER.findByUserId2", model);
    }

    @Override
    public List<Map<String, Object>> scrap(String userId) {
        return sql.selectList("USER.scrap", userId);
    }

    @Override
    public List<Map<String, Object>> whrite(String userId) {
        return sql.selectList("USER.whrite", userId);
    }

}
