# Kristalball QA Automation

This repository contains automated UI tests for the Kristalball Web Application using Java, Selenium WebDriver, and TestNG.

## Prerequisites
- **Java Development Kit (JDK):** Version 17 or higher.
- **Google Chrome:** Needs to be installed on your local machine.

## How to Run Tests Locally
This project uses the Gradle Wrapper, which automatically handles downloading the required Gradle version for you.

To run the tests, open your terminal in the root of the project and execute:

**Windows (PowerShell or Command Prompt):**
```powershell
.\gradlew test
```

**Mac/Linux:**
```bash
./gradlew test
```

You will see the Chrome browser pop up locally as the tests execute. 

## Running in CI (GitHub Actions)
The project is fully configured to run automatically via GitHub Actions.

A workflow runs every time code is pushed to the `main` or `master` branch, or when a Pull Request is opened.
When running in GitHub Actions, the tests automatically detect the environment (via the `CI=true` environment variable) and run Google Chrome in **headless mode**. This ensures the tests pass smoothly on CI servers without a display.
