import pickle
import pandas as pd
from sklearn.preprocessing import LabelEncoder,MinMaxScaler
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
import collections, numpy
import numpy as np
import pyodbc
import sys
# pip install SQLAlchemy
from sqlalchemy.engine import URL
from sqlalchemy import create_engine

sv='DESKTOP-4UNL892'
db='Fashion_shop'
pwd="tt"

connection_string = "DRIVER={ODBC Driver 17 for SQL Server};SERVER="+sv+";DATABASE="+db+";UID=sa;PWD="+pwd
connection_url = URL.create("mssql+pyodbc", query={"odbc_connect": connection_string})

engine = create_engine(connection_url)

query = "SELECT Product.ID, Price, Brand, Gender, ReleaseTime, ProductType, ProductMaterial FROM (SELECT * FROM History WHERE SessionID = '{0}') AS H INNER JOIN Product ON Product.ID = H.ProductID".format(str(sys.argv[1]))
df = pd.read_sql(query, engine)

list_ID=df["ID"].values.tolist()
df.drop(['ID'], axis=1, inplace=True)
X=df
brandInt=X['Brand']
typeInt=X['ProductType']
genderInt=X['Gender']
clothInt=X['ProductMaterial']
le = LabelEncoder()

X['Brand'] = le.fit_transform(X['Brand'])
brandInt = le.transform(brandInt)
X['ProductType'] = le.fit_transform(X['ProductType'])
typeInt = le.transform(typeInt)
X['Gender'] = le.fit_transform(X['Gender'])
genderInt = le.transform(genderInt)
X['ProductMaterial'] = le.fit_transform(X['ProductMaterial'])
clothInt = le.transform(clothInt)
cols = X.columns
ms = MinMaxScaler()

X = ms.fit_transform(X)
X = pd.DataFrame(X, columns=[cols])
X = X.mean(axis=0)
# load model
with open("C:/Users/THANHTRUNG/OneDrive - student.ptithcm.edu.vn/Desktop/eclipse_workspace/do-an-phat-trien-cac-he-thong-thong-minh/model.pkl", "rb") as f:
    kmeans = pickle.load(f)
print(kmeans.predict([[X[0], X[1], X[2], X[3], X[4], X[5]], ])[0])

    