# DIGDATA Data Engineer Code Test

## Task1(task1.py)

Here we are given a JSON file 'key_metrics.json' which is a response from a web analytics reporting API. The response from the API comprises of page_views,visits, unqiue_visitors,
and bounce_data of the website. 

Here all the required parameters are read from JSON file and a list of dictionary files is written to a JSON file and output is printed.

Command to run the task1 file.

Run time is printed as standard output(0.017216205596923828)

python task1.py 'input_file_path' 'output_file_path'


## Task2(task2.py)

Here we are given a JSON file 'products.json' which gives us the product traffics for top countries/cities for a single day.  

In this web analytics API, the dimensions (e.g.product, country and city) are referred to as “elements. Based on the elements breakdown is done.

Here all the required parameters are read from JSON file and a list of dictionary files is written to a JSON file and the output is printed.

Run time is printed as standard output(0.10983824729919434)

Command to run the task1 file.

python task2.py 'input_file_path' 'output_file_path'

## Task3

Here we are receiving the pageviews for each product_name by country and city.

On a single day, with the help of this data, we could predict traffic on the websites for the upcoming days by using time series algorithms.

We could predict the website traffic for an ecommerce website on a sales day or an festival.

We could also alert any product owners by prediciting whether there might be a sharp reduction in the page views to their websites.

We could also alert product owners if there is a sharp spike in page_views on their websites due to any malicious activities.
