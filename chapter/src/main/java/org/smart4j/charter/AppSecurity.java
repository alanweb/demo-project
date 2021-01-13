package org.smart4j.charter;

import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.plugin.security.SmartSecurity;

import java.util.Set;

/**
 * 应用安全控制
 */
public class AppSecurity implements SmartSecurity {
    @Override
    public String getPassword(String username) {
        String sql = "select password from t_user where username =? ";
        return DatabaseHelper.query(sql,username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql="select role_name from t_user u,t_user_role ur,t_role r where u.id = ur.user_id and ur.role_id=r.id and username = ?";
        return DatabaseHelper.querySet(sql,username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "select permission_name from t_permission p ,t_role_permission rp ,t_role r where r.id = rp.role_id and p.id = rp.permission_id and role_name =?";
        return DatabaseHelper.querySet(sql,roleName);
    }

    public static void main(String[] args) {
        String sql="select role_name from t_user u,t_user_role ur,t_role r where u.id = ur.user_id and ur.role_id=r.id and username = ?";
        System.out.println(DatabaseHelper.querySet(sql,"vn04wcu"));
    }
}
