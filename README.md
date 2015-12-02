# Simple Stocks

This is a simple Java application does following calculations - 

a. For a given stock 
        
	a.i. calculate the dividend yield
	a.ii. calculate the P/E Ratio
	a.iii. record a trade, with time stamp, quantity of shares, buy or sell indicator and price
	a.iv. Calculate Stock Price based on trades recorded in past 15 minutes
b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

![Data and formula tables](https://raw.githubusercontent.com/arya610/SimpleStock/master/data_and_formula_tables.png)

### Assumption -

Any stock which has not been traded in last 15 minutes, has not been considered for stock price calculation.

### Design -

This program uses various design patterns popular in Java to make it loosely coupled and extensible in future. For eg. DAO and Factory patterns are used
to separate out data access logic and object creation logic respectively.

### Running/Testing -
This program is using Java 1.8 and to run this program or to check all requirements as given in the description are met, one can run the Tests inside "test" folder.

