package myprograms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class EmailHandler implements IReporter {
	public static final String EMAIL_SIGNATURE = "<br>Regards<br>Automation Team";
	private static long suiteStartTime;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// You can customize this method to gather information about passed and failed
		// tests
		int totalPassed = 0;
		int totalFailed = 0;

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult result : suiteResults.values()) {
				ITestContext testContext = result.getTestContext();
				totalPassed += testContext.getPassedTests().size();
				totalFailed += testContext.getFailedTests().size();
			}
		}
		
		String reportLink = System.getProperty("ReportLink");
		System.out.println("Reporting =" +reportLink);
		
		try {
			sendEmailWithAutomationResults(reportLink, getEmailList());
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setSuiteStartTime(long startTime) {
		suiteStartTime = startTime;
	}

	public void sendEmailWithAutomationResults(String reportLink,
			List<String> recipientEmails) throws EmailException {
		HtmlEmail email = createHtmlEmail(recipientEmails);
		
		email.setSubject("Automation Suite Execution Summary ");
		// Build the email message
		StringBuilder emailMessage = new StringBuilder();
		emailMessage
				.append("Hi,<br><br>Please find attached the Automation execution summary for " + "<strong>" )
				.append("<span style='font-weight: bold;'>").append("</span><br>");
		emailMessage.append("<span style='font-weight: bold;'>Total Passed Automation Flows: </span>")
				.append("<span style='font-weight: bold;'>").append("</span><br>");
		emailMessage.append("<span style='font-weight: bold;'>Total Failed Automation Flows: </span>")
				.append("<span style='font-weight: bold;'>").append("</span><br><br>");
		emailMessage.append("<span style='font-weight: bold;'>Total Suite Execution Time: </span>")
				.append("<span style='font-weight: bold;'>").append(getFormattedExecutionTime()).append("</span><br>");
		emailMessage.append("<span style='font-weight: bold;'>Executed in: </span>")
				.append("<span style='font-weight: bold;'>").append("</span><br><br>");
		emailMessage.append("Report Link : ").append(reportLink).append("</span><br>");
		emailMessage.append("Feel free to reach out if you have any questions.<br>");
		emailMessage.append(EMAIL_SIGNATURE);

		email.setMsg(emailMessage.toString());

		// Send the email
		email.send();
		System.out.println("email sent");
	}



	public static HtmlEmail createHtmlEmail(List<String> recipientEmails)
			throws EmailException {
		System.out.println("Creating  Report");
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("kinshipautomation01@kinship.co",
				"vjgl qear zmar jkoq"));
		email.setStartTLSRequired(true);
		email.setFrom("kinshipautomation01@kinship.co", "Kinship Automation");

		// Add recipients
		for (String recipientEmail : recipientEmails) {
			email.addTo(recipientEmail);
		}
		return email;
	}

	private String getFormattedExecutionTime() {
		long executionTimeMillis = System.currentTimeMillis() - suiteStartTime;
		long minutes = (executionTimeMillis / 1000) / 60;
		long seconds = (executionTimeMillis / 1000) % 60;
		return minutes + " minutes and " + seconds + " seconds";
	}

	public static String getCSVFilePath(String environment, String OUTPUT_DIRECTORY) {
		File directory = new File(OUTPUT_DIRECTORY);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		return directory.getPath() + File.separator + "brokenlinks_" + environment + ".csv";
	}
	
	public List<String> getEmailList() {
		List<String> list = new ArrayList<String>();
		list.add("maninder.singh.ext@kinship.co");
		return list;
	}
	


}
