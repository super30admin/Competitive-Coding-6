'''
1. First, fetch the ids which do not fall under 1st quarter
2. Next, find out which are sold in q1
3. We need to find those products that were sold ONLY in q1 so we take the ids not in first df but belong to second df
'''



import pandas as pd

def sales_analysis(product: pd.DataFrame, sales: pd.DataFrame) -> pd.DataFrame:
    df1 = sales[(sales['sale_date']>'2019-03-31') | (sales['sale_date']<'2019-01-01')]
    df2 = sales[(sales['sale_date'] >= '2019-01-01') & (sales['sale_date'] <= '2019-03-31')]
    res = product[(~product['product_id'].isin(df1['product_id'])) &(product['product_id'].isin(df2['product_id'])) ][['product_id','product_name']]
    return res 