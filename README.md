# 🚀 Jenkins CI/CD Pipeline with Automated Quality Gates  

This project demonstrates a *production-style CI/CD pipeline* built using *Jenkins*, where automated tests decide whether the application gets deployed.  

## 🔹 Core Workflow
*GitHub Commit → Jenkins Trigger → Automated Tests → Quality Gate → Deploy to AWS EC2* ✅  

## 🔹 Features
- Pulls both *Application Repo* (HTML/CSS/JS) and *Automation Test Repo*.  
- Executes regression tests using *Java, Selenium, TestNG, Maven (POM Framework)*.  
- Enforces *Quality Gates* → Deployment stops immediately if tests fail ❌.  
- On passing tests ✅ → Deploys to *AWS EC2* via SSH, restarts *Nginx*, and serves the app live.  
- *JUnit reports* integrated into Jenkins for visibility.  

## Automation folder structure

CICD/
├── src/
│ ├── main/java/com/Conference/
│ │ ├── Base/
│ │ │ └── TestBase.java # Base setup/teardown for tests
│ │ ├── ConfigReader.java # Reads environment properties
│ │ ├── DriverFactory.java # WebDriver initialization & management
│ │ ├── enums/ # Enum constants
│ │ ├── listeners/ # TestNG Listeners (logging, reporting, etc.)
│ │ ├── Pages/ # Page Object Model classes
│ │ └── utils/ # Utilities (ExcelUtils, WaitUtils, LoggerUtils, etc.)
│ ├── main/resources/
│ │ ├── prod.properties # Production environment config
│ │ └── dev.properties # Development environment config
│ └── test/java/com/Conference/TestPage/
│ ├── LoginTest.java # Data-driven login tests
│ ├── HomeTest.java # Home page validation tests
│ └── PaperSubmissionTest.java # Paper submission workflow tests
├── test/resources/
│ └── suites/ # TestNG XML suite files
├── log4j2.xml # Log4j configuration
├── LoginTestData.xlsx # Test data for login
├── extentReports/ # Extent HTML reports
├── logs/ # Execution logs (automation.log, regression.xml, etc.)
├── screenshots/ # Screenshots captured on failures
├── pom.xml # Maven dependencies
└── test-output/ # Default TestNG reports
  

## 🔹 Tech Stack
- *CI/CD Tool:* Jenkins  
- *Automation Framework:* Java + Selenium + TestNG + Maven (POM design)  
- *Cloud Provider:* AWS EC2 (Ubuntu)  
- *Web Server:* Nginx  
- *Source Control:* GitHub  

## 🔹 Pipeline Stages
1. *Checkout App Repo* → Clones web application.  
2. *Checkout Test Repo* → Clones Selenium automation framework.  
3. *Run Tests* → Executes TestNG regression suite.  
4. *Quality Gate* → Stops if tests fail.  
5. *Deploy to AWS* → Copies files, updates /var/www/html/, restarts Nginx.  

## 🔹 Next Steps
- Containerize build with *Docker*.  
- Scale deployments with *Kubernetes*.  
- Add monitoring & reporting dashboards.  

---

💡 *If you’re exploring CI/CD as a QA/SDET:*  
Clone this repo, set up Jenkins on an EC2 instance, and try connecting your own framework. It’s the fastest way to get real-world hands-on CI/CD experience.  

---

## 📌 Author
👤 *Bhagavath Shankar*  
QA Engineer | SDET 

📫 Connect on [LinkedIn](https://www.linkedin.com/in/bhagavath-shankar-625a792b9) 
