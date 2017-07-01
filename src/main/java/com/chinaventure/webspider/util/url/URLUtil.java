package com.chinaventure.webspider.util.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import com.chinaventure.webspider.util.CookieUtil;

import net.kernal.spiderman.worker.download.Downloader;

public class URLUtil {
	private static List<Downloader.Cookie> cookieList = new ArrayList<>();
	private static boolean isCookie = false;

	public static HashMap<String, String> ParseQueryString(String query) {
		return ParseQueryString(query, "utf-8");
	}

	public static HashMap<String, String> ParseQueryString(String query, String encoding) {
		if (query == null) {
			throw new NullPointerException("query");
		}
		if (encoding == null) {
			throw new NullPointerException("encoding");
		}
		if ((query.length() > 0) && (query.charAt(0) == '?')) {
			query = query.substring(1);
		}
		return FillFromString(query, false, encoding);
	}

	private static HashMap<String, String> FillFromString(String s, Boolean urlencoded, String encoding) {
		HashMap<String, String> httpValueCollectionMap = new HashMap<String, String>();
		try {
			int num = (s != null) ? s.length() : 0;
			for (int i = 0; i < num; i++) {
				int startIndex = i;
				int num4 = -1;
				while (i < num) {
					char ch = s.charAt(i);
					if (ch == '=') {
						if (num4 < 0) {
							num4 = i;
						}
					} else if (ch == '&') {
						break;
					}
					i++;
				}
				String str = null;
				String str2 = null;
				if (num4 >= 0) {
					str = s.substring(startIndex, num4);
					str2 = s.substring(num4 + 1, i);
				} else {
					str2 = s.substring(startIndex, i);
				}
				if (urlencoded) {
					httpValueCollectionMap.put(URLDecoder.decode(str, encoding), URLDecoder.decode(str2, encoding));
				} else {
					httpValueCollectionMap.put(str, str2);
				}
				if ((i == (num - 1)) && (s.charAt(i) == '&')) {
					httpValueCollectionMap.put(null, "");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return httpValueCollectionMap;
	}

	public static void fillRequestHeader(Downloader.Request request, String referer) {
		if (request != null) {
			request.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			request.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.59 Safari/537.36");
			request.addHeader("X-Requested-With", "XMLHttpRequest");
			request.addHeader("Referer", referer);
			request.addHeader("Accept-Encoding", "gzip,deflate");
			request.addHeader("Accept-Language", "en-us,en");

			// request.addCookie("emstat_bc_emcount", "38614422101921477329");
			// request.addCookie("emstat_ss_emcount", "0_1498148878_182160029");
			// request.addCookie("st_pvi", "29896496352739");
			// request.addCookie("st_si", "96428275923244");
			// if (cookieList != null && !cookieList.isEmpty()) {
			if (isCookie == true) {
				// addCookies(request);
			} else {
				isCookie = true;
				request.addCookie(".ASPXAUTH",CookieUtil.getProperty(".ASPXAUTH"));
				request.addCookie("ct",CookieUtil.getProperty("ct"));
				request.addCookie("ut",CookieUtil.getProperty("ut"));
				request.addCookie("pi",CookieUtil.getProperty("pi"));
				
//				request.addCookie(".ASPXAUTH",
//						"153FD5DF08667A00DD7889B0A5A0F83A038990EB762A1025E18450FD6CF39EC19ACBD6BF62CE381249608CE9BF9BFD30CEE109F4B7526C2C909E06CF5032F2E098404D1E7E6C97F4275901FB46FB96507D425DF5123A40D03CDC3EE1427864E77BC3ADF04ABFC50D56659ED5CF66E2355A0AC215F12CDA60C8C1EFF39A61CFF2557C98F99B92A9FF1BBE9D6F4C2106478BC96756E30719D621F6267C3215DC2175ACCCECB4421392758DC1A11275A8D5987516A201D9E8DAC74F04A12AAE87798BFD1EA35EBE07741979ABAF514FCD3693A8DA82233380AB35F64ADBF42AC914E4E4CF927637B4B2EBE46054A6BC912906680621A83CC96A35B8DA5FC5401BEA955076F43DF3337A056DF936F83276BB21A50E65745E6C86C75B7015E4A1061FC5CCE32FF77CA1755ECDAB3C327EDE6C8384F0502B4EAFF11DB6D5D3F214AAC68DA7244A812430E311ED2A9DEEE79DC0DDA3EFA11D50D8D87B764946999F06DDE790C77ECADCBE369FC2FAB61AF5E38BE05B6E1A57462C7546ED395024B3F5B2");
//				request.addCookie("ct",
//						"GpsOSOdKUxCPVsvFss0Xr2MYvDJ0lasEHLV8LYOLt0ykGRAnp-6ScKRvpxQySSYat2JP_gLOTCt12cj5_uTrTQSiiJwyHsDQluZNA66qkJOQk6igIIqAH8VC4-DT_VrVEJ1qzO6a6whdvQQqHmTa-DurIQN98P8SwXOVJdzIVYk");
//				request.addCookie("ut",
//						"FobyicMgeV7N4wKlQW1dCpaaWGbOSAWCNNKaAJ91PzKYVmJtwL6KhSA7wOjEhqiDyxvpO2O19z8DF8EYDhqY0O8w9_BUsONJxDmrb76EW4H0l6lVu3MqcDrlOgkBTZUPeRrm9vnS5-f6vMq1rupkd4PRRomkUwhcqifBXuY_nCx5JgvxERBTpxkqtPeqEZ5k2YnioH8-jUQgia9ZdT_PYkVe2wkC4wQIPjWGrUshkgwJnDgfXAiWKbt6bwq9_dy027_GgHuH49uK3_dC1tQlpMadL12OHZAo6ELuQalQrOT1nQdCP8bgykdvxujFvmoV");
//				request.addCookie("pi",
//						"2968044966403974%3bx2968044966403974%3b%e8%82%a1%e5%8f%8bUZNFas%3bILjUPRaxuIZhH8sk6TitOXlvjfAS6xR3CcLpCMKVvIKQ4NeSxt164D4rOWOzccs06UuUb7hIM4ea6Z%2brGqVoebPp%2biZrY8BBcK8Xsazio39Yep4IefPwodb2Esj1AckLX6wdAOpW22FFn%2f2mVLOp%2fTpAmzqhoFJnil%2f2O8QZ9BF40WmLNRzxoxMxHw26InrPaZdRSYmn%3bJnKkAaoObsS38EG9TJkwTYsEX%2bG133VyX4HfauJYenrJ3GfEjcyJ%2fwNI4yW3YHTVcbMwBgkc9v1StPlC006sUwtQsenAgMy8h0y1ziu6LXrxAL5XI%2bQKBfY4DPPVaFe0MB47hWNMf%2bDe4TKg8Bl2dl6F9gZ0Pg%3d%3d");
			}
		}

	}

	public static void setCookies(List<Downloader.Cookie> cookies) {
		cookieList = cookies;
	}

	public static void insertCookies(List<Cookie> cookies) {
		if (cookies == null || cookies.isEmpty()) {
			return;
		}
		if (cookieList != null) {
			cookieList.clear();
		}
		for (int i = 0; i < cookies.size(); i++) {
			cookieList.add(new Downloader.Cookie(cookies.get(i).getName(), cookies.get(i).getValue()));
		}
	}

	public static void addCookies(Downloader.Request request) {
		if (cookieList != null && !cookieList.isEmpty()) {
			for (int i = 0; i < cookieList.size(); i++) {
				Downloader.Cookie tmp = cookieList.get(i);
				request.addCookie(tmp.getName(), tmp.getValue());
			}
		}
	}
}
