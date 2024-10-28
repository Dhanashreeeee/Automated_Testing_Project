package mini;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumscript {

    public static void main(String[] args) {

        // Set up Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Test Case 1: Verify Page Title
            driver.get("http://127.0.0.1:5500/index.html");
            System.out.println("Test Case 1: Verify Page Title");
            String expectedTitle = "Money Tracker - Login";
            String actualTitle = driver.getTitle();
            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);  // Wait 2 seconds before the next test case

            // Test Case 2: Verify Login with Correct Credentials
            System.out.println("Test Case 2: Verify Login with Correct Credentials");
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("1234");
            driver.findElement(By.tagName("button")).click();
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/home.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);

            // Test Case 3: Verify Login with Incorrect Credentials
            System.out.println("Test Case 3: Verify Login with Incorrect Credentials");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys("invalid");
            driver.findElement(By.id("password")).sendKeys("wrongpassword");
            driver.findElement(By.tagName("button")).click();
            String errorMessage = driver.findElement(By.id("error")).getText();
            if (errorMessage.contains("Invalid credentials")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);
            
         // Test Case 4: Verify Login without username
            System.out.println("Test Case 4: Verify Login without username");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys(" ");
            driver.findElement(By.id("password")).sendKeys("wrongpassword");
            driver.findElement(By.tagName("button")).click();
            String errorMessage1 = driver.findElement(By.id("error")).getText();
            if (errorMessage1.contains("Invalid credentials")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);
            
         // Test Case 5: Verify Login without password
            System.out.println("Test Case 5: Verify Login without password");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys("invalid");
            driver.findElement(By.id("password")).sendKeys("");
            driver.findElement(By.tagName("button")).click();
            String errorMessage2 = driver.findElement(By.id("error")).getText();
            if (errorMessage2.contains("Invalid credentials")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);
            
         // Test Case 6: Verify Login without username and password
            System.out.println("Test Case 6: Verify Login without username and password");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys(" ");
            driver.findElement(By.id("password")).sendKeys("");
            driver.findElement(By.tagName("button")).click();
            String errorMessage3 = driver.findElement(By.id("error")).getText();
            if (errorMessage3.contains("Invalid credentials")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);
            
         // Test Case 7: Verify Login with different username different password
            System.out.println("Test Case 7: Verify Login with different username different password");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys("user1");
            driver.findElement(By.id("password")).sendKeys("1234");
            driver.findElement(By.tagName("button")).click();
            String errorMessage4 = driver.findElement(By.id("error")).getText();
            if (errorMessage4.contains("Invalid credentials")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(2000);
            
            // Test Case 8: Add Income Entry without source
            System.out.println("Test Case 8: Add Income Entry without source");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys(" ");
            driver.findElement(By.id("amount")).sendKeys("5000");
            driver.findElement(By.tagName("button")).click();
            if (driver.switchTo().alert().getText().equals("Income added!")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
         // Test Case 9: Add Income Entry
            System.out.println("Test Case 9: Add Income Entry");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys("Freelancing");
            driver.findElement(By.id("amount")).sendKeys("5000");
            driver.findElement(By.tagName("button")).click();
            if (driver.switchTo().alert().getText().equals("Income added!")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            
            // Test Case 10: Add Income Entry without source
            System.out.println("Test Case 10: Add Income Entry without source");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys(" ");
            driver.findElement(By.id("amount")).sendKeys("10000");
            driver.findElement(By.tagName("button")).click();
            if (driver.switchTo().alert().getText().equals("Income added!")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
            

            // Test Case 11: Check Transaction List for Added Entry
            System.out.println("Test Case 11: Check Transaction List for Added Entry");
            driver.get("http://127.0.0.1:5500/transaction.html");
            boolean transactionExists = driver.getPageSource().contains("Freelancing") && driver.getPageSource().contains("5000");
            if (transactionExists) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);

            // Test Case 12: Edit Transaction with change source
            System.out.println("Test Case 12: Edit Transaction with change source");
            driver.findElement(By.xpath("//button[text()='Edit']")).click();
            driver.switchTo().alert().sendKeys("New Source");
            driver.switchTo().alert().accept();
            driver.switchTo().alert().sendKeys("5000");
            driver.switchTo().alert().accept();
            if (driver.getPageSource().contains("New Source") && driver.getPageSource().contains("5000")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
            // Test Case 13: Edit Transaction with change income
            System.out.println("Test Case 13: Edit Transaction with change income");
            driver.findElement(By.xpath("//button[text()='Edit']")).click();
            driver.switchTo().alert().sendKeys("New Source");
            driver.switchTo().alert().accept();
            driver.switchTo().alert().sendKeys("6000");
            driver.switchTo().alert().accept();
            if (driver.getPageSource().contains("New Source") && driver.getPageSource().contains("6000")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 14: Edit Transaction with change source and income
            System.out.println("Test Case 14: Edit Transaction with change source and income");
            driver.findElement(By.xpath("//button[text()='Edit']")).click();
            driver.switchTo().alert().sendKeys("Salary");
            driver.switchTo().alert().accept();
            driver.switchTo().alert().sendKeys("10000");
            driver.switchTo().alert().accept();
            if (driver.getPageSource().contains("Salary") && driver.getPageSource().contains("10000")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);

            // Test Case 15: Delete Transaction with source
            System.out.println("Test Case 15: Delete Transaction with source");
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
            if (!driver.getPageSource().contains("New Source")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
            // Test Case 16: Delete Transaction with income
            System.out.println("Test Case 16: Delete Transaction with income");
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
            if (!driver.getPageSource().contains("10000")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);

            // Test Case 17: Verify Login Redirect on Direct Income Page Access
            System.out.println("Test Case 17: Verify Login Redirect on Direct Income Page Access");
            driver.get("http://127.0.0.1:5500/income.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/index.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 18: Verify home Redirect on Direct login Page Access
            System.out.println("Test Case 18: Verify home Redirect on Direct login Page Access");
            driver.get("http://127.0.0.1:5500/index.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/home.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 19: Verify transaction Redirect on Direct home Page Access
            System.out.println("Test Case 19: Verify transaction Redirect on Direct home Page Access");
            driver.get("http://127.0.0.1:5500/home.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/transaction.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 20: Verify Login Redirect on Direct transaction Page Access
            System.out.println("Test Case 20: Verify Login Redirect on Direct transaction Page Access");
            driver.get("http://127.0.0.1:5500/transaction.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/index.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 21: Verify income Redirect on Direct login Page Access
            System.out.println("Test Case 21: Verify income Redirect on Direct login Page Access");
            driver.get("http://127.0.0.1:5500/index.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/income.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 22: Verify home Redirect on Direct Income Page Access
            System.out.println("Test Case 22: Verify home Redirect on Direct Income Page Access");
            driver.get("http://127.0.0.1:5500/income.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/home.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 23: Verify login Redirect on Direct home Page Access
            System.out.println("Test Case 22: Verify home Redirect on Direct Income Page Access");
            driver.get("http://127.0.0.1:5500/home.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/index.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
            // Test Case 24: Verify transaction Redirect on Direct login Page Access
            System.out.println("Test Case 22: Verify transaction Redirect on Direct login Page Access");
            driver.get("http://127.0.0.1:5500/index.html");
            if (driver.getCurrentUrl().equals("http://127.0.0.1:5500/transaction.html")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
           

            // Test Case 25: Add Multiple Transactions
            System.out.println("Test Case 23: Add Multiple Transactions");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys("Freelancing");
            driver.findElement(By.id("amount")).sendKeys("5000");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().alert().accept();

            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys("Investment");
            driver.findElement(By.id("amount")).sendKeys("10000");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().alert().accept();

            if (driver.getPageSource().contains("Freelancing") && driver.getPageSource().contains("Investment")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
            
         // Test Case 26: Verify Empty Fields on Login
            System.out.println("Test Case 24: Verify Empty Fields on Login");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.tagName("button")).click();
            String errorMessageEmptyFields = driver.findElement(By.id("error")).getText();
            if (errorMessageEmptyFields.contains("Fields cannot be empty")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);

         // Test Case 27: Verify Income Page Input Fields Reset on Form Submission
            System.out.println("Test Case 25: Verify Income Page Input Fields Reset on Form Submission");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys("Gift");
            driver.findElement(By.id("amount")).sendKeys("1000");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().alert().accept();
            String sourceFieldAfterSubmit = driver.findElement(By.id("source")).getAttribute("value");
            String amountFieldAfterSubmit = driver.findElement(By.id("amount")).getAttribute("value");
            if (sourceFieldAfterSubmit.equals("") && amountFieldAfterSubmit.equals("")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);

         // Test Case 28: Verify Adding Multiple Income Entries
            System.out.println("Test Case 26: Verify Adding Multiple Income Entries");
            driver.get("http://127.0.0.1:5500/income.html");
            driver.findElement(By.id("source")).sendKeys("Freelancing");
            driver.findElement(By.id("amount")).sendKeys("4000");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().alert().accept();

            driver.findElement(By.id("source")).sendKeys("Bonus");
            driver.findElement(By.id("amount")).sendKeys("2000");
            driver.findElement(By.tagName("button")).click();
            driver.switchTo().alert().accept();

            if (driver.getPageSource().contains("Freelancing") && driver.getPageSource().contains("Bonus")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);
           
         // Test Case 29: Verify Home Page Content After Login
            System.out.println("Test Case 27: Verify Home Page Content After Login");
            driver.get("http://127.0.0.1:5500/index.html");
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("1234");
            driver.findElement(By.tagName("button")).click();
            boolean homeContentVisible = driver.getPageSource().contains("Welcome, admin");
            if (homeContentVisible) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            Thread.sleep(5000);


         // Test Case 30: Verify Edit Transaction Button is Functional
            System.out.println("Test Case 28: Verify Edit Transaction Button is Functional");
            driver.get("http://127.0.0.1:5500/transaction.html");
            driver.findElement(By.xpath("//button[text()='Edit']")).click();
            String editAlertText = driver.switchTo().alert().getText();
            if (editAlertText.equals("Edit your transaction:")) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
            driver.switchTo().alert().accept();
            Thread.sleep(5000);


        

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser session
            driver.quit();
        }
    }
}
