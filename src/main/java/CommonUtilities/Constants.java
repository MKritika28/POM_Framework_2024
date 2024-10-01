package CommonUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String HOME_PAGE_TITLE = "My Account";
	public static final int SHORT_TIMEOUT = 5;
	
	public static final String LOGIN_ERROR_MESSAGE = " Warning: No match for E-Mail Address and/or Password.";
	public static final String PRODUCT_PAGE = "ProductDetails";

	public static List<String> getExpectedAccountPageHeaderLinks() {
		List<String> ExpectedAccountPageHeaderLinks = new ArrayList<String>();
		ExpectedAccountPageHeaderLinks.add("My Account");
		ExpectedAccountPageHeaderLinks.add("My Orders");
		ExpectedAccountPageHeaderLinks.add("My Affiliate Account");
		ExpectedAccountPageHeaderLinks.add("Newsletter");
		return ExpectedAccountPageHeaderLinks;
	}
	
}
