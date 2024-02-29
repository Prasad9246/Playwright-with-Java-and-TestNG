# Playwright Script with TestNG Framework

This repository contains a Java-based Playwright script integrated with the TestNG framework for automated testing. Playwright is a Node.js library to automate the browser. It enables reliable automation of web pages across multiple browsers.

## Prerequisites

Before running the tests, ensure you have the following dependencies installed:

- Java Development Kit (JDK)
- Apache Maven
- Node.js (for Playwright)
- TestNG

## Installation

1. Clone this repository:
git clone (https://github.com/Prasad9246/Playwright-with-Java-and-TestNG.git)

2. Install dependencies:
cd your-repo
npm install playwright
npm install @playwright/test

## Running the Tests

Execute the following command to run the tests:


This will trigger the TestNG suite, which will execute the Playwright scripts.

## Viewing Test Reports

### Extent Report

An Extent Report is generated after each test run, providing detailed information about the test results including logs, screenshots, and more. You can find the report in the `extent-reports` directory.

### Screenshots

Screenshots are automatically captured for each test case, allowing you to visually inspect any failures. Screenshots are stored in the `screenshots` directory.

## Project Structure

- `src/test/java`: Contains the Java test classes.
- `src/main/resources`: Contains any additional resources such as configuration files.
- `screenshots`: Stores the screenshots captured during test execution.
- `extent-reports`: Stores the Extent Reports generated after each test run.

## Contributors

- [Prasad Kamble](https://github.com/Prasad9246)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
