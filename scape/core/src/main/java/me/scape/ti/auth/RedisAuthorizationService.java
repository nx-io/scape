package me.scape.ti.auth;

import me.scape.ti.auth.request.PrivilegedRequest;
import me.scape.ti.auth.request.LoginRequest;
import me.scape.ti.auth.response.PrivilegedResponse;
import me.scape.ti.auth.response.LoginResponse;
import me.scape.ti.redis.RedisCallback;
import me.scape.ti.redis.RedisTemplate;
import me.scape.ti.utils.GuidUtils;
import me.scape.ti.utils.PasswdUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author 刘飞 E-mail:liufei_it@126.com
 * @version 1.0.0
 * @since 2015年3月8日 下午6:40:29
 */
public class RedisAuthorizationService implements AuthorizationService {

	protected final Log log = LogFactory.getLog(getClass());

	private RedisTemplate redisTemplate;

	private static final int DEFAULT_TOKEN_EXPIRES_IN_SEC = 60 * 60 * 24 * 30;

	@Override
	public LoginResponse doLogin(LoginRequest request) {
		final String appId = request.getApp_id();
		final String secretId = request.getSecret_id();
		final String open_id = redisTemplate.execute(new RedisCallback<String>() {
			@Override
			public String doInRedis(Jedis jedis) throws Throwable {
				String openId = GuidUtils.guid();
				// 将应用系统的用户ID关联到open_id
				jedis.hset(appId, openId, secretId);
				return openId;
			}
		});
		return redisTemplate.execute(new RedisCallback<LoginResponse>() {
			@Override
			public LoginResponse doInRedis(Jedis jedis) throws Throwable {
				String access_token = PasswdUtils.signPwsswd(open_id, secretId);
				int expires_in = DEFAULT_TOKEN_EXPIRES_IN_SEC;
				// 设置access_token的过期时间
				jedis.setex(open_id, expires_in, access_token);
				return new LoginResponse(appId, open_id, access_token, expires_in);
			}
		}, LoginResponse.DEFAULT_RESPONSE);
	}

	@Override
	public PrivilegedResponse doPrivileged(PrivilegedRequest request) {
		final String appId = request.getApp_id();
		final String open_id = request.getOpen_id();
		final String access_token = request.getAccess_token();
		return redisTemplate.execute(new RedisCallback<PrivilegedResponse>() {
			@Override
			public PrivilegedResponse doInRedis(Jedis jedis) throws Throwable {
				String _access_token = jedis.get(open_id);
				if (StringUtils.isEmpty(_access_token)) {
					return PrivilegedResponse.DEFAULT_RESPONSE;
				}
				if (!StringUtils.equals(_access_token, access_token)) {
					return PrivilegedResponse.DEFAULT_RESPONSE;
				}
				String secretId = jedis.hget(appId, open_id);
				if (StringUtils.isEmpty(secretId)) {
					return PrivilegedResponse.DEFAULT_RESPONSE;
				}
				return new PrivilegedResponse(secretId);
			}
		}, PrivilegedResponse.DEFAULT_RESPONSE);
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
