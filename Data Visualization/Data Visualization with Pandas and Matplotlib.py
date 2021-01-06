#!/usr/bin/env python
# coding: utf-8

# In[76]:


# Importing Some Helpful Data Visualization Packages!
from matplotlib import pyplot as plt
import pandas as pd
import numpy as np


# In[113]:


# Getting a Dataframe from a Given Countries CSV File
df = pd.read_csv("countries.csv")


# In[99]:


## Creating Time Series from Line Charts
# Time Series and Line Sharts show a trend in time, test a hypotheses on a variety of conditions, and reduces misinterpretation of data.

# Retrieving Afghanistan Data From Beyond 1980 and Accessing Population Metrics
afghanistan = df[df["country"] == "Afghanistan"]
afghanistan_1980 = afghanistan[afghanistan["year"] > 1980]
afghanistan_1980_population = afghanistan_1980["population"]

# Retrieving Zimbabwe Data From Beyond 1980 and Accessing Population Metrics
zimbabwe = df[df["country"] == "Zimbabwe"]
zimbabwe_1980 = zimbabwe[zimbabwe["year"] > 1980]
zimbabwe_1980_population = zimbabwe_1980["population"]

# Retrieving Namibia Data From Beyond 1980 and Accessing Population Metrics
namibia = df[df["country"] == "Namibia"]
namibia_1980 = namibia[namibia["year"] > 1980]
namibia_1980_population = namibia_1980["population"]

# Using the iloc() function to determine the growth factors in each year of population shift, with respect to the first charted year.
afghanistan_growth = afghanistan_1980_population / afghanistan_1980_population.iloc[0] * 100
zimbabwe_growth = zimbabwe_1980_population / zimbabwe_1980_population.iloc[0] * 100
namibia_growth = namibia_1980_population / namibia_1980_population.iloc[0] * 100

# Plotting the year of the dataframe as well as the growth numbers for each analyzed country.
plt.plot(afghanistan_1980["year"], afghanistan_growth)
plt.plot(zimbabwe_1980["year"], zimbabwe_growth)
plt.plot(namibia_1980["year"], namibia_growth)

# Adding a title, x and y labels, and a legend to our graph!
plt.title("Comparing the Population Growth Cycles of African States (1980 - 2007)")
plt.xlabel("Years (1980 - 2007)")
plt.ylabel("Population Growth (Starts from 100%)")
plt.legend(["Afghanistan Population Over Time", "Zimbabwe Population Over Time", "Namibia Population Over Time"], loc="upper left")
plt.show()

# This line can be used to save the image as a PNG file in the local directory.
# plt.savefig("African Population Growth Comparison Plot Chart")

# plt.xlim(limit) and plt.ylim(limit) can also be used to set a domain for our graph.


# In[115]:


## Finding Distribution of Data with Histograms
# Histograms allow you to understand the distribution of a numeric value in a way that you cannot with mean or median alone.

# Creating new dataframes storing the data of certain countries.
brazil = df[df["country"] == "Brazil"]
kenya = df[df["country"] == "Kenya"]
netherlands = df[df["country"] == "Netherlands"]

# Printing out the means and medians of each country's population metrics from 1950 to 2000.
print("Mean Population in Brazil from 1952 to 2007: " + str(brazil.population.mean()))
print("Median Population in Brazil from 1952 to 2007: " + str(brazil.population.median()))
print()

print("Mean Population in Kenya from 1952 to 2007: " + str(kenya.population.mean()))
print("Median Population in Kenya from 1952 to 2007: " + str(kenya.population.median()))
print()

print("Mean Population in Netherlands from 1952 to 2007: " + str(netherlands.population.mean()))
print("Median Population in Netherlands from 1952 to 2007: " + str(netherlands.population.median()))

# Using the subplot function to subjugate individual space for each graph.
plt.subplot(3, 1, 1) # Follows the form: number of rows, number of columns, order

# Uses the hist() method to visualize a histogram with a range of x values specified, 15 bins, with a black edge color.
plt.hist(netherlands.population / 1_000_000, 15, range = (0, 30), edgecolor = "black")

# Adds a helpful title and x/y labels for increased readability.
plt.title("Population Distribution in Netherlands")
plt.xlabel("Population (in millions) Ranging from 0 - 30")
plt.ylabel("Number of Occurrences")
plt.show()

# Using the subplot function to subjugate individual space for each graph.
plt.subplot(3, 1, 2)

# Uses the hist() method to visualize a histogram with a range of x values specified, 18 bins, with a black edge color.
plt.hist(kenya.population / 1_000_000, 18, range = (0, 60), edgecolor = "black")

# Adds a helpful title and x/y labels for increased readability.
plt.title("Population Distribution in Kenya")
plt.xlabel("Population (in millions) Ranging from 0 - 60")
plt.ylabel("Number of Occurrences")
plt.show()

# Using the subplot function to subjugate individual space for each graph.
plt.subplot(3, 1, 3)

# Uses the hist() method to visualize a histogram with a range of x values specified, 25 bins, with a black edge color.
plt.hist(brazil.population / 1_000_000, 25, range = (0, 200), edgecolor = "black")

# Adds a helpful title and x/y labels for increased readability.
plt.title("Population Distribution in Brazil")
plt.xlabel("Population (in millions) Ranging from 0 - 200")
plt.ylabel("Number of Occurrences")
plt.show()


# In[118]:


## Examining Relationships in Data with Scatter Plots
# Scatter Plots show relationships between multiple variables and sometimes help you find outliers in data.

# Assigns and plots the relationship between a given year and the population of a country using the scatter() method.
country = df[df["country"] == "United States"]
plt.scatter(country["year"], country["population"] / 1_000_000, 100)

# Titles and adds helpful labels to the graphs for increased readability.
plt.title("United States Population Shift Between 1950 and 2000")
plt.xlabel("Year")
plt.ylabel("Population in Millions")
plt.show()

# Uses the corr() method to determine the amount of correlation between the two variables.
print("Accuracy of Graph: " + str(country["year"].corr(country["population"]) * 100) + " percent.");


# In[111]:


## Comparing Data with Bar Graphs
# Bar Graphs help you compare numerical values, compare multiple values, and sometimes give you new insight.

# Gets all data from the year 2007.
data_2007 = df[df["year"] == 2007]

# Gets the top ten most populous countries by using the sort_values() method and looking at the population from highest to lowest.
top_ten = data_2007.sort_values('population', ascending=False).head(10)

# Uses the range method to generate a list of values from 0 to 9.
x = range(10)

# Calls the bar() method with the list x and the populations of the top ten countries.
plt.bar(x, top_ten["population"] / 1_000_000)

# Uses the xticks() function to denote the bars with their individual country names in a vertical format.
plt.xticks(x, top_ten["country"], rotation='vertical')

# Adds titles, labels, and a legend to the graph for increased readability.
plt.title("10 Most Populous Countries in 2007")
plt.ylabel("Population in Millions")
plt.legend(["Population in Millions"])

plt.show()


# In[ ]:


## Other Helpful Methods

# groupBy(column_name) // groups data and performs any necessary computation you tell it to (e.g. mean())
# quantile(decimal) // finds the given decimal percentile of a set of data (e.g. data.quantile(0.25) finds 25th percentile)
# sample(frac=decimal_value) // uses the specified 'frac' parameter to take a subset of a large dataset (e.g. data.frac(0.1))
# sample(n=sample_amount) // uses the specified 'n' parameter to take a certain number of samples from the dataset
# plt.tight_layout() // separates graphs in a subplot when an overlap is present

# plt.plot() extra parameters
# 'alpha' is used to specify the transparency of the data points
# 'markersize' is used to specify the size of the data points
# 'color' with any color of your choosing changes the color of the graph

