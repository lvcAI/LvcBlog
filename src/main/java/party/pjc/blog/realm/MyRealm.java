package party.pjc.blog.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import party.pjc.blog.model.User;
import party.pjc.blog.service.UserService;

public class MyRealm extends AuthorizingRealm {


	@Autowired
	private UserService userService;
	
	/**
	 * 角色和权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		
			authorizationInfo.setRoles(userService.getRoles(userName));
			authorizationInfo.setStringPermissions(userService.getPermissions(userName));
		
		return authorizationInfo;
	}

	/**
	 * 登陆认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
			User user=userService.getByUserName( userName);
			System.out.println("user:"+user);
			if(user!=null){
				AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),"xx");
				return authcInfo;
			}else{
				return null;
			}
		
		
	}

}
