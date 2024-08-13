
# Number System Converter Application

![Static Badge](https://img.shields.io/badge/Build-passing-flat)
[![Static Badge](https://img.shields.io/badge/Coverage-100%25-flat)](https://jacobnatural.github.io/numbers_converter/jacoco/index.html)
[![Static Badge](https://img.shields.io/badge/docs-blue)](https://jacobnatural.github.io/numbers_converter/apidocs/index.html)
## Overview
This application allows the conversion of numbers from one specified numerical base (ranging from 2 to 9) 
to another numerical base. If the target base is the same as the source base, the application saves the 
conversion logic to a separate file. All components of the application are thoroughly tested using JUnit.

## Getting Started


### Prerequisites

- **Java Development Kit (JDK) 22+**
- **Apache Maven 3.9.6+**

### Example File

- Sample input data in a text file (`data.txt`) should be formatted as follows:
```text
# The format is: <source_base> <target_base> <number_in_source_base>
2 4 101010  
3 5 102211  
6 3 1522001
```
### Cloning the repository:
- To clone the repository and navigate into the project directory, run:

```bash
git clone https://github.com/JacobNatural/numbers_converter.git
cd numbers_converter
```


### Running the application:
- To build the application and run it:
```bash
mvn clean package -DskipTests
cd target  
java --enable-preview -jar numbers-converter-1.0.jar
```

### Running Tests
- To execute the tests, use the following command:
```bash
mvn clean test
```


### Integrate into Your Project
- If you want to use this application as a dependency in another Maven project, 
first install it into your local Maven repository by running:
```bash
mvn clean install -DskipTests
```
- Then, you can add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.app</groupId>
    <artifactId>numbers-converter</artifactId>
    <version>1.0</version>
</dependency>
```


## Contributing

We welcome contributions to improve the Number System Converter Application. Here's how you can contribute:

1. Fork the repository on GitHub.
2. Make enhancements or fix issues in your forked copy.
3. Submit a pull request to merge your changes into the main repository.

Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.

