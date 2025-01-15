import pandas as pd
import sklearn.model_selection
import sklearn.preprocessing
import sklearn.svm
import sklearn.tree
from scipy.io import arff
import sklearn


file = arff.loadarff("./rice.arff")

df = pd.DataFrame(file[0])

X = df.iloc[:,:7];
Y = df.iloc[:,7:];


# print(X)


# print("end")
# print(Y)

Xtrain,Xtest,Ytrain,Ytest = sklearn.model_selection.train_test_split(X,Y,test_size=.25)

# print(Xtrain);

le = sklearn.preprocessing.LabelEncoder()
Ytrain = le.fit_transform(Ytrain.values.ravel());
Ytest = le.fit_transform(Ytest.values.ravel());


sc = sklearn.preprocessing.StandardScaler();
Xtrain = sc.fit_transform(Xtrain);
Xtest = sc.transform(Xtest);


# print(Xtest,Xtrain)
# print(Ytrain,Ytest)

# dtree = sklearn.tree.DecisionTreeClassifier()
# dtree = sklearn.svm.SVC()

svm = sklearn.svm.SVC(kernel='linear')
svm.fit(Xtrain,Ytrain)
yPred = svm.predict(Xtest);

# print(yPred)

from sklearn.metrics import f1_score,confusion_matrix

cm = confusion_matrix(Ytest,yPred)

print(cm)

fScore = f1_score(Ytest,yPred);
# print(fScore)

# print(yPred.tolist())
# 

print(len(yPred))
cammeo = 0
osman = 0

for predictions in yPred.tolist():
    # print(predictions)
    if(predictions == 1):
        # print("cammeo")
        cammeo +=1
    else:
        # print("osmanci")
        osman += 1

# print(osman,cammeo)
print(f"osmancik: {osman}")
print(f"cammeo: {cammeo}")



# exit()

print(f"confusion matrix\n{cm}")
print(f"fscore \n{fScore}")
# print(fScore)
