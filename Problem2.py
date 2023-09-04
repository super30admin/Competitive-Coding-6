'''
1. We need to find the orders made by each user which is buyer in Orders table. Filter the rows that have order date's year as 2019.
2. Group on buyer_id and count the number of orders made using size/count method.
3. Right join this df to users and fill nas with 0 as we need all users in our result.
'''
import pandas as pd

def market_analysis(users: pd.DataFrame, orders: pd.DataFrame, items: pd.DataFrame) -> pd.DataFrame:
    df = orders[orders['order_date'].apply(lambda x: x.year==2019)].groupby(['buyer_id'])['order_id'].size()
    df = users.merge(df,how='left',left_on='user_id',right_on='buyer_id').fillna(0).rename(columns={'user_id':'buyer_id','order_id':'orders_in_2019'})
    return df[['buyer_id','join_date','orders_in_2019']]
    