package user.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter @Getter
@ToString
public class UserDTO {

    private String name;
    private String userId; //DTO , jsp의 name이랑 mapper의 명칭?
    private String pwd;
    private String skill;
    private String phone;
    private String email;
    //    private String zipCode;
//    private String addr1;
//    private String addr2;
    private Date hiredate;
}