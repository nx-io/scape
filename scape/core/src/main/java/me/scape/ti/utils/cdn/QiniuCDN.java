package me.scape.ti.utils.cdn;

import java.io.InputStream;

import me.scape.ti.constant.CommonConstant;
import me.scape.ti.constant.GlobalProperties;

import org.apache.commons.lang3.StringUtils;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.net.CallRet;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;

public final class QiniuCDN implements CDN {

	private static Mac MAC;

	static {
		Config.ACCESS_KEY = GlobalProperties.CDN_ACCESS_KEY.trim();
		Config.SECRET_KEY = GlobalProperties.CDN_SECRET_KEY.trim();
		MAC = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
	}

	@Override
	public String uploadFile(InputStream in, String fileName) throws Exception {
		PutExtra extra = new PutExtra();
		PutRet putRet = null;
		putRet = IoApi.Put(getUptoken(), fileName, in, extra);
		if (!putRet.ok()) {
			throw new Exception("File upload error");
		}

		return putRet.getKey();
	}

	@Override
	public boolean deleteFile(String path) {
		CallRet callRet = new RSClient(MAC).delete(GlobalProperties.CDN_BUCKET_NAME.trim(), path);

		return callRet.ok();
	}

	@Override
	public String getHttpPath(String path) {
		String url = null;
		if (isFullURL(path)) {
			url = path;
		} else if (StringUtils.isNotBlank(path)) {
			url = GlobalProperties.CDN_DOMAIN.concat(GlobalProperties.CDN_DOMAIN.endsWith(CommonConstant.SEPARATOR) ? "" : CommonConstant.SEPARATOR).concat(path);
		}

		return url;
	}

	private String getUptoken() {
		PutPolicy putPolicy = new PutPolicy(GlobalProperties.CDN_BUCKET_NAME.trim());
		String uptoken = null;
		try {
			uptoken = putPolicy.token(MAC);
		} catch (Exception e) {
		}

		return uptoken;
	}

	private boolean isFullURL(final String url) {
		boolean flag = false;
		if (StringUtils.isNotBlank(url)) {
			flag = url.toLowerCase().startsWith("http");
		}
		return flag;
	}

}
