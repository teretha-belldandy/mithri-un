package net.picenter.pictest;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class PatternMatcherDemo {

	public static void main(String[] args) {
		DesensitizePatternLayout layout = new DesensitizePatternLayout();
		layout.setPatternsProperty(
				"id|name-1-0,password-0-0,phone|mobilePhone-3-4,certificateNumber-6-8");
		String message = "\\\"phone\\\":\\\"abcdefghij\\\"";
		System.out.println(layout.doLayout(message));
	}

	@SuppressWarnings("unused")
	private static void showDemo() {
		Pattern p = Pattern.compile("([a-z]+)(\\d*)([a-z]+)");
		Matcher m = p.matcher("aaa2223bb1111ccc333dddd55555");
		while (m.find()) {
			System.out.println("------------------------");
			System.out.println("count : " + m.groupCount());
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.println(m.start(i));
				System.out.println(m.end(i));
				System.out.println(m.group(i));
				System.out.println("--------");
			}
		}
	}
}

class DesensitizePatternLayout {

	private String patternsProperty;
	private Map<Optional<Pattern>, List<Integer>> patternGroup;

	public String getPatternsProperty() {
		return patternsProperty;
	}

	public void setPatternsProperty(String patternsProperty) {
		this.patternsProperty = patternsProperty;
		if (null == patternGroup)
			patternGroup = Maps.newHashMap();
		String[] patternArray = StringUtils.split(patternsProperty, ',');

		for (String patternCube : patternArray) {
			if (StringUtils.isNotBlank(patternCube)) {
				String[] patterns = StringUtils.split(patternCube, '-');
				if (patterns.length >= 3) {
					StringBuilder regxBuilder = new StringBuilder();
					regxBuilder.append("\\\\*\"?(");
					regxBuilder.append(patterns[0]);
					regxBuilder.append(")\\\\*\"?\\s*(=|:)\\s*\\\\*\"?([^(,|\\]|\\)|\\}|\")]*)\\\\*\"?");
					List<Integer> locations = Lists.newArrayList();
					locations.add(Integer.valueOf(patterns[1]));
					locations.add(Integer.valueOf(patterns[2]));
					this.patternGroup.put(Optional.of(Pattern.compile(regxBuilder.toString(), Pattern.MULTILINE)),
							locations);
				}
			}
		}
		System.out.println("patternGroup size is " + patternGroup.size());
	}

	public String doLayout(String str) {
		final StringBuilder message = new StringBuilder(str);

		if (patternGroup.size() > 0) {
			for (Optional<Pattern> pattern : patternGroup.keySet()) {
				Matcher matcher = pattern.get().matcher(message);
				List<Integer> locations = patternGroup.get(pattern);
				while (matcher.find()) {
					int group = 3;
					if (group <= matcher.groupCount() && matcher.group(group) != null) {
						System.out.println(matcher.group(3));
						for (int i = matcher.start(group) + locations.get(0); i < matcher.end(group)
								&& (0 == locations.get(1)
										|| i < (matcher.start(group) + locations.get(0) + locations.get(1))); i++) {
							if (matcher.group(3).equals("15111111111")) {
								System.out.println(i);
							}
							message.setCharAt(i, '*');
						}
					}
				}
			}
		}

		return message.toString();
	}
}
