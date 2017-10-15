package org.picenter.pictest;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TmpTest {
	
	public static void main(String[] args) {
		TestLayout layout = new TestLayout();
		layout.setPatternsProperty("id|name|customerName|memberName|bankAccountName|platformUserName|bankcardHolder|firstContactName|secondContactName|repayAccountName-1-0,password-0-0,phone|mobilePhone|bindPhone|bankcardPhone|contactNumber|firstContactPhone|secondContactPhone-3-4,certificateNumber|cashOutAccountNo|bankcardNumber|bankAccountNo|repayAccountNo-6-4");
		String testStr = "fetch data from LoanContract -- {\"platformUserName\":\"liudehua\",\"certificateNumber\":\"123456111117890\",\"annualRate\":0.010000,\\\"bankAccountName\\\":\\\"dog188\\\",\"bankAccountNo\":\"6214850212331638\",\"firstContactName\":\"��������\",\"bidFeeRate\":0.000000,\"firstContactPhone\":\"2017082800000001\",\"bizLoanSerialNo\":\"2017082800000001\",\"cashOutAccountNo\":\"6214850212331638\",\"cashOutDay\":1,\"certificateNumber\":\"110111199001013753\",\"certificateType\":0,\"createBy\":\"101\",\"firstContactPhone\":1503883996000,\"dayAnnualRate\":0.000028,\"id\":1129,\"loanAmount\":30000.000000,\"loanApplicationNo\":\"17082809281394100003\",\"loanContractNo\":\"20170828000000700004\",\"memberName\":\"dog188\",\"memberNo\":\"e405eed5f9df4d9c9120dac26927d529\",\"misusePenaltyScale\":1.000000,\"mobilePhone\":\"11100008188\",\"modifyBy\":\"101\",\"modifyTime\":1503883996000,\"monthFeeRate\":0.020000,\"overDuePenaltyScale\":1.000000,\"payFrequencyType\":\"1\",\"penaltyRate\":0.020000,\"platformUserName\":\"110111199001013753\",\"prepayPenaltyRate\":0.005000,\"productId\":7,\"productType\":0,\"purposeType\":\"TRAVEL\",\"repaymentType\":\"RPT-01\",\"residentialAddress\":\"�˾˼�\",\"signFinishTime\":1503916099000,\"specificId\":\"PTYG00018\",\"termmonth\":24,\"yearDays\":360}";
		System.out.println(layout.doLayout(testStr));
	}

}

class TestLayout {

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
					regxBuilder.append("\\\\?\"?(");
					regxBuilder.append(patterns[0]);
					regxBuilder.append(")\\\\?\"?\\s*(=|:)\\s*\\\\?\"?([^(,|\\]|\\)|\\}|\\\\|\")]*)\\\\?\"?");
					List<Integer> locations = Lists.newArrayList();
					locations.add(Integer.valueOf(patterns[1]));
					locations.add(Integer.valueOf(patterns[2]));
					this.patternGroup.put(Optional.of(Pattern.compile(regxBuilder.toString(), Pattern.MULTILINE)),
							locations);
				}
			}
		}
	}

	public String doLayout(String content) {
		final StringBuilder message = new StringBuilder("Desensitize ofc pattern --- ");
		message.append(content);

		try {
			if (patternGroup.size() > 0) {
				for (Optional<Pattern> pattern : patternGroup.keySet()) {
					Matcher matcher = pattern.get().matcher(message);
					List<Integer> locations = patternGroup.get(pattern);
					while (matcher.find()) {
						int group = 3;
						if (group <= matcher.groupCount() && matcher.group(group) != null) {
							for (int i = matcher.start(group) + locations.get(0); i < (matcher.end(group) - locations.get(1)); i++) {
								message.setCharAt(i, '*');
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message.toString();
	}

}
