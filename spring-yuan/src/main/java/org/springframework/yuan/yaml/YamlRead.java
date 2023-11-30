package org.springframework.yuan.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlRead {

	public Map<String,Object> getYamlMap(String path){
		Yaml yaml = new Yaml();
		InputStream inputStream = this.getClass()
				.getClassLoader()
				.getResourceAsStream(path);
        return yaml.load(inputStream);
	}
}
