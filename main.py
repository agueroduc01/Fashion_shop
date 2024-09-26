import pyodbc 
from typing import Union
import pickle
import pandas as pd
from sklearn.preprocessing import LabelEncoder,MinMaxScaler
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
import collections, numpy
import numpy as np
import pyodbc
# pip install SQLAlchemy
from sqlalchemy.engine import URL
from sqlalchemy import create_engine
# Some other example server values are
# server = 'localhost\sqlexpress' # for a named instance
# server = 'myserver,port' # to specify an alternate port
sv='DESKTOP-4UNL892'
db='Fashion_shop'
pwd="tt"

server = 'DESKTOP-4UNL892,1433' 
database = 'Fashion_Shop' 
username = 'sa' 
password = 'tt' 

connection_string = "DRIVER={ODBC Driver 17 for SQL Server};SERVER="+sv+";DATABASE="+db+";UID=sa;PWD="+pwd
connection_url = URL.create("mssql+pyodbc", query={"odbc_connect": connection_string})


from fastapi import FastAPI

app = FastAPI()


@app.get("/")
def read_root():
    return {"Hello": "World"}


@app.get("/cluster")
def cluster():
    try:
        engine = create_engine(connection_url)

        query = "SELECT ID,IDCategory,Price,Brand,Gender,ReleaseTime,ProductType,ProductMaterial FROM Product"
        df = pd.read_sql(query, engine)
        df.replace(np.NaN, 0, inplace=True)
        print(df)

        list_ID=df["ID"].values.tolist()
        df.drop(['ID'], axis=1, inplace=True)

        X=df
        brandInt=X['Brand']
        typeInt=X['ProductType']
        genderInt=X['Gender']
        clothInt=X['ProductMaterial']
        le = LabelEncoder()

        # https://brandirectory.com/rankings/apparel/table
        X['Brand'] = np.where(X['Brand'] == 'Nike', 10, 
        np.where(X['Brand'] == 'Louis Vuitton', 9,
        np.where(X['Brand'] == 'GUCCI', 8,
        np.where(X['Brand'] == 'Chanel', 7,
        np.where(X['Brand'] == 'Adidas', 6,
        np.where(X['Brand'] == 'Hermes', 5,
        np.where(X['Brand'] == 'ZARA', 4,
        np.where(X['Brand'] == 'H&M', 3,
        np.where(X['Brand'] == 'Cartier', 2,
        np.where(X['Brand'] == 'UNIQLO', 1,
        0))))))))))
        # X['Brand'] = le.fit_transform(X['Brand'])
        # brandInt = le.transform(brandInt)
        X['ProductType'] = le.fit_transform(X['ProductType'])
        typeInt = le.transform(typeInt)
        X['Gender'] = le.fit_transform(X['Gender'])
        genderInt = le.transform(genderInt)
        X['ProductMaterial'] = le.fit_transform(X['ProductMaterial'])
        clothInt = le.transform(clothInt)

        price_max = X['Price'].max()
        price_min = X['Price'].min()
        delta = (price_max - price_min) / 3

        fpoint = price_min + delta
        spoint = price_max - delta

        X['Price'] = np.where(X['Price'] < fpoint, 0, X['Price'])
        X['Price'] = np.where((X['Price'] >= fpoint) & (X['Price'] <= spoint), 1, X['Price'])
        X['Price'] = np.where(X['Price'] > spoint, 2, X['Price'])

        cols = X.columns
        ms = MinMaxScaler()

        X = ms.fit_transform(X)
        X = pd.DataFrame(X, columns=[cols])
        # print(X.head())

        print(find_K(X))
        kmeans = KMeans(n_clusters=find_K(X), random_state=0) 
        cluster_list=kmeans.fit_predict(X)
        # save model
        with open("C:/Users/THANHTRUNG/OneDrive - student.ptithcm.edu.vn/Desktop/eclipse_workspace/do-an-phat-trien-cac-he-thong-thong-minh/model.pkl", "wb") as f:
            pickle.dump(kmeans, f)
        # In list cụm:
        print(cluster_list)
        # Lấy số lượng trong mỗi cụm
        print(collections.Counter(cluster_list))    


        # print(df[df.columns[0]].count())
        # updating_cluster="UPDATE Product SET ProductCluster=1 where Product.ID<10"

        for i in range(df[df.columns[0]].count()):
            engine.execute('UPDATE Product SET ProductCluster='+ str(cluster_list[i]) + ' where Product.ID='+str(list_ID[i]))

        return {"code": 200, "message": "success"}
    except Exception as e:
        print(e)
        return {"code": 500, "message": "failed"}

def find_K(dataset):
    distortions = []
    K = range(1,10)
    for k in K:
        kmeanModel = KMeans(n_clusters=k)
        kmeanModel.fit(dataset)
        distortions.append(kmeanModel.inertia_)
        #   print(kmeanModel.inertia_)
    
    for i in range(1, len(distortions)):
        if distortions[i] / distortions[i-1] > 0.93:
            return i

@app.get("/get-history-cluster/{session_id}")
def get_history_cluster(session_id: str, q: Union[str, None] = None):
    try:
        engine = create_engine(connection_url)
        history_query = "SELECT Product.ID, IDCategory, Price, Brand, Gender, ReleaseTime, ProductType, ProductMaterial FROM (SELECT * FROM History WHERE SessionID = '{0}') AS H INNER JOIN Product ON Product.ID = H.ProductID".format(session_id)
        query = "SELECT ID, IDCategory, Price, Brand, Gender, ReleaseTime, ProductType, ProductMaterial FROM Product"
        df_history = pd.read_sql(history_query, engine)
        df = pd.read_sql(query, engine)
        df = pd.concat([df, df_history])
        df.replace(np.NaN, 0)
        print(df)

        list_ID=df["ID"].values.tolist()
        df.drop(['ID'], axis=1, inplace=True)
        X=df
        brandInt=X['Brand']
        typeInt=X['ProductType']
        genderInt=X['Gender']
        clothInt=X['ProductMaterial']
        le = LabelEncoder()

        # https://brandirectory.com/rankings/apparel/table
        X['Brand'] = np.where(X['Brand'] == 'Nike', 10, 
        np.where(X['Brand'] == 'Louis Vuitton', 9,
        np.where(X['Brand'] == 'GUCCI', 8,
        np.where(X['Brand'] == 'Chanel', 7,
        np.where(X['Brand'] == 'Adidas', 6,
        np.where(X['Brand'] == 'Hermes', 5,
        np.where(X['Brand'] == 'ZARA', 4,
        np.where(X['Brand'] == 'H&M', 3,
        np.where(X['Brand'] == 'Cartier', 2,
        np.where(X['Brand'] == 'UNIQLO', 1,
        0))))))))))
        # X['Brand'] = le.fit_transform(X['Brand'])
        # brandInt = le.transform(brandInt)
        X['ProductType'] = le.fit_transform(X['ProductType'])
        typeInt = le.transform(typeInt)
        X['Gender'] = le.fit_transform(X['Gender'])
        genderInt = le.transform(genderInt)
        X['ProductMaterial'] = le.fit_transform(X['ProductMaterial'])
        clothInt = le.transform(clothInt)

        price_max = X['Price'].max()
        price_min = X['Price'].min()
        delta = (price_max - price_min) / 3

        fpoint = price_min + delta
        spoint = price_max - delta

        X['Price'] = np.where(X['Price'] < fpoint, 0, X['Price'])
        X['Price'] = np.where((X['Price'] >= fpoint) & (X['Price'] <= spoint), 1, X['Price'])
        X['Price'] = np.where(X['Price'] > spoint, 2, X['Price'])
        
        cols = X.columns
        ms = MinMaxScaler()

        X = ms.fit_transform(X)
        X = pd.DataFrame(X, columns=[cols])
        X = X.tail(n=len(df_history))
        X = X.mean(axis=0)

        # load model
        with open("C:/Users/THANHTRUNG/OneDrive - student.ptithcm.edu.vn/Desktop/eclipse_workspace/do-an-phat-trien-cac-he-thong-thong-minh/model.pkl", "rb") as f:
            kmeans = pickle.load(f)
        cluster_id = kmeans.predict([[X[0], X[1], X[2], X[3], X[4], X[5], X[6]], ])[0]
        return {"code": 200, "cluster": int(cluster_id)}

    except Exception as e:
        print(e)
        return {"code": 500, "message": "failed"}