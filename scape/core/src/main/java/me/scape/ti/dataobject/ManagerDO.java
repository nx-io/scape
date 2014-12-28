package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 管理员。
 * 
 * @author WangJianZheng E-mail:zing.wang@look.com
 * @version 1.0.0
 * @since 2014年12月21日 上午01:30:00
 */
@Entity
@Table(name = "manager", catalog = "scape")
@NamedQueries({ @NamedQuery(name = "ManagerDO.getByEmail", query = "FROM ManagerDO WHERE email = ?") })
public class ManagerDO implements Serializable {

    private static final long serialVersionUID = 5660189006433341336L;

    public static final byte ACTIVE = 1;
    public static final byte INACTIVE = 0;
    public static final byte DELETED = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;// 用户名

    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;// 邮箱/账号

    @Column(name = "role_id", nullable = false)
    private Integer role_id;

    @Column(name = "password", nullable = false, length = 64)
    private String password;// 密码

    @Column(name = "salt", nullable = false, length = 64)
    private String salt;// 密码salt

    @Column(name = "avatar", length = 255)
    private String avatar;// 头像

    @Column(name = "status", nullable = false)
    private Byte status;// 状态，1:可用，0:不可用，-1:删除

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date last_login;// 最后一次登录的时间

    @Column(name = "last_ip", nullable = false)
    private Long last_ip;// 最后一次登录的IP

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    private Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified")
    private Date gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Long getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(Long last_ip) {
        this.last_ip = last_ip;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
        result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((last_ip == null) ? 0 : last_ip.hashCode());
        result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
        result = prime * result + ((salt == null) ? 0 : salt.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ManagerDO other = (ManagerDO) obj;
        if (avatar == null) {
            if (other.avatar != null)
                return false;
        } else if (!avatar.equals(other.avatar))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (gmt_created == null) {
            if (other.gmt_created != null)
                return false;
        } else if (!gmt_created.equals(other.gmt_created))
            return false;
        if (gmt_modified == null) {
            if (other.gmt_modified != null)
                return false;
        } else if (!gmt_modified.equals(other.gmt_modified))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (last_ip == null) {
            if (other.last_ip != null)
                return false;
        } else if (!last_ip.equals(other.last_ip))
            return false;
        if (last_login == null) {
            if (other.last_login != null)
                return false;
        } else if (!last_login.equals(other.last_login))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (role_id == null) {
            if (other.role_id != null)
                return false;
        } else if (!role_id.equals(other.role_id))
            return false;
        if (salt == null) {
            if (other.salt != null)
                return false;
        } else if (!salt.equals(other.salt))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

}