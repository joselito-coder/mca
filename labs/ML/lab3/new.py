from scipy.io import arff
import pandas
import sklearn
import sklearn.model_selection

file = arff.loadarff('rice.arff');

df = pandas.DataFrame(file[0])

X = df.iloc[:,:7]
Y = df.iloc[:,7:]

xTrain,xTest,yTrain,yTest = sklearn.model_selection.train_test_split(X,Y,random_state=0,test_size=0.25)

import sklearn.naive_bayes
from sklearn.preprocessing import LabelEncoder,StandardScaler

le = LabelEncoder()
yTrain = le.fit_transform(yTrain.values.ravel())
yTest = le.fit_transform(yTest.values.ravel())

sc = StandardScaler()
xTrain = sc.fit_transform(xTrain)
xTest = sc.transform(xTest)


gb = sklearn.naive_bayes.GaussianNB();

gb.fit(xTrain,yTrain)

yPred  = gb.predict(xTest);

from sklearn.metrics import f1_score,confusion_matrix,precision_score,accuracy_score

cm = confusion_matrix(yTest,yPred);
# exit();
fscore = f1_score(yTest,yPred)
accuracy = accuracy_score(yTest,yPred)
precision = precision_score(yTest,yPred)

print(f"confusion matrix: \n{cm}")
print(f"confusion matrix: {fscore}")
print(f"confusion matrix: {accuracy}")
print(f"confusion matrix: {precision}")




