# CurrencyConverter

CurrencyConverter is a tool designed to calculate the final value of an amount in any target currency, based on the exchange rates published by the National Bank of Poland (NBP). The application retrieves the latest exchange rates from the XML file published by NBP and ensures accurate and secure conversions between currencies.

## Features
- Fetches and parses the latest exchange rates from [NBP XML file](https://www.nbp.pl/kursy/xml/lasta.xml).
- Converts a specified amount from any source currency to a target currency.
- Ensures data validation to prevent incorrect user input.
- Implements object-oriented principles with a focus on SOLID and the Singleton design pattern.
- Provides a user-friendly interface for entering amounts and selecting currencies.

## Architecture
- **SOLID Principles:** The project structure is designed with single responsibility, open/closed principles, and clear separation of concerns in mind.
- **Singleton Pattern:** Ensures a single instance of the exchange rate manager for consistent data across the application.
- **Class Decomposition:** The solution includes separate classes for parsing exchange rates, handling currency conversion logic, and managing user interaction.

## Usage
1. Start the application.
2. Enter the amount and select the source currency.
3. Select the target currency.
4. View the calculated result based on the latest exchange rates.

## Requirements
- Internet connection to fetch the latest exchange rates.
- A programming environment capable of running the chosen implementation language (e.g., Python, Java, C++).
- Libraries for XML parsing (specific to the chosen language).

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/swpiotr5/currencyconverter.git
