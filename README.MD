
# Number System Converter Application

## Overview

#### This application allows conversion of numbers from a specified numerical base range `<2, 9>` to another numerical base. If the target base is the same as the source base, the application saves the code to a separate file.

## Example File

- Sample input data txt file format:

2,4,101010  
3,5,102211  
6,3,1522001  


## Components

### [App.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/app/App.java)

- Main class of the application showcasing usage.

### [Format.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/formmat/Format.java)
 - A class responsible for a single object

Contain fields:
- `entrySystemCode`
- `expectedSystemCode`
- `code`

Provides method:
- **'public boolean validateFormat()'**: The method checks if the entrySystemCode is consistent with the code.
- **'public boolean isDuplicated()'**: The  method checks if the entrySystemCode is the same as the expectedSystemCode
- **'public String transformCode()'**: The method converts the code to the expectedSystemCode.

### [FormatServiceImpl.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/formmat_service/impl/FormatServiceImpl.java)

- Contains methods for converting codes and saving transformations to a file.

#### Contain field:
- `private final FormatRepositoryImpl formatRepository'

#### Provides method:

- **`public Map<Type, String> transform()`**: Converts code to the expected format.
- **`public void saveTransformToTxt(String filename, SaveToTxt<String> saveToTxt, Type type)`**: Saves the conversion to a file.

### [FormatLineParser.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/parser/impl/FormatLineParser.java)


#### Contains fields:
- `private final String regex`
- `private final Validator<Format> validator`

#### Provides method:
- **`public Format parse(String line)`**: Parses a line of text into a `Format` object.

### [FormatRepositoryImpl.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/repository/impl/FormatRepositoryImpl.java)
- The class retrieves data from a text file and returns a list of Format objects.

#### Contains field:

- `private final List<Format> formats`

#### Provides method:
- **`public List<Format> getAll()`**: Retrieves all `Format` objects from the repository.

### [AbstractLoadFromTxt.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/txt/load/generic/AbstractLoadFromTxt.java)

- Generic class for loading data from a file.

#### Contains fields:
- `private final TransferTxt<T> transferTxt;`
- `private final LineParser<T> lineParser;`

#### Provides method:
- **`List<T> load(String filename)`**: Loads data of type `T` from a file.

### [FormatTxtLoadImpl.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/txt/load/impl/FormatTxtLoadImpl.java)
- Implement 'AbstractLoadFromTxt' constructor 
 
### [AbstractSaveToTxt.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/txt/save/generic/AbstractSaveToTxt.java)

- Generic class for saving data to a file.

#### Contains fields:
- `private final TransferTxt<T> transferTxt;`
- `private final LineParser<T> lineParser;`

#### Provides method:
- **`void save(String filename, T t, Function<T, String> prepare)`**: Saves data of type `T` to a file.

### [StringTxtSaveImpl.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/txt/save/impl/StringTxtSaveImpl.java)
- Implement 'AbstractSaveToTxt' constructor

### [TransferTxt.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/txt/transfer/impl/TransferTxt.java)

#### Contains methods:
- **`public List<T> read(String filename, LineParser<T> lineParser)`**: Reads data from a file using the specified `LineParser`.
- **`public void write(String filename, T t, Function<T, String> prepare)`**: Writes data to a file using the specified preparation function.

### [Type.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/type/Type.java)

- Enum defining types of data entries.

- `transformed`: Indicates transformed data.
- `duplicated`: Indicates duplicated data.

### [FormatValidator.java](https://github.com/JacobNatural/Numbers_Converter/blob/master/src/main/java/com/app/validate/impl/FormatValidator.java)

- Validates `Format` objects against specified criteria.

#### Contains methods:

- **`public String validate(Format format)`**: Checks if `entrySystemCode` matches `expectedSystemCode`.

## [Testing and Coverage](https://jacobnatural.github.io/Numbers_Converter/)

- All components of the application are thoroughly tested using JUnit, achieving 89% code coverage.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 22
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)


### Cloning the repository:

```Bash
git clone https://github.com/JacobNatural/Numbers_Converter.git
cd Numbers_Converter
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

Integrate into Your Project:
Import the necessary packages (format, parser, repository, txt, transfer, type, validate) into your Java project.
Utilize the classes and methods provided to handle conversions, data loading, saving, and validation within your own applications.
Contributing
We welcome contributions to improve the Number System Converter Application. Here's how you can contribute:

Fork the repository on GitHub.
Make enhancements or fix issues in your forked copy.
Submit a pull request to merge your changes into the main repository.
Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.

