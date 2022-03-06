# JavaProjectTemplate

## Overview

### Purpose

<li> The main goal of this project is to reduce development time for QA automation developers.
<li> This project contains templates for automation testing of Web, Mobile and Desktop applications.

### Usage

<li> Constants class contains configuration parameters (e.g. Platform, Browser Type, Initial URL)
<li> elementsRepo.properties contains elements xpath.
<li> In order to view allure-reports use the following command: allure serve <"allure reports dir">.
<li> Tests executed with testng xml suites.

### Examples

<li> Web - [TestProject demo website](https://example.testproject.io/web/)
<li> Desktop - Windows Calculator.
<li> Web and Desktop tests examples can be found under tests package.
<li> Both web and desktop tests are composed of page objects model, business processes and common web actions.

### Infrastructure includes:

<li>Layers (Utilities, Pages, Business process...)
<li>Page object model support
<li>Properties file reading support
<li>Logging system
<li>Support for different client browsers
<li>Desktop (WinAppDriver) support
<li>Mobile (Appium) testing

### Tools & Frameworks:

<li>TestNG Framework
<li>Customizable TestNG Reports
<li>Selenium Java
<li>Appium Studio & Java-Appium for Mobile Testing
<li>Allure Reports - Reporting System
