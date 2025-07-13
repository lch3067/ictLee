package main.util;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlConfig {
	private static final String CONFIG_PATH = "../resources/db-config.xml";
	private String url, username, password;

	private XmlConfig() {
	        try (InputStream is = XmlConfig.class.getResourceAsStream(CONFIG_PATH)) {
	            Document doc = DocumentBuilderFactory.newInstance()
	                .newDocumentBuilder().parse(is);
	            Element root = doc.getDocumentElement();
	            url = root.getElementsByTagName("url").item(0).getTextContent().trim();
	            username = root.getElementsByTagName("username").item(0).getTextContent().trim();
	            password = root.getElementsByTagName("password").item(0).getTextContent().trim();
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to load db-config.xml", e);
	        }
	    }

	public static XmlConfig load() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		static final XmlConfig INSTANCE = new XmlConfig();
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
