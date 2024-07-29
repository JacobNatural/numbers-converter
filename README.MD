
# Number System Converter Application

![Static Badge](https://img.shields.io/badge/Build-passing-flat)
[![Static Badge](https://img.shields.io/badge/Coverage-100%25-flat)](https://jacobnatural.github.io/numbers_converter/jacoco/index.html)
[![Static Badge](https://img.shields.io/badge/docs-blue)](https://jacobnatural.github.io/numbers_converter/apidocs/index.html)
## Overview
This application allows conversion of numbers from a specified numerical base range `<2, 9>`
to another numerical base. If the target base is the same as the source base,
the application saves the code to a sep
All components of the application are thoroughly tested using JUnit.

## Getting Started


### Prerequisites

- Java Development Kit (JDK) 22
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Example File

- Sample input data txt file format:

2,4,101010  
3,5,102211  
6,3,1522001

### Cloning the repository:

```Bash
git clone https://github.com/JacobNatural/numbers_converter.git
cd numbers_converter
```
### Building the project using Maven:


```Bash
mvn clean install
```
### Running the application:
```Bash
cd target  
java --enable-preview -jar numbers_converter-1.0.jar
```

  


### Integrate into Your Project

1. Import the necessary packages into your Java project.
2. Utilize the classes and methods provided to handle conversions, data loading, saving, and validation within your own applications.

## Contributing

We welcome contributions to improve the Car Processing Application. Here's how you can contribute:

1. Fork the repository on GitHub.
2. Make enhancements or fix issues in your forked copy.
3. Submit a pull request to merge your changes into the main repository.

Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.

