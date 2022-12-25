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

sv='DESKTOP-4UNL892'
db='Fashion_shop'
pwd="tt"

connection_string = "DRIVER={ODBC Driver 17 for SQL Server};SERVER="+sv+";DATABASE="+db+";UID=sa;PWD="+pwd
connection_url = URL.create("mssql+pyodbc", query={"odbc_connect": connection_string})

engine = create_engine(connection_url)

query = "SELECT ID,Price,Brand,Gender,ReleaseTime,ProductType,ProductMaterial FROM Product"
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
# print(X.head())


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