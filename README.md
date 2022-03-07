# JavaProjectTemplate

## Overview

### Purpose

<li> The main goal of this project is to reduce development time for QA automation developers by providing template infrastructure for whole projects development lifecycle.
<li> This project contains templates for automation testing of Web, Mobile and Desktop applications.

### Usage
<li> This project was built using JDK version 14, it is recommended to upgrade JDK to version 14.
<li> In case no JDK upgrade was done, pom.xml must be modified according to the relevant JDK version.

![jdkersion](https://user-images.githubusercontent.com/74132643/157055818-3d0738d4-6569-4d8b-9419-dd758b7fcae6.PNG)

<li> Constants class contains configuration parameters (e.g. Platform, Browser Type, Initial URL)
<li> elementsRepo.properties contains elements xpath.
<li> In order to view allure-reports use the following command in terminal: allure serve <"allure reports dir">.
<li> Tests executed with testng xml suites.

### Examples

<li> Web - [TestProject demo website](https://example.testproject.io/web/)
<li> Desktop - Windows Calculator.
<li> Mobile - Eri Bank App.
<li> Web,Desktop and Mobile tests examples can be found under tests package.
<li> Web,desktop and mobile tests are composed of page objects model, business processes and common web actions.

### Infrastructure includes:

<li>Layers (Utilities, Pages, Business process...)
<li>Page object model support
<li>Properties file reading support
<li>Logging system
<li>Support for different client browsers(WebDriver)
<li>Desktop (WinAppDriver) support
<li>Mobile (Appium) testing

### Tools & Frameworks:

<li>TestNG Framework
<li>Customizable TestNG Reports
<li>Selenium Java
<li>Appium Studio & Java-Appium for Mobile Testing
<li>Allure Reports - Reporting System
