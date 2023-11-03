---
layout: default.md
title: "Chen Jin Yang's Project Portfolio Page"
---

## Project: Flagship

Flagship is a desktop application used to help aspiring students track internship applications. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about () kLoC.

## Summary of contributions

* **Code contributed**:
    * Refactored the AB3 models and interfaces so that they can be repurposed for Flagship
        * E.g. Adding new parameters, renaming interfaces, etc.
    * Oversaw the development of the Create Command, which allows users to key in internship details into Flagship.
    * Overall in charge of the following files
      * ApplicationStatus.java
      * CompanyName.java
      * Deadline.java
      * Duration.java
      * Internship.java
      * Role.java
      * StartDate.java
      * Requirement.java
      * CreateCommandParser.java
      * ParserUtil.java
      * CreateCommand.java
      * UniqueInternshipList.java
      * DeadlineTest.java
      * InternshipTest.java
      * RequirementTest.java
      * CreateCommandTest.java
      * InternshipStorageManagerTest.java
      * JsonAdaptedInternshipTest.java
      * JsonInternshipBookStorageTest.java
      * JsonSerializableInternshipBookTest.java
      * JsonInternshipUserPrefsStorageTest.java
    * Wrote test cases to comprehensively test the Create Command
    * [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=jinyang628&tabRepo=AY2324S1-CS2103T-W17-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

* **New Feature**: Create command
    * What it does: _**create**_ an internship in Flagship
    * Justification: Flagships needs to be able to store internship information
    * Highlights
      * Internship requirements are extremely flexible (users can input any number of requirements)
      * Internship details can be keyed in any order
      * Purposeful equality definition that strikes a balance between error detection and user flexibility 
    * (Pull requests [\#19](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/19), [\#75](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/75))

* **Documentation**:
  * User Guide:
    * Overall in charge of the user guide - Managed all the content that is not command specific 
    * Managed the _**Create command**_ part of the User Guide
    * Pull requests [\#36](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/36), [\#116](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/116)
  * Developer Guide:
    * Managed the _**Create command**_ and **Storage** part of the Developer Guide
    * Pull requests [\#130](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/130)

* **Project management**:
  * Set deadlines during meetings and push everyone to finish their work on time
  * Managed milestone `v1.3`, `v1.4` and assigned the issues on GitHub

* **Community**:
  * Non-trivial PRs reviewed with detailed comments:
    [\#23](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/23),
    [\#57](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/57),
    [\#69](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/69),
    [\#88](https://github.com/AY2324S1-CS2103T-W17-1/tp/pull/88)
  * Reported bugs and suggestions for other teams in the class (examples: to be added soon)

* **Tools**:
  * Utilised 'org.junit.jupiter:junit-jupiter-params:5.7.0' to reduce code duplications in test cases
