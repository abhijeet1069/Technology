package security;

import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.Enumeration;

public class SecurityApp {
	public static void main(String[] args) {
		ProtectionDomain domain1 = "".getClass().getProtectionDomain();
		PermissionCollection pc = Policy.getPolicy().getPermissions(domain1);
		
		
		Enumeration e1 = pc.elements();
		for(;e1.hasMoreElements(); ) {
			Permission per = (Permission)e1.nextElement();
			System.out.println(per);
		}
	}
}
