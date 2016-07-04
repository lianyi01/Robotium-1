package Untils;

import redis.clients.jedis.Jedis;

public class RedisUtils {
	public static String getCode(String phone) {
		String code = null;
		if (null != phone || "" != phone || phone.length() != 11) {
			Jedis jedis = new Jedis("139.219.12.51", 30303);
			code = jedis.get(phone);
		}
		return code;
	}
}
