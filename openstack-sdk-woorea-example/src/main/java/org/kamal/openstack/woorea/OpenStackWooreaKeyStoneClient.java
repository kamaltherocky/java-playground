package org.kamal.openstack.woorea;

import com.woorea.openstack.base.client.OpenStackResponseException;
import com.woorea.openstack.keystone.model.Access;
import com.woorea.openstack.keystone.model.authentication.UsernamePassword;
import com.woorea.openstack.keystone.Keystone;

/**
 * Created by kmuralidharan on 12/12/2014.
 */

public class OpenStackWooreaKeyStoneClient {

	/**
	 * Authenticate against Keystone using Credentials (username / password)
	 * 
	 * @param endpoint
	 * @param username
	 * @param password
	 * @return
	 * @throws OpenStackResponseException
	 */
	public Access authenticateWithCredentials(String endpoint, String username,
			String password) throws OpenStackResponseException {
		Keystone keystone = new Keystone(endpoint);
		UsernamePassword auth = new UsernamePassword(username, password);
		Access access = keystone.tokens().authenticate(auth).execute();
		return access;
	}
}
